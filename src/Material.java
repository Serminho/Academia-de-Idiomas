public class Material {
    private String id;
    private String titulo;
    private String tipo;
    private boolean disponivel = true;

    public Material(String id, String titulo, String tipo, boolean disponivel) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.disponivel = disponivel;
    }

    public String getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean d) {
        this.disponivel = d;
    }

    public String toString() {
        return "| " + this.titulo + " | ID: " + this.id + (disponivel ? "| (Disponível) |" : "| (Indisponível) |");
    }
}
