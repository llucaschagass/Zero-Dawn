/**
 Hades:
 Tem a função de ser uma contramedida de emergência, caso a vida na Terra não possa ser mantida.
 Hades é projetado para desencadear a extinção de todas as formas de vida no planeta.
 */
import java.util.Scanner;

public class Hades extends Gaia {
    private Scanner scanner;

    public Hades(String nome, int versao) {
        super(nome, versao);
        scanner = new Scanner(System.in);
    }

    public void inicializar() {
        System.out.println("Inicializando Hades...");
        System.out.println();
        analisarSituacaoHabitacao();
    }

    public void analisarSituacaoHabitacao() {
        System.out.print("Digite o nível de satisfação da vegetação (0-100): ");
        double nivelVegetacao = scanner.nextDouble();

        System.out.print("Digite o nível de satisfação da água (0-100): ");
        double nivelAgua = scanner.nextDouble();

        System.out.print("Digite o nível de satisfação do ar (0-100): ");
        double nivelAr = scanner.nextDouble();

        if (nivelVegetacao < 50 || nivelAgua < 50 || nivelAr < 50) {
            System.out.println("Situação crítica de habitação detectada!");
            executarExtincao();
        } else {
            System.out.println("Situação de habitação estável.");
            System.out.println();
        }
    }

    private void executarExtincao() {
        System.out.println("Executando extinção de todas as formas de vida...");
        System.out.println();
    }

    public static void main(String[] args) {
        Hades hades = new Hades("Hades", 1);
        hades.inicializar();
        hades.analisarSituacaoHabitacao();
    }
}

