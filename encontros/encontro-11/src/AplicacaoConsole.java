import java.util.Locale;
import java.util.Scanner;

public class AplicacaoConsole {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Carro carro = new Carro("ABC1D23", "Hatch");
        Moto moto = new Moto("XYZ9K87", "Urbana");
        Carro segundo = new Carro("QWE4R56", "Sedan");
        int opcao;
        do {
            System.out.println("1 Consultar | 2 Alterar primeiro carro | 3 Alterar moto | 4 Alterar segundo carro | 5 Tarifas | 0 Sair");
            opcao = entrada.nextInt();
            entrada.nextLine();
            if (opcao == 1) {
                System.out.println(carro);
                System.out.println(moto);
                System.out.println(segundo);
            } else if (opcao >= 2 && opcao <= 4) {
                System.out.println("Novo modelo:");
                String texto = entrada.nextLine();
                boolean aceito;
                if (opcao == 2) aceito = carro.alterarModelo(texto);
                else if (opcao == 3) aceito = moto.alterarModelo(texto);
                else aceito = segundo.alterarModelo(texto);
                System.out.println(aceito ? "Alteracao aceita" : "Alteracao recusada");
            } else if (opcao == 5) {
                System.out.printf(Locale.ROOT, "Tarifa/h: carro %.2f | moto %.2f%n", carro.getTarifaHora(), moto.getTarifaHora());
            } else if (opcao != 0) System.out.println("Opcao inexistente");
        } while (opcao != 0);
        entrada.close();
    }
}
