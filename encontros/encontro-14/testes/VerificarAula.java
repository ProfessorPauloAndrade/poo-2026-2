import java.util.*;
import java.lang.reflect.*;
import java.io.*;
// Infraestrutura fornecida: nao e necessario editar ou estudar reflexao/lambdas nesta aula.
public final class VerificarAula {
    interface Caso { void executar() throws Exception; }
    private static int ok, pendentes, falhas;
    static void igual(Object esperado, Object observado, String motivo) {
        if (!Objects.equals(esperado, observado))
            throw new AssertionError(motivo + " | esperado=" + esperado + " observado=" + observado);
    }
    static void condicao(boolean ok, String motivo) {
        if (!ok) throw new AssertionError(motivo);
    }
    static void esperar(Class<? extends Exception> tipo, Caso caso) throws Exception {
        try { caso.executar(); }
        catch (UnsupportedOperationException pendente) { throw pendente; }
        catch (Exception falha) {
            if (tipo.isInstance(falha)) return;
            throw new AssertionError("Esperada " + tipo.getSimpleName() + ", recebida " + falha.getClass().getSimpleName());
        }
        throw new AssertionError("A chamada deveria recusar com " + tipo.getSimpleName());
    }
    static void etapa(String nome, Caso caso) {
        try { caso.executar(); ok++; System.out.println("OK       " + nome); }
        catch (UnsupportedOperationException e) { pendentes++; System.out.println("PENDENTE " + nome + " | " + e.getMessage()); }
        catch (AssertionError | Exception e) { falhas++; System.out.println("REVER    " + nome + " | " + e.getClass().getSimpleName() + ": " + e.getMessage()); }
    }
    static Object privado(Object alvo, String nome, String argumento) throws Exception {
        Method m = alvo.getClass().getDeclaredMethod(nome, String.class); m.setAccessible(true);
        try { return m.invoke(alvo, argumento); }
        catch (InvocationTargetException e) {
            if (e.getCause() instanceof Exception) throw (Exception)e.getCause();
            throw e;
        }
    }
    public static int executar() throws Exception {
        ok=0; pendentes=0; falhas=0;
        etapa("14.1 - motivo da excecao propria", () -> {
            igual("Motivo de teste",new RegraNegocioException("Motivo de teste").getMessage(),"mensagem preservada");
        });
        etapa("14.2 - proteger argumentos e estado", () -> {
            esperar(IllegalArgumentException.class,()->new Carro(null,"Hatch"));
            Carro v=new Carro("ABC1D23","Hatch");esperar(IllegalArgumentException.class,()->v.alterarModelo("  "));igual("Hatch",v.getModelo(),"estado anterior");
        });
        etapa("14.3 - recusar duracao", () -> {
            esperar(IllegalArgumentException.class,()->new Carro("ABC1D23","Hatch").calcularTarifa(0));
        });
        etapa("14.4 - proteger estado da permanencia", () -> {
            Permanencia p=new Permanencia(1,new Carro("ABC1D23","Hatch"));esperar(IllegalStateException.class,()->p.calcularValor());
            esperar(IllegalArgumentException.class,()->p.encerrar(0));condicao(!p.estaEncerrada(),"segue aberta");p.encerrar(75);
            igual(20.0,p.calcularValor(),"valor");esperar(IllegalStateException.class,()->p.encerrar(20));
        });
        etapa("14.5 - recuperar apos recusa", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));e.registrarEntrada("ABC1D23");
            esperar(RegraNegocioException.class,()->e.registrarEntrada("ABC1D23"));
            esperar(IllegalArgumentException.class,()->e.registrarSaida("ABC1D23",0));igual(1,e.listarPermanenciasAtivas().size(),"visita preservada");
            igual(20.0,e.registrarSaida("ABC1D23",75).calcularValor(),"operacao posterior");esperar(RegraNegocioException.class,()->e.removerVeiculo("ABC1D23"));
        });

        System.out.println("RESUMO OK="+ok+" PENDENTE="+pendentes+" REVER="+falhas);
        System.out.println("Este roteiro verifica os casos acima; confira tambem a atividade, o menu e a entrega.");
        return pendentes+falhas;
    }
    public static void exigirTudoPronto() throws Exception {
        if (executar()!=0) throw new AssertionError("Ha etapas Java pendentes ou resultados a rever");
    }
    public static void main(String[] args) throws Exception { if (executar()!=0) System.exit(1); }
}
