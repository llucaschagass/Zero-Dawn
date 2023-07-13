/**
 Hephaestus:
 Tem a função de fabricar e gerenciar a produção de máquinas, garantindo seu bom funcionamento e manutenção.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Hephaestus extends Gaia {
    private HashMap<String, Machine> catalogoMaquinas;
    private Scanner scanner;

    public Hephaestus(String nome, int versao) {
        super(nome, versao);
        catalogoMaquinas = new HashMap<>();
        inicializarCatalogoMaquinas();
        scanner = new Scanner(System.in);
    }

    public void inicializar() {
        System.out.println("Inicializando Hephaestus...");
        System.out.println();
        exibirMenu();
    }

    private void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Mostrar Catálogo");
            System.out.println("2. Criar Máquina");
            System.out.println("3. Consertar Máquina");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            System.out.println();

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    mostrarCatalogo();
                    break;
                case 2:
                    criarMaquina();
                    break;
                case 3:
                    consertarMaquina();
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

    private void inicializarCatalogoMaquinas() {
        String filePath = "C:\\Users\\Lucas\\OneDrive\\Área de Trabalho\\Atividade Severino\\Zero Dawn\\maquinas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            Machine maquina = null;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome:")) {
                    if (maquina != null) {
                        catalogoMaquinas.put(maquina.getNome().toLowerCase(), maquina);
                    }
                    String nome = linha.substring(5);
                    maquina = new Machine(nome);
                } else if (linha.startsWith("Classe:")) {
                    String classe = linha.substring(7);
                    if (maquina != null) {
                        maquina.setClasse(classe);
                    }
                } else if (linha.startsWith("Fraquezas:")) {
                    String fraquezas = linha.substring(10);
                    if (maquina != null) {
                        maquina.setFraquezas(fraquezas);
                    }
                } else if (linha.startsWith("Caldeirão:")) {
                    String caldeirao = linha.substring(10);
                    if (maquina != null) {
                        maquina.setCaldeirao(caldeirao);
                    }
                }
            }

            if (maquina != null) {
                catalogoMaquinas.put(maquina.getNome().toLowerCase(), maquina);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarCatalogo() {
        System.out.println("=== Catálogo de Máquinas ===");
        for (Machine maquina : catalogoMaquinas.values()) {
            System.out.println("Nome: " + maquina.getNome());
            System.out.println("Classe: " + maquina.getClasse());
            System.out.println("Fraquezas: " + maquina.getFraquezas());
            System.out.println("Caldeirão: " + maquina.getCaldeirao());
            System.out.println();
        }
    }

    private void criarMaquina() {
        System.out.println("=== Criar Máquina ===");
        System.out.print("Digite o nome da máquina: ");
        String nome = scanner.nextLine();

        Machine novaMaquina = new Machine(nome);
        catalogoMaquinas.put(nome.toLowerCase(), novaMaquina);

        System.out.println("Máquina criada com sucesso!");
    }

    private void consertarMaquina() {
        System.out.println("=== Consertar Máquina ===");
        System.out.print("Digite o nome da máquina a ser consertada: ");
        String nome = scanner.nextLine();

        Machine maquina = catalogoMaquinas.get(nome.toLowerCase());
        if (maquina != null) {
            // Lógica de conserto da máquina
            System.out.println("Consertando a máquina: " + maquina.getNome());
        } else {
            System.out.println("Máquina não encontrada no catálogo.");
        }
    }

    public static void main(String[] args) {
        Hephaestus hephaestus = new Hephaestus("Hephaestus", 1);
        hephaestus.inicializar();
    }
}



