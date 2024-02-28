package com.yzanghelini.model.DTO;


import com.yzanghelini.interfaces.DefaultEntitiesInterface;

public class Quadro implements DefaultEntitiesInterface{

    private int id_usuario;
	private int id_quadro;
    private String tituloQuadro;
	// private List<Lista> listas;

    public Quadro(int id_usuario, String tituloQuadro) {
        this.id_usuario = id_usuario;
        this.tituloQuadro = tituloQuadro;
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
    public String getTituloQuadro() {
        return tituloQuadro;
    }
    public void setTituloQuadro(String tituloQuadro) {
        this.tituloQuadro = tituloQuadro;
    }
   
    
}
