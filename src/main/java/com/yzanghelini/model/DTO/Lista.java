package com.yzanghelini.model.DTO ;

import com.yzanghelini.interfaces.DefaultEntitiesInterface;

public class Lista implements DefaultEntitiesInterface{

    private int id_quadro;
    private int id_lista;
    private String tituloLista;

    public Lista(int id_quadro, String tituloLista) {
        this.id_quadro = id_quadro;
        this.tituloLista = tituloLista;
    }

    public int getId() {
        return id_lista;
    }

    public void setId(int id_lista) {
        this.id_lista = id_lista;
    }

    public String getTituloLista() {
        return tituloLista;
    }

    public void setTituloLista(String tituloLista) {
        this.tituloLista = tituloLista;
    }

    public int getId_quadro() {
        return id_quadro;
    }

    public void setId_quadro(int id_quadro) {
        this.id_quadro = id_quadro;
    }



    
}
