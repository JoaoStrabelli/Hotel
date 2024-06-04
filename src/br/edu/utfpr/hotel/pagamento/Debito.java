package br.edu.utfpr.hotel.pagamento;

public class Debito implements Pagamento{
    @Override
    public void pagar() {
        System.out.println("Pagando no débito!");
    }
}
