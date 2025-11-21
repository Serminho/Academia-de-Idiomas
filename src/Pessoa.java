public abstract class Pessoa {
    protected String nome;
    protected String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Construtor alternativo (sem e-mail)
    public Pessoa(String nome) {
        this.nome = nome;
        this.email = "";
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
}
