package br.edu.utfpr.hotel.menu;

import br.edu.utfpr.hotel.Hotel;
import br.edu.utfpr.hotel.estado.Indisponivel;
import br.edu.utfpr.hotel.estado.Ocupado;
import br.edu.utfpr.hotel.modelo.Hospede;
import br.edu.utfpr.hotel.modelo.Pessoa;
import br.edu.utfpr.hotel.modelo.Quarto;
import br.edu.utfpr.hotel.modelo.Reserva;

import java.time.LocalDate;

public class HospedeMenu extends AbstractMenu {
    public HospedeMenu() {
        super(
                "Hospede",
                "Gerar Hospedes",
                "Adicionar Reserva",
                "Listar Hospedes",
                "Remover Hospede"
        );
    }

    private final Hospede.HospedeManager hospedeManager = Hospede.HospedeManager.getInstance();

    @Override
    protected void gerar() {
        for (int i = 0; i < 30; i++) {
            Pessoa.Builder builder = new Pessoa.Builder("Nome" + (hospedeManager.size() + 1))
                .email("email" + (hospedeManager.size() + 1) + "@example.com")
                .telefone("Telefone" + (hospedeManager.size() + 1))
                .endereco("Endereço " + (hospedeManager.size() + 1));
            Hospede hospede = new Hospede(builder);
            hospedeManager.addHospede(hospede);
        }
        System.out.println("30 hóspedes gerados com sucesso!");
    }

    @Override
    protected void gerenciar() {
        int option;
        do {
            System.out.println("=== Gerenciar Hóspedes ===");
            System.out.println("1 - Criar Reserva");
            System.out.println("2 - Checkout / Remover Reserva");
            System.out.println("3 - Sair");
            option = Hotel.INPUT.nextInt();
            switch(option) {
                case 1:
                    fazerReserva();
                    break;
                case 2:
                    checkOut();
                    break;
                default:
            }
        } while(option != 3);
    }

    private void fazerReserva() {
        int option;
        do {
            System.out.println("Digite o id do hóspede que deseja fazer a reserva:");
            option = Hotel.INPUT.nextInt();
            if (option > 0 && option <= hospedeManager.size()) {
                option--;
                Quarto quarto = Quarto.QuartoManager.getInstance().getFirstAvailable();
                hospedeManager.getHospede(option).setReserva(
                    new Reserva(
                        hospedeManager.getHospede(option),
                        quarto,
                        LocalDate.now(),
                        LocalDate.now().plusDays(5)
                    )
                );
                quarto.setEstado(new Ocupado(quarto));
                System.out.println("Reserva realizada com sucesso!");
            } else if (option != 0) {
                System.out.println("Índice inválido. Tente novamente.");
            }
        } while (option > 0);
    }

    private void checkOut() {
        int option;
        do {
            System.out.println("Digite o id do hóspede que deseja fazer o checkout:");
            option = Hotel.INPUT.nextInt();
            if(option > 0 && option <= hospedeManager.size()) {
                option--;
                Hospede hospede = hospedeManager.getHospede(option);
                Reserva reserva = hospede.getReserva();
                if(reserva != null) {
                    reserva.getQuarto().setEstado(new Indisponivel(reserva.getQuarto()));
                    hospede.setReserva(null);
                } else {
                    System.out.println("Hóspede informado não tem reservas.");
                }
                System.out.println("Checout realizado com sucesso!");
            } else if (option != 0) {
                System.out.println("Índice inválido. Tente novamente.");
            }
        } while(option > 0);
    }

    @Override
    protected void listar() {
        int i = hospedeManager.size();
        if (i == 0) {
            System.out.println("ERRO: Não há hóspedes registrados. Tente novamente após registrar alguns hóspedes.");
            return;
        }
        System.out.printf("Exibindo dados de todos os %s hóspedes:\n", i);
        hospedeManager.forEach(Hospede::exibirDados);
    }

    @Override
    protected void remover() {
        if (hospedeManager.isEmpty()) {
            System.out.println("ERRO: Não há hóspedes registrados. Tente novamente após registrar alguns hóspedes.");
            return;
        }

        int option;
        do {
            System.out.println("Digite o índice do hóspede ou 0 para voltar: ");
            option = Hotel.INPUT.nextInt();
            if (option > 0 && option <= hospedeManager.size()) {
                hospedeManager.removeHospede(option - 1);
                System.out.println("Hóspede removido com sucesso!");
            } else if (option != 0) {
                System.out.println("Índice inválido. Tente novamente.");
            }
        } while (option > 0);
    }
}