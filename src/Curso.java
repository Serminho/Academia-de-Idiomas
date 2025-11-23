import java.util.*;

public class Curso {
    private String id;
    private String nome;
    private Professor professor;
    private String idioma;
    private List<Level> niveis;
    private double preco;

    public Curso(String nome, Professor professor, String idioma, List<Level> niveis, double preco) {
        this.id = "C" + System.currentTimeMillis();
        this.nome = nome != null ? nome : "Curso";
        this.professor = professor;
        this.idioma = idioma != null ? idioma : "Geral";
        this.niveis = (niveis != null && !niveis.isEmpty()) ? new ArrayList<>(niveis) : Arrays.asList(Level.BASICO);
        this.preco = preco >= 0.0 ? preco : 0.0;
    }

    public Curso(String nome) {
        this(nome, null, "Geral", Arrays.asList(Level.BASICO, Level.INTERMEDIARIO, Level.AVANCADO), 1000.0);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getIdioma() {
        return idioma;
    }

    public List<Level> getNiveis() {
        return Collections.unmodifiableList(niveis);
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        String lvl = niveis.isEmpty() ? "" : niveis.get(0).toString();
        return nome + " - " + idioma + " (" + lvl + ")" + (professor != null ? " - Prof. " + professor.getNome() : "") + " - R$ " + preco;
    }
}
