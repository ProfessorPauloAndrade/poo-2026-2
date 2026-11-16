import java.util.Scanner;
import java.util.Locale;

public class CalculadoraMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Segunda nota: ");
        double nota2 = scanner.nextDouble();

        double media = (nota1 + nota2) / 2;

        System.out.println("Notas: " + nota1 + " e " + nota2);
        System.out.println("Média: " + media);

        scanner.close();
    }
}
