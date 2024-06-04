package br.edu.utfpr.hotel.modelo;

import java.time.LocalDate;
import java.util.Date;
import static java.time.temporal.ChronoUnit.DAYS;

public class Reserva {
    private String idReserva;
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    public Reserva(String idReserva, Hospede hospede, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.idReserva = idReserva;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public String getIdReserva() { return idReserva; }
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
