package br.edu.utfpr.hotel.modelo;

import br.edu.utfpr.hotel.Hotel;
import java.util.ArrayList;
import java.util.List;

class HospedeManager {
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


public class Hospede extends Pessoa implements IExibirDados {

    protected final Reserva reserva = null; // FIXME

    public Hospede(String nome, String email, String telefone, String endereco) {
        super(nome, email, telefone, endereco);
    }

    @Override
    public void exibirDados() {
        System.out.printf("Nome: %s, Email: %s, Telefone: %s, Endereço: %s%n", getNome(), getEmail(), getTelefone(), getEndereco());
    }


    public static void menu() {
        int option;
        HospedeManager manager = HospedeManager.getInstance();

        do {
            System.out.println("=== Hóspedes ===");
            System.out.println("1 - Gerar Hóspedes");
            System.out.println("2 - Mudar estado de Hóspede");
            System.out.println("3 - Listar Hóspedes");
            System.out.println("4 - Remover Hóspede");
            System.out.println("5 - Voltar");
            option = Hotel.INPUT.nextInt();
            switch (option) {
                case 1:
                    gerarHospedes(manager);
                    break;
                case 2:
                    mudarEstadoDeHospede();
                    break;
                case 3:
                    listarHospedes(manager);
                    break;
                case 4:
                    removerHospede(manager);
                    break;
                default:
                    break;
            }
        } while (option != SAIR_MENU_HOSPEDE_INDEX);
    }

    private static void gerarHospedes(HospedeManager manager) {
        for (int i = 0; i < 30; i++) {
            Hospede hospede = new Hospede(
                    "Nome" + (manager.getHospedes().size() + 1),
                    "email" + (manager.getHospedes().size() + 1) + "@example.com",
                    "Telefone" + (manager.getHospedes().size() + 1),
                    "Endereço " + (manager.getHospedes().size() + 1)
            );
            manager.addHospede(hospede);
        }
        System.out.println("30 hóspedes gerados com sucesso!");
    }

    private static void mudarEstadoDeHospede() {
        // TODO: Implementar lógica para mudar o estado de um hóspede, se necessário
    }

    private static void removerHospede(HospedeManager manager) {
        if (manager.getHospedes().isEmpty()) {
            System.out.println("ERRO: Não há hóspedes registrados. Tente novamente após registrar alguns hóspedes.");
            return;
        }

        int option;
        do {
            System.out.println("Digite o índice do hóspede ou 0 para voltar: ");
            option = Hotel.INPUT.nextInt();
            if (option > 0 && option <= manager.getHospedes().size()) {
                manager.removeHospede(option - 1);
                System.out.println("Hóspede removido com sucesso!");
            } else if (option != 0) {
                System.out.println("Índice inválido. Tente novamente.");
            }
        } while (option > 0);
    }

    private static void listarHospedes(HospedeManager manager) {
        int i = manager.getHospedes().size();
        if (i == 0) {
            System.out.println("ERRO: Não há hóspedes registrados. Tente novamente após registrar alguns hóspedes.");
            return;
        }
        System.out.printf("Exibindo dados de todos os %s hóspedes:\n", i);
        manager.getHospedes().forEach(Hospede::exibirDados);
    }

    private static final int SAIR_MENU_HOSPEDE_INDEX = 5;
}