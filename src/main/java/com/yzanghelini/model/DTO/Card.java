package com.yzanghelini.model.DTO;

import java.text.SimpleDateFormat;

import com.yzanghelini.interfaces.DefaultEntitiesInterface;

public class Card implements DefaultEntitiesInterface {

    private int id_lista;
    private int id_card;
	private String titulo_card;
	private String dataInicial;
	private String dataEntrega;
	private String horaEntrega;
	
	
	public Card() {
    
    }

	public Card(int id_lista, String titulo_card, String dataEntrega, String horaEntrega) {
        this.id_lista = id_lista;
        this.titulo_card = titulo_card;
        this.dataInicial = dataFormatada().toString();
        this.dataEntrega = dataEntrega;
        this.horaEntrega = horaEntrega;
    }

    private String dataFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtualFormatada = sdf.format(new java.util.Date());
        return dataAtualFormatada;
    }

    public int getId() {
        return id_card;
    }


    public void setId(int id_card) {
        this.id_card = id_card;
    }


    public String getTitulo_card() {
        return titulo_card;
    }


    public void setTitulo_card(String titulo_card) {
        this.titulo_card = titulo_card;
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


    public int getId_lista() {
        return id_lista;
    }


    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    @Override
    public String getTitulo() {
        return titulo_card;
    }

    @Override
    public String toString() {
        return "Card [id_lista=" + id_lista + ", id_card=" + id_card + ", titulo_card=" + titulo_card + ", dataInicial="
                + dataInicial + ", dataEntrega=" + dataEntrega + ", horaEntrega=" + horaEntrega + "]";
    }

 
    
}
