public class Aluno extends Pessoa {
    private boolean vip;

    public Aluno(String nome, String email, boolean vip) {
        super(nome, email);
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }
}
