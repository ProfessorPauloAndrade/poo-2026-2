package br.edu.uva.estacionamento.modelo;

import java.util.*;
import br.edu.uva.estacionamento.excecao.RegraNegocioException;

public class Estacionamento {
    private final Map<String, Veiculo> veiculos = new HashMap<>();
    private final Map<String, Permanencia> ativas = new HashMap<>();
    private final List<Cobravel> cobrancas = new ArrayList<>();
    private int proximoNumero = 1;
    private Veiculo buscarVeiculo(String chave) {
        return veiculos.get(chave);
    }
    private Permanencia buscarAtiva(String chave) {
        return ativas.get(chave);
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
        veiculos.put(v.getPlaca(),v);
    }
    public Veiculo consultarVeiculo(String placa) throws RegraNegocioException {
        // TODO 15.1: consulte pela chave normalizada mantendo o contrato
        throw new UnsupportedOperationException("TODO 15.1: consulte pela chave normalizada mantendo o contrato");
    }
    public void atualizarModelo(String placa, String novo) throws RegraNegocioException {
        consultarVeiculo(placa).alterarModelo(novo);
    }
    public void removerVeiculo(String placa) throws RegraNegocioException {
        Veiculo v = consultarVeiculo(placa);
        if (buscarAtiva(v.getPlaca()) != null)
            throw new RegraNegocioException("Cadastro possui permanencia aberta");
        for (Cobravel c : cobrancas) if (c.getPlaca().equals(v.getPlaca()))
            throw new RegraNegocioException("Cadastro possui historico de cobrancas");
        veiculos.remove(v.getPlaca());
    }
    public List<Veiculo> listarVeiculos() {
        // TODO 15.5: ordene uma copia dos valores sem expor a visao do mapa
        throw new UnsupportedOperationException("TODO 15.5: ordene uma copia dos valores sem expor a visao do mapa");
    }
    public int registrarEntrada(String placa) throws RegraNegocioException {
        // TODO 15.2: registre a ativa no mapa sem substituir outra
        throw new UnsupportedOperationException("TODO 15.2: registre a ativa no mapa sem substituir outra");
    }
    public Cobravel registrarSaida(String placa,int minutos) throws RegraNegocioException {
        // TODO 15.2: encerre antes de mudar historico e mapa
        throw new UnsupportedOperationException("TODO 15.2: encerre antes de mudar historico e mapa");
    }
    public Cobravel registrarLavagem(String placa) throws RegraNegocioException {
        Permanencia p = exigirAtiva(placa);
        Lavagem l = new Lavagem(proximoNumero,consultarVeiculo(p.getPlaca()));
        cobrancas.add(l);
        proximoNumero++;
        return l;
    }
    public List<Permanencia> listarPermanenciasAtivas() { return new ArrayList<>(ativas.values()); }
    public List<Cobravel> listarCobrancas() { return new ArrayList<>(cobrancas); }
    public double totalizarCobrancas() {
        double total=0;for(Cobravel c:cobrancas) total+=c.calcularValor();return total;
    }
    public Set<String> placasAtendidas() {
        // TODO 15.4: derive o conjunto das cobrancas finalizadas
        throw new UnsupportedOperationException("TODO 15.4: derive o conjunto das cobrancas finalizadas");
    }
}

