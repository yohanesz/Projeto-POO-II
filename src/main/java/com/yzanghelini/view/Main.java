package com.yzanghelini.view;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
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
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PersistenceType dataPersistence = PersistenceType.JSON;

        // setando tipo de persistencia
        CardBO cardBO = new CardBO(dataPersistence);
        ListaBO listaBO = new ListaBO(dataPersistence);
        QuadroBO quadroBO = new QuadroBO(dataPersistence);
        UsuarioBO usuarioBO = new UsuarioBO(dataPersistence);

        boolean verificador = true;
        int idUsuario = 0;

        Usuario usuario = new Usuario("yohanes", "1234");

        // // => Cadastrar novo usuário
        usuarioBO.criarUsuario(usuario);

        viewGeral vW = new viewGeral();

        do {

            vW.limparConsole();
            // login
            System.out.print("Insira o nome: ");
            String nomeUsuario = scanner.nextLine();
            System.out.print("Insira a senha: ");
            String senhaUsuario = scanner.nextLine();

            // retorna dois valores, um verificador e um id
            Object[] resultado = usuarioBO.logarUsuario(nomeUsuario, senhaUsuario);

            idUsuario = (int) resultado[0];
            verificador = (boolean) resultado[1];

            if (!verificador) {
                vW.limparConsole();
                vW.showLinha();
                System.out.println("Senha incorreta, tente novamente.");
                vW.showLinha();
                scanner.nextLine();
            }

        } while (!verificador);

        // criando quadro e pegando id
        Quadro quadro1 = new Quadro(idUsuario, "Pessoal");
        quadroBO.criarQuadro(quadro1);

        // // System.out.println("Deseja remover qual quadro?");

        int id_quadro = quadroBO.getIdQuadroByName("Pessoal");

        // System.out.println("id do quadroooo: " + id_quadro);
        // // criando lista com o id do quadro
        Lista novaLista = new Lista(id_quadro, "Pendentes");
        listaBO.criarLista(novaLista);
        int id_lista = listaBO.getIdListaByName("Pendentes");

        // // Lista novaLista2 = new Lista(id_quadro, "Concluidos");
        // // listaBO.criarLista(novaLista2);
        // // int id_lista2 = listaBO.getIdListaByName("Concluidos");

        // //criando card e setando os parâmetros
        Card novoCard = new Card(id_lista, "Projeto POO", "30/02/2024", "09:00");
        cardBO.criarCard(novoCard);
        // int id_card = cardBO.getIdCardByName("Projeto POO");

        // // Card novoCard2 = new Card(id_lista2, "Prova Calculo", "05/05/2024",
        // "08:00");
        // // cardBO.criarCard(novoCard2);
        // // int id_card2 = cardBO.getIdCardByName("Prova Calculo");

        // System.out.println("Primeiro Card: " + novoCard.getTitulo_card() + "\n id da
        // lista: " + id_card);
        // // System.out.println("Segundo Card: " + novoCard2.getTitulo_card() + "\n id
        // da lista: " + id_card2);

        // Listar os itens
        List<Card> cards = cardBO.listarCards();
        List<Lista> listas = listaBO.listarListas();
        List<Quadro> quadros = quadroBO.listarQuadros();

        for (Quadro quadro : quadros) {
            System.out.println(quadro);
        }
        for (Lista lista : listas) {
            System.out.println(lista);
        }

        for (Card card : cards) {
            System.out.println(card);
        }

    }

}
