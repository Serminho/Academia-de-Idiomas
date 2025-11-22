public class Material {
    private String id;
    private String titulo;
    private String tipo;
    private boolean disponivel = true;
    private boolean exclusivoVip = false;

    public Material(String id, String titulo, String tipo, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.disponivel = disponivel;
    }

    public Material(String id, String titulo, String tipo, boolean disponivel, boolean exclusivoVip) {
        this(id, titulo, tipo, disponivel);
        this.exclusivoVip = exclusivoVip;
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

    public boolean isExclusivoVip() {
        return this.exclusivoVip;
    }

    public void setExclusivoVip(boolean exclusivoVip) {
        this.exclusivoVip = exclusivoVip;
    }

    @Override
    public String toString() {
        String s = "| " + this.titulo + " | ID: " + this.id + (disponivel ? " | (Disponível) |" : " | (Indisponível) |");
        if (exclusivoVip) s += " [VIP]";
        return s;
    }
}
