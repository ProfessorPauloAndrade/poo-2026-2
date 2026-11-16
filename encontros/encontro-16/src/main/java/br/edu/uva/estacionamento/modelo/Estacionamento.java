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
        Veiculo v = buscarVeiculo(Veiculo.normalizarPlaca(placa));
        if (v == null) throw new RegraNegocioException("Placa nao cadastrada");
        return v;
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
        List<Veiculo> copia = new ArrayList<>(veiculos.values());
        for (int i=0;i<copia.size();i++) for(int j=i+1;j<copia.size();j++) {
            if (copia.get(i).getPlaca().compareTo(copia.get(j).getPlaca())>0) {
                Veiculo anterior=copia.get(i);copia.set(i,copia.get(j));copia.set(j,anterior);
            }
        }
        return copia;
    }
    public int registrarEntrada(String placa) throws RegraNegocioException {
        Veiculo v = consultarVeiculo(placa);
        if (buscarAtiva(v.getPlaca()) != null)
            throw new RegraNegocioException("Veiculo ja possui permanencia aberta");
        Permanencia p = new Permanencia(proximoNumero,v);
        ativas.put(v.getPlaca(),p);
        proximoNumero++;
        return p.getNumero();
    }
    public Cobravel registrarSaida(String placa,int minutos) throws RegraNegocioException {
        // Ordem definida: exigir ativa, depois validar duracao no proprio objeto.
        Permanencia p = exigirAtiva(placa);
        p.encerrar(minutos);
        cobrancas.add(p);
        ativas.remove(p.getPlaca());
        return p;
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
        Set<String> placas = new HashSet<>();
        for (Cobravel c : cobrancas) placas.add(c.getPlaca());
        return placas;
    }
    // TODO 16.2: implemente a consulta e use-a na remocao sem mudar a regra.
    private boolean possuiCobrancaDaPlaca(String chave) {
        throw new UnsupportedOperationException("TODO 16.2: consultar vinculo com historico");
    }

}

