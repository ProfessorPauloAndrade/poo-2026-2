public class TiposEOperadores {
    public static void main(String[] args) {
        int quantidade = 3;
        double preco = 12.50;
        char turma = 'A';
        boolean pagamentoConfirmado = true;
        final double DESCONTO = 0.10;

        double total = quantidade * preco;
        double totalComDesconto = total * (1 - DESCONTO);
        boolean quantidadePositiva = quantidade > 0;

        System.out.println("Turma: " + turma);
        System.out.println("Pagamento confirmado: " + pagamentoConfirmado);
        System.out.println("Total: " + total);
        System.out.println("Total com desconto: " + totalComDesconto);
        System.out.println("Quantidade positiva: " + quantidadePositiva);
    }
}
