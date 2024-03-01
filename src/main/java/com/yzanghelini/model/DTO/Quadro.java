package com.yzanghelini.model.DTO;


import com.yzanghelini.interfaces.DefaultEntitiesInterface;

public class Quadro implements DefaultEntitiesInterface{

    private int id_usuario;
	private int id_quadro;
    private String titulo_quadro;
	// private List<Lista> listas;

    public Quadro() {
       
    }

    public Quadro(int id_usuario, String titulo_quadro) {
        this.id_usuario = id_usuario;
        this.titulo_quadro = titulo_quadro;
    }

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getId() {
        return id_quadro;
    }
    public void setId(int id_quadro) {
        this.id_quadro = id_quadro;
    }
    public String getTitulo_quadro() {
        return titulo_quadro;
    }
    public void setTitulo_quadro(String titulo_quadro) {
        this.titulo_quadro = titulo_quadro;
    }

    @Override
    public String getTitulo() {
        return titulo_quadro;
    }

 
    
}
