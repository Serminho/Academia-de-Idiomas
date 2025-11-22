import java.time.LocalDateTime;

public class Agendamento {
    private String id;
    private Aluno aluno;
    private Curso curso;
    private Professor professor;
    private LocalDateTime dataHora;
    private String status;
    private double valor;

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
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public double getValor() {
        return valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}