// package com.yzanghelini.controller;

// import com.yzanghelini.interfaces.PersistenceType;
// import com.yzanghelini.model.BO.CardBO;
// import com.yzanghelini.model.BO.ListaBO;
// import com.yzanghelini.model.BO.QuadroBO;
// import com.yzanghelini.model.BO.UsuarioBO;
// import com.yzanghelini.view.viewGeral;

// public class ControllerMain {

// private viewGeral telaPrincipal;
// private PersistenceType persistenceType;
// // private ControllerItens controllerItens;
// private ControllerUsuario controllerUsuario;

//     public ControllerMain() {
//         this.telaPrincipal = new viewGeral();

//         persistenceType = telaPrincipal.readPersistence();


//         viewGeral.limparConsole();

//         viewGeral.showLinha();
//         System.out.println("Persistência selecionada: " + persistenceType);
//         viewGeral.showLinha();

//         //Instanciando os controllers e passando o tipo de persistencia no parâmetro
//         ControllerUsuario controllerUsuario = new ControllerUsuario(persistenceType);
//         ControllerItens controllerItens = new ControllerItens(persistenceType);


//     }

//     // public static void main(String[] args) {

//     //     ControllerMain cM = new ControllerMain();
//     //     cM.iniciar();
//     // }

// }
