// package com.yzanghelini.controller;

// import com.yzanghelini.interfaces.PersistenceType;
// import com.yzanghelini.model.BO.UsuarioBO;
// import com.yzanghelini.model.DTO.Usuario;
// import com.yzanghelini.view.UserInfoView;
// import com.yzanghelini.view.viewGeral;
// import java.util.Scanner;

// public class ControllerUsuario {

//     Scanner read = new Scanner(System.in);

//     private viewGeral telaPrincipal;
//     private UsuarioBO usuarioBO;

//     public ControllerUsuario(PersistenceType persistenceType) {
//         this.telaPrincipal = new viewGeral();
//         this.usuarioBO = new UsuarioBO(persistenceType);
//     }

//     public int executarInicio() {
//         int optionStart = telaPrincipal.showStart();
//         boolean logado = false;
//         int id_usuario = 0;

//         switch (optionStart) {

//             case 1:
//                 do {
//                     UserInfoView loginInformations = telaPrincipal.showStartLogin();
//                     Object[] resultado = usuarioBO.logarUsuario(loginInformations.getNomeUsuario(), loginInformations.getSenhaUsuario());
//                     logado = (boolean) resultado[1];
//                     id_usuario = (int) resultado[0];

//                     if (!logado) {
//                         viewGeral.limparConsole();
//                         viewGeral.showLinha();
//                         System.out.println("Senha Incorreta!");
//                         viewGeral.showLinha();
//                         read.nextLine();
//                     }

//                 } while (!logado);
//                 break;

//             case 2:
//                 UserInfoView registerInformations = telaPrincipal.showStartRegister();
//                 Usuario usuario = new Usuario(registerInformations.getNomeUsuario(), registerInformations.getSenhaUsuario());
//                 usuarioBO.criarUsuario(usuario);
                
//                 viewGeral.limparConsole();
//                 viewGeral.showLinha();
//                 System.out.println("Usuário criado com sucesso!");
//                 viewGeral.showLinha();
//                 read.nextLine();
//                 break;

//             default:
//                 break;
//         }

//         return id_usuario;
//     }
// }
