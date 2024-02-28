package com.yzanghelini.model.BO;

import java.util.List;

import com.yzanghelini.interfaces.DataPersistence;
import com.yzanghelini.interfaces.PersistenceType;
import com.yzanghelini.model.DAO.PersistenceFactory;
import com.yzanghelini.model.DTO.Lista;

public class ListaBO {

    private DataPersistence<Lista> dataPersistence;

    public ListaBO(PersistenceType persistenceType) {
        this.dataPersistence = PersistenceFactory.setDataPersistence(Lista.class, persistenceType);
    }

    public void criarLista(Lista lista) {
        if(lista.getId() <= 0) {
            lista.setId(dataPersistence.getNextId());
        }

        dataPersistence.create(lista);
    }

    public Lista buscarLista(int id) {
        return dataPersistence.read(id);
    }

    public void atualizarLista(Lista lista) {
        dataPersistence.update(lista);
    }

    public void deletarLista(int id) {
        dataPersistence.delete(id);
    }

    public List<Lista> listarListas() {
        return dataPersistence.readAll();
    }

    
    
}
