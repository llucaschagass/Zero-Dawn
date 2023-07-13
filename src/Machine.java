public class Machine {
    private String nome;
    private String classe;
    private String fraquezas;
    private String caldeirao;

    public Machine(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getFraquezas() {
        return fraquezas;
    }

    public void setFraquezas(String fraquezas) {
        this.fraquezas = fraquezas;
    }

    public String getCaldeirao() {
        return caldeirao;
    }

    public void setCaldeirao(String caldeirao) {
        this.caldeirao = caldeirao;
    }
}

