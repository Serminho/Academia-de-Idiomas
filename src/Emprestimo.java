import java.time.LocalDate;

public class Emprestimo {
    private Aluno aluno;
    private Material material;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Aluno aluno, Material material) {
        this.aluno = aluno;
        this.material = material;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Material getMaterial() {
        return material;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return dataDevolucao == null;
    }

    public void devolver() {
        if (!isAtivo()) return;
        this.dataDevolucao = LocalDate.now();
        if (material != null) material.setDisponivel(true);
    }

    @Override
    public String toString() {
        return aluno.getNome() + " → " + material.getTitulo() +
                " | Empréstimo: " + dataEmprestimo +
                (dataDevolucao != null ? " | Devolvido: " + dataDevolucao : " | Não devolvido |");
    }
}
