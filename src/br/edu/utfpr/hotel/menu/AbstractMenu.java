package br.edu.utfpr.hotel.menu;

import br.edu.utfpr.hotel.Hotel;

public abstract class AbstractMenu {

    private final String titulo;
    private final String tituloGerar;
    private final String tituloGerenciar;
    private final String tituloListar;
    private final String tituloRemover;

    public AbstractMenu(String titulo, String tituloGerar, String tituloGerenciar, String tituloListar, String tituloRemover) {
        this.titulo = titulo;
        this.tituloGerar = tituloGerar;
        this.tituloGerenciar = tituloGerenciar;
        this.tituloListar = tituloListar;
        this.tituloRemover = tituloRemover;
    }


    public final void abrir() {
        int option;
        do {
            System.out.printf("=== %s ===\n", titulo);
            System.out.printf("1 - %s\n", tituloGerar);
            System.out.printf("2 - %s\n", tituloGerenciar);
            System.out.printf("3 - %s\n", tituloListar);
            System.out.printf("4 - %s\n", tituloRemover);
            System.out.println("5 - Voltar");
            option = Hotel.INPUT.nextInt();
            switch(option) {
                case 1:
                    gerar();
                    break;
                case 2:
                    gerenciar();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    remover();
                    break;
                default:
                    break;
            }
        } while(option != 5);
    }

    protected abstract  void gerar();
    protected abstract void gerenciar();
    protected abstract void listar();
    protected abstract void remover();

}