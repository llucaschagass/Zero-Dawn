import java.util.Scanner;

public class Poseidon extends Gaia {
    private int nivelChuvas, porcentagem;
    private Scanner scanner;

    public Poseidon(String nome, int versao) {
        super(nome, versao);
        nivelChuvas = 0;
        scanner = new Scanner(System.in);
    }

    public void inicializar() {
        System.out.println("Inicializando Poseidon...");
        System.out.println();
        exibirMenu();
    }

    private void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Menu de Gerenciamento de Água ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Distribuição de água");
            System.out.println("2. Controle de inundações");
            System.out.println("3. Verificar nível de chuvas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    realizarDistribuicaoAgua();
                    break;
                case 2:
                    realizarControleInundacoes();
                    break;
                case 3:
                    verificarNivelChuvas();
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

    private void realizarDistribuicaoAgua() {
        System.out.println("=== Realizar Distribuição de Água ===");
        while (porcentagem < 101 ){
            System.out.println(porcentagem +"%");
            porcentagem = porcentagem +1;
        }
        System.out.println();
        System.out.println("Distribuição de água realizada com sucesso.");
        System.out.println();
    }

    private void realizarControleInundacoes() {
        System.out.println("=== Realizar Controle de Inundações ===");
        System.out.println("Controle de inundações realizado com sucesso.");
        System.out.println();
    }

    private void verificarNivelChuvas() {
        System.out.println("=== Verificar Nível de Chuvas ===");
        System.out.println("Nível atual de chuvas: " + nivelChuvas);
        System.out.println();
    }

    public void atualizarNivelChuvas(int nivel) {
        nivelChuvas = nivel;
    }

    public static void main(String[] args) {
        Poseidon poseidon = new Poseidon("Poseidon", 1);
        poseidon.inicializar();
    }
}


