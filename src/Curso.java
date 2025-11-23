import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private Professor professor;
    private String idioma;
    private List<String> niveis;
    private double preco;

    public Curso(String nome) {
        this.nome = nome;
        this.professor = null;
        this.idioma = "Geral";
        this.niveis = new ArrayList<>();
        this.niveis.add("Básico");
        this.preco = 1000.0;
    }

    public Curso(String nome, Professor professor, String idioma, String nivel, double preco) {
        this.nome = nome;
        this.professor = professor;
        this.idioma = idioma != null ? idioma : "Geral";
        this.niveis = new ArrayList<>();
        if (nivel != null) this.niveis.add(nivel);
        this.preco = preco;
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
    public String getNivel() {
        return niveis.isEmpty() ? "" : niveis.get(0);
    }
    public List<String> getNiveis() {
        return new ArrayList<>(niveis);
    }
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " - " + idioma + " (" + getNivel() + ")" + (professor != null ? " - Prof. " + professor.getNome() : "") + " - R$ " + preco;
    }
}
