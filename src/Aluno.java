import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String id;
    private boolean vip;
    private List<Pagamento> pagamentos;
    private List<CursoConcluido> cursosConcluidos;

    public Aluno(String nome, boolean vip) {
        super(nome);
        this.vip = vip;
        this.pagamentos = new ArrayList<>();
        this.cursosConcluidos = new ArrayList<>();
    }

    public Aluno(String nome, String email, boolean vip) {
        super(nome, email);
        this.vip = vip;
        this.pagamentos = new ArrayList<>();
        this.cursosConcluidos = new ArrayList<>();
}

    // Construtor alternativo (sem e-mail e vip)
    public Aluno(String nome) {
        super(nome);
        this.id = "Aluno" + System.currentTimeMillis();
        this.vip = false;
        this.pagamentos = new ArrayList<>();
        this.cursosConcluidos = new ArrayList<>();
    }

    public boolean isVip() {
        return vip;
    }

    public void registrarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void concluirCurso(Curso curso, Nivel nivel, double nota) {
        cursosConcluidos.add(new CursoConcluido(curso, nivel, nota, java.time.LocalDate.now()));
    }

    public List<CursoConcluido> getCursosConcluidos() {
        return cursosConcluidos;
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
}
