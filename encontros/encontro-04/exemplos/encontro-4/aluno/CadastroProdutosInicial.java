import java.util.Locale;
import java.util.Scanner;

public class CadastroProdutosInicial {
    static final int MAX_PRODUTOS = 5;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        int[] codigos = new int[MAX_PRODUTOS];
        double[] precos = new double[MAX_PRODUTOS];
        int quantidade = 0;
        int opcao;

        do {
            mostrarMenu();
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    // TODO: ler codigo e preco; atualizar quantidade com cadastrarProduto.
                    break;
                case 2:
                    // TODO: ler codigo e chamar consultarProduto.
                    break;
                case 3:
                    // TODO: ler codigo e novo preco; chamar alterarPreco.
                    break;
                case 4:
                    // TODO: ler codigo; atualizar quantidade com removerProduto.
                    break;
                case 5:
                    // TODO: chamar listarProdutos.
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

    static void mostrarMenu() {
        System.out.println("\n--- CADASTRO DE PRODUTOS ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Consultar");
        System.out.println("3 - Alterar preco");
        System.out.println("4 - Remover");
        System.out.println("5 - Listar");
        System.out.println("0 - Sair");
        System.out.print("Opcao: ");
    }

    static int buscarIndicePorCodigo(int[] codigos, int quantidade, int codigo) {
        // TODO: percorrer apenas os indices ocupados e devolver o indice ou -1.
        return -1;
    }

    static int cadastrarProduto(int[] codigos, double[] precos, int quantidade,
                                int codigo, double preco) {
        // TODO: validar e, se valido, gravar no indice quantidade.
        return quantidade;
    }

    static void consultarProduto(int[] codigos, double[] precos, int quantidade, int codigo) {
        // TODO: buscar e exibir o produto encontrado.
    }

    static void alterarPreco(int[] codigos, double[] precos, int quantidade,
                             int codigo, double novoPreco) {
        // TODO: buscar e alterar somente se o produto existir e o preco for valido.
    }

    static int removerProduto(int[] codigos, double[] precos, int quantidade, int codigo) {
        // TODO: buscar, deslocar codigo e preco juntos e devolver a nova quantidade.
        return quantidade;
    }

    static void listarProdutos(int[] codigos, double[] precos, int quantidade) {
        // TODO: exibir os produtos dos indices 0 ate quantidade - 1.
    }
}
