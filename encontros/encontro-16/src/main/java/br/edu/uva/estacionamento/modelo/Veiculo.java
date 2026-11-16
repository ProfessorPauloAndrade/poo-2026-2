package br.edu.uva.estacionamento.modelo;

import java.util.*;

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
        if (placa == null || placa.trim().isEmpty())
            throw new IllegalArgumentException("Placa deve ter texto");
        return placa.trim().toUpperCase(Locale.ROOT);
    }
    private static String validarModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty())
            throw new IllegalArgumentException("Modelo deve ter texto");
        return modelo.trim();
    }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public void alterarModelo(String novo) { modelo = validarModelo(novo); }
    public abstract double getTarifaHora();
    public double calcularTarifa(int minutos) {
        if (minutos <= 0) throw new IllegalArgumentException("Minutos devem ser positivos");
        double tarifa = getTarifaHora();
        if (!Double.isFinite(tarifa) || tarifa <= 0)
            throw new IllegalStateException("Categoria forneceu tarifa invalida");
        return Math.ceil(minutos / 60.0) * tarifa;
    }
    @Override public final boolean equals(Object outro) {
        if (this == outro) return true;
        if (!(outro instanceof Veiculo)) return false;
        Veiculo v = (Veiculo) outro;
        return placa.equals(v.placa);
    }
    @Override public final int hashCode() { return placa.hashCode(); }
    @Override public String toString() { return placa + " | " + modelo; }
}
