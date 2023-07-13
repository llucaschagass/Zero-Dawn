import java.util.Scanner;
public class Gaia {
    // Variáveis de instância
    private String nome;
    private int versao;

    // Construtor
    public Gaia(String nome, int versao) {
        this.nome = nome;
        this.versao = versao;
    }

    // Métodos
    public void inicializar() {
        System.out.println("Inicializando a GAIA...");
        System.out.println();
    }

    public void executar() {
        System.out.println("Bem vindo ao Protocolo de Terraformação GAIA");
        System.out.println();
        System.out.println("Escolha a função subordinada da Gaia que deseja executar: ");
        System.out.println();

        exibirMenugaia();
        int escolha = lerEscolha();

        switch (escolha) {
            case 1:
                Minerva minerva = new Minerva("Minerva",1);
                minerva.inicializar();
                break;
            case 2:
                Hades hades = new Hades("Hades", 1);
                hades.inicializar();
                break;
            case 3:
                Apollo apollo = new Apollo("Apollo",1);
                apollo.inicializar();
                break;
            case 4:
                Artemis artemis = new Artemis("Artemis", 1);
                artemis.inicializar();
                break;
            case 5:
                Demeter demeter = new Demeter("Demeter",1);
                demeter.inicializar();
                break;
            case 6:
                Hephaestus hephaestus = new Hephaestus("Hephaestus",1);
                hephaestus.inicializar();
                break;
            case 7:
                Poseidon poseidon = new Poseidon("Poseidon",1);
                poseidon.inicializar();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void atualizar() {
        System.out.println("Atualizando a GAIA para a versão " + (versao + 1) + "...");
    }

    public void desligar() {
        System.out.println("Desligando a GAIA...");
    }

    public void backup(){
        int porcentagem = 0;
        while (porcentagem < 101 ){
            System.out.println(porcentagem +"%");
            porcentagem = porcentagem +1;
        }
        System.out.println();
        System.out.println("Processo de Backup concluído");

    }
    private void exibirMenugaia() {
        System.out.println("===== Menu de Opções =====");
        System.out.println("1. Inicializar Minerva");
        System.out.println("2. Inicializar Hades");
        System.out.println("3. Inicializar Apollo");
        System.out.println("4. Inicializar Artemis");
        System.out.println("5. Inicializar Demeter");
        System.out.println("6. Inicializar Hephaestus");
        System.out.println("7. Inicializar Poseidon");
        System.out.println("0. Voltar");
        System.out.println();

    }
    private int lerEscolha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        return escolha;
    }

    public static void main(String[] args) {
        Gaia gaia = new Gaia("GAIA", 1);
        gaia.inicializar();
        gaia.executar();
        gaia.desligar();
    }

}
