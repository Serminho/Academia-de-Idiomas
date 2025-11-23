import java.util.*;

public class Turma {
    private String codigo;
    private Curso curso;
    private Horario horario;
    private Professor professor;
    private int limiteAlunos;
    private List<Aluno> alunos;

    public Turma(String codigo, Curso curso, Horario horario, Professor professor, int limiteAlunos) {
        this.codigo = codigo;
        this.curso = curso;
        this.horario = horario;
        this.professor = professor;
        this.limiteAlunos = limiteAlunos;
        this.alunos = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (aluno == null) return false;
        if (alunos.contains(aluno)) {
            System.out.println("O aluno " + aluno.getNome() + " já está na turma.");
            return false;
        }
        if (alunos.size() < limiteAlunos) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado a turma " + codigo);
            return true;
        }
        if (aluno.isVip()) {
            for (int i = 0; i < alunos.size(); i++) {
                if (!alunos.get(i).isVip()) {
                    String alunoSubstituido = alunos.get(i).getNome();
                    alunos.set(i, aluno);
                    System.out.println("Aluno VIP " + aluno.getNome()
                            + " adicionado à turma " + codigo
                            + ", substituindo o aluno " + alunoSubstituido);
                    return true;
                }
            }
        }
        System.out.println("Não foi possível adicionar o aluno " + aluno.getNome() +
                " à turma " + codigo + ": limite atingido.");
        return false;
    }

    public boolean removerAluno(Aluno aluno) {
        if (alunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " removido da turma " + codigo);
            return true;
        }
        System.out.println("Aluno " + aluno.getNome() + " não encontrado na turma " + codigo);
        return false;
    }

    public boolean temVaga() {
        return alunos.size() < limiteAlunos;
    }

    public List<Aluno> getAlunos() {
        return Collections.unmodifiableList(alunos);
    }

    public int getQuantidadeAlunos() {
        return alunos.size();
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Turma " + codigo + " | Curso: " + (curso != null ? curso.getNome() : "N/A") +
                " | Prof: " + (professor != null ? professor.getNome() : "N/A") +
                " | Horário: " + (horario != null ? horario.getDiaSemana() + " " + horario.getHora() : "N/A") +
                " | Alunos: " + alunos.size() + "/" + limiteAlunos;
    }
}
