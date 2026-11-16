import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Estacionamento {
    private final List<Veiculo> veiculos = new ArrayList<>();
    private final List<Permanencia> ativas = new ArrayList<>();
    private final List<Cobravel> cobrancas = new ArrayList<>();
    private int proximoNumero = 1;
    private Veiculo buscarVeiculo(String chave) {
        for (Veiculo v : veiculos) if (v.getPlaca().equals(chave)) return v;
        return null;
    }
    private Permanencia buscarAtiva(String chave) {
        for (Permanencia p : ativas) if (p.getPlaca().equals(chave)) return p;
        return null;
    }
    private Permanencia exigirAtiva(String placa) throws RegraNegocioException {
        Permanencia p = buscarAtiva(Veiculo.normalizarPlaca(placa));
        if (p == null) throw new RegraNegocioException("Nao existe permanencia aberta para a placa");
        return p;
    }
    public void cadastrarVeiculo(Veiculo v) throws RegraNegocioException {
        if (v == null) throw new IllegalArgumentException("Veiculo obrigatorio");
        if (buscarVeiculo(v.getPlaca()) != null)
            throw new RegraNegocioException("Placa ja cadastrada");
        veiculos.add(v);
    }
    public Veiculo consultarVeiculo(String placa) throws RegraNegocioException {
        Veiculo v = buscarVeiculo(Veiculo.normalizarPlaca(placa));
        if (v == null) throw new RegraNegocioException("Placa nao cadastrada");
        return v;
    }
    public void atualizarModelo(String placa, String novo) throws RegraNegocioException {
        consultarVeiculo(placa).alterarModelo(novo);
    }
    public void removerVeiculo(String placa) throws RegraNegocioException {
        // TODO 14.5: explique a recusa e preserve estado listas e numeros
        throw new UnsupportedOperationException("TODO 14.5: explique a recusa e preserve estado listas e numeros");
    }
    public List<Veiculo> listarVeiculos() {
        List<Veiculo> copia = new ArrayList<>(veiculos);
        for (int i=0;i<copia.size();i++) for(int j=i+1;j<copia.size();j++) {
            if (copia.get(i).getPlaca().compareTo(copia.get(j).getPlaca())>0) {
                Veiculo anterior=copia.get(i);copia.set(i,copia.get(j));copia.set(j,anterior);
            }
        }
        return copia;
    }
    public int registrarEntrada(String placa) throws RegraNegocioException {
        // TODO 14.5: explique a recusa e preserve estado listas e numeros
        throw new UnsupportedOperationException("TODO 14.5: explique a recusa e preserve estado listas e numeros");
    }
    public Cobravel registrarSaida(String placa,int minutos) throws RegraNegocioException {
        // TODO 14.5: explique a recusa e preserve estado listas e numeros
        throw new UnsupportedOperationException("TODO 14.5: explique a recusa e preserve estado listas e numeros");
    }
    public Cobravel registrarLavagem(String placa) throws RegraNegocioException {
        // TODO 14.5: explique a recusa e preserve estado listas e numeros
        throw new UnsupportedOperationException("TODO 14.5: explique a recusa e preserve estado listas e numeros");
    }
    public List<Permanencia> listarPermanenciasAtivas() { return new ArrayList<>(ativas); }
    public List<Cobravel> listarCobrancas() { return new ArrayList<>(cobrancas); }
    public double totalizarCobrancas() {
        double total=0;for(Cobravel c:cobrancas) total+=c.calcularValor();return total;
    }
}
