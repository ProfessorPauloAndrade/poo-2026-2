package br.edu.uva.estacionamento.modelo;

import java.util.*;

public interface Cobravel {
    int getNumero();
    String getPlaca();
    String getDescricao();
    double calcularValor();
}
