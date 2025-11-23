import java.util.*;

public class Biblioteca {
    private List<Material> materiais = new ArrayList<>();
    private List<Emprestimo> historico = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public Biblioteca() {}

    public void adicionarMaterial(Material material) {
        if (material == null) return;
        materiais.add(material);
    }

    public void listarMateriaisDisponiveis() {
        System.out.println("\n=== MATERIAIS ===");
        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
            return;
        }
        for (Material m : materiais) {
            System.out.println("=#= " + m);
        }
    }

    public boolean emprestarMaterial(Aluno aluno, Material material) {
        if (aluno == null || material == null) {
            System.out.println("Aluno ou material inválido.");
            return false;
        }
        if (!material.isDisponivel()) {
            System.out.println("Material indisponível!");
            return false;
        }
        if (material.isExclusivoVip() && !aluno.isVip()) {
            System.out.println("Material exclusivo para alunos VIP. Empréstimo negado para " + aluno.getNome());
            return false;
        }

        material.setDisponivel(false);
        Emprestimo e = new Emprestimo(aluno, material);
        historico.add(e);
        System.out.println(aluno.getNome() + " emprestou: " + material.getTitulo());
        return true;
    }

    public boolean devolverLivro(Aluno aluno, Material material) {
        if (aluno == null || material == null) {
            System.out.println("Aluno ou material inválido.");
            return false;
        }

        for (Emprestimo e : historico) {
            if (Objects.equals(e.getAluno(), aluno) && Objects.equals(e.getMaterial(), material) && e.isAtivo()) {
                e.devolver();
                System.out.println("Devolução registrada para " + aluno.getNome() + " - " + material.getTitulo());
                return true;
            }
        }

        System.out.println("Nenhum empréstimo ativo encontrado para esse aluno/material.");
        return false;
    }

    public void mostrarHistorico() {
        System.out.println("\n=== HISTÓRICO DE EMPRÉSTIMOS ===");
        if (historico.isEmpty()) {
            System.out.println("Sem registros de empréstimos.");
            return;
        }
        for (Emprestimo e : historico) {
            System.out.println("=#= " + e);
        }
    }

    public Aluno buscarAlunoPorNome(String nome) {
        if (nome == null) return null;
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome.trim())) return a;
        }
        return null;
    }

    public Material buscarMaterialPorTitulo(String titulo) {
        if (titulo == null) return null;
        for (Material m : materiais) {
            if (m.getTitulo().equalsIgnoreCase(titulo.trim())) return m;
        }
        return null;
    }

    public void cadastrarAluno(String nome, String email, boolean vip) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido.");
            return;
        }
        Aluno existente = buscarAlunoPorNome(nome);
        if (existente != null) {
            System.out.println("Aluno já cadastrado: " + nome);
            return;
        }
        Aluno novo = new Aluno(nome, email, vip);
        alunos.add(novo);
        System.out.println("Aluno " + nome + " cadastrado com sucesso!");
    }

    public void listarAlunos() {
        System.out.println("\n=== ALUNOS CADASTRADOS ===");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Aluno a : alunos) {
            System.out.println("- " + a);
        }
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return historico;
    }
}
