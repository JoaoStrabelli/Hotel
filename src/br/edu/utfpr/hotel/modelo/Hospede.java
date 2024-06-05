package br.edu.utfpr.hotel.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Hospede extends Pessoa implements IExibirDados {

    public Reserva reserva;

    public Hospede(Builder builder, Reserva reserva) {
        super(builder);
        this.reserva = reserva;
    }

    public Hospede(Builder builder) {
        super(builder);
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }


    @Override
    public void exibirDados() {
        System.out.printf("Nome: %s, Email: %s, Telefone: %s, Endereço: %s%n", getNome(), getEmail(), getTelefone(), getEndereco());
        if(reserva != null) {
            reserva.exibirDados();
        }
    }

    public static class HospedeManager {
        private static HospedeManager instance;
        private final List<Hospede> hospedes = new ArrayList<>();

        public static HospedeManager getInstance() {
            if(instance == null) {
                instance = new HospedeManager();
            }
            return instance;
        }

        public Hospede getHospede(int index) {
            return hospedes.get(index);
        }

        public void addHospede(Hospede hospede) {
            hospedes.add(hospede);
        }

        public void removeHospede(int index) {
            if(index >= 0 && index < hospedes.size()) {
                hospedes.remove(index);
            }
        }

        public int size() {
            return hospedes.size();
        }

        public boolean isEmpty() {
            return hospedes.isEmpty();
        }

        public void forEach(Consumer<? super Hospede> consumer) {
            hospedes.forEach(consumer);
        }
    }

}