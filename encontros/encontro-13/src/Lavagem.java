// TODO 13.2: conecte este tipo ao contrato Cobravel e confira as implementacoes publicas.
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Lavagem {
    private static final double PRECO_PADRAO = 20.0;
    private final int numero;
    private final Veiculo veiculo;
    private final double valorCobrado;
    Lavagem(int numero, Veiculo veiculo) {
        // TODO 13.3: registre numero veiculo e preco fixo do servico
        throw new UnsupportedOperationException("TODO 13.3: registre numero veiculo e preco fixo do servico");
    }
    public int getNumero() { return numero; }
    public String getPlaca() { return veiculo.getPlaca(); }
    public String getDescricao() { return "Lavagem"; }
    public double calcularValor() {
        // TODO 13.3: registre numero veiculo e preco fixo do servico
        throw new UnsupportedOperationException("TODO 13.3: registre numero veiculo e preco fixo do servico");
    }
    public String toString() {
        return String.format(Locale.ROOT, "%d | %s | %s | R$ %.2f", numero, getPlaca(), getDescricao(), calcularValor());
    }
}
