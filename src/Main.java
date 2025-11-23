import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== INICIANDO TESTES ===\n");

        Professor prof1 = new Professor("Marcos", "marcos@icev.edu", null);
        Professor prof2 = new Professor("Juliana", "juliana@icev.edu");

        CadastroCursos cadastro = new CadastroCursos();
        cadastro.adicionarCurso("Inglês Básico", prof1, "Inglês", "Básico", 1500);
        cadastro.adicionarCurso("Espanhol Intermediário", prof2, "Espanhol", "Intermediário", 1800);

        System.out.println("\n--- Cursos cadastrados ---");
        cadastro.listarCursos();

        Aluno alunoVip = new Aluno("Carlos VIP", "vip@teste.com", true);
        Aluno alunoNormal = new Aluno("João", "joao@teste.com", false);

        Biblioteca bib = new Biblioteca();
        Material m1 = new Material("123456", "Java Avançado", "Computação", false, false);
        Material m2 = new Material("654321","Python para VIPs", true, false);

        bib.adicionarMaterial(m1);
        bib.adicionarMaterial(m2);

        System.out.println("\n--- Materiais disponíveis ---");
        bib.listarMateriaisDisponiveis();

        System.out.println("\n--- Teste de empréstimo ---");
        bib.emprestarMaterial(alunoNormal, m1); // deve funcionar
        bib.emprestarMaterial(alunoNormal, m2); // deve negar (VIP)
        bib.emprestarMaterial(alunoVip, m2);    // deve funcionar

        System.out.println("\n--- Histórico após empréstimos ---");
        bib.mostrarHistorico();

        bib.devolverLivro(alunoVip, m2);

        System.out.println("\n--- Histórico após devolução ---");
        bib.mostrarHistorico();

        AgendamentoServico agServ = new AgendamentoServico(cadastro.getCursos());

        LocalDateTime dataValida = LocalDateTime.now().plusDays(3);
        while (!(dataValida.getDayOfWeek().getValue() == 1 ||
                 dataValida.getDayOfWeek().getValue() == 3 ||
                 dataValida.getDayOfWeek().getValue() == 5)) {
            dataValida = dataValida.plusDays(1);
        }

        System.out.println("\n--- Criando agendamento VIP ---");
        Agendamento ag = agServ.criarAgendamento(
                alunoVip,
                cadastro.getCursos().get(0),
                prof1,
                dataValida
        );
        System.out.println("Criado: " + ag);

        System.out.println("\n--- Tentando criar agendamento para aluno comum ---");
        try {
            agServ.criarAgendamento(
                alunoNormal,
                cadastro.getCursos().get(0),
                prof1,
                dataValida.plusDays(1)
            );
        } catch (Exception e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Tempo restante para o agendamento ---");
        TempoRestante tr = agServ.calcularTempoRestante(ag.getId());
        System.out.println("Dias: " + tr.getDias() + " | Horas: " + tr.getHoras());

        System.out.println("\n--- Cancelando agendamento ---");
        ResultadoCancelamento rc = agServ.cancelarAgendamento(ag.getId());
        System.out.println("Cancelado. Multa: R$ " + rc.getMulta());

        System.out.println("\n--- Conclusão de curso ---");
        alunoVip.concluirCurso(cadastro.getCursos().get(0), null, 9.5);

        System.out.println("\n--- Histórico formatado ---");
        String relatorio = FormatadorHistorico.gerarRelatorio(alunoVip);
        System.out.println(relatorio);

        System.out.println("\n=== FIM DOS TESTES ===");
    }
}
