import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private Professor professor;
    private String idioma;
    private List<String> niveis;
    private double preco;

    public Curso(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.idioma = "Geral";
        this.niveis = new ArrayList<>();
        this.niveis.add("Básico");
        this.preco = 1000.0;
    }

    public Curso(String nome, String idioma, String nivel, Professor professor, double preco) {
        this.nome = nome;
        this.idioma = idioma;
        this.professor = professor;
        this.niveis = new ArrayList<>();
        this.niveis.add(nivel);
        this.preco = preco;
    }

    // Getters
    public String getNome() {
        return nome;
    }
    public Professor getProfessor() {
        return professor;
    }
}