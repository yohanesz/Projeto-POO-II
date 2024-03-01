package com.yzanghelini.model.DAO;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.yzanghelini.interfaces.DataPersistence;
import com.yzanghelini.interfaces.DefaultEntitiesInterface;

public class XmlPersistence<T extends DefaultEntitiesInterface> implements DataPersistence<T> {

    private Class<T> clazz;
    private File file;

    public XmlPersistence(Class<T> clazz) {
        this.clazz = clazz;
        this.file = getFile();
    }

    private File getFile() {
        String tableName = clazz.getSimpleName().toLowerCase();
        return new File("data/xml/" + tableName + ".xml");
      }

    @Override
  public void create(T object) {
    List<T> objects = readAll();
    objects.add(object);
    writeAll(objects);
  }

  @Override
  public T read(int id) {
    List<T> objects = readAll();
    for (T obj : objects) {
      if (obj.getId() == id) {
        return obj;
      }
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
    Iterator<T> iterator = objects.iterator();
    while (iterator.hasNext()) {
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
      try {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlItems.class, clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        @SuppressWarnings("unchecked")
        XmlItems<T> xmlItems = (XmlItems<T>) jaxbUnmarshaller.unmarshal(file);
        resultList = xmlItems.getItems();
      } catch (JAXBException e) {
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
      if (object.getId() > maxId) {
        maxId = object.getId();
      }
    }
  
    return maxId + 1;
  }
  
  public void writeAll(List<T> objects) {
    XmlItems<T> xmlItems = new XmlItems<>();
    xmlItems.setItems(objects);

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(XmlItems.class, clazz);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(xmlItems, file);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Object[] autenticar(String nome, String senha) {
      List<T> items = readAll();
  
      for (T item : items) {
          // Substitua com a lógica de autenticação apropriada para o seu tipo de objeto
          // Aqui estou assumindo que o objeto tem métodos getNome e getSenha
          try {
              Method getNomeMethod = item.getClass().getMethod("getNome");
              Method getSenhaMethod = item.getClass().getMethod("getSenha");
  
              Object nomeDoItem = getNomeMethod.invoke(item);
              Object senhaDoItem = getSenhaMethod.invoke(item);
  
              if (nome.equals(nomeDoItem) && senha.equals(senhaDoItem)) {
                  // Retornar informações necessárias, por exemplo, o ID
                  return new Object[]{getId(item), true};
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  
      return new Object[]{0, false}; // Retornar algum valor padrão
  }
  
  @Override
  public int getIdByName(String name) {
      List<T> items = readAll();
  
      for (T item : items) {
          try {
              Method getTituloMethod = item.getClass().getMethod("getTitulo");
  
              Object tituloDoItem = getTituloMethod.invoke(item);
  
              if (tituloDoItem != null && name.equals(tituloDoItem.toString())) {
                  return getId(item);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  
      return -1; // Retornar algum valor padrão indicando falha
  }
  
  
  // Método fictício para obter o ID do objeto, substitua com o método apropriado
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