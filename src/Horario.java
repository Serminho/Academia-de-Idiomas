public class Horario {
    private String diaSemana;
    private String hora;

    public Horario(String diaSemana, String hora) {
        this.diaSemana = diaSemana;
        this.hora = hora;
    }

    public String getDiaSemana() {
        return diaSemana;
    }
    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return diaSemana + " " + hora;
    }
}
