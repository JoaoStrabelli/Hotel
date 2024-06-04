package br.edu.utfpr.hotel.pagamento;

public class Pix implements Pagamento{
    @Override
    public void pagar() {
        System.out.println("Pagando no PIX!");
    }
}

