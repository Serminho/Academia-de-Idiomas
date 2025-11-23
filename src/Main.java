import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA WorldTalk (teste) ===\n");

        // Professores
        Professor prof1 = new Professor("Marcos", "marcos@icev.edu", "Inglês");
        Professor prof2 = new Professor("Juliana", "juliana@icev.edu", "Espanhol");

        // Cadastro de cursos
        CadastroCursos cadastro = new CadastroCursos();
        cadastro.adicionarCurso("Inglês Básico", prof1, "Inglês",
                Arrays.asList(Level.BASICO, Level.INTERMEDIARIO, Level.AVANCADO),
                1500.0);

        cadastro.adicionarCurso("Espanhol Intermediário", prof2, "Espanhol",
                Arrays.asList(Level.INTERMEDIARIO, Level.AVANCADO),
                1800.0);

        System.out.println("\n--- Cursos cadastrados ---");
        cadastro.listarCursos();

        // Alunos
        Aluno alunoVip = new Aluno("Carlos VIP", "vip@teste.com", true);
        Aluno alunoNormal = new Aluno("João", "joao@teste.com", false);

        // Biblioteca e materiais
        Biblioteca bib = new Biblioteca();
        Material m1 = new Material("MAT-001", "Java Avançado", "Computação", false, true);
        Material m2 = new Material("MAT-002", "Python para VIPs", "Computação", true, true);
        bib.adicionarMaterial(m1);
        bib.adicionarMaterial(m2);

        System.out.println("\n--- Materiais disponíveis ---");
        bib.listarMateriaisDisponiveis();

        System.out.println("\n--- Teste de empréstimo ---");
        bib.emprestarMaterial(alunoNormal, m1); // OK
        bib.emprestarMaterial(alunoNormal, m2); // Negado (VIP)
        bib.emprestarMaterial(alunoVip, m2);    // OK

        System.out.println("\n--- Histórico após empréstimos ---");
        bib.mostrarHistorico();

        // Agendamento
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

        System.out.println("\n--- Tentando criar agendamento para aluno comum (esperado erro) ---");
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
        System.out.println("Cancelado. Multa: R$ " + String.format("%.2f", rc.getMulta()));

        // Concluir curso
        alunoVip.concluirCurso(cadastro.getCursos().get(0), Level.BASICO, 9.5);

        System.out.println("\n--- Histórico formatado (texto) ---");
        String relatorio = FormatadorHistorico.gerarRelatorioTexto(alunoVip);
        System.out.println(relatorio);

        // NOVO: Gera .txt (não mais PDF)
        System.out.println("\n--- Salvando relatório em arquivo texto ---");
        FormatadorHistorico.gerarPdf(
                alunoVip,
                "data/historico_" + alunoVip.getId() + ".txt"
        );

        // Persistência: agora usando arquivos .txt simples
        try {
            PersistenceUtil.saveText(
                    "data/students.txt",
                    "Alunos:\n" + alunoVip.toString() + "\n" + alunoNormal.toString()
            );

            PersistenceUtil.saveText(
                    "data/courses.txt",
                    cadastro.exportarCursosComoTexto()
            );

            System.out.println("Dados persistidos em data/*.txt");
        } catch (Exception e) {
            System.err.println("Falha persistência: " + e.getMessage());
        }

        System.out.println("\n=== FIM DOS TESTES ===");
    }
}
