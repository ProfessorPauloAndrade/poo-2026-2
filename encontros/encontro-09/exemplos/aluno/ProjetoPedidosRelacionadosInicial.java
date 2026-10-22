import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// ESQUELETO DO ALUNO: compila e abre o menu, mas nao e a solucao.
// Retornos false, null e 0.0 sao provisórios. Complete os TODOs antes dos testes.
// Crie os objetos com dados iniciais validos, conforme MATERIAL_ALUNO.md.
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
        // TODO: validar preco positivo e finito; atualizar somente se valido.
        return false;
    }

    void exibir() {
        System.out.printf("Codigo: %d | Preco: %.2f%n", codigo, preco);
    }

}

class ItemPedido {
    private final Produto produto;
    private int quantidade;

    ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    int getCodigoProduto() { return produto.getCodigo(); }
    int getQuantidade() { return quantidade; }

    boolean alterarQuantidade(int novaQuantidade) {
        // TODO: recusar quantidade nao positiva, preservando o estado.
        return false;
    }

    double calcularSubtotal() {
        // TODO: calcular usando a referencia ao Produto e a quantidade atual.
        return 0.0;
    }

    void exibir() {
        // TODO: exibir codigo, preco atual, quantidade e subtotal.
        System.out.println("TODO: exibir item.");
    }

}

class Cliente {
    private final int codigo;
    private String nome;

    Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    int getCodigo() { return codigo; }
    String getNome() { return nome; }

    boolean alterarNome(String novoNome) {
        // TODO: validar nome nao nulo/nem vazio apos trim; atualizar se valido.
        return false;
    }

}

class FichaRetirada {
    private final int senha;
    private int guiche;

    FichaRetirada(int senha, int guiche) {
        this.senha = senha;
        this.guiche = guiche;
    }

    int getSenha() { return senha; }
    int getGuiche() { return guiche; }

    boolean alterarGuiche(int novoGuiche) {
        // TODO: recusar guiche nao positivo, preservando o estado.
        return false;
    }

}

class Pedido {
    private final int numero;
    private final ArrayList<ItemPedido> itens;
    private final Cliente cliente;
    private final FichaRetirada ficha;

    Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.itens = new ArrayList<>();
        // TODO: guardar a referencia ao cliente recebido e criar a ficha exclusiva.
        // Substitua os nulls; senha = numero do pedido, guiche inicial = 1.
        this.cliente = null;
        this.ficha = null;
    }

    int getNumero() { return numero; }
    int getQuantidadeItens() { return itens.size(); }

    // Contrato: retorna o indice do item de mesmo codigo, ou -1 se ausente.
    private int buscarIndicePorCodigo(int codigo) {
        // TODO: percorrer a lista comparando codigos; codigo nao e indice.
        return -1;
    }

    boolean incluirItem(Produto produto, int quantidade) {
        // TODO: recusar produto nulo, quantidade invalida e duplicidade local.
        // Criar o ItemPedido neste pedido somente depois das verificacoes.
        return false;
    }

    void consultarItem(int codigo) {
        // TODO: usar a busca; distinguir item ausente e item encontrado.
        System.out.println("TODO: consultar item.");
    }

    boolean alterarQuantidade(int codigo, int novaQuantidade) {
        // TODO: localizar o item e delegar a alteracao, sem substituir referencias.
        return false;
    }

    boolean removerItem(int codigo) {
        // TODO: buscar e remover com seguranca; preservar os demais itens.
        return false;
    }

    double calcularTotal() {
        // TODO: percorrer itens e acumular seus subtotais; considerar pedido vazio.
        return 0.0;
    }

    void exibir() {
        // TODO: mostrar numero, itens, total e, quando houver, cliente e ficha.
        System.out.println("TODO: exibir pedido (inclusive o caso vazio).");
    }

    int getCodigoCliente() {
        // TODO: consultar o codigo pela referencia ao Cliente.
        return -1;
    }

    boolean alterarGuiche(int novoGuiche) {
        // TODO: delegar para a ficha exclusiva deste pedido.
        return false;
    }


}

public class ProjetoPedidosRelacionadosInicial {
    static void mostrarMenu() {
        System.out.print("\n1-Listar 2-Incluir item 3-Consultar item 4-Alterar quantidade"
            + "\n5-Remover item 6-Alterar preco 7-Catalogo\n8-Selecionar pedido 9-Guiche 10-Clientes 11-Pedidos do cliente 12-Nome 0-Sair\nOpcao: ");
    }

    // Infraestrutura do catalogo fixo; a busca dos itens fica em Pedido.
    static Produto buscarProduto(Produto[] catalogo, int codigo) {
        for (Produto produto : catalogo) {
            if (produto.getCodigo() == codigo) return produto;
        }
        return null;
    }

    static void informarResultado(boolean realizado) {
        System.out.println(realizado ? "Operacao realizada."
            : "Operacao recusada ou pendente: confira os TODOs e os dados informados.");
    }

    static Pedido buscarPedido(Pedido[] pedidos, int numero) {
        // TODO: buscar pelo numero; retornar null quando nao existir.
        return null;
    }

    static Cliente buscarCliente(Cliente[] clientes, int codigo) {
        // TODO: buscar pelo codigo; retornar null quando nao existir.
        return null;
    }

    static void listarPedidosDoCliente(Pedido[] pedidos, Cliente cliente) {
        // TODO: percorrer pedidos e filtrar pelo cliente, sem uma lista duplicada.
        // Distinguir cliente cadastrado sem pedidos de cliente inexistente (no menu).
        System.out.println("TODO: consultar pedidos do cliente.");
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        Produto[] catalogo = {
            new Produto(101, 5.50), new Produto(202, 8.00), new Produto(303, 4.00)
        };
        Cliente[] clientes = { new Cliente(1, "Ana"), new Cliente(2, "Bruno") };
        Pedido[] pedidos = { new Pedido(10, clientes[0]), new Pedido(20, clientes[0]) };
        // Laboratorio do encontro 09: acrescente pedido 30 de Bruno e investigue os vinculos.
        Pedido pedido = pedidos[0];
        System.out.println("ESQUELETO: menu disponivel; regras e calculos dependem dos TODOs.");
        int opcao;
        do {
            mostrarMenu();
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    pedido.exibir();
                    break;
                case 2: {
                    System.out.print("Codigo do produto: ");
                    Produto produto = buscarProduto(catalogo, entrada.nextInt());
                    System.out.print("Quantidade: ");
                    int quantidade = entrada.nextInt();
                    if (produto == null) System.out.println("Produto nao encontrado no catalogo.");
                    else informarResultado(pedido.incluirItem(produto, quantidade));
                    break;
                }
                case 3:
                    System.out.print("Codigo do item: ");
                    pedido.consultarItem(entrada.nextInt());
                    break;
                case 4: {
                    System.out.print("Codigo do item: ");
                    int codigo = entrada.nextInt();
                    System.out.print("Nova quantidade: ");
                    informarResultado(pedido.alterarQuantidade(codigo, entrada.nextInt()));
                    break;
                }
                case 5:
                    System.out.print("Codigo do item: ");
                    informarResultado(pedido.removerItem(entrada.nextInt()));
                    break;
                case 6: {
                    System.out.print("Codigo do produto: ");
                    Produto produto = buscarProduto(catalogo, entrada.nextInt());
                    System.out.print("Novo preco: ");
                    double preco = entrada.nextDouble();
                    if (produto == null) System.out.println("Produto nao encontrado no catalogo.");
                    else informarResultado(produto.alterarPreco(preco));
                    break;
                }
                case 7:
                    for (Produto produto : catalogo) produto.exibir();
                    break;
                case 8: {
                    System.out.print("Numero do pedido: ");
                    Pedido encontrado = buscarPedido(pedidos, entrada.nextInt());
                    if (encontrado == null) {
                        System.out.println("Pedido nao encontrado ou busca pendente; selecao preservada.");
                    } else {
                        pedido = encontrado;
                        System.out.println("Pedido selecionado: " + pedido.getNumero());
                    }
                    break;
                }
                case 9:
                    System.out.print("Novo guiche do pedido selecionado: ");
                    informarResultado(pedido.alterarGuiche(entrada.nextInt()));
                    break;
                case 10:
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getCodigo() + " - " + cliente.getNome());
                    }
                    break;
                case 11: {
                    System.out.print("Codigo do cliente: ");
                    Cliente cliente = buscarCliente(clientes, entrada.nextInt());
                    if (cliente == null) System.out.println("Cliente inexistente ou busca pendente.");
                    else listarPedidosDoCliente(pedidos, cliente);
                    break;
                }
                case 12: {
                    System.out.print("Codigo do cliente: ");
                    Cliente cliente = buscarCliente(clientes, entrada.nextInt());
                    entrada.nextLine(); // Consumir a quebra antes de ler o nome inteiro.
                    System.out.print("Novo nome: ");
                    String nome = entrada.nextLine();
                    if (cliente == null) System.out.println("Cliente inexistente ou busca pendente.");
                    else informarResultado(cliente.alterarNome(nome));
                    break;
                }

                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
        entrada.close();
    }
}
