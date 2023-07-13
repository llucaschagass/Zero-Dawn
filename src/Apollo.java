/**
 Apollo:
 É responsável pela educação e instrução da nova geração de humanos, transmitindo conhecimentos e informações necessárias
 para a reconstrução da sociedade.
 */

import java.util.Scanner;

public class Apollo extends Gaia {
    private Scanner scanner;

    public Apollo(String nome, int versao) {
        super(nome, versao);
        scanner = new Scanner(System.in);
    }

    public void inicializar() {
        System.out.println("Inicializando Apollo...");
        System.out.println();
        exibirMenu();
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Menu de Educação ===");
            System.out.println("Escolha a matéria que gostaria de aprender:");
            System.out.println("1. Matemática");
            System.out.println("2. Português");
            System.out.println("3. História");
            System.out.println("4. Física");
            System.out.println("5. Química");
            System.out.println("6. Geografia");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    aprenderMatematica();
                    break;
                case 2:
                    aprenderPortugues();
                    break;
                case 3:
                    aprenderHistoria();
                    break;
                case 4:
                    aprenderFisica();
                    break;
                case 5:
                    aprenderQuimica();
                    break;
                case 6:
                    aprenderGeografia();
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

    private void aprenderMatematica() {
        System.out.println("=== Aprendendo Matemática ===");
    }

    private void aprenderPortugues() {
        System.out.println("=== Aprendendo Português ===");
    }

    private void aprenderHistoria() {
        System.out.println("=== Aprendendo História ===");
    }

    private void aprenderFisica() {
        System.out.println("=== Aprendendo Física ===");
    }

    private void aprenderQuimica() {
        System.out.println("=== Aprendendo Química ===");
    }

    private void aprenderGeografia() {
        System.out.println("=== Aprendendo Geografia ===");
    }

    public static void main(String[] args) {
        Apollo apollo = new Apollo("Apollo", 1);
        apollo.inicializar();
    }
}


