import java.util.*;

public class CadastroCursos {
    private List<Curso> cursos;
    private Set<Level> niveisDisponiveis;

    public CadastroCursos() {
        this.cursos = new ArrayList<>();
        this.niveisDisponiveis = EnumSet.allOf(Level.class);
    }

    public void adicionarCurso(Curso curso) {
        if (curso != null) cursos.add(curso);
    }

    public void adicionarCurso(String nome, Professor professor, String idioma, List<Level> niveis, double preco) {
        Curso novoCurso = new Curso(nome, professor, idioma, niveis, preco);
        cursos.add(novoCurso);
    }

    public List<Curso> getCursos() { return new ArrayList<>(cursos); }
    public List<Level> getNiveis() { return new ArrayList<>(niveisDisponiveis); }

    public List<Curso> getCursosPorIdioma(String idioma) {
        List<Curso> resultado = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getIdioma() != null && curso.getIdioma().equalsIgnoreCase(idioma)) {
                resultado.add(curso);
            }
        }
        return resultado;
    }

    public List<Curso> getCursosPorNivel(Level nivel) {
        List<Curso> resultado = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getNiveis().contains(nivel)) {
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

    public String exportarCursosComoTexto() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTA DE CURSOS ===\n");
        if (cursos.isEmpty()) {
            sb.append("(Nenhum curso cadastrado)\n");
            return sb.toString();
        }

        for (Curso c : cursos) {
            sb.append("ID: ").append(c.getId()).append(" | ");
            sb.append("Nome: ").append(c.getNome()).append(" | ");
            sb.append("Idioma: ").append(c.getIdioma()).append(" | ");

            List<Level> niveis = c.getNiveis();
            sb.append("Níveis: ");
            for (int i = 0; i < niveis.size(); i++) {
                sb.append(niveis.get(i));
                if (i < niveis.size() - 1) sb.append(", ");
            }
            sb.append(" | ");

            sb.append("Preço: R$ ").append(String.format("%.2f", c.getPreco())).append(" | ");
            sb.append("Professor: ").append(c.getProfessor() != null ? c.getProfessor().getNome() : "Sem professor");
            sb.append("\n");
        }

        return sb.toString();
    }
}
