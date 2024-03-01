// package com.yzanghelini.controller;

// import com.yzanghelini.interfaces.PersistenceType;
// import com.yzanghelini.model.BO.CardBO;
// import com.yzanghelini.model.BO.ListaBO;
// import com.yzanghelini.model.BO.QuadroBO;
// import com.yzanghelini.model.BO.UsuarioBO;
// import com.yzanghelini.model.DTO.Quadro;
// import com.yzanghelini.view.viewGeral;

// import java.util.Scanner;

// public class ControllerItens {

// private viewGeral telaPrincipal;
// private CardBO cardBO;
// private ListaBO listaBO;
// private QuadroBO quadroBO;
// private ControllerUsuario controllerUsuario;

// Scanner read = new Scanner(System.in);

// public ControllerItens(PersistenceType persistenceType) {
//     this.telaPrincipal = new viewGeral();
//     this.cardBO = new CardBO(persistenceType);
//     this.listaBO = new ListaBO(persistenceType);
//     this.quadroBO = new QuadroBO(persistenceType);
// }

// int id_usuario = controllerUsuario.executarInicio();

// public int executarQuadro(int id_usuario) {

//     int option = telaPrincipal.showMainQuadro();

//     do {
        
//         switch (option) {
//             //criar novo quadro
//             case 1:

//                 criarQuadro(id_usuario);
//             break;
//             //acessar quadro
//             case 2:

//                 viewGeral.limparConsole();
//                 viewGeral.showLinha();
//                 quadroBO.listarQuadros();
//                 viewGeral.showLinha();
//                 System.out.println("Selecione o quadro que deseja acessar: ");


//             break;
//             //excluir quadro
//             case 3:

//             break;

//             default:
//                 break;
//         }

//     } while (option != 4);
//     return option;

// }

// public Quadro criarQuadro(int id_usuario) {

//     viewGeral.limparConsole();
//     System.out.println("Insira o nome do quadro: ");
//     String tituloQuadro = read.nextLine();
//     Quadro novoQuadro = new Quadro(id_usuario, tituloQuadro);
//     return novoQuadro;

// }

// public String acessarQuadro(int id_quadro) {

//     viewGeral.limparConsole();
//     viewGeral.showLinha();
//     listaBO.listarListas();
//     viewGeral.showLinha();
//     return null;
// }
    
// }
