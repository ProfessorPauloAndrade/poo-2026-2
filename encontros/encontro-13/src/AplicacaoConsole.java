import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AplicacaoConsole {
    private static void imprimirRecibo(Cobravel c) {
        // TODO 13.6: apresente sem alterar registros usando sobrecarga
        throw new UnsupportedOperationException("TODO 13.6: apresente sem alterar registros usando sobrecarga");
    }
    private static void imprimirRecibo(Cobravel c, String observacao) {
        // TODO 13.6: apresente sem alterar registros usando sobrecarga
        throw new UnsupportedOperationException("TODO 13.6: apresente sem alterar registros usando sobrecarga");
    }
    public static void main(String[] args) {
        Estacionamento est = new Estacionamento();
        est.cadastrarVeiculo(new Carro("ABC1D23", "Hatch"));
        est.cadastrarVeiculo(new Moto("XYZ9K87", "Urbana"));
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 Veiculos | 2 Entrada | 3 Abertas | 4 Saida | 5 Lavagem | 6 Historico | 7 Total | 0 Sair");
            // Recorte 13: formato numerico valido; tratamento textual vem em 14.
            opcao = entrada.nextInt(); entrada.nextLine();
            try {
            if (opcao == 1) {
                for (Veiculo v : est.listarVeiculos()) System.out.println(v);
            } else if (opcao == 2) {
                System.out.println("Placa:");
                System.out.println(est.registrarEntrada(entrada.nextLine()) ? "Entrada aceita" : "Entrada recusada");
            } else if (opcao == 3) {
                if (est.listarPermanenciasAtivas().isEmpty()) System.out.println("Nenhuma permanencia aberta");
                for (Permanencia p : est.listarPermanenciasAtivas()) System.out.println(p);
            } else if (opcao == 4) {
                System.out.println("Placa:"); String placa = entrada.nextLine();
                System.out.println("Minutos positivos:"); int minutos = entrada.nextInt(); entrada.nextLine();
                Cobravel c = est.registrarSaida(placa, minutos);
                if (c == null) System.out.println("Saida recusada"); else imprimirRecibo(c);
            } else if (opcao == 5) {
                System.out.println("Placa:"); Cobravel c = est.registrarLavagem(entrada.nextLine());
                if (c == null) System.out.println("Lavagem recusada");
                else imprimirRecibo(c, "Visita permanece aberta");
            } else if (opcao == 6) {
                if (est.listarCobrancas().isEmpty()) System.out.println("Historico vazio");
                for (Cobravel c : est.listarCobrancas()) imprimirRecibo(c);
            } else if (opcao == 7) System.out.printf(Locale.ROOT, "Total R$ %.2f%n", est.totalizarCobrancas());
            else if (opcao != 0) System.out.println("Opcao inexistente");
            } catch (UnsupportedOperationException etapa) {
                System.out.println("ETAPA PENDENTE: " + etapa.getMessage());
            }
        } while (opcao != 0);
        entrada.close();
    }
    // TODO 13.7: complete as comparacoes; os argumentos ja estao normalizados.
    static boolean mesmaPlaca(String a, String b) {
        throw new UnsupportedOperationException("TODO 13.7: comparar conteudo");
    }
    static int compararPlacas(String a, String b) {
        throw new UnsupportedOperationException("TODO 13.7: comparar ordem");
    }

}
