package br.edu.utfpr.hotel.estado;

import br.edu.utfpr.hotel.modelo.Quarto;

public class Indisponivel implements Estado {

    private final Quarto quarto;

    public Indisponivel(Quarto quarto) {
        this.quarto = quarto;
    }

    @Override
    public void ocupar() {
        System.out.println("ERRO: Precisa ser limpo antes de ocupado novamente");
    }

    @Override
    public void desocupar() {
        System.out.println("ERRO: Precisa ser limpo antes de disponibilizado novamente");
    }

    @Override
    public void limpar() {
        quarto.setEstado(new Disponivel(quarto));
        System.out.println("SUCESSO: Limpado e novamente disponível!");
    }
}