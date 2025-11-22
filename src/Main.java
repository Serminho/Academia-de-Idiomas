import java.util.Scanner;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = 0;

        do {
            System.out.println("\n=== MENU DA BIBLIOTECA ===");
            System.out.println("1 - Cadastrar Material");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Listar Aluno");
            System.out.println("4 - Listar Materiais");
            System.out.println("5 - Emprestar Material");
            System.out.println("6 - Devolver Material");
            System.out.println("7 - Ver Histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Inserir ID do material: ");
                    String id = sc.nextLine();
                    System.out.print("Inserir Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Inserir Tipo : ");
                    String tipo = sc.nextLine();

                    Material m = new Material(id, titulo, tipo, true);
                    biblioteca.adicionarMaterial(m);
                    System.out.println("Material cadastrado!");
                    break;

                case 2:
                    System.out.print("Inserir Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Inserir Email: ");
                    String email = sc.nextLine();
                    System.out.print("É VIP? (true/false): ");
                    boolean vip = sc.nextBoolean();
                    sc.nextLine();
                    biblioteca.cadastrarAluno(nome, email, vip);
                    break;

                case 3:
                    biblioteca.listarAlunos();
                    break;

                case 4:
                    biblioteca.listarMateriaisDisponiveis();
                    break;

                case 5:
                    System.out.println("\n=== EMPRESTAR MATERIAL ===");

                    biblioteca.listarAlunos();
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = sc.nextLine();

                    Aluno alunoEscolhido = biblioteca.buscarAlunoPorNome(nomeAluno);

                    biblioteca.listarMateriaisDisponiveis();
                    System.out.print("Digite o titulo do Material: ");
                    String tituloMaterial = sc.nextLine();

                    Material materialEscolhido = biblioteca.buscarMaterialPorTitulo(tituloMaterial);
                    biblioteca.emprestarMaterial(alunoEscolhido, materialEscolhido);
                    break;

                case 6:

                    System.out.println("\n=== DEVOLVENDO MATERIAL ===");
                    System.out.print("Digite o nome do aluno: ");
                    String nomeDevolver = sc.nextLine();

                    Aluno alunoDevolver = biblioteca.buscarAlunoPorNome(nomeDevolver);

                    if (alunoDevolver == null) {
                        System.out.println("Aluno não encontrado!");
                    } else {
                        biblioteca.listarMateriaisDisponiveis();
                        System.out.print("Escolha o material para ser devolvido: ");
                        String tituloMaterialDevolver = sc.nextLine();

                        Material materialDevolver = biblioteca.buscarMaterialPorTitulo(tituloMaterialDevolver);
                        biblioteca.devolverLivro(alunoDevolver, materialDevolver);
                    }
                    break;

                case 7:
                    biblioteca.mostrarHistorico();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);

        sc.close();
    }
