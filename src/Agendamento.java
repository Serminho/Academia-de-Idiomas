import java.time.LocalDateTime;

public class Agendamento {
    private final String id;
    private final Aluno aluno;
    private final Curso curso;
    private final Professor professor;
    private final LocalDateTime dataHora;
    private String status;
    private final double valor;

    public Agendamento(Aluno aluno, Curso curso, Professor professor,
                       LocalDateTime dataHora, double valor) {
        this.id = "AG" + System.currentTimeMillis();
        this.aluno = aluno;
        this.curso = curso;
        this.professor = professor;
        this.dataHora = dataHora;
        this.status = "AGENDADO";
        this.valor = valor;
    }

    public String getId() {
        return id;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public Curso getCurso() {
        return curso;
    }
    public Professor getProfessor() {
        return professor;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public String getStatus() {
        return status;
    }
    public double getValor() {
        return valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s | Aluno: %s | Curso: %s | Prof: %s | DataHora: %s | Status: %s | Valor: %.2f",
                id,
                aluno != null ? aluno.getNome() : "N/A",
                curso != null ? curso.getNome() : "N/A",
                professor != null ? professor.getNome() : "N/A",
                dataHora != null ? dataHora.toString() : "N/A",
                status,
                valor);
    }
}
