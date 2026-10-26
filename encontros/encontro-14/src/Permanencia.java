import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Permanencia implements Cobravel {
    private final int numero;
    private final Veiculo veiculo;
    private Integer minutos;
    private Double valorCobrado;
    Permanencia(int numero, Veiculo veiculo) {
        if (numero <= 0 || veiculo == null)
            throw new IllegalArgumentException("Registro exige numero positivo e veiculo");
        this.numero = numero;
        this.veiculo = veiculo;
    }
    void encerrar(int duracao) {
        // TODO 14.4: valide estado e argumento antes de atribuir ou extrair o valor
        throw new UnsupportedOperationException("TODO 14.4: valide estado e argumento antes de atribuir ou extrair o valor");
    }
    public boolean estaEncerrada() { return minutos != null; }
    public Integer getMinutos() { return minutos; }
    @Override public int getNumero() { return numero; }
    @Override public String getPlaca() { return veiculo.getPlaca(); }
    @Override public String getDescricao() {
        return estaEncerrada() ? "Permanencia encerrada | " + minutos + " min"
            : "Permanencia ABERTA — valor ainda não apurado";
    }
    @Override public double calcularValor() {
        // TODO 14.4: valide estado e argumento antes de atribuir ou extrair o valor
        throw new UnsupportedOperationException("TODO 14.4: valide estado e argumento antes de atribuir ou extrair o valor");
    }
    @Override public String toString() {
        String base = numero + " | " + getPlaca() + " | " + getDescricao();
        return estaEncerrada() ? base + String.format(Locale.ROOT," | R$ %.2f",calcularValor()) : base;
    }
}
