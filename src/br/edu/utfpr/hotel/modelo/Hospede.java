package br.edu.utfpr.hotel.modelo;

import br.edu.utfpr.hotel.Hotel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Singleton: Classe que gerencia a lista de hóspedes
class HospedeManager {
    private static HospedeManager instance;
    private List<Hospede> hospedes;
    private List<HospedeObserver> observers;

    private HospedeManager() {
        hospedes = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized HospedeManager getInstance() {
        if (instance == null) {
            instance = new HospedeManager();
        }
        return instance;
    }

    public void addHospede(Hospede hospede) {
        hospedes.add(hospede);
        notifyObservers();
    }

    public void removeHospede(int index) {
        if (index >= 0 && index < hospedes.size()) {
            hospedes.remove(index);
            notifyObservers();
        }
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void addObserver(HospedeObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (HospedeObserver observer : observers) {
            observer.update();
        }
    }
}

// Observer: Interface para notificação de mudanças
interface HospedeObserver {
    void update();
}

// Factory Method: Classe para criar hóspedes
class HospedeFactory {
    public Hospede createHospede(String nome, String email, String telefone, String endereco) {
        return new Hospede(nome, email, telefone, endereco);
    }
}

// Classe Hospede implementando IExibirDados
public class Hospede implements IExibirDados {
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public Hospede(String nome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public void exibirDados() {
        System.out.printf("Nome: %s, Email: %s, Telefone: %s, Endereço: %s%n", nome, email, telefone, endereco);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static void menu() {
        int option;
        HospedeFactory factory = new HospedeFactory();
        HospedeManager manager = HospedeManager.getInstance();
        manager.addObserver(() -> System.out.println("Lista de hóspedes atualizada."));

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
                    gerarHospedes(factory, manager);
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

    private static void gerarHospedes(HospedeFactory factory, HospedeManager manager) {
        for (int i = 0; i < 30; i++) {
            Hospede hospede = factory.createHospede(
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
