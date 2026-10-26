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
        etapa("11.BASE - versao independente fornecida", () -> {
            Carro a=new Carro("ABC1D23","Hatch"); Moto b=new Moto("XYZ9K87","Urbana");
            igual("ABC1D23",a.getPlaca(),"placa"); igual(10.0,a.getTarifaHora(),"tarifa carro"); igual(6.0,b.getTarifaHora(),"tarifa moto");
        });
        etapa("11.1 - regra comum", () -> {
            Veiculo v=new Veiculo(" abc1d23 ","Hatch");
            igual("ABC1D23",v.getPlaca(),"normalizacao"); condicao(v.alterarModelo(" Compacto "),"alteracao valida");
            condicao(!v.alterarModelo("  "),"recusa"); igual("Compacto",v.getModelo(),"estado preservado");
        });
        etapa("11.2 - especializacao sem campos duplicados", () -> {
            if(!Carro.class.getSuperclass().equals(Veiculo.class) || !Moto.class.getSuperclass().equals(Veiculo.class))
                throw new UnsupportedOperationException("TODO 11.2: as categorias ainda sao independentes");
            for(Class<?> tipo:List.of(Carro.class,Moto.class)) for(Field f:tipo.getDeclaredFields())
                condicao(!f.getName().equals("placa")&&!f.getName().equals("modelo"),"retire o estado comum de "+tipo.getSimpleName());
        });
        etapa("11.3 - descricao sem efeito colateral", () -> {
            Carro a=new Carro("ABC1D23","Hatch"); igual("Carro | ABC1D23 | Hatch",a.toString(),"descricao");
            igual("Hatch",a.getModelo(),"consulta nao altera"); igual("Não informado",new Carro("AAA1A11").getModelo(),"construcao reduzida");
        });
        etapa("11.4 - estado independente", () -> {
            Carro a=new Carro("ABC1D23","Hatch"),b=new Carro("QWE4R56","Sedan");
            a.alterarModelo("Compacto");igual("Sedan",b.getModelo(),"segundo carro");igual(10.0,a.getTarifaHora(),"tarifa constante");
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
