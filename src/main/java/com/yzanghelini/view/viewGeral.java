// package com.yzanghelini.view;

// import com.yzanghelini.interfaces.PersistenceType;
// import com.yzanghelini.model.DTO.Quadro;

// public class viewGeral {

    
//     //métodos estáticos para ser usado dentro da classe
//     public static void showLinha() {
//         System.out.println("------------------------------");
//     }

//     public static void limparConsole() {
//         System.out.println("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ");
//     }

//     public static void showResposta() {
//         System.out.print("R: ");
//     }


//     //retorna a opção 
//     public int showStart() {
//         limparConsole();
//         showLinha();
//         System.out.println("          INICIO        ");
//         showLinha();
//         System.out.println("[1] - Cadastrar novo usuário");
//         System.out.println("[2] - Já tenho cadastro");
//         showLinha();
//         showResposta();
//         int option = Integer.parseInt(System.console().readLine());
//         return option;
//     }

//     public UserInfoView showStartLogin() {
//         limparConsole();
//         showLinha();
//         System.out.println("           LOGIN         ");
//         showLinha();
//         System.out.println("Insira seu nome de usuário \ne senha para entrar:");

//         showLinha();
//         System.out.print("Nome de usuário: ");
//         String nomeUsuario = System.console().readLine();
//         System.out.print("Senha: ");
//         String senhaUsuario = System.console().readLine();
//         showLinha();
//         return new UserInfoView(nomeUsuario, senhaUsuario);
//     }
    
//     //retorna o nome do usuario e a senha
//     public UserInfoView showStartRegister() {
//         limparConsole();
//         showLinha();
//         System.out.println("      CADASTRAR USUÁRIO      ");
//         showLinha();
//         System.out.println("Insira as informações para \ncriar uma conta:");

//         showLinha();
//         System.out.print("Nome de usuário: ");
//         String nomeUsuario = System.console().readLine();
//         System.out.print("Senha: ");
//         String senhaUsuario = System.console().readLine();
//         showLinha();
//         return new UserInfoView(nomeUsuario,senhaUsuario);
//     }

//     public int showMainQuadro() {

//         showLinha();
//         System.out.println("      TELA PRINCIPAL      ");
//         showLinha();
//         System.out.println("[1] - Criar novo quadro\n" + 
//                             "[2] - Acessar quadro\n" +
//                             "[3] - Excluir quadro\n" + 
//                             "[4] - Encerrar");
//         showLinha();
//         showResposta();
//         int option = Integer.parseInt(System.console().readLine());
//         return option;
        
//     }

//     public int showMainLista() {
//         showLinha();
//         System.out.println("      TELA PRINCIPAL      ");
//         showLinha();
//         System.out.println("[1] - Criar nova lista\n" + 
//                             "[2] - Acessar lista\n" +
//                             "[3] - Excluir lista\n" + 
//                             "[4] - Voltar");
//         showLinha();
//         showResposta();
//         int option = Integer.parseInt(System.console().readLine());
//         return option;

//     }

//     public int showMainCard() {
//         showLinha();
//         System.out.println("      TELA PRINCIPAL      ");
//         showLinha();
//         System.out.println("[1] - Criar novo card\n" + 
//                             "[2] - Acessar card\n" +
//                             "[3] - Excluir card\n" +
//                             "[4] - Voltar");
//         showLinha();
//         showResposta();
//         int option = Integer.parseInt(System.console().readLine());
//         return option;
//     }
    
//     public PersistenceType readPersistence() {
//         limparConsole();
//         showLinha();
//         System.out.println("Escolha o tipo de persistência: ");
//         showLinha();
//             for (int i = 0; i < PersistenceType.values().length; i++) {
//                 System.out.println(i + " - " + PersistenceType.values()[i].name());
//             }
//         showLinha();
//         showResposta();
//         int opcao = Integer.parseInt(System.console().readLine());
//         return PersistenceType.values()[opcao];
//     }

   
// }
