/**
 Artemis:
 Tem a tarefa de catalogar e preservar a diversidade biológica da Terra, incluindo informações sobre flora e fauna.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Artemis extends Gaia {
    private Map<String, String> catalogoFlora;
    private Map<String, String> catalogoFauna;
    private Scanner scanner;

    public Artemis(String nome, int versao) {
        super(nome, versao);
        catalogoFlora = new HashMap<>();
        catalogoFauna = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void inicializar() {
        System.out.println("Inicializando Artemis...");
        System.out.println();
        carregarCatalogoFlora("flora.txt");
        carregarCatalogoFauna("fauna.txt");
        exibirMenu();
    }

    private void carregarCatalogoFlora(String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            String nome = "";
            StringBuilder descricao = new StringBuilder();
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome:")) {
                    if (!nome.isEmpty()) {
                        catalogoFlora.put(nome, descricao.toString());
                    }
                    nome = linha.substring(6).trim();
                    descricao = new StringBuilder();
                } else if (linha.startsWith("Região:")) {
                    String regiao = linha.substring(8).trim();
                    descricao.append("Região: ").append(regiao).append("\n");
                } else {
                    descricao.append(linha).append("\n");
                }
            }
            catalogoFlora.put(nome, descricao.toString());
        } catch (IOException e) {
            System.out.println("Erro ao carregar o catálogo de flora.");
            e.printStackTrace();
        }
    }

    private void carregarCatalogoFauna(String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            String nome = "";
            StringBuilder descricao = new StringBuilder();
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome:")) {
                    if (!nome.isEmpty()) {
                        catalogoFauna.put(nome, descricao.toString());
                    }
                    nome = linha.substring(6).trim();
                    descricao = new StringBuilder();
                } else if (linha.startsWith("Região:")) {
                    String regiao = linha.substring(8).trim();
                    descricao.append("Região: ").append(regiao).append("\n");
                } else {
                    descricao.append(linha).append("\n");
                }
            }
            catalogoFauna.put(nome, descricao.toString());
        } catch (IOException e) {
            System.out.println("Erro ao carregar o catálogo de fauna.");
            e.printStackTrace();
        }
    }

    private void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Menu de Catálogos ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Exibir catálogo de flora");
            System.out.println("2. Exibir catálogo de fauna");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirCatalogoFlora();
                    break;
                case 2:
                    exibirCatalogoFauna();
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

    private void exibirCatalogoFlora() {
        System.out.println("=== Catálogo de Flora ===");
        for (String nome : catalogoFlora.keySet()) {
            System.out.println("Nome: " + nome);
            System.out.println("Descrição: " + catalogoFlora.get(nome));
            System.out.println();
        }
    }

    private void exibirCatalogoFauna() {
        System.out.println("=== Catálogo de Fauna ===");
        for (String nome : catalogoFauna.keySet()) {
            System.out.println("Nome: " + nome);
            System.out.println("Descrição: " + catalogoFauna.get(nome));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Artemis artemis = new Artemis("Artemis", 1);
        artemis.inicializar();
    }
}



