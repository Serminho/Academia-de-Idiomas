public abstract class Pessoa {
    protected String nome;
    protected String email;

    public Pessoa(String nome, String email) {
        this.nome = nome != null ? nome : "";
        this.email = email != null ? email : "";
    }

    // Construtor alternativo (sem e-mail)
    public Pessoa(String nome) {
        this(nome, "");
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }
}
