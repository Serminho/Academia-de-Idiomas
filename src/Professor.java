public class Professor extends Pessoa {
    public Professor(String nome, String email) {
        super(nome, email);
    }
    private String especialidade;

    public Professor(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
