public class Material {
    private String id;
    private String titulo;
    private String tipo;
    private boolean disponivel = true;
    private boolean exclusivoVip = false;

    // Ordem padronizada: id, titulo, tipo, exclusivoVip, disponivel
    public Material(String id, String titulo, String tipo, boolean exclusivoVip, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo != null ? tipo : "Tipo Genérico";
        this.disponivel = disponivel;
        this.exclusivoVip = exclusivoVip;
    }

    public Material(String id, String titulo, boolean exclusivoVip, boolean disponivel) {
        this(id, titulo, "Tipo Genérico", exclusivoVip, disponivel);
    }

    public Material(String titulo, boolean exclusivoVip) {
        this(java.util.UUID.randomUUID().toString(), titulo, "Tipo Genérico", exclusivoVip, true);
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isExclusivoVip() {
        return exclusivoVip;
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
