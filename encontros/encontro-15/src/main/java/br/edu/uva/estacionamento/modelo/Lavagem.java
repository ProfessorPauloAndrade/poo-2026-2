package br.edu.uva.estacionamento.modelo;

import java.util.*;

public class Lavagem implements Cobravel {
    private static final double PRECO_PADRAO = 20.0;
    private final int numero;
    private final Veiculo veiculo;
    private final double valorCobrado;
    Lavagem(int numero, Veiculo veiculo) {
        if (numero <= 0 || veiculo == null)
            throw new IllegalArgumentException("Registro exige numero positivo e veiculo");
        this.numero = numero;
        this.veiculo = veiculo;
        valorCobrado = PRECO_PADRAO;
    }
    @Override public int getNumero() { return numero; }
    @Override public String getPlaca() { return veiculo.getPlaca(); }
    @Override public String getDescricao() { return "Lavagem"; }
    @Override public double calcularValor() { return valorCobrado; }
    @Override public String toString() {
        return String.format(Locale.ROOT,"%d | %s | %s | R$ %.2f",numero,getPlaca(),getDescricao(),calcularValor());
    }
}
