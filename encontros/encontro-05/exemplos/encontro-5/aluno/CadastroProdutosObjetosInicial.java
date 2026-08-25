import java.util.Locale;
import java.util.Scanner;

class Produto {
    // TODO: declarar int codigo e double preco.

    void exibir() {
        // TODO: exibir codigo e preco deste produto.
    }

    void alterarPreco(double novoPreco) {
        // TODO: validar e alterar o preco deste produto.
    }
}

public class CadastroProdutosObjetosInicial {
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
                    // TODO: ler dados e atualizar quantidade com cadastrarProduto.
                    break;
                case 2:
                    // TODO: consultar.
                    break;
                case 3:
                    // TODO: alterar preco.
                    break;
                case 4:
                    // TODO: remover e atualizar quantidade.
                    break;
                case 5:
                    listarProdutos(produtos, quantidade);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
        entrada.close();
    }

    static void mostrarMenu() { System.out.print("\n1-Cadastrar 2-Consultar 3-Alterar 4-Remover 5-Listar 0-Sair\nOpcao: "); }
    static int buscarIndicePorCodigo(Produto[] produtos, int quantidade, int codigo) { return -1; }
    static int cadastrarProduto(Produto[] produtos, int quantidade, int codigo, double preco) { return quantidade; }
    static void consultarProduto(Produto[] produtos, int quantidade, int codigo) { }
    static int removerProduto(Produto[] produtos, int quantidade, int codigo) { return quantidade; }
    static void listarProdutos(Produto[] produtos, int quantidade) { }
}
