public class SaidaFormatada {
    public static void main(String[] args) {
        double media = 7.75;
        String estudante = "Ana";

        System.out.print("Estudante: ");
        System.out.println(estudante);
        System.out.println("Média sem formatação: " + media);
        System.out.printf("Média com duas casas: %.2f%n", media);
    }
}
