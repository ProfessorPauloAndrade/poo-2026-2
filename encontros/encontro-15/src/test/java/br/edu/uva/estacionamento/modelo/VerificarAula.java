package br.edu.uva.estacionamento.modelo;
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
        etapa("15.1 - consultar sem substituir", () -> {
            Estacionamento e=new Estacionamento();Veiculo v=new Carro("ABC1D23","Hatch");e.cadastrarVeiculo(v);
            condicao(v==e.consultarVeiculo(" abc1d23 "),"mesmo cadastro");esperar(RegraNegocioException.class,()->e.cadastrarVeiculo(new Moto("ABC1D23","Urbana")));
            condicao(v==e.consultarVeiculo("ABC1D23"),"original preservado");
        });
        etapa("15.2 - migrar ativas", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));igual(1,e.registrarEntrada("ABC1D23"),"entrada");
            esperar(IllegalArgumentException.class,()->e.registrarSaida("ABC1D23",0));igual(1,e.listarPermanenciasAtivas().size(),"visita mantida");igual(20.0,e.registrarSaida("ABC1D23",75).calcularValor(),"saida");
        });
        etapa("15.3 - identidade estavel", () -> {
            Veiculo a=new Carro(" abc1d23 ","Hatch"),b=new Moto("ABC1D23","Urbana");condicao(a.equals(b)&&b.equals(a),"igualdade entre subtipos");
            igual(a.hashCode(),b.hashCode(),"hash compativel");Set<Veiculo>s=new HashSet<>();s.add(a);s.add(b);igual(1,s.size(),"identidade unica");a.alterarModelo("Compacto");condicao(s.contains(a),"modelo fora da identidade");
        });
        etapa("15.4 - placas derivadas do historico", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Moto("XYZ9K87","Urbana"));e.registrarEntrada("XYZ9K87");
            igual(Set.of(),e.placasAtendidas(),"aberta sem cobranca");e.registrarLavagem("XYZ9K87");e.registrarLavagem("XYZ9K87");
            igual(Set.of("XYZ9K87"),e.placasAtendidas(),"duas cobrancas uma placa");e.placasAtendidas().clear();igual(1,e.placasAtendidas().size(),"relatorio novo");
        });
        etapa("15.5 - copia e apresentacao", () -> {
            Estacionamento e=new Estacionamento();e.cadastrarVeiculo(new Moto("XYZ9K87","Urbana"));e.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));
            List<Veiculo>c=e.listarVeiculos();igual("ABC1D23",c.get(0).getPlaca(),"ordem por placa");c.get(0).alterarModelo("Compacto");c.clear();
            igual(2,e.listarVeiculos().size(),"estrutura interna");igual("Compacto",e.consultarVeiculo("ABC1D23").getModelo(),"elemento compartilhado");
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
