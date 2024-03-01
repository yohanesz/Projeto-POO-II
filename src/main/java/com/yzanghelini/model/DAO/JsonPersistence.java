package com.yzanghelini.model.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.yzanghelini.interfaces.DataPersistence;
import com.yzanghelini.interfaces.DefaultEntitiesInterface;
import com.yzanghelini.model.DTO.Usuario;



class JsonPersistence<T extends DefaultEntitiesInterface> implements DataPersistence<T> {

    private Class<T> clazz;
    private File file;
    private Gson gson;

    public JsonPersistence(Class<T> clazz) {
        this.clazz = clazz;
        this.file = getFile();
        this.gson = new Gson();
    }

    private File getFile() {
        String tableName = clazz.getSimpleName().toLowerCase();
        return new File("data/json/" + tableName + ".json");
      }

    @Override
  public void create(T object) {
    try (FileWriter writer = new FileWriter(file, true)) {
      String json = gson.toJson(object);
      writer.write(json + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public T read(int id) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        T object = gson.fromJson(line, clazz);
        if (object != null && object.getId() == id) {
          return object;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public void update(T object) {
    List<T> objects = readAll();

    for (int i = 0; i < objects.size(); i++) {
      T obj = objects.get(i);
      if (obj.getId() == object.getId()) {
        objects.set(i, object);
        break;
      }
    }

    writeAll(objects);
  }

  @Override
  public void delete(int id) {
    List<T> objects = readAll();

    for (Iterator<T> iterator = objects.iterator(); iterator.hasNext();) {
      T obj = iterator.next();
      if (obj.getId() == id) {
        iterator.remove();
      }
    }

    writeAll(objects);
  }

  @Override
  public List<T> readAll() {
    List<T> resultList = new ArrayList<>();
    if (file.exists() && file.length() > 0) {
      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
          T obj = gson.fromJson(line, clazz);
          resultList.add(obj);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return resultList;
  }


  @Override
  public int getNextId() {
      List<T> objects = this.readAll();
      int maxId = 0;
    
      for (T object : objects) {
          if (object != null && object.getId() > maxId) {
              maxId = object.getId();
          }
      }
    
      return maxId + 1;
  }

  private void writeAll(List<T> objects) {
    try (FileWriter writer = new FileWriter(file)) {
      for (T obj : objects) {
        String json = gson.toJson(obj);
        writer.write(json + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Object[] autenticar(String nomeUsuario, String senhaUsuario) {
    int idUsuario = 0;
    boolean autenticado = false;

    try {
        JsonPersistence<Usuario> jsonPersistence = new JsonPersistence<>(Usuario.class);
        List<Usuario> usuarios = jsonPersistence.readAll();

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario) && usuario.getSenha().equals(senhaUsuario)) {
                idUsuario = usuario.getId();
                autenticado = true;
                break;
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return new Object[]{idUsuario, autenticado};
}


@Override
public int getIdByName(String name) {
    List<T> items = readAll();

    for (T item : items) {
        try {
            Method getTituloMethod = item.getClass().getMethod("getTitulo");

            if (getTituloMethod != null) {
                Object tituloDoItem = getTituloMethod.invoke(item);

                if (tituloDoItem != null && name.equals(tituloDoItem.toString())) {
                    return getId(item);
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    return -1; // Retornar algum valor padrão indicando falha
}


private int getId(T item) {
  try {
      Method getIdMethod = item.getClass().getMethod("getId");
      return (int) getIdMethod.invoke(item);
  } catch (Exception e) {
      e.printStackTrace();
      return -1; // Retornar algum valor padrão indicando falha
  }
}





}
