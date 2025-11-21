import java.time.LocalDate;

public class Pagamento {
    private double valor;
    private LocalDate data;
    private String descricao;

    public Pagamento(double valor, LocalDate data, String descricao) {
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public double getValor() { return valor; }
    public LocalDate getData() { return data; }
    public String getDescricao() { return descricao; }
}