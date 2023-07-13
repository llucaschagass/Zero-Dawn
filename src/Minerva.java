/**
 Minerva:
 É responsável por supervisionar o desenvolvimento e o gerenciamento das instalações de inteligência artificial de GAIA.

 */
import java.util.Scanner;

public class Minerva extends Gaia {
    private Scanner scanner;

    public Minerva(String nome, int versao) {
        super(nome, versao);
        scanner = new Scanner(System.in);
    }

    public void inicializar() {
        System.out.println("Inicializando Minerva...");
        System.out.println();
    }

    public void supervisionarDesenvolvimento() {
        System.out.print("Digite o status do desenvolvimento (Em andamento, Concluído): ");
        String statusDesenvolvimento = scanner.nextLine();

        System.out.print("Digite o status do gerenciamento (Ativo, Inativo): ");
        String statusGerenciamento = scanner.nextLine();

        System.out.println("Supervisão do desenvolvimento e gerenciamento:");
        System.out.println("Status do desenvolvimento: " + statusDesenvolvimento);
        System.out.println("Status do gerenciamento: " + statusGerenciamento);
    }

    public static void main(String[] args) {
        Minerva minerva = new Minerva("Minerva", 1);
        minerva.inicializar();
        minerva.supervisionarDesenvolvimento();
    }
}


