package com.yzanghelini.model.DTO ;

import com.yzanghelini.interfaces.DefaultEntitiesInterface;

public class Lista implements DefaultEntitiesInterface{

    private int id_quadro;
    private int id_lista;
    private String titulo_lista;

    public Lista() {
    }

    public Lista(int id_quadro, String titulo_lista) {
        this.id_quadro = id_quadro;
        this.titulo_lista = titulo_lista;
    }

    public int getId() {
        return id_lista;
    }

    public void setId(int id_lista) {
        this.id_lista = id_lista;
    }

    public String getTitulo_lista() {
        return titulo_lista;
    }

    public void setTitulo_lista(String titulo_lista) {
        this.titulo_lista = titulo_lista;
    }

    public int getId_quadro() {
        return id_quadro;
    }

    public void setId_quadro(int id_quadro) {
        this.id_quadro = id_quadro;
    }

    @Override
    public String getTitulo() {
        return titulo_lista;
    }

  


    
}
