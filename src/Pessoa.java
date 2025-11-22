public abstract class Pessoa {
    protected String nome;
    protected String email;

    public Pessoa(String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
    }

    // Construtor alternativo (sem e-mail)
    public Pessoa(String nome) {
        this.nome = nome;
        this.email = "";
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getEmail() {
        return this.email;
    }
}
