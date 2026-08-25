import java.util.Locale;
import java.util.Scanner;

class Produto {
    private final int codigo;
    private double preco;

    Produto(int codigo, double preco) {
        // TODO: receber os dados ja validados pelo cadastro e atribui-los com this.
        this.codigo = codigo;
        this.preco = preco;
    }

    Produto(int codigo) {
        // TODO: delegar ao construtor completo com this(...).
        this(codigo, 1.00);
    }

    int getCodigo() { return codigo; }
    double getPreco() { return preco; }

    boolean alterarPreco(double novoPreco) {
        // TODO: recusar valor menor ou igual a zero e preservar o preco anterior.
        if (novoPreco <= 0) return false;
        preco = novoPreco;
        return true;
    }

    void exibir() {
        System.out.printf("Codigo: %d | Preco: %.2f%n", codigo, preco);
    }
}

public class CadastroProdutosEncapsuladoInicial {
    static final int MAX_PRODUTOS = 5;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        Produto[] produtos = new Produto[MAX_PRODUTOS];
        int quantidade = 0;
        int opcao;
        do {
            mostrarMenu();
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Codigo: ");
                    int codigo = entrada.nextInt();
                    System.out.print("Preco: ");
                    double preco = entrada.nextDouble();
                    quantidade = cadastrarProduto(produtos, quantidade, codigo, preco);
                    break;
                case 2:
                    System.out.print("Codigo para consulta: ");
                    consultarProduto(produtos, quantidade, entrada.nextInt());
                    break;
                case 3:
                    System.out.print("Codigo do produto: ");
                    codigo = entrada.nextInt();
                    System.out.print("Novo preco: ");
                    alterarPrecoProduto(produtos, quantidade, codigo, entrada.nextDouble());
                    break;
                case 4:
                    System.out.print("Codigo para remover: ");
                    quantidade = removerProduto(produtos, quantidade, entrada.nextInt());
                    break;
                case 5: listarProdutos(produtos, quantidade); break;
                case 0: System.out.println("Programa encerrado."); break;
                default: System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
        entrada.close();
    }

    static void mostrarMenu() { System.out.print("\n1-Cadastrar 2-Consultar 3-Alterar 4-Remover 5-Listar 0-Sair\nOpcao: "); }
    static int buscarIndicePorCodigo(Produto[] produtos, int quantidade, int codigo) {
        for (int i = 0; i < quantidade; i++) if (produtos[i].getCodigo() == codigo) return i;
        return -1;
    }
    static int cadastrarProduto(Produto[] produtos, int quantidade, int codigo, double preco) {
        if (quantidade == MAX_PRODUTOS) { System.out.println("Cadastro cheio."); return quantidade; }
        if (codigo <= 0 || preco <= 0) { System.out.println("Codigo e preco devem ser maiores que zero."); return quantidade; }
        if (buscarIndicePorCodigo(produtos, quantidade, codigo) != -1) { System.out.println("Codigo ja cadastrado."); return quantidade; }
        // TODO: criar Produto com o construtor, pois os dados ja foram validados.
        produtos[quantidade] = new Produto(codigo, preco);
        System.out.println("Produto cadastrado.");
        return quantidade + 1;
    }
    static void consultarProduto(Produto[] produtos, int quantidade, int codigo) {
        int indice = buscarIndicePorCodigo(produtos, quantidade, codigo);
        if (indice == -1) System.out.println("Produto nao encontrado."); else produtos[indice].exibir();
    }
    static void alterarPrecoProduto(Produto[] produtos, int quantidade, int codigo, double novoPreco) {
        int indice = buscarIndicePorCodigo(produtos, quantidade, codigo);
        if (indice == -1) System.out.println("Produto nao encontrado.");
        else if (produtos[indice].alterarPreco(novoPreco)) System.out.println("Preco alterado.");
        else System.out.println("O preco deve ser maior que zero.");
    }
    static int removerProduto(Produto[] produtos, int quantidade, int codigo) {
        int indice = buscarIndicePorCodigo(produtos, quantidade, codigo);
        if (indice == -1) { System.out.println("Produto nao encontrado."); return quantidade; }
        for (int i = indice; i < quantidade - 1; i++) produtos[i] = produtos[i + 1];
        produtos[--quantidade] = null;
        System.out.println("Produto removido.");
        return quantidade;
    }
    static void listarProdutos(Produto[] produtos, int quantidade) {
        if (quantidade == 0) { System.out.println("Nenhum produto cadastrado."); return; }
        for (int i = 0; i < quantidade; i++) produtos[i].exibir();
    }
}
