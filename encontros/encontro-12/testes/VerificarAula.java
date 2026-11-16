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
        etapa("12.1 - contrato abstrato", () -> {
            if(!Modifier.isAbstract(Veiculo.class.getModifiers()) || !Modifier.isAbstract(Veiculo.class.getDeclaredMethod("getTarifaHora").getModifiers()))
                throw new UnsupportedOperationException("TODO 12.1: restricao ainda nao esta no tipo");
            Veiculo v=new Moto("XYZ9K87","Urbana");igual(6.0,v.getTarifaHora(),"despacho");
        });
        etapa("12.2 - horas iniciadas", () -> {
            Veiculo v=new Carro("ABC1D23","Hatch");igual(10.0,v.calcularTarifa(60),"hora exata");igual(20.0,v.calcularTarifa(61),"fronteira");
        });
        etapa("12.3 - registro concluido", () -> {
            Permanencia p=new Permanencia(1,new Moto("XYZ9K87","Urbana"),20);
            igual(1,p.getNumero(),"numero");igual(20,p.getMinutos(),"duracao");igual(6.0,p.calcularValor(),"valor gravado");
        });
        etapa("12.4 - recusa antes da criacao", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));
            condicao(!e.registrarPermanencia("ABC1D23",0),"duracao invalida");igual(0,e.listarPermanencias().size(),"historico");
            condicao(e.registrarPermanencia("ABC1D23",75),"registro valido");igual(1,e.listarPermanencias().get(0).getNumero(),"numero nao consumido");
        });
        etapa("12.5 - total de duas categorias", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));e.cadastrarVeiculo(new Moto("XYZ9K87","Urbana"));
            e.registrarPermanencia("ABC1D23",75);e.registrarPermanencia("XYZ9K87",20);igual(26.0,e.totalizarPermanencias(),"soma dos registros");
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
