public class Professor extends Pessoa {
    private String especialidade;

    public Professor(String nome, String email, String especialidade) {
        super(nome, email);
        this.especialidade = especialidade;
    }

    public Professor(String nome, String email) {
        super(nome, email);
        this.especialidade = "Geral";
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
