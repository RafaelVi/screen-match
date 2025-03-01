package br.com.alura.screenmatch;

import java.util.Scanner;

public class Menu {
    public static String exibeMenu(String titulo) {
        System.out.println("Qual " + titulo +" você deseja buscar?");
        return new Scanner(System.in).nextLine();
    }
}
