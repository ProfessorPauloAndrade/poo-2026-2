import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public abstract class Veiculo {
    private final String placa;
    private String modelo;
    protected Veiculo(String placa, String modelo) {
        String chave = normalizarPlaca(placa);
        String texto = validarModelo(modelo);
        this.placa = chave;
        this.modelo = texto;
    }
    static String normalizarPlaca(String placa) {
        // TODO 14.2: recuse null e texto vazio antes de trim.
        return placa.trim().toUpperCase(Locale.ROOT);
    }
    private static String validarModelo(String modelo) {
        // TODO 14.2: recuse null e texto vazio antes de trim.
        return modelo.trim();
    }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public void alterarModelo(String novo) { modelo = validarModelo(novo); }
    public abstract double getTarifaHora();
    public double calcularTarifa(int minutos) {
        // TODO 14.3: proteja argumento e tarifa antes do calculo.
        return Math.ceil(minutos / 60.0) * getTarifaHora();
    }
    @Override public String toString() { return placa + " | " + modelo; }
}
