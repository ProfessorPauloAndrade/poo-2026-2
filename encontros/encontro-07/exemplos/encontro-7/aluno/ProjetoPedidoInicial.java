import java.util.Locale;

class Produto {
    private final int codigo;
    private double preco;

    Produto(int codigo, double preco) {
        this.codigo = codigo;
        this.preco = preco;
    }

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
    private final int quantidade;

    ItemPedido(Produto produto, int quantidade) {
        // TODO: guardar a referencia do produto e a quantidade com this.
        this.produto = produto;
        this.quantidade = quantidade;
    }

    double calcularSubtotal() {
        // TODO: consultar preco do produto e multiplicar pela quantidade.
        return produto.getPreco() * quantidade;
    }

    void exibir() {
        // TODO: mostrar codigo do produto, quantidade e subtotal.
        System.out.printf("Produto: %d | Quantidade: %d | Subtotal: %.2f%n",
                produto.getCodigo(), quantidade, calcularSubtotal());
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
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Produto cafe = new Produto(101, 5.50);
        Pedido pedido = new Pedido(10, cafe, 3);
        pedido.exibir();

        // TODO: alterar o preco do mesmo objeto Produto e prever o novo total.
    }
}
