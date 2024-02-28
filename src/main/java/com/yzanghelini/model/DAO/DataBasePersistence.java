package com.yzanghelini.model.DAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yzanghelini.interfaces.DataPersistence;
import com.yzanghelini.interfaces.DefaultEntitiesInterface;
import com.yzanghelini.model.DAO.ConexaoDB;

public class DataBasePersistence<T extends DefaultEntitiesInterface> implements DataPersistence<T> {

  private Class<T> clazz;
  private Connection connection;

  protected DataBasePersistence(Class<T> clazz) {
    this.clazz = clazz;
    try {
      this.connection = ConexaoDB.getInstance().getConnection();
    } catch (SQLException e) {
      System.err.println("Failed to get database connection: " + e.getMessage());
      this.connection = null;
    }
  }

    @Override
    public void create(T object) {
        String nomeTabela = clazz.getSimpleName().toLowerCase();
        String sql = "INSERT INTO " + nomeTabela + " (";
        String values = " VALUES (";
        // retorna todos os campos declarados da classe (privated, public)
        Field[] fields = clazz.getDeclaredFields();

        List<Object> valuesList = new ArrayList<>();
        for (Field field : fields) {
            String fieldName = field.getName();

            try{
                Object value = field.get(object);

                if ((value instanceof Integer && (Integer) value == 0) || (value instanceof String && ((String) value).isEmpty())) {
                    continue;
                }
                sql = sql + fieldName + ", ";
                values = values + "?, ";
                valuesList.add(value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (sql.endsWith(", ")) {
                sql = sql.substring(0, sql.length() - 2);
            }
              if (values.endsWith(", ")) {
                values = values.substring(0, values.length() - 2);
            }

            sql = sql + ")";
            values = values + ")";
            sql = sql + values;

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int paramIndex = 1;
            for (Object value : valuesList) {
                statement.setObject(paramIndex++, value);
            }

            statement.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
            }

        }
    }


    @Override
    public T read(int id) {
        String nomeTabela = clazz.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + nomeTabela + " WHERE id_" + nomeTabela + " = ?";

        try (
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {

                    T object = clazz.getDeclaredConstructor().newInstance();
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        String fieldName = field.getName();
                        Object value = resultSet.getObject(fieldName);

                        if (value != null) {
                            field.set(object, value);
                        }
                    }

                return object;

                }
            } 

        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException
            | InvocationTargetException e) {
          e.printStackTrace();
        }
        return null;
    }



    @Override
    public void update(T object) {
        String nomeTabela = clazz.getSimpleName().toLowerCase();
        String sql = "UPDATE " + nomeTabela + " SET ";
        Field[] fields = clazz.getDeclaredFields();
    
        List<Object> valuesList = new ArrayList<>();
        String idFieldName = "";
        Object idValue = null;
    
        for (Field field : fields) {
          field.setAccessible(true);
          String fieldName = field.getName();
          try {
            Object value = field.get(object);
            if (fieldName.startsWith("id_") && fieldName.equals("id_" + nomeTabela.toLowerCase())) {
              idFieldName = fieldName;
              idValue = value;
            } else {
              sql += fieldName + " = ?, ";
              valuesList.add(value);
            }
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }
        }
    
        if (sql.endsWith(", ")) {
          sql = sql.substring(0, sql.length() - 2);
        }
    
        sql += " WHERE " + idFieldName + " = ?";
    
        try (
            PreparedStatement statement = connection.prepareStatement(sql)) {
          int paramIndex = 1;
          for (Object value : valuesList) {
            statement.setObject(paramIndex++, value);
          }
          statement.setObject(paramIndex, idValue);
          statement.executeUpdate();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    
      @Override
      public void delete(int id) {
        String nomeTabela = clazz.getSimpleName().toLowerCase();
        String sql = "DELETE FROM " + nomeTabela + " WHERE id_" + nomeTabela + " = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
          statement.setInt(1, id);
          int rowsAffected = statement.executeUpdate();
          if (rowsAffected == 0) {
            System.out.println("Nenhum registro foi excluído com o ID: " + id);
          } else {
            System.out.println("Registro excluído com sucesso!");
          }
        } catch (SQLException e) {
          System.out.println("Erro ao tentar excluir o registro com o ID: " + id);
          e.printStackTrace();
        }
      }
    
      @Override
      public List<T> readAll() {
        String nomeTabela = clazz.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + nomeTabela;
        List<T> resultList = new ArrayList<>();
        try (
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {
            T object = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
              field.setAccessible(true);
              String fieldName = field.getName();
              Object value = resultSet.getObject(fieldName);
              if (value != null) {
                field.set(object, value);
              }
            }
            resultList.add(object);
          }
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException
            | InvocationTargetException e) {
          e.printStackTrace();
        }
        
        return resultList;
      }
    
      @Override
      public int getNextId() {
        List<T> objects = this.readAll();
        int maxId = 0;
      
        for (T object : objects) {
          if (object.getId() > maxId) {
            maxId = object.getId();
          }
        }
      
        return maxId + 1;
      }  

      public Object[] autenticar(String nomeUsuario, String senhaUsuario) {

        int idUsuario = 0;
        boolean autenticado = false;
    
        try {
            String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, nomeUsuario);
                ps.setString(2, senhaUsuario); 
                
    
                try (ResultSet rs = ps.executeQuery()) {
                  if (rs.next()) {
                      idUsuario = rs.getInt("id_usuario");
                      autenticado = true;
                  }
              }
                
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return new Object[] {idUsuario, autenticado};
    }

    }