import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String id;
    private boolean vip;
    private List<Pagamento> pagamentos;
    private List<CursoConcluido> cursosConcluidos;
    private List<Progresso> progressosAtivos;

    public Aluno(String nome, boolean vip) {
        super(nome);
        this.id = "AL" + System.currentTimeMillis();
        this.vip = vip;
        this.pagamentos = new ArrayList<>();
        this.cursosConcluidos = new ArrayList<>();
        this.progressosAtivos = new ArrayList<>();
    }

    public Aluno(String nome, String email, boolean vip) {
        super(nome, email);
        this.id = "AL" + System.currentTimeMillis();
        this.vip = vip;
        this.pagamentos = new ArrayList<>();
        this.cursosConcluidos = new ArrayList<>();
    }

    public Aluno(String nome) {
        super(nome);
        this.id = "AL" + System.currentTimeMillis();
        this.vip = false;
        this.pagamentos = new ArrayList<>();
        this.cursosConcluidos = new ArrayList<>();
        this.progressosAtivos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public boolean isVip() {
        return this.vip;
    }
    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
    public List<CursoConcluido> getCursosConcluidos() {
        return cursosConcluidos;
    }
    public List<Progresso> getProgressosAtivos() {
        return progressosAtivos;
    }

    public void registrarPagamento(Pagamento p) {
        if (p != null) pagamentos.add(p);
    }

    public void concluirCurso(Curso curso, Nivel nivel, double nota) {
        cursosConcluidos.add(new CursoConcluido(curso, nivel, nota, java.time.LocalDate.now()));
    }

    public void iniciarProgresso(Progresso progresso) {
        if (progresso != null) progressosAtivos.add(progresso);
    }

    public int getPontosFidelidade() {
        return cursosConcluidos.size() * 10;
    }

    public String getCategoriaFidelidade() {
        int pontos = getPontosFidelidade();
        if (pontos >= 100) return "Ouro";
        if (pontos >= 50) return "Prata";
        return "Bronze";
    }

    @Override
    public String toString() {
        return "| Aluno: " + this.nome + " | Email: " + this.email + " | VIP: " + (this.vip ? "Sim" : "Não") + "| ";
    }
}
