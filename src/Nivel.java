public class Nivel {
    private int nivelAual;

    public Nivel(int nivelAual) {
        this.nivelAual = nivelAual;
    }

    public int getDescricao() { 
        return nivelAual; 
    }

    @Override
    public String toString() {
        return String.valueOf(nivelAual);
    }
}