package br.edu.utfpr.hotel.modelo;

import br.edu.utfpr.hotel.estado.Disponivel;
import br.edu.utfpr.hotel.estado.Estado;

public class Quarto {
    private int id;
    private float valor;
    public Estado estado;

    public Quarto(int id, float valor) {
        this(id, valor, null);
        this.estado = new Disponivel(this);
    }

    public Quarto(int id, float valor, Estado estado) {
        this.id = id;
        this.valor = valor;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}