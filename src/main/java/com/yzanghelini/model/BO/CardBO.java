package com.yzanghelini.model.BO;

import java.util.List;

import com.yzanghelini.interfaces.DataPersistence;
import com.yzanghelini.interfaces.PersistenceType;
import com.yzanghelini.model.DAO.PersistenceFactory;
import com.yzanghelini.model.DTO.Card;

public class CardBO {

    private DataPersistence<Card> dataPersistence;

    public CardBO(PersistenceType persistenceType) {
        this.dataPersistence = PersistenceFactory.setDataPersistence(Card.class, persistenceType);
    }

    public void criarCard(Card card) {
        if (card.getId() <= 0) {
            card.setId(dataPersistence.getNextId());
        }

        dataPersistence.create(card);
    }

    public Card buscarCard(int id) {
        return dataPersistence.read(id);
    }

    public void atualizarCard(Card card) {
        dataPersistence.update(card);
    }

    public void deletarCard(int id) {
        dataPersistence.delete(id);
    }

    public List<Card> listarCards() {
        return dataPersistence.readAll();
    }
    
    
}
