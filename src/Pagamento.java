import java.time.LocalDate;

public class Pagamento {
    private double valor;
    private LocalDate data;
    private String descricao;

    public Pagamento(double valor, LocalDate data) {
        this(valor, data, "");
    }

    public Pagamento(double valor, LocalDate data, String descricao) {
        this.valor = valor;
        this.data = data != null ? data : LocalDate.now();
        this.descricao = descricao != null ? descricao : "";
    }

    public double getValor() {
        return valor;
    }
    
    public LocalDate getData() {
        return data;
    }
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "R$ " + String.format("%.2f", valor) + " | " + data + (descricao.isEmpty() ? "" : " | " + descricao);
    }
}
