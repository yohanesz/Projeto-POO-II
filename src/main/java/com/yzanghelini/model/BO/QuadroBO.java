package com.yzanghelini.model.BO;

import java.util.List;

import com.yzanghelini.interfaces.DataPersistence;
import com.yzanghelini.interfaces.PersistenceType;
import com.yzanghelini.model.DAO.PersistenceFactory;
import com.yzanghelini.model.DTO.Quadro;

public class QuadroBO {
    private DataPersistence<Quadro> dataPersistence;

    public QuadroBO(PersistenceType persistenceType) {
        this.dataPersistence = PersistenceFactory.setDataPersistence(Quadro.class, persistenceType);

    }
    
    public void criarQuadro(Quadro quadro) {
        if(quadro.getId() <= 0) {
            quadro.setId(dataPersistence.getNextId());
        }

        dataPersistence.create(quadro);
    }

    public Quadro buscarQuadro(int id) {
        return dataPersistence.read(id);
    }

    public void atualizarQuadro(Quadro quadro) {
        dataPersistence.update(quadro);

    }

    public void deletarQuadro(int id) {
        dataPersistence.delete(id);
    }

    public List<Quadro> listarQuadros() {
        return dataPersistence.readAll();
    }


}
