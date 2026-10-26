import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// TODO 12.1: torne a base abstrata e a tarifa um metodo abstrato.
public class Veiculo {
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
    public double getTarifaHora() { throw new UnsupportedOperationException("TODO 12.1: contrato de tarifa"); }
    // Precondicao: minutos positivos; gestor verifica antes do registro.
    public double calcularTarifa(int minutos) {
        // TODO 12.2: calcule horas iniciadas e use a tarifa do objeto
        throw new UnsupportedOperationException("TODO 12.2: calcule horas iniciadas e use a tarifa do objeto");
    }
    @Override public String toString() { return placa + " | " + modelo; }
}
