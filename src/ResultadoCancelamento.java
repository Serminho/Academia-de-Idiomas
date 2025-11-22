public class ResultadoCancelamento {
    private Agendamento agendamento;
    private double multa;
    private long horasRestantes;

    public ResultadoCancelamento(Agendamento agendamento, double multa, long horasRestantes) {
        this.agendamento = agendamento;
        this.multa = multa;
        this.horasRestantes = horasRestantes;
    }

    // Getters
    public Agendamento getAgendamento() {
        return agendamento;
    }
    public double getMulta() {
        return multa;
    }
    public long getHorasRestantes() {
        return horasRestantes;
    }
    public boolean temMulta() {
        return multa > 0;
    }
}