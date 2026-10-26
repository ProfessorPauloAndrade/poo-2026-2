package br.edu.uva.estacionamento.modelo;

import java.util.*;

public class Carro extends Veiculo {
    private static final double TARIFA_HORA = 10.0;
    public Carro(String placa, String modelo) { super(placa, modelo); }
    public Carro(String placa) { this(placa, "Não informado"); }
    @Override public double getTarifaHora() { return TARIFA_HORA; }
    @Override public String toString() { return "Carro | " + super.toString(); }
}
