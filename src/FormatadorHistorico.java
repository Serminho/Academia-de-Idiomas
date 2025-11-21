public class FormatadorHistorico {

    public static String gerarRelatorio(Aluno aluno) {
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
            sb.append(" - R$ ").append(p.getValor())
              .append(" | Data: ").append(p.getData())
              .append("\n");
        }

        return sb.toString();
    }
}
