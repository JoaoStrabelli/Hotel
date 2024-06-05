package br.edu.utfpr.hotel;

import br.edu.utfpr.hotel.menu.PrincipalMenu;
import br.edu.utfpr.hotel.modelo.Hospede;
import br.edu.utfpr.hotel.modelo.Quarto;

import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("Gerenciador de Hotel");
        System.out.println("=====================");
        PrincipalMenu.abrirMenu();
    }

    public static final Scanner INPUT = new Scanner(System.in);


}