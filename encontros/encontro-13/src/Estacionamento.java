import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Estacionamento {
    private final List<Veiculo> veiculos = new ArrayList<>();
    private final List<Permanencia> ativas = new ArrayList<>();
    private final List<Cobravel> cobrancas = new ArrayList<>();
    private int proximoNumero = 1;
    public boolean cadastrarVeiculo(Veiculo veiculo) {
        if (veiculo == null || consultarVeiculo(veiculo.getPlaca()) != null) return false;
        veiculos.add(veiculo);
        return true;
    }
    public Veiculo consultarVeiculo(String placa) {
        if (placa == null || placa.trim().isEmpty()) return null;
        String chave = placa.trim().toUpperCase(Locale.ROOT);
        for (Veiculo v : veiculos) if (v.getPlaca().equals(chave)) return v;
        return null;
    }
    public List<Veiculo> listarVeiculos() {
        List<Veiculo> copia = new ArrayList<>(veiculos);
        // Apenas apoio operacional a compareTo, usando lacos ja conhecidos.
        for (int i = 0; i < copia.size(); i++) {
            for (int j = i + 1; j < copia.size(); j++) {
                if (copia.get(i).getPlaca().compareTo(copia.get(j).getPlaca()) > 0) {
                    Veiculo anterior = copia.get(i);
                    copia.set(i, copia.get(j));
                    copia.set(j, anterior);
                }
            }
        }
        return copia;
    }
    private Permanencia consultarAtiva(String placa) {
        Veiculo v = consultarVeiculo(placa);
        if (v == null) return null;
        for (Permanencia p : ativas) if (p.getPlaca().equals(v.getPlaca())) return p;
        return null;
    }
    public boolean registrarEntrada(String placa) {
        // TODO 13.4: coordene ativas e historico sem duplicar a cobranca
        throw new UnsupportedOperationException("TODO 13.4: coordene ativas e historico sem duplicar a cobranca");
    }
    public Cobravel registrarSaida(String placa, int minutos) {
        // TODO 13.4: coordene ativas e historico sem duplicar a cobranca
        throw new UnsupportedOperationException("TODO 13.4: coordene ativas e historico sem duplicar a cobranca");
    }
    public Cobravel registrarLavagem(String placa) {
        // TODO 13.4: coordene ativas e historico sem duplicar a cobranca
        throw new UnsupportedOperationException("TODO 13.4: coordene ativas e historico sem duplicar a cobranca");
    }
    public List<Permanencia> listarPermanenciasAtivas() { return new ArrayList<>(ativas); }
    public List<Cobravel> listarCobrancas() { return new ArrayList<>(cobrancas); }
    public double totalizarCobrancas() {
        // TODO 13.5: some pelo contrato Cobravel
        throw new UnsupportedOperationException("TODO 13.5: some pelo contrato Cobravel");
    }
}
