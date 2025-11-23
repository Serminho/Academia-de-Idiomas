public class TempoRestante {
    private final long dias;
    private final long horas;

    public TempoRestante(long dias, long horas) {
        this.dias = dias;
        this.horas = horas;
    }

    public long getDias() {
        return dias;
    }
    public long getHoras() {
        return horas;
    }
    public boolean menosDe24Horas() {
        return horas < 24;
    }
}
