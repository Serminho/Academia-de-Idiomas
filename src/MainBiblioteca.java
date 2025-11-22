import java.util.Scanner;

public class MainBiblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = -1;

        do {
            System.out.println("\n=== MENU DA BIBLIOTECA ===");
            System.out.println("1 - Cadastrar Material");
            System.out.println("2 - Cadastrar Aluno (biblioteca)");
            System.out.println("3 - Listar Alunos (biblioteca)");
            System.out.println("4 - Listar Materiais");
            System.out.println("5 - Emprestar Material");
            System.out.println("6 - Devolver Material");
            System.out.println("7 - Ver Histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.nextLine();
                continue;
            }

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Inserir ID do material: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Inserir Título: ");
                    String titulo = sc.nextLine().trim();
                    System.out.print("Inserir Tipo : ");
                    String tipo = sc.nextLine().trim();
                    System.out.print("Material exclusivo para VIP? (s/n): ");
                    String resp = sc.nextLine().trim();
                    boolean exclusivoVip = resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("y");

                    Material m = new Material(id, titulo, tipo, true);

                    biblioteca.adicionarMaterial(m);
                    System.out.println("Material cadastrado!");
                }

                case 2 -> {
                    System.out.print("Inserir Nome: ");
                    String nome = sc.nextLine().trim();
                    System.out.print("Inserir Email: ");
                    String email = sc.nextLine().trim();
                    System.out.print("É VIP? (true/false): ");
                    boolean vip = false;
                    if (sc.hasNextBoolean()) {
                        vip = sc.nextBoolean();
                        sc.nextLine();
                    } else {
                        String tmp = sc.nextLine();
                        vip = tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("s");
                    }
                    biblioteca.cadastrarAluno(nome, email, vip);
                }

                case 3 -> biblioteca.listarAlunos();

                case 4 -> biblioteca.listarMateriaisDisponiveis();

                case 5 -> {
                    if (biblioteca.getAlunos().isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado. Cadastre um aluno primeiro.");
                        break;
                    }
                    if (biblioteca.getMateriais().isEmpty()) {
                        System.out.println("Nenhum material cadastrado. Cadastre um material primeiro.");
                        break;
                    }

                    biblioteca.listarAlunos();
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = sc.nextLine().trim();
                    Aluno alunoEscolhido = biblioteca.buscarAlunoPorNome(nomeAluno);
                    if (alunoEscolhido == null) {
                        System.out.println("Aluno não encontrado: " + nomeAluno);
                        break;
                    }

                    biblioteca.listarMateriaisDisponiveis();
                    System.out.print("Digite o titulo do Material: ");
                    String tituloMaterial = sc.nextLine().trim();
                    Material materialEscolhido = biblioteca.buscarMaterialPorTitulo(tituloMaterial);
                    if (materialEscolhido == null) {
                        System.out.println("Material não encontrado: " + tituloMaterial);
                        break;
                    }

                    biblioteca.emprestarMaterial(alunoEscolhido, materialEscolhido);
                }

                case 6 -> {
                    if (biblioteca.getAlunos().isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                        break;
                    }
                    System.out.print("Digite o nome do aluno: ");
                    String nomeDevolver = sc.nextLine().trim();
                    Aluno alunoDevolver = biblioteca.buscarAlunoPorNome(nomeDevolver);
                    if (alunoDevolver == null) {
                        System.out.println("Aluno não encontrado!");
                        break;
                    }

                    biblioteca.listarMateriaisDisponiveis();
                    System.out.print("Escolha o material para ser devolvido (título): ");
                    String tituloMaterialDevolver = sc.nextLine().trim();
                    Material materialDevolver = biblioteca.buscarMaterialPorTitulo(tituloMaterialDevolver);
                    if (materialDevolver == null) {
                        System.out.println("Material não encontrado!");
                        break;
                    }

                    biblioteca.devolverLivro(alunoDevolver, materialDevolver);
                }

                case 7 -> biblioteca.mostrarHistorico();

                case 0 -> System.out.println("Saindo...");

                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
