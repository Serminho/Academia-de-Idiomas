public enum Level {
    BASICO,
    INTERMEDIARIO,
    AVANCADO;

    @Override
    public String toString() {
        switch (this) {
            case BASICO: return "Básico";
            case INTERMEDIARIO: return "Intermediário";
            case AVANCADO: return "Avançado";
            default: return name();
        }
    }
}
