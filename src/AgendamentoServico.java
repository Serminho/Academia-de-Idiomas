import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class AgendamentoServico {
    private final Map<String, Agendamento> agendamentos = new HashMap<>();
    private final List<Curso> cursosDisponiveis;

    public AgendamentoServico(List<Curso> cursosDisponiveis) {
        this.cursosDisponiveis = cursosDisponiveis != null ? cursosDisponiveis : new ArrayList<>();
    }

    public Agendamento criarAgendamento(Aluno aluno, Curso curso, Professor professor, LocalDateTime dataHora) {
        if (aluno == null) throw new IllegalArgumentException("Aluno inválido");
        if (curso == null) throw new IllegalArgumentException("Curso inválido");
        if (professor == null) throw new IllegalArgumentException("Professor inválido");
        if (!aluno.isVip()) throw new IllegalArgumentException("Somente alunos VIP podem agendar aulas particulares.");
        if (dataHora == null) throw new IllegalArgumentException("Data/hora inválida");
        if (!validarDiaAula(dataHora)) {
            throw new IllegalArgumentException("Aulas só acontecem às segundas, quartas e sextas");
        }
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível agendar para datas passadas");
        }

        double valor = curso.getPreco();
        Agendamento agendamento = new Agendamento(aluno, curso, professor, dataHora, valor);
        agendamentos.put(agendamento.getId(), agendamento);
        return agendamento;
    }

    public ResultadoCancelamento cancelarAgendamento(String agendamentoId) {
        Agendamento agendamento = agendamentos.get(agendamentoId);
        if (agendamento == null) {
            throw new IllegalArgumentException("Agendamento não encontrado");
        }

        LocalDateTime agora = LocalDateTime.now();
        long horasRestantes = ChronoUnit.HOURS.between(agora, agendamento.getDataHora());
        double multa = 0.0;

        if (horasRestantes < 24) {
            multa = agendamento.getValor() * 0.5;
            Pagamento p = new Pagamento(multa, LocalDate.now(), "Multa cancelamento");
            agendamento.getAluno().registrarPagamento(p);
        }

        agendamento.setStatus("CANCELADO");
        return new ResultadoCancelamento(agendamento, multa, horasRestantes);
    }

    public TempoRestante calcularTempoRestante(String agendamentoId) {
        Agendamento agendamento = agendamentos.get(agendamentoId);
        if (agendamento == null) {
            throw new IllegalArgumentException("Agendamento não encontrado");
        }

        LocalDateTime agora = LocalDateTime.now();
        long dias = ChronoUnit.DAYS.between(agora.toLocalDate(), agendamento.getDataHora().toLocalDate());
        long horas = ChronoUnit.HOURS.between(agora, agendamento.getDataHora());

        return new TempoRestante(dias, horas);
    }

    private boolean validarDiaAula(LocalDateTime dataHora) {
        DayOfWeek diaSemana = dataHora.getDayOfWeek();
        return diaSemana == DayOfWeek.MONDAY ||
               diaSemana == DayOfWeek.WEDNESDAY ||
               diaSemana == DayOfWeek.FRIDAY;
    }

    public List<Curso> getCursosDisponiveis() {
        return Collections.unmodifiableList(cursosDisponiveis);
    }

    public Agendamento getAgendamento(String id) {
        return agendamentos.get(id);
    }

    public List<Agendamento> listarTodos() {
        return new ArrayList<>(agendamentos.values());
    }
}
