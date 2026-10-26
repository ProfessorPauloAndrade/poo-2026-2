package br.edu.uva.estacionamento.modelo;

import java.util.*;

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
        if (estaEncerrada()) throw new IllegalStateException("Permanencia ja encerrada");
        if (duracao <= 0) throw new IllegalArgumentException("Minutos devem ser positivos");
        double apurado = veiculo.calcularTarifa(duracao);
        minutos = duracao;
        valorCobrado = apurado;
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
        if (!estaEncerrada()) throw new IllegalStateException("Valor ainda nao apurado");
        return valorCobrado;
    }
    @Override public String toString() {
        String base = numero + " | " + getPlaca() + " | " + getDescricao();
        return estaEncerrada() ? base + String.format(Locale.ROOT," | R$ %.2f",calcularValor()) : base;
    }
}
