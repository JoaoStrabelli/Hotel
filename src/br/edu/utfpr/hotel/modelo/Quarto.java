package br.edu.utfpr.hotel.modelo;

import br.edu.utfpr.hotel.estado.Disponivel;
import br.edu.utfpr.hotel.estado.Estado;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Quarto implements IExibirDados {
    private int id;
    private float valor;
    private Estado estado;

    public Quarto(int id, float valor) {
        this(id, valor, null);
        this.estado = new Disponivel(this);
    }

    public Quarto(int id, float valor, Estado estado) {
        this.id = id;
        this.valor = valor;
        this.estado = estado;
    }

    @Override
    public void exibirDados() {
        System.out.printf("    - ID %d (%s) com diária de R$%.2f%n", id, estado.getNome(), valor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    private static final int SAIR_MENU_QUARTO_INDEX = 5;


    public static class QuartoManager {
        private static QuartoManager instance;
        private final List<Quarto> quartos = new ArrayList<>();

        public static QuartoManager getInstance() {
            if(instance == null) {
                instance = new QuartoManager();
            }
            return instance;
        }

        public Quarto get(int index) {
            return quartos.get(index);
        }

        public void addQuarto(Quarto quarto) {
            quartos.add(quarto);
        }

        public void removeQuarto(int index) {
            if(index >= 0 && index < quartos.size()) {
                quartos.remove(index);
            }
        }

        public int size() {
            return quartos.size();
        }

        public boolean isEmpty() {
            return quartos.isEmpty();
        }

        public void forEach(Consumer<? super Quarto> consumer) {
            quartos.forEach(consumer);
        }

        public Quarto getFirstAvailable() {
            return quartos
                .stream()
                .filter(q -> q.estado.getNome().equals("Disponível"))
                .findFirst().get();
        }
    }
}