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
        etapa("13.1 - ausencia e encerramento", () -> {
            Permanencia p=new Permanencia(1,new Carro("ABC1D23","Hatch"));
            condicao(!p.estaEncerrada(),"visita aberta");igual(null,p.getMinutos(),"ausente nao e zero");condicao(!p.encerrar(0),"recusa");
            condicao(p.encerrar(75),"encerramento");igual(20.0,p.calcularValor(),"valor");condicao(!p.encerrar(20),"nao encerrar duas vezes");
        });
        etapa("13.2 - contrato implementado", () -> {
            if(!Cobravel.class.isAssignableFrom(Permanencia.class)||!Cobravel.class.isAssignableFrom(Lavagem.class))
                throw new UnsupportedOperationException("TODO 13.2: conferir implements e metodos publicos");
        });
        etapa("13.3 - lavagem independente", () -> {
            Lavagem l=new Lavagem(3,new Moto("XYZ9K87","Urbana"));igual(3,l.getNumero(),"numero");igual(20.0,l.calcularValor(),"preco");
        });
        etapa("13.4 e 13.5 - integrar sem duplicar", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));e.cadastrarVeiculo(new Moto("XYZ9K87","Urbana"));
            e.registrarEntrada("ABC1D23");e.registrarEntrada("XYZ9K87");e.registrarSaida("ABC1D23",75);e.registrarLavagem("XYZ9K87");
            igual(1,e.listarPermanenciasAtivas().size(),"moto continua aberta");igual(40.0,e.totalizarCobrancas(),"total parcial");
            e.registrarSaida("XYZ9K87",20);igual(46.0,e.totalizarCobrancas(),"total final");
            igual(List.of(1,3,2),e.listarCobrancas().stream().map(Cobravel::getNumero).toList(),"ordem de lancamento");
        });
        etapa("13.6 - assinaturas de recibo", () -> {
            Method a=AplicacaoConsole.class.getDeclaredMethod("imprimirRecibo",Cobravel.class);a.setAccessible(true);
            Method b=AplicacaoConsole.class.getDeclaredMethod("imprimirRecibo",Cobravel.class,String.class);b.setAccessible(true);
            Lavagem l=new Lavagem(3,new Moto("XYZ9K87","Urbana"));
            try { a.invoke(null,l);b.invoke(null,l,"Conferencia"); }catch(InvocationTargetException ex){if(ex.getCause()instanceof Exception)throw(Exception)ex.getCause();throw ex;}
            igual(20.0,l.calcularValor(),"recibo nao muda preco");
        });
        etapa("13.7 - conteudo e ordem", () -> {
            condicao(AplicacaoConsole.mesmaPlaca(new String("ABC1D23"),new String("ABC1D23")),"conteudo");
            condicao(AplicacaoConsole.compararPlacas("ABC1D23","XYZ9K87")<0,"sinal da ordem");
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
