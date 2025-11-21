import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private boolean vip;
    private List<Pagamento> pagamentos;
    private List<String> cursosConcluidos;
    private List<Nivel> niveisConcluidos;
    private List<Double> notasConcluidas;
    private int pontosFidelidade;

    public Aluno(String nome, String email, boolean vip) {
        super(nome, email);
        this.vip = vip;
        this.pagamentos = new ArrayList<>();
        this.cursosConcluidos = new ArrayList<>();
        this.niveisConcluidos = new ArrayList<>();
        this.notasConcluidas = new ArrayList<>();
        this.pontosFidelidade = 0;
    }

    public boolean isVip() {
        return vip;
    }

    public void registrarPagamento(double valor, String descricao) {
        pagamentos.add(new Pagamento(valor, LocalDate.now(), descricao));
    }

    public void concluirCurso(String nomeCurso, Nivel nivel, double nota) {
        cursosConcluidos.add(nomeCurso);
        niveisConcluidos.add(nivel);
        notasConcluidas.add(nota);

        pontosFidelidade += 100;
        if (nota >= 9.0) {
            pontosFidelidade += 50;
        }
    }

    public void exibirHistoricoCompleto() {
        System.out.println("\n--- HISTÓRICO COMPLETO DO ALUNO ---");
        System.out.println("Nome: " + getNome());
        System.out.println("E-mail: " + getEmail());
        System.out.println("VIP: " + (vip ? "Sim" : "Não"));
        System.out.println("Nível de Fidelidade: " + 
            (pontosFidelidade >= 500 ? "Ouro" : 
             pontosFidelidade >= 300 ? "Prata" : 
             pontosFidelidade >= 150 ? "Bronze" : "Iniciante") + 
            " (" + pontosFidelidade + " pontos)");
        System.out.println("-------------------------------------------");

        System.out.println("Cursos concluídos:");
        if (cursosConcluidos.isEmpty()) {
            System.out.println("  Nenhum curso concluído ainda.");
        } else {
            for (int i = 0; i < cursosConcluidos.size(); i++) {
                System.out.printf("  • %s - %s | Nota: %.1f | %s%n",
                        cursosConcluidos.get(i),
                        niveisConcluidos.get(i).getDescricao(),
                        notasConcluidas.get(i),
                        LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        }

        System.out.println("\nPagamentos realizados:");
        if (pagamentos.isEmpty()) {
            System.out.println("  Nenhum pagamento registrado.");
        } else {
            for (Pagamento p : pagamentos) {
                System.out.printf("  • R$ %.2f | %s | %s%n",
                        p.getValor(),
                        p.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        p.getDescricao());
            }
        }
        System.out.println("-------------------------------------------\n");
    }
}
