import java.util.Locale;
import java.util.Scanner;

public class CaixaCantinaInicial {
    static void mostrarMenu() {
        System.out.println("\n1 - Registrar venda");
        System.out.println("2 - Consultar total");
        System.out.println("0 - Encerrar");
        System.out.print("Opcao: ");
    }

    static double registrarVenda(double total, double valor) {
        // TODO: se o valor for invalido, mostre uma mensagem e preserve o total.
        // TODO: caso contrario, some o valor ao total e devolva o novo total.
        return total;
    }

    static void mostrarTotal(double total) {
        // TODO: mostre o total com duas casas decimais.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        double total = 0.0;
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();

            // TODO: use switch para tratar as opcoes 1, 2, 0 e uma opcao invalida.
        } while (opcao != 0);

        scanner.close();
    }
}
