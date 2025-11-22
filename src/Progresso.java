public class Progresso {
    private Aluno aluno;
    private Curso curso;
    private String nivelAtual;
    private String nivelAnterior;
    private int aulasConcluidas;
    private int totalAulas;

    public Progresso(Aluno aluno, Curso curso, String nivelInicial) {
        this.aluno = aluno;
        this.curso = curso;
        this.nivelAtual = nivelInicial;
        this.nivelAnterior = nivelInicial;
        this.aulasConcluidas = 0;
        this.totalAulas = 20; // Padrão de 20 aulas por nível
    }

    public Progresso(Aluno aluno, Curso curso, String nivelInicial, int totalAulas) {
        this.aluno = aluno;
        this.curso = curso;
        this.nivelAtual = nivelInicial;
        this.nivelAnterior = nivelInicial;
        this.aulasConcluidas = 0;
        this.totalAulas = totalAulas;
    }


    public Aluno getAluno() { return aluno; }
    public Curso getCurso() { return curso; }
    public String getNivelAtual() { return nivelAtual; }
    public String getNivelAnterior() { return nivelAnterior; }
    public int getAulasConcluidas() { return aulasConcluidas; }
    public int getTotalAulas() { return totalAulas; }

    // Métodos de progresso
    public void concluirAula() {
        if (aulasConcluidas < totalAulas) {
            aulasConcluidas++;
        }
    }

    public void avancarNivel() {
        if (aulasConcluidas >= totalAulas) {
            nivelAnterior = nivelAtual;
            switch (nivelAtual) {
                case "Básico" -> nivelAtual = "Intermediário";
                case "Intermediário" -> nivelAtual = "Avançado";
                case "Avançado" -> nivelAtual = "Concluído";
            }
            aulasConcluidas = 0; // Reinicia para o próximo nível
        }
    }

    // Métodos de consulta
    public double getPorcentagemConclusao() {
        return (aulasConcluidas * 100.0) / totalAulas;
    }

    public boolean isCursoConcluido() {
        return nivelAtual.equals("Concluído");
    }

    public boolean podeAvancarNivel() {
        return aulasConcluidas >= totalAulas && !nivelAtual.equals("Concluído");
    }

    public int getAulasRestantes() {
        return totalAulas - aulasConcluidas;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %s (%s) - %d/%d aulas (%.1f%%)",
                aluno.getNome(),
                curso.getNome(),
                nivelAtual,
                aulasConcluidas,
                totalAulas,
                getPorcentagemConclusao()
        );
    }
}
