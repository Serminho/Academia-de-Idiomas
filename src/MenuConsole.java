import java.util.Scanner;

public class MenuConsole {

    private CadastroCursos cadastro;
    private Scanner sc;

    public MenuConsole(CadastroCursos cadastro) {
        this.cadastro = cadastro;
        this.sc = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Listar cursos");
        System.out.println("2. Adicionar curso");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void iniciar() {
        boolean rodando = true;

        while (rodando) {
            exibirMenu();
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("\n--- Cursos ---");
                    for (Curso c : cadastro.getCursos()) {
                        System.out.println(c.getId() + " - " + c.getNome());
                    }
                    System.out.println();
                    break;

                case "2":
                    System.out.print("Nome do curso: ");
                    String nome = sc.nextLine();
                    int novoId = cadastro.getCursos().size() + 1;
                    Curso novo = new Curso(nome);
                    cadastro.adicionarCurso(novo);
                    System.out.println("Curso adicionado!\n");
                    break;

                case "3":
                    System.out.println("Encerrando...");
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida.\n");
            }
        }
    }
}
