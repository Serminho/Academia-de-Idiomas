import java.io.FileWriter;
import java.io.IOException;

public class FormatadorHistorico {

    public static String gerarRelatorioTexto(Aluno aluno) {
        StringBuilder sb = new StringBuilder();

        sb.append("Histórico do aluno ").append(aluno.getNome()).append("\n");
        sb.append("Categoria de fidelidade: ").append(aluno.getCategoriaFidelidade()).append("\n\n");

        sb.append("Cursos concluídos:\n");
        for (CursoConcluido c : aluno.getCursosConcluidos()) {
            sb.append(" - ").append(c.getCurso().getNome())
              .append(" | Nível: ").append(c.getNivel())
              .append(" | Nota: ").append(c.getNota())
              .append(" | Conclusão: ").append(c.getDataConclusao())
              .append("\n");
        }

        sb.append("\nPagamentos:\n");
        for (Pagamento p : aluno.getPagamentos()) {
            sb.append(" - R$ ").append(String.format("%.2f", p.getValor()))
              .append(" | Data: ").append(p.getData())
              .append(" | ").append(p.getDescricao())
              .append("\n");
        }

        return sb.toString();
    }

    public static void gerarPdf(Aluno aluno, String caminhoArquivo) {
        String texto = gerarRelatorioTexto(aluno);

        try (FileWriter fw = new FileWriter(caminhoArquivo)) {
            fw.write(texto);

            System.out.println("Relatório salvo como arquivo de texto: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }
}
