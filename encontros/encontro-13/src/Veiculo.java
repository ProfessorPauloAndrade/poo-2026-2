import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public abstract class Veiculo {
    private final String placa;
    private String modelo;
    protected Veiculo(String placa, String modelo) {
        // Precondicao: dados iniciais validos. Excecoes no encontro 14.
        this.placa = placa.trim().toUpperCase(Locale.ROOT);
        this.modelo = modelo.trim();
    }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public boolean alterarModelo(String novo) {
        if (novo == null || novo.trim().isEmpty()) return false;
        modelo = novo.trim();
        return true;
    }
    public abstract double getTarifaHora();
    // Precondicao: minutos positivos; gestor verifica antes do registro.
    public double calcularTarifa(int minutos) {
        return Math.ceil(minutos / 60.0) * getTarifaHora();
    }
    @Override public String toString() { return placa + " | " + modelo; }
}
