import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class Produto {
    private final int codigo;
    private double preco;
    Produto(int codigo, double preco) { this.codigo = codigo; this.preco = preco; }
    int getCodigo() { return codigo; }
    double getPreco() { return preco; }
    boolean alterarPreco(double novoPreco) {
        if (novoPreco <= 0 || !Double.isFinite(novoPreco)) return false;
        preco = novoPreco;
        return true;
    }
}

class ItemPedido {
    private final Produto produto;
    private int quantidade;
    ItemPedido(Produto produto, int quantidade) { this.produto = produto; this.quantidade = quantidade; }
    int getCodigoProduto() { return produto.getCodigo(); }
    boolean alterarQuantidade(int novaQuantidade) {
        if (novaQuantidade <= 0) return false;
        quantidade = novaQuantidade;
        return true;
    }
    double calcularSubtotal() { return produto.getPreco() * quantidade; }
    void exibir() {
        System.out.printf("Produto: %d | Preco: %.2f | Quantidade: %d | Subtotal: %.2f%n",
            produto.getCodigo(), produto.getPreco(), quantidade, calcularSubtotal());
    }
}

class Pedido {
    private final int numero;
    private final List<ItemPedido> itens = new ArrayList<>();
    Pedido(int numero) { this.numero = numero; }
    int quantidadeItens() { return itens.size(); }
    private int buscarIndice(int codigo) {
        // TODO: Percorra itens com size/get; compare getCodigoProduto; retorne indice ou -1.
        return -1;
    }
    boolean adicionarItem(Produto produto, int quantidade) {
        // TODO: Recuse produto null, quantidade invalida e codigo repetido; crie ItemPedido e use add.
        return false;
    }
    boolean consultarItem(int codigo) {
        // TODO: Busque indice; proteja -1; exiba o item encontrado e retorne true.
        return false;
    }
    boolean alterarQuantidade(int codigo, int novaQuantidade) {
        // TODO: Na classe Pedido, busque por codigo, proteja -1 e delegue ao item.
        return false;
    }
    boolean removerItem(int codigo) {
        // TODO: Busque por codigo; proteja -1; remova por indice e retorne true.
        return false;
    }
    double calcularTotal() {
        // TODO: Some os subtotais com size/get; vazio deve produzir zero.
        return 0.0;
    }
    void exibir() {
        // TODO: Em Pedido, mostre numero, tamanho, cada item e total; sinalize pedido vazio.

    }
}

public class ProjetoPedidoListaInicial {
    // Catalogo pequeno e fixo; a colecao dinamica desta aula e a de itens do pedido.
    static Produto buscarProduto(Produto[] catalogo, int codigo) {
        for (int i = 0; i < catalogo.length; i++) {
            if (catalogo[i].getCodigo() == codigo) return catalogo[i];
        }
        return null;
    }
    static void mostrarCatalogo(Produto[] catalogo) {
        for (int i = 0; i < catalogo.length; i++) {
            System.out.printf("Codigo: %d | Preco: %.2f%n", catalogo[i].getCodigo(), catalogo[i].getPreco());
        }
    }
    static void mostrarMenu() {
        System.out.print("\n1-Listar 2-Incluir 3-Consultar 4-Alterar quantidade 5-Remover 6-Alterar preco 7-Catalogo 0-Sair\nOpcao: ");
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        Produto[] catalogo = {new Produto(101, 5.50), new Produto(202, 8.00), new Produto(303, 4.00)};
        Pedido pedido = new Pedido(10);
        int opcao;
        mostrarCatalogo(catalogo);
        do {
            mostrarMenu();
            opcao = entrada.nextInt();
            int codigo;
            Produto produto;
            switch (opcao) {
                case 1: pedido.exibir(); break;
                case 2:
                    System.out.print("Codigo e quantidade: ");
                    codigo = entrada.nextInt();
                    int quantidade = entrada.nextInt();
                    produto = buscarProduto(catalogo, codigo);
                    System.out.println(pedido.adicionarItem(produto, quantidade) ? "Item incluido." : "Inclusao recusada: codigo inexistente, duplicado ou quantidade invalida.");
                    break;
                case 3:
                    System.out.print("Codigo: ");
                    if (!pedido.consultarItem(entrada.nextInt())) System.out.println("Item nao encontrado.");
                    break;
                case 4:
                    System.out.print("Codigo e nova quantidade: ");
                    codigo = entrada.nextInt();
                    System.out.println(pedido.alterarQuantidade(codigo, entrada.nextInt()) ? "Quantidade alterada." : "Alteracao recusada.");
                    break;
                case 5:
                    System.out.print("Codigo: ");
                    System.out.println(pedido.removerItem(entrada.nextInt()) ? "Item removido." : "Item nao encontrado.");
                    break;
                case 6:
                    System.out.print("Codigo e novo preco: ");
                    codigo = entrada.nextInt();
                    double preco = entrada.nextDouble();
                    produto = buscarProduto(catalogo, codigo);
                    System.out.println(produto != null && produto.alterarPreco(preco) ? "Preco alterado." : "Alteracao recusada.");
                    break;
                case 7: mostrarCatalogo(catalogo); break;
                case 0: System.out.println("Programa encerrado."); break;
                default: System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
        entrada.close();
    }
}
