import java.time.LocalDate;

public class CursoConcluido {
    private Curso curso;
    private Nivel nivel;
    private double nota;
    private LocalDate dataConclusao;

    public CursoConcluido(Curso curso, Nivel nivel, double nota, LocalDate dataConclusao) {
        this.curso = curso;
        this.nivel = nivel;
        this.nota = nota;
        this.dataConclusao = dataConclusao;
    }

    public Curso getCurso() {
        return curso;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public double getNota() {
        return nota;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }
}
