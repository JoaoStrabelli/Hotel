package br.edu.utfpr.hotel.modelo;

import java.time.LocalDate;
import java.util.Date;
import static java.time.temporal.ChronoUnit.DAYS;

public class Reserva implements IExibirDados {

    private final Hospede hospede;
    private final Quarto quarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    public Reserva(Hospede hospede, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    @Override
    public void exibirDados() {
        System.out.printf("    - Reserva do quarto #%d por %d dias com diária de R$%.2f", quarto.getId(), getDuracao(), quarto.getValor());
    }

    public Hospede getHospede() { return hospede; }
    public Quarto getQuarto() { return quarto; }
    public LocalDate getDataCheckIn() { return dataCheckIn; }
    public void setDataCheckIn(LocalDate dataCheckIn) { this.dataCheckIn = dataCheckIn; }
    public LocalDate getDataCheckOut() { return dataCheckOut; }
    public void setDataCheckOut(LocalDate dataCheckOut) { this.dataCheckOut = dataCheckOut; }

    public long getDuracao() {
        return DAYS.between(dataCheckIn, dataCheckOut);
    }

    public double getValorTotal() {
        return getDuracao() * this.quarto.getValor();
    }

}