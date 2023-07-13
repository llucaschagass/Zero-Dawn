import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        Gaia gaia = new Gaia("GAIA", 1);

        do {
            exibirMenu();
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println();
                    gaia.executar();
                    break;
                case 2:
                    gaia.atualizar();
                    break;
                case 3:
                    gaia.desligar();
                    break;
                case 4:
                    gaia.backup();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("===== Menu de Opções =====");
        System.out.println("1. Executar");
        System.out.println("2. Atualizar");
        System.out.println("3. Desligar");
        System.out.println("4. Fazer Backup");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
