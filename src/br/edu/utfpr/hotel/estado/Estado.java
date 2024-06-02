package br.edu.utfpr.hotel.estado;

public interface Estado {

    void ocupar();
    void desocupar();
    void limpar();


    default void mensagemErro(String estado) {
        System.out.printf("ERRO: Quarto já está %s!%n", estado);
    }

    default void mensagemSucesso(String estado) {
        System.out.printf("SUCESSO: O quarto foi %s!%n", estado);
    }
}