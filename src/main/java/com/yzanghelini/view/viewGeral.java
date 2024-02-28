package com.yzanghelini.view;

public class viewGeral {

    public static void showLinha() {
        System.out.println("------------------------------");
    }

    public static void limparConsole() {
        System.out.println("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ");
    }

    public static void showResposta() {
        System.out.println("");
        System.out.println("R: ");
        showLinha();
    }

    public static void showLogin() {
        System.out.println("");
    }

    public static void main(String[] args) {
        
        showStart();
    }

    public static void showStart() {
        limparConsole();
        System.out.println("          INICIO        ");
        showLinha();
        System.out.println("[1] - Cadastrar novo usuário");
        System.out.println("[2] - Já tenho cadastro");
        showLinha();
        showResposta();
    }

    public void criarItem() {

    }
    public void menuQuadro() {

    }

    public void menuLista() {

    }

    public void menuCard() {
        
    }
    
}
