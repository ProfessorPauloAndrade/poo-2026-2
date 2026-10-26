// TODO 13.2: conecte este tipo ao contrato Cobravel e confira as implementacoes publicas.
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Permanencia {
    private final int numero;
    private final Veiculo veiculo;
    private Integer minutos;
    private Double valorCobrado;
    // Precondicao de construcao: numero positivo e veiculo valido.
    Permanencia(int numero, Veiculo veiculo) {
        this.numero = numero;
        this.veiculo = veiculo;
    }
    boolean encerrar(int duracao) {
        // TODO 13.1: represente ausencia e encerre a mesma visita com coerencia
        throw new UnsupportedOperationException("TODO 13.1: represente ausencia e encerre a mesma visita com coerencia");
    }
    public boolean estaEncerrada() {
        // TODO 13.1: represente ausencia e encerre a mesma visita com coerencia
        throw new UnsupportedOperationException("TODO 13.1: represente ausencia e encerre a mesma visita com coerencia");
    }
    public Integer getMinutos() { return minutos; }
    public int getNumero() { return numero; }
    public String getPlaca() { return veiculo.getPlaca(); }
    public String getDescricao() {
        // TODO 13.1: represente ausencia e encerre a mesma visita com coerencia
        throw new UnsupportedOperationException("TODO 13.1: represente ausencia e encerre a mesma visita com coerencia");
    }
    // Precondicao: encerrada. Aula 14 acrescenta IllegalStateException explicita.
    // Nunca retornar zero como substituto de um valor ainda ausente.
    public double calcularValor() {
        // TODO 13.1: represente ausencia e encerre a mesma visita com coerencia
        throw new UnsupportedOperationException("TODO 13.1: represente ausencia e encerre a mesma visita com coerencia");
    } // unboxing
    public String toString() {
        String base = numero + " | " + getPlaca() + " | " + getDescricao();
        return estaEncerrada() ? base + String.format(Locale.ROOT, " | R$ %.2f", calcularValor()) : base;
    }
}
