public class Professor extends Pessoa {
    private String especialidade;

    public Professor(String nome, String email, String especialidade) {
        super(nome, email);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
