import java.util.Locale;
import java.util.Scanner;

class Produto {
    private final int codigo;
    private double preco;
    Produto(int codigo, double preco) { this.codigo = codigo; this.preco = preco; }
    int getCodigo() { return codigo; }
    double getPreco() { return preco; }
    boolean alterarPreco(double novoPreco) {
        if (novoPreco <= 0) return false;
        preco = novoPreco;
        return true;
    }
}

class ItemPedido {
    private final Produto produto;
    private int quantidade;
    ItemPedido(Produto produto, int quantidade) {
        // TODO: guardar a referencia do produto e a quantidade com this.
        this.produto = produto;
        this.quantidade = quantidade;
    }
    boolean alterarQuantidade(int novaQuantidade) {
        // TODO: recusar valor menor ou igual a zero e preservar a quantidade anterior.
        if (novaQuantidade <= 0) return false;
        quantidade = novaQuantidade;
        return true;
    }
    double calcularSubtotal() {
        // TODO: consultar preco do produto e multiplicar pela quantidade.
        return produto.getPreco() * quantidade;
    }
    void exibir() {
        // TODO: mostrar codigo, preco, quantidade e subtotal.
        System.out.printf("Produto: %d | Preco: %.2f | Quantidade: %d | Subtotal: %.2f%n",
                produto.getCodigo(), produto.getPreco(), quantidade, calcularSubtotal());
    }
}

class Pedido {
    private final int numero;
    private final ItemPedido item;
    Pedido(int numero, Produto produto, int quantidade) {
        this.numero = numero;
        // TODO: criar internamente o ItemPedido. Pedido controla seu item.
        this.item = new ItemPedido(produto, quantidade);
    }
    boolean alterarQuantidade(int novaQuantidade) {
        // TODO: delegar a alteracao para ItemPedido.
        return item.alterarQuantidade(novaQuantidade);
    }
    double calcularTotal() {
        // TODO: delegar o calculo para o item.
        return item.calcularSubtotal();
    }
    void exibir() {
        System.out.println("Pedido: " + numero);
        item.exibir();
        System.out.printf("Total: %.2f%n", calcularTotal());
    }
}

public class ProjetoPedidoInicial {
    static void mostrarMenu() {
        System.out.print("\n1-Exibir pedido 2-Alterar preco 3-Alterar quantidade 0-Sair\nOpcao: ");
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        Produto cafe = new Produto(101, 5.50);
        Pedido pedido = new Pedido(10, cafe, 3);
        int opcao;
        do {
            mostrarMenu();
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1: pedido.exibir(); break;
                case 2:
                    System.out.print("Novo preco: ");
                    if (cafe.alterarPreco(entrada.nextDouble())) System.out.println("Preco alterado.");
                    else System.out.println("O preco deve ser maior que zero.");
                    break;
                case 3:
                    System.out.print("Nova quantidade: ");
                    if (pedido.alterarQuantidade(entrada.nextInt())) System.out.println("Quantidade alterada.");
                    else System.out.println("A quantidade deve ser maior que zero.");
                    break;
                case 0: System.out.println("Programa encerrado."); break;
                default: System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
        entrada.close();
    }
}
