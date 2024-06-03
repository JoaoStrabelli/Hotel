package br.edu.utfpr.hotel.modelo;

import br.edu.utfpr.hotel.Hotel;
import br.edu.utfpr.hotel.estado.Disponivel;
import br.edu.utfpr.hotel.estado.Estado;

import java.util.ArrayList;
import java.util.Random;

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



    public static void menu() {
        int option;
        do {
            System.out.println("=== Quartos ===");
            System.out.println("1 - Gerar Quartos");
            System.out.println("2 - Mudar estado de Quarto");
            System.out.println("3 - Listar Quartos");
            System.out.println("4 - Remover Quarto");
            System.out.println("5 - Voltar");
            option = Hotel.INPUT.nextInt();
            switch(option) {
                case 1:
                    gerarQuartos();
                    break;
                case 2:
                    mudarEstadoDeQuarto();
                    break;
                case 3:
                    listarQuartos();
                    break;
                case 4:
                    removerQuarto();
                    break;
                default:
                    break;
            }
        } while(option != SAIR_MENU_QUARTO_INDEX);
    }

    private static void gerarQuartos() {
        for(int i = 0; i < 30; i++) {
            Quarto quarto = new Quarto(
                QUARTOS.size() + 1,
                new Random().nextFloat(50F, 290F)
            );
            QUARTOS.add(quarto);
        }
    }

    private static void mudarEstadoDeQuarto() { // TODO
    }

    private static void removerQuarto() {
        if(QUARTOS.isEmpty()) {
            System.out.println("ERRO: Não há quartos registrados. Tente novamente após registrar alguns quartos.");
            return;
        }

        int option;
        do {
            System.out.println("Digite o id do quarto ou 0 para voltar: ");
            option = Hotel.INPUT.nextInt();
            if(option > 0) {
                QUARTOS.remove(option);
                System.out.println("Quarto removido com sucesso!");
            }
        } while(option > 0);
    }

    private static void listarQuartos() {
        int i = QUARTOS.size();
        if(i == 0) {
            System.out.println("ERRO: Não há quartos registrados. Tente novamente após registrar alguns quartos.");
            return;
        }
        System.out.printf("Exibindo dados de todos os %s quartos:\n", i);
        QUARTOS.forEach(Quarto::exibirDados);
    }


    private static final int SAIR_MENU_QUARTO_INDEX = 5;
    public static final ArrayList<Quarto> QUARTOS = new ArrayList<>();
}