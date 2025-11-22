import java.util.ArrayList;
import java.util.List;

public class CadastroCursos {
    private List<Curso> cursos;
    private List<String> niveis; 

    public CadastroCursos() {
        this.cursos = new ArrayList<>();
        this.niveis = new ArrayList<>();
        cadastrarNiveisPadrao();
    }

    private void cadastrarNiveisPadrao() {
        adicionarNivel("Básico");
        adicionarNivel("Intermediário");
        adicionarNivel("Avançado");
    }

    // Métodos para cadastrar cursos
    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void adicionarCurso(String nome, Professor professor, String idioma, String nivel, double preco) {
        Curso novoCurso = new Curso(nome, idioma, nivel, professor, preco);
        cursos.add(novoCurso);
    }

    // Métodos para cadastrar níveis (agora como String)
    public void adicionarNivel(String descricaoNivel) {
        if (!niveis.contains(descricaoNivel)) {
            niveis.add(descricaoNivel);
        }
    }

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }

    public List<String> getNiveis() {
        return new ArrayList<>(niveis);
    }

    public List<Curso> getCursosPorIdioma(String idioma) {
        List<Curso> resultado = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getIdioma().equalsIgnoreCase(idioma)) {
                resultado.add(curso);
            }
        }
        return resultado;
    }

    public List<Curso> getCursosPorNivel(String nivel) {
        List<Curso> resultado = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getNivel().equalsIgnoreCase(nivel)) {
                resultado.add(curso);
            }
        }
        return resultado;
    }

    public void listarCursos() {
        System.out.println("=== CURSOS CADASTRADOS ===");
        for (Curso curso : cursos) {
            System.out.println(curso);
        }
    }

    public void listarNiveis() {
        System.out.println("=== NÍVEIS CADASTRADOS ===");
        for (String nivel : niveis) {
            System.out.println(nivel);
        }
    }
}
