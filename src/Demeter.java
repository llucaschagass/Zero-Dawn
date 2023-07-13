/**
 Demeter:
 É responsável por regular e gerenciar todos os aspectos relacionados à agricultura,
 garantindo a produção de alimentos para a sobrevivência humana.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demeter extends Gaia {
    private Map<String, Integer> plantacoes;
    private int nivelEstoqueComida;
    private Scanner scanner;

    public Demeter(String nome, int versao) {
        super(nome, versao);
        plantacoes = new HashMap<>();
        nivelEstoqueComida = 0;
        scanner = new Scanner(System.in);
    }

    public void inicializar() {
        System.out.println("Inicializando Demeter...");
        System.out.println();
        exibirMenu();
    }

    private void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Menu de Agricultura ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Verificar andamento das plantações");
            System.out.println("2. Verificar nível do estoque de comida");
            System.out.println("3. Informar valor do estoque de comida");
            System.out.println("4. Adicionar nova plantação");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do inteiro

            switch (opcao) {
                case 1:
                    verificarAndamentoPlantacoes();
                    break;
                case 2:
                    verificarNivelEstoqueComida();
                    break;
                case 3:
                    informarValorEstoqueComida();
                    break;
                case 4:
                    adicionarNovaPlantacao();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private void verificarAndamentoPlantacoes() {
        System.out.println("=== Verificar Andamento das Plantações ===");
        if (plantacoes.isEmpty()) {
            System.out.println("Não há plantações registradas.");
        } else {
            for (String planta : plantacoes.keySet()) {
                int andamento = plantacoes.get(planta);
                System.out.println("Planta: " + planta);
                System.out.println("Andamento: " + andamento + "%");
                System.out.println();
            }
        }
    }

    private void verificarNivelEstoqueComida() {
        System.out.println("=== Verificar Nível do Estoque de Comida ===");
        System.out.println("Nível atual do estoque de comida: " + nivelEstoqueComida + "%" );
        System.out.println();
    }

    private void informarValorEstoqueComida() {
        System.out.println("=== Informar Valor do Estoque de Comida ===");
        System.out.print("Digite o novo valor do estoque de comida: ");
        int novoValor = scanner.nextInt();
        scanner.nextLine();
        atualizarNivelEstoqueComida(novoValor);
        System.out.println("Valor do estoque de comida atualizado com sucesso.");
        System.out.println();
    }

    private void adicionarNovaPlantacao() {
        System.out.println("=== Adicionar Nova Plantação ===");
        System.out.print("Digite o nome da nova plantação: ");
        String nomePlanta = scanner.nextLine();
        System.out.print("Digite o andamento da plantação (em %): ");
        int andamento = scanner.nextInt();
        scanner.nextLine();
        adicionarPlantacao(nomePlanta, andamento);
        System.out.println("Nova plantação adicionada com sucesso.");
        System.out.println();
    }

    public void adicionarPlantacao(String planta, int andamento) {
        plantacoes.put(planta, andamento);
    }

    public void atualizarNivelEstoqueComida(int nivel) {
        nivelEstoqueComida = nivel;
    }

    public static void main(String[] args) {
        Demeter demeter = new Demeter("Demeter", 1);
        demeter.inicializar();
    }
}



