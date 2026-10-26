package br.edu.uva.estacionamento.modelo;

import java.util.*;

public class Moto extends Veiculo {
    private static final double TARIFA_HORA = 6.0;
    public Moto(String placa, String modelo) { super(placa, modelo); }
    public Moto(String placa) { this(placa, "Não informado"); }
    @Override public double getTarifaHora() { return TARIFA_HORA; }
    @Override public String toString() { return "Moto | " + super.toString(); }
}
