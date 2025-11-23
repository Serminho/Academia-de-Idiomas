public class Progresso {
    private Aluno aluno;
    private Curso curso;
    private Level nivelAtual;
    private Level nivelAnterior;
    private int aulasConcluidas;
    private int totalAulas;

    public Progresso(Aluno aluno, Curso curso, Level nivelInicial) {
        this(aluno, curso, nivelInicial, 20);
    }

    public Progresso(Aluno aluno, Curso curso, Level nivelInicial, int totalAulas) {
        this.aluno = aluno;
        this.curso = curso;
        this.nivelAtual = nivelInicial != null ? nivelInicial : Level.BASICO;
        this.nivelAnterior = nivelAtual;
        this.aulasConcluidas = 0;
        this.totalAulas = Math.max(1, totalAulas);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return courseOrNull();
    }
    
    private Curso courseOrNull() {
        return curso;
    }

    public Level getNivelAtual() {
        return nivelAtual;
    }
    
    public Level getNivelAnterior() {
        return nivelAnterior;
    }

    public int getAulasConcluidas() {
        return aulasConcluidas;
    }

    public int getTotalAulas() {
        return totalAulas;
    }

    public void concluirAula() {
        if (aulasConcluidas < totalAulas) aulasConcluidas++;
    }

    public void avancarNivel() {
        if (aulasConcluidas >= totalAulas) {
            nivelAnterior = nivelAtual;
            switch (nivelAtual) {
                case BASICO -> nivelAtual = Level.INTERMEDIARIO;
                case INTERMEDIARIO -> nivelAtual = Level.AVANCADO;
                case AVANCADO -> {/* permanece */}
            }
            aulasConcluidas = 0;
        }
    }

    public double getPorcentagemConclusao() {
        return (aulasConcluidas * 100.0) / totalAulas;
    }

    public boolean isCursoConcluido() {
        return nivelAtual == Level.AVANCADO && aulasConcluidas >= totalAulas;
    }

    public boolean podeAvancarNivel() {
        return aulasConcluidas >= totalAulas && !isCursoConcluido();
    }

    public int getAulasRestantes() {
        return totalAulas - aulasConcluidas;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s) - %d/%d aulas (%.1f%%)",
                aluno != null ? aluno.getNome() : "N/A",
                curso != null ? curso.getNome() : "N/A",
                nivelAtual,
                aulasConcluidas,
                totalAulas,
                getPorcentagemConclusao()
        );
    }
}
