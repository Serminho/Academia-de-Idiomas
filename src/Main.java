public class Main {
    public static void main(String[] args) {

        Curso inglesBasico = new Curso("Inglês", "Básico");
        Horario horario1 = new Horario("Segunda-feira", "10:00");
        Professor profAna = new Professor("Ana Souza", "ana@worldtalk.com");

        Turma turmaA = new Turma(
                "ING-BAS-01",
                inglesBasico,
                horario1,
                profAna,
                3
        );

        Aluno a1 = new Aluno("Carlos", "carlos@email.com", false);
        Aluno a2 = new Aluno("Marina", "marina@email.com", false);
        Aluno a3 = new Aluno("João", "joao@email.com", false);

        Aluno vip1 = new Aluno("Amanda VIP", "amanda@email.com", true);
        Aluno vip2 = new Aluno("Lucas VIP", "lucas@email.com", true);

        System.out.println("\n--- ADICIONANDO ALUNOS NORMAIS ---");
        turmaA.adicionarAluno(a1);
        turmaA.adicionarAluno(a2);
        turmaA.adicionarAluno(a3);

        System.out.println("\n--- LISTA DE ALUNOS DA TURMA ---");
        for (Aluno aluno : turmaA.getAlunos()) {
            System.out.println("- " + aluno.getNome() + (aluno.isVip() ? " (VIP)" : ""));
        }

        System.out.println("\n--- TENTANDO ADICIONAR MAIS UM ALUNO NORMAL (deve falhar) ---");
        Aluno a4 = new Aluno("Pedro", "pedro@email.com", false);
        turmaA.adicionarAluno(a4);  // falha esperada

        System.out.println("\n--- LISTA DE ALUNOS DA TURMA ---");
        for (Aluno aluno : turmaA.getAlunos()) {
            System.out.println("- " + aluno.getNome() + (aluno.isVip() ? " (VIP)" : ""));
        }

        System.out.println("\n--- TENTANDO ADICIONAR ALUNO VIP (deve substituir alguém) ---");
        turmaA.adicionarAluno(vip1);  // substitui alguém não VIP

        System.out.println("\n--- LISTA DE ALUNOS DA TURMA ---");
        for (Aluno aluno : turmaA.getAlunos()) {
            System.out.println("- " + aluno.getNome() + (aluno.isVip() ? " (VIP)" : ""));
        }

        System.out.println("\n--- REMOVENDO UM ALUNO ---");
        turmaA.removerAluno(a2);

        System.out.println("\n--- LISTA DE ALUNOS DA TURMA ---");
        for (Aluno aluno : turmaA.getAlunos()) {
            System.out.println("- " + aluno.getNome() + (aluno.isVip() ? " (VIP)" : ""));
        }

        System.out.println("\n--- ADICIONANDO OUTRO VIP APÓS REMOÇÃO ---");
        turmaA.adicionarAluno(vip2);

        System.out.println("\n--- LISTA FINAL ATUALIZADA ---");
        for (Aluno aluno : turmaA.getAlunos()) {
            System.out.println("- " + aluno.getNome() + (aluno.isVip() ? " (VIP)" : ""));
        }

        System.out.println("\n--- FIM DO TESTE ---");
    }
}
