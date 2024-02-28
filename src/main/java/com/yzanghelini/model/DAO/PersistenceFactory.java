package com.yzanghelini.model.DAO;

import com.yzanghelini.interfaces.DataPersistence;
import com.yzanghelini.interfaces.DefaultEntitiesInterface;
import com.yzanghelini.interfaces.PersistenceType;

public class PersistenceFactory {

    public static <T extends DefaultEntitiesInterface> DataPersistence<T> setDataPersistence(Class<T> clazz, PersistenceType format) {
      switch (format) {
        case DATABASE:
          return new DataBasePersistence<>(clazz);
        // case JSON:
        //   return new JsonPersistence<>(clazz);
        // case XML:
        //   return new XmlPersistence<>(clazz);
        default:
          throw new IllegalArgumentException("Formato de persistência inválido: " + format);
        }
    }
  }