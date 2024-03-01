package com.yzanghelini.model.DTO;


import com.yzanghelini.interfaces.DefaultEntitiesInterface;

public class Usuario implements DefaultEntitiesInterface {

    private int id_usuario;
    private String nome;
	private String senha;

    public Usuario() {
        
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public int getId() {
        return id_usuario;
    }
    public void setId(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {

        return "Usuario [id_usuario =" + id_usuario + ", nome=" + nome + ", senha=" + senha + "]";
    }

    @Override
    public String getTitulo() {
       return nome;
    }

    // public List<Quadro> getQuadros() {
    //     return quadros;
    // }
    // public void setQuadros(List<Quadro> quadros) {
    //     this.quadros = quadros;
    // }

    
}
