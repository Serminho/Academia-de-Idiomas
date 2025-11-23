import java.time.LocalDate;

public class CursoConcluido {
    private Curso curso;
    private Level nivel;
    private double nota;
    private LocalDate dataConclusao;

    public CursoConcluido(Curso curso, Level nivel, double nota, LocalDate dataConclusao) {
        this.curso = curso;
        this.nivel = nivel != null ? nivel : Level.BASICO;
        this.nota = nota;
        this.dataConclusao = dataConclusao != null ? dataConclusao : LocalDate.now();
    }

    public Curso getCurso() {
        return curso;
    }

    public Level getNivel() {
        return nivel;
    }

    public double getNota() {
        return nota;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    @Override
    public String toString() {
        return curso.getNome() + " | " + nivel + " | Nota: " + nota + " | " + dataConclusao;
    }
}
