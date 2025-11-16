import java.util.ArrayList;
import java.util.List;

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
        if (alunos.size() < limiteAlunos) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado à turma " + codigo);
            return true;
        }

        if (aluno.isVip()) {
            for (int i = alunos.size(); i >= 1; i--) {
                if (!alunos.get(i).isVip()) {
                    String alunoSubstituido = alunos.get(i).getNome();
                    alunos.set(i, aluno);
                    System.out.println("Aluno VIP " + aluno.getNome() + " adicionadoo à turma " + codigo + ", substituindo o aluno " + alunoSubstituido);
                    return true;
                }
            }
        }
        System.out.println("Não foi possível adicionar o aluno " + aluno.getNome() + " à turma " + codigo + ": limite atingido.");
        return false;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}
