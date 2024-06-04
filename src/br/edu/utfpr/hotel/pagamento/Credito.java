package br.edu.utfpr.hotel.pagamento;

public class Credito implements Pagamento{
    @Override
    public void pagar() {
        System.out.println("Pagando no crédito!");
    }
}
