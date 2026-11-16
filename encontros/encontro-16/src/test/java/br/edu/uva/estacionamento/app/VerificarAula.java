package br.edu.uva.estacionamento.app;
import br.edu.uva.estacionamento.modelo.*;
import br.edu.uva.estacionamento.excecao.RegraNegocioException;
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
        etapa("16.1 - jornada preparada pelo aluno", () -> {
            Estacionamento e=MeuTeste.montarJornada();igual(0,e.listarPermanenciasAtivas().size(),"todas encerradas");igual(46.0,e.totalizarCobrancas(),"total");
            igual(List.of(1,3,2),e.listarCobrancas().stream().map(Cobravel::getNumero).toList(),"historico");igual(Set.of("ABC1D23","XYZ9K87"),e.placasAtendidas(),"placas");
            Cobravel primeira=e.listarCobrancas().get(0);igual(4,e.registrarEntrada("ABC1D23"),"nova visita");condicao(primeira!=e.listarPermanenciasAtivas().get(0),"novo objeto");igual(20.0,primeira.calcularValor(),"antiga preservada");
        });
        etapa("16.BASE - recusa e tentativa posterior", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));e.registrarEntrada("ABC1D23");Permanencia p=e.listarPermanenciasAtivas().get(0);
            esperar(IllegalArgumentException.class,()->e.registrarSaida("ABC1D23",0));condicao(p==e.listarPermanenciasAtivas().get(0),"mesma visita");igual(20.0,e.registrarSaida("ABC1D23",75).calcularValor(),"recuperacao");
        });
        etapa("16.2 - consulta privada extraida", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Moto("XYZ9K87","Urbana"));igual(false,privado(e,"possuiCobrancaDaPlaca","XYZ9K87"),"sem vinculo");
            e.registrarEntrada("XYZ9K87");e.registrarLavagem("XYZ9K87");igual(true,privado(e,"possuiCobrancaDaPlaca","XYZ9K87"),"com vinculo");esperar(RegraNegocioException.class,()->e.removerVeiculo("XYZ9K87"));
        });
        etapa("16.3 - apresentar sem alterar", () -> {
            Estacionamento e=new Estacionamento();PrintStream anterior=System.out;ByteArrayOutputStream bytes=new ByteArrayOutputStream();
            try {System.setOut(new PrintStream(bytes));AplicacaoConsole.apresentarAbertas(e);}finally{System.setOut(anterior);}
            condicao(bytes.toString().contains("Nenhuma permanencia aberta"),"mensagem vazia");
            e.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));e.registrarEntrada("ABC1D23");bytes.reset();
            try {System.setOut(new PrintStream(bytes));AplicacaoConsole.apresentarAbertas(e);}finally{System.setOut(anterior);}
            condicao(bytes.toString().contains("ABC1D23")&&bytes.toString().contains("ABERTA"),"descricao sem valor");igual(0,e.listarCobrancas().size(),"consulta nao cobra");
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
