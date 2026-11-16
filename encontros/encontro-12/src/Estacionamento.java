import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Estacionamento {
    private final List<Veiculo> veiculos = new ArrayList<>();
    private final List<Permanencia> permanencias = new ArrayList<>();
    private int proximoNumero = 1;
    public boolean cadastrarVeiculo(Veiculo veiculo) {
        if (veiculo == null || consultarVeiculo(veiculo.getPlaca()) != null) return false;
        veiculos.add(veiculo);
        return true;
    }
    public Veiculo consultarVeiculo(String placa) {
        if (placa == null || placa.trim().isEmpty()) return null;
        String chave = placa.trim().toUpperCase(Locale.ROOT);
        for (Veiculo veiculo : veiculos) if (veiculo.getPlaca().equals(chave)) return veiculo;
        return null;
    }
    public List<Veiculo> listarVeiculos() { return new ArrayList<>(veiculos); }
    public boolean registrarPermanencia(String placa, int minutos) {
        // TODO 12.4: valide antes de criar e numerar o registro
        throw new UnsupportedOperationException("TODO 12.4: valide antes de criar e numerar o registro");
    }
    public List<Permanencia> listarPermanencias() { return new ArrayList<>(permanencias); }
    public double totalizarPermanencias() {
        // TODO 12.5: some os valores registrados
        throw new UnsupportedOperationException("TODO 12.5: some os valores registrados");
    }
}
