package com.yzanghelini.model.DTO;

import java.text.SimpleDateFormat;

import com.yzanghelini.interfaces.DefaultEntitiesInterface;

public class Card implements DefaultEntitiesInterface {

    private int id_lista;
    private int id_card;
	private String tituloCard;
	private String dataInicial;
	private String dataEntrega;
	private String horaEntrega;
	
	
	//inserir data atual 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String dataAtualFormatada = sdf.format(new java.util.Date());
	
	
	public Card(int id_lista, String tituloCard, String dataInicial, String dataEntrega, String horaEntrega) {
        this.id_lista = id_lista;
        this.tituloCard = tituloCard;
        this.dataInicial = dataAtualFormatada;
        this.dataEntrega = dataEntrega;
        this.horaEntrega = horaEntrega;
    }


    public int getId() {
        return id_card;
    }


    public void setId(int id_card) {
        this.id_card = id_card;
    }


    public String getTituloCard() {
        return tituloCard;
    }


    public void setTituloCard(String tituloCard) {
        this.tituloCard = tituloCard;
    }


    public String getDataInicial() {
        return dataInicial;
    }


    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }


    public String getDataEntrega() {
        return dataEntrega;
    }


    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }


    public String getHoraEntrega() {
        return horaEntrega;
    }


    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }


    public SimpleDateFormat getSdf() {
        return sdf;
    }


    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }


    public String getDataAtualFormatada() {
        return dataAtualFormatada;
    }


    public void setDataAtualFormatada(String dataAtualFormatada) {
        this.dataAtualFormatada = dataAtualFormatada;
    }


    public int getId_lista() {
        return id_lista;
    }


    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    
}
