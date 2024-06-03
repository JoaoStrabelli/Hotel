package br.edu.utfpr.hotel.estado;

import br.edu.utfpr.hotel.modelo.Quarto;

public class Ocupado implements Estado {

    private final Quarto quarto;

    public Ocupado(Quarto quarto) {
        this.quarto = quarto;
    }

    @Override
    public void ocupar() {
        mensagemErro("ocupado");
    }

    @Override
    public void desocupar() {
        quarto.setEstado(new Indisponivel(quarto));
        mensagemSucesso("desocupado");
    }

    @Override
    public void limpar() {
        mensagemErro("limpo");
    }

    @Override
    public String getNome() {
        return "Ocupado";
    }
}