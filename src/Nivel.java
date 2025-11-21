public class Nivel {
    private String descricao;

    public Nivel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() { 
        return descricao; 
    }

    @Override
    public String toString() {
        return descricao;
    }
}