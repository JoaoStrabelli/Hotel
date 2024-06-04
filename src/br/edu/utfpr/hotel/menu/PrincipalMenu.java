package br.edu.utfpr.hotel.menu;

import br.edu.utfpr.hotel.Hotel;
import br.edu.utfpr.hotel.modelo.Hospede;

public class PrincipalMenu {

    public static void abrirMenu() {
        System.out.println();
        int option;
        do {
            System.out.println();
            System.out.println("=== Menu Principal ===");
            System.out.println("1 - Quartos");
            System.out.println("2 - Hospedes");
            System.out.println("4 - Sair");
            option = Hotel.INPUT.nextInt();
            switch(option) {
                case 1:
                    QUARTO_MENU.abrir();
                    break;
                case 2:
                    Hospede.menu(); // FIXME
                    break;
                default:
            }
        } while(option != SAIR_MENU_INDEX);
    }

    private static final QuartoMenu QUARTO_MENU = new QuartoMenu();

    private static final int SAIR_MENU_INDEX = 4;
}