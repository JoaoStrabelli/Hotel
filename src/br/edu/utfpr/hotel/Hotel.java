package br.edu.utfpr.hotel;

import br.edu.utfpr.hotel.modelo.Quarto;

public class Hotel {

    public static void main(String[] args) {
        Quarto quarto = new Quarto(1, 10F);

        quarto.estado.desocupar();
        quarto.estado.limpar();

        quarto.estado.ocupar();
        quarto.estado.limpar();
        quarto.estado.ocupar();
        quarto.estado.desocupar();

        quarto.estado.desocupar();
        quarto.estado.ocupar();
        quarto.estado.limpar();

    }
}