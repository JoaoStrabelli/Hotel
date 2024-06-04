package br.edu.utfpr.hotel.pagamento;

public class Dinheiro implements Pagamento{
    @Override
    public void pagar() {
        System.out.println("Pagando no dinheiro!");
    }
}
