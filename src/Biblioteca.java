import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Material> materiais = new ArrayList<>();
    private List<Emprestimo> historico = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarMaterial(Material material) {
        materiais.add(material);
    }

    public void listarMateriaisDisponiveis() {
        System.out.println("\n=== MATERIAIS DISPONÍVEIS ===");
        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
            return;
        }

        for (Material m : materiais) {
            System.out.println("=#= " + m);
        }
    }

    public boolean emprestarMaterial(Aluno aluno, Material material) {
        if (!material.isDisponivel()) {
            System.out.println("Material indisponível!");
            return false;
        }

        material.setDisponivel(false);
        Emprestimo e = new Emprestimo(aluno, material);
        historico.add(e);

        System.out.println(aluno + " Emprestou: " + material.getTitulo());
        return true;
    }

    public void devolverLivro(Aluno aluno, Material material) {
        material.setDisponivel(true);

        for (Emprestimo e : historico) {
            if (e.getAluno().equals(aluno) && e.getMaterial().equals(material)) {
                e.devolver();
                System.out.println("Devolução registrada!");
                return;
            }
        }
    }

    public void mostrarHistorico() {
        System.out.println("\n=== HISTÓRICO DE EMPRÉSTIMOS ===");
        for (Emprestimo e : historico) {
            System.out.println("=#= " + e);
        }
    }

    public Aluno buscarAlunoPorNome(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    public Material buscarMaterialPorTitulo(String titulo) {
        for (Material m : materiais) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return m;
            }
        }
        return null;
    }

    public void cadastrarAluno(String nome, String email, boolean vip) {
        alunos.add(new Aluno(nome, email, vip));
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
}
