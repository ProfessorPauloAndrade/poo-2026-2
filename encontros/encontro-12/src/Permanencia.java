import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Permanencia {
    private final int numero;
    private final Veiculo veiculo;
    private final int minutos;
    private final double valorCobrado;
    // Recorte 12: cria somente visita concluida, com dados validos conhecidos.
    Permanencia(int numero, Veiculo veiculo, int minutos) {
        // TODO 12.3: guarde os dados e o valor da visita concluida
        throw new UnsupportedOperationException("TODO 12.3: guarde os dados e o valor da visita concluida");
    }
    public int getNumero() { return numero; }
    public String getPlaca() { return veiculo.getPlaca(); }
    public int getMinutos() { return minutos; }
    public double calcularValor() { return valorCobrado; }
    @Override public String toString() {
        return String.format(Locale.ROOT, "Permanencia %d | %s | %d min | R$ %.2f", numero, getPlaca(), minutos, valorCobrado);
    }
}
