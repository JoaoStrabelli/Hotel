package br.edu.utfpr.hotel;

import br.edu.utfpr.hotel.modelo.Hospede;
import br.edu.utfpr.hotel.modelo.Quarto;

import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("Gerenciador de Hotel");
        System.out.println("=====================");

        int option;
        do {
            System.out.println();
            System.out.println("=== Menu Principal ===");
            System.out.println("1 - Quartos");
            System.out.println("2 - Hospedes");
            System.out.println("4 - Sair");
            option = INPUT.nextInt();
            switch(option) {
                case 1:
                    Quarto.menu();
                    break;
                case 2:
                    Hospede.menu();
                    break;
                default:
            }
        } while(option != SAIR_MENU_INDEX);
    }

    public static final Scanner INPUT = new Scanner(System.in);

    private static final int SAIR_MENU_INDEX = 4;
}