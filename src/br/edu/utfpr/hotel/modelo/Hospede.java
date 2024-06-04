package br.edu.utfpr.hotel.modelo;

import br.edu.utfpr.hotel.Hotel;
import java.util.ArrayList;
import java.util.List;

public class Hospede extends Pessoa implements IExibirDados {

    protected final Reserva reserva = null; // FIXME

    public Hospede(String nome, String email, String telefone, String endereco) {
        super(nome, email, telefone, endereco);
    }

    @Override
    public void exibirDados() {
        System.out.printf("Nome: %s, Email: %s, Telefone: %s, Endereço: %s%n", getNome(), getEmail(), getTelefone(), getEndereco());
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

        public void addHospede(Hospede hospede) {
            hospedes.add(hospede);
        }

        public void removeHospede(int index) {
            if(index >= 0 && index < hospedes.size()) {
                hospedes.remove(index);
            }
        }

        public List<Hospede> getHospedes() {
            return hospedes;
        }
    }

}