package br.edu.utfpr.hotel.menu;

import br.edu.utfpr.hotel.Hotel;
import br.edu.utfpr.hotel.modelo.Hospede;
import br.edu.utfpr.hotel.modelo.Quarto;

public class HospedeMenu extends AbstractMenu {
    public HospedeMenu() {
        super(
                "Hospede",
                "Gerar Hospedes",
                "Gerenciar Hospede",
                "Listar Hospedes",
                "Remover Hospede"
        );
    }

    private final Hospede.HospedeManager hospedeManager = Hospede.HospedeManager.getInstance();

    @Override
    protected void gerar() {
        for (int i = 0; i < 30; i++) {
            Hospede hospede = new Hospede(
                    "Nome" + (hospedeManager.getHospedes().size() + 1),
                    "email" + (hospedeManager.getHospedes().size() + 1) + "@example.com",
                    "Telefone" + (hospedeManager.getHospedes().size() + 1),
                    "Endereço " + (hospedeManager.getHospedes().size() + 1)
            );
            hospedeManager.addHospede(hospede);
        }
        System.out.println("30 hóspedes gerados com sucesso!");
    }

    @Override
    protected void gerenciar() {
        if (hospedeManager.getHospedes().isEmpty()) {
            System.out.println("ERRO: Não há hóspedes registrados. Tente novamente após registrar alguns hóspedes.");
            return;
        }

        int option;
        do {
            System.out.println("Digite o índice do hóspede que deseja gerenciar ou 0 para voltar: ");
            option = Hotel.INPUT.nextInt();
            if (option > 0 && option <= hospedeManager.getHospedes().size()) {
                Hospede hospede = hospedeManager.getHospedes().get(option - 1);
                System.out.println("Hóspede selecionado:");
                hospede.exibirDados();

                System.out.println("Digite o novo nome ou pressione Enter para manter o atual: ");
                Hotel.INPUT.nextLine(); // Consume the newline
                String nome = Hotel.INPUT.nextLine();
                if (!nome.isEmpty()) {
                    hospede.setNome(nome);
                }

                System.out.println("Digite o novo email ou pressione Enter para manter o atual: ");
                String email = Hotel.INPUT.nextLine();
                if (!email.isEmpty()) {
                    hospede.setEmail(email);
                }

                System.out.println("Digite o novo telefone ou pressione Enter para manter o atual: ");
                String telefone = Hotel.INPUT.nextLine();
                if (!telefone.isEmpty()) {
                    hospede.setTelefone(telefone);
                }

                System.out.println("Digite o novo endereço ou pressione Enter para manter o atual: ");
                String endereco = Hotel.INPUT.nextLine();
                if (!endereco.isEmpty()) {
                    hospede.setEndereco(endereco);
                }

                System.out.println("Dados do hóspede atualizados com sucesso!");
            } else if (option != 0) {
                System.out.println("Índice inválido. Tente novamente.");
            }
        } while (option > 0);
    }

    @Override
    protected void listar() {
        int i = hospedeManager.getHospedes().size();
        if (i == 0) {
            System.out.println("ERRO: Não há hóspedes registrados. Tente novamente após registrar alguns hóspedes.");
            return;
        }
        System.out.printf("Exibindo dados de todos os %s hóspedes:\n", i);
        hospedeManager.getHospedes().forEach(Hospede::exibirDados);
    }

    @Override
    protected void remover() {
        if (hospedeManager.getHospedes().isEmpty()) {
            System.out.println("ERRO: Não há hóspedes registrados. Tente novamente após registrar alguns hóspedes.");
            return;
        }

        int option;
        do {
            System.out.println("Digite o índice do hóspede ou 0 para voltar: ");
            option = Hotel.INPUT.nextInt();
            if (option > 0 && option <= hospedeManager.getHospedes().size()) {
                hospedeManager.removeHospede(option - 1);
                System.out.println("Hóspede removido com sucesso!");
            } else if (option != 0) {
                System.out.println("Índice inválido. Tente novamente.");
            }
        } while (option > 0);
    }
}
