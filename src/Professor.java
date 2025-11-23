public class Professor extends Pessoa {
    private String especialidade;

    public Professor(String nome, String email, String especialidade) {
        super(nome, email);
        this.especialidade = especialidade != null ? especialidade : "Geral";
    }

    public Professor(String nome, String email) {
        this(nome, email, "Geral");
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return nome + " (" + especialidade + ") - " + email;
    }
}
