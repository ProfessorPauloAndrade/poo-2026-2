import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AplicacaoConsole {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.cadastrarVeiculo(new Carro("ABC1D23", "Hatch"));
        estacionamento.cadastrarVeiculo(new Moto("XYZ9K87", "Urbana"));
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 Veiculos | 2 Registrar visita concluida | 3 Historico | 4 Total | 0 Sair");
            opcao = entrada.nextInt(); entrada.nextLine();
            try {
            if (opcao == 1) {
                for (Veiculo v : estacionamento.listarVeiculos())
                    System.out.printf(Locale.ROOT, "%s | tarifa/h R$ %.2f%n", v, v.getTarifaHora());
            } else if (opcao == 2) {
                System.out.println("Placa:"); String placa = entrada.nextLine();
                System.out.println("Minutos positivos:"); int minutos = entrada.nextInt(); entrada.nextLine();
                System.out.println(estacionamento.registrarPermanencia(placa, minutos) ? "Registro aceito" : "Registro recusado");
            } else if (opcao == 3) {
                if (estacionamento.listarPermanencias().isEmpty()) System.out.println("Historico vazio");
                for (Permanencia p : estacionamento.listarPermanencias()) System.out.println(p);
            } else if (opcao == 4) System.out.printf(Locale.ROOT, "Total R$ %.2f%n", estacionamento.totalizarPermanencias());
            else if (opcao != 0) System.out.println("Opcao inexistente");
            } catch (UnsupportedOperationException etapa) {
                System.out.println("ETAPA PENDENTE: " + etapa.getMessage());
            }
        } while (opcao != 0);
        entrada.close();
    }
}
