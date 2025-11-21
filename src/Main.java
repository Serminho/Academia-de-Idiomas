import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Criando níveis
        Nivel iniciante = new Nivel("Iniciante");
        Nivel avancado = new Nivel("Avançado");

        // Criando cursos
        Curso cursoJava = new Curso("Java");
        Curso cursoPython = new Curso("Python");

        // Criando alunos
        Aluno aluno1 = new Aluno("Samuel", "samuel@email.com", true);
        Aluno aluno2 = new Aluno("Marina");
        Aluno aluno3 = new Aluno("Carlos", "carlos@email.com", false);

        // Criar professor
        Professor professor = new Professor("Roberto", "roberto@escola.com");

        // Criar turma (limite 2)
        Horario horario = new Horario("Segunda", "14:00");
        Turma turma = new Turma("T01", cursoJava, horario, professor, 2);

        // Registrar pagamentos
        aluno1.registrarPagamento(new Pagamento(300.0, LocalDate.now()));
        aluno2.registrarPagamento(new Pagamento(250.0, LocalDate.now()));

        // Concluir cursos
        aluno1.concluirCurso(cursoJava, iniciante, 9.2);
        aluno1.concluirCurso(cursoPython, avancado, 8.5);
        aluno2.concluirCurso(cursoJava, iniciante, 7.8);

        // Teste da geração de relatório
        System.out.println("===== RELATÓRIO DO ALUNO 1 =====");
        System.out.println(FormatadorHistorico.gerarRelatorio(aluno1));

        System.out.println("===== RELATÓRIO DO ALUNO 2 =====");
        System.out.println(FormatadorHistorico.gerarRelatorio(aluno2));

        // Testes da turma
        System.out.println("\n===== TESTE DA TURMA =====");
        turma.adicionarAluno(aluno1); // ok
        turma.adicionarAluno(aluno2); // ok (turma cheia)
        turma.adicionarAluno(aluno3); // não vip → recusado

        // adicionando VIP para testar substituição
        Aluno alunoVipExtra = new Aluno("Leonardo", "leo@email.com", true);

        turma.adicionarAluno(alunoVipExtra); // deve substituir aluno não vip

        System.out.println("\nAlunos finais da turma:");
        for (Aluno a : turma.getAlunos()) {
            System.out.println("- " + a.getNome() + (a.isVip() ? " (VIP)" : ""));
        }
    }
}
