package com.yzanghelini.view;

import java.sql.Connection;
import java.util.Scanner;

import com.yzanghelini.interfaces.PersistenceType;
import com.yzanghelini.model.BO.CardBO;
import com.yzanghelini.model.BO.QuadroBO;
import com.yzanghelini.model.BO.UsuarioBO;
import com.yzanghelini.model.DAO.ConexaoDB;
import com.yzanghelini.model.BO.ListaBO;
import com.yzanghelini.model.DTO.Card;
import com.yzanghelini.model.DTO.Quadro;
import com.yzanghelini.model.DTO.Lista;
import com.yzanghelini.model.DTO.Usuario;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        PersistenceType dataPersistence = PersistenceType.DATABASE;
        
        
        CardBO cardBO = new CardBO(dataPersistence);
        ListaBO listaBO = new ListaBO(dataPersistence);
        QuadroBO quadroBO = new QuadroBO(dataPersistence);
        UsuarioBO usuarioBO = new UsuarioBO(dataPersistence);
        // PersistenciaUsuario pUsuario = new PersistenciaUsuario();

//      UsuarioDTO usuario = new UsuarioDTO("yohanes", "1234"); => Cadastrar novo usuário       
//      usuarioDAO.registrarUsuarioBD(usuario);



        System.out.print("Insira o nome: ");
        String nomeUsuario = scanner.nextLine();
        
        System.out.print("Insira a senha: ");
        String senhaUsuario = scanner.nextLine();
        
        Object[] resultado = usuarioBO.logarUsuario(nomeUsuario, senhaUsuario);
        
        int idUsuario = (int) resultado[0];
        boolean verificador = (boolean) resultado[1];

        System.out.println(idUsuario);
        System.out.println(verificador);
       

    }
    
}

