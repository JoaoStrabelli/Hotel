package br.edu.utfpr.hotel.estado;
import br.edu.utfpr.hotel.modelo.Quarto;

public class Disponivel implements Estado {

    private final Quarto quarto;

    public Disponivel(Quarto quarto) {
        this.quarto = quarto;
    }

    @Override
    public void ocupar() {
        quarto.setEstado(new Ocupado(quarto));
        System.out.println("SUCESSO: Ocupado!");
    }

    @Override
    public void desocupar() {
        System.out.println("ERRO: Já está desocupado!");
    }

    @Override
    public void limpar() {
        System.out.println("ERRO: Já está limpo!");
    }

}