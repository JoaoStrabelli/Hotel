package br.edu.utfpr.hotel.menu;

import br.edu.utfpr.hotel.Hotel;
import br.edu.utfpr.hotel.estado.Disponivel;
import br.edu.utfpr.hotel.estado.Indisponivel;
import br.edu.utfpr.hotel.estado.Ocupado;
import br.edu.utfpr.hotel.modelo.Quarto;

import java.util.Random;

public class QuartoMenu extends AbstractMenu {

    protected QuartoMenu() {
        super(
            "Quarto",
            "Gerar Quartos",
            "Gerenciar Quarto",
            "Listar Quartos",
            "Remover Quarto"
        );
    }

    private final Quarto.QuartoManager quartoManager = Quarto.QuartoManager.getInstance();

    @Override
    protected void gerar() {
        for(int i = 0; i < 30; i++) {
            Quarto quarto = new Quarto(
                quartoManager.size() + 1,
                new Random().nextFloat(50F, 290F)
            );
            quartoManager.addQuarto(quarto);
        }
    }

    @Override
    protected void gerenciar() {
        if(quartoManager.isEmpty()) {
            System.out.println("ERRO: Não há quartos registrados. Tente novamente após registrar alguns quartos.");
            return;
        }

        int option;
        do {
            System.out.println("Digite o id do quarto ou 0 para voltar: ");
            option = Hotel.INPUT.nextInt();
            if(option > 0 && option < quartoManager.size() + 1) {
                option--;
                String state;
                boolean hasStateChanged = false;
                do {
                    System.out.println("Escolha o estado (disponivel, indisponivel, ocupado): ");
                    state = Hotel.INPUT.nextLine();
                    switch(state) {
                        case "disponível", "disponivel":
                            quartoManager.get(option).setEstado(new Disponivel(quartoManager.get(option)));
                            hasStateChanged = true;
                            break;
                        case "indisponível", "indisponivel":
                            quartoManager.get(option).setEstado(new Indisponivel(quartoManager.get(option)));
                            hasStateChanged = true;
                            break;
                        case "ocupado":
                            quartoManager.get(option).setEstado(new Ocupado(quartoManager.get(option)));
                            hasStateChanged = true;
                            break;
                    }
                } while(!hasStateChanged);
                System.out.println("O estado do quarto foi alterado.");
            }
        } while(option > 0);
    }

    @Override
    protected void remover() {
        if(quartoManager.isEmpty()) {
            System.out.println("ERRO: Não há quartos registrados. Tente novamente após registrar alguns quartos.");
            return;
        }

        int option;
        do {
            System.out.println("Digite o id do quarto ou 0 para voltar: ");
            option = Hotel.INPUT.nextInt();
            if(option > 0 && option < quartoManager.size() + 1) {
                quartoManager.removeQuarto(option - 1);
                System.out.println("Quarto removido com sucesso!");
            }
        } while(option > 0);
    }

    @Override
    protected void listar() {
        int i = quartoManager.size();
        if(i == 0) {
            System.out.println("ERRO: Não há quartos registrados. Tente novamente após registrar alguns quartos.");
            return;
        }
        System.out.printf("Exibindo dados de todos os %s quartos:\n", i);
        quartoManager.forEach(Quarto::exibirDados);
    }
}