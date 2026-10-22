import java.util.Locale;
import java.util.Scanner;

class Produto {
    private final int codigo;
    private double preco;

    Produto(int codigo, double preco) {
        // TODO 2:
        // Receba os dados ja validados pelo cadastro
        // e atribua-os aos atributos usando this.
        // Substitua estes valores provisorios pelos parametros recebidos.
        this.codigo = 0;
        this.preco = 0.0;
    }

    Produto(int codigo) {
        // Este construtor reutiliza o construtor completo.
        this(codigo, 1.00);
    }

    int getCodigo() {
        return codigo;
    }

    double getPreco() {
        return preco;
    }

    boolean alterarPreco(double novoPreco) {
        // TODO 4:
        // Recuse precos menores ou iguais a zero.
        // Se o valor for invalido, preserve o preco atual.
        // Retorne true quando a alteracao ocorrer
        // e false quando ela for recusada.

        return false;
    }

    void exibir() {
        System.out.printf(
            "Codigo: %d | Preco: %.2f%n",
            codigo,
            preco
        );
    }
}

public class CadastroProdutosEncapsuladoInicial {

    static final int MAX_PRODUTOS = 5;

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        System.out.println("ESQUELETO: complete os TODOs antes de validar o CRUD.");

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

                    quantidade = cadastrarProduto(
                        produtos,
                        quantidade,
                        codigo,
                        preco
                    );
                    break;

                case 2:
                    System.out.print("Codigo para consulta: ");

                    consultarProduto(
                        produtos,
                        quantidade,
                        entrada.nextInt()
                    );
                    break;

                case 3:
                    System.out.print("Codigo do produto: ");
                    codigo = entrada.nextInt();

                    System.out.print("Novo preco: ");

                    alterarPrecoProduto(
                        produtos,
                        quantidade,
                        codigo,
                        entrada.nextDouble()
                    );
                    break;

                case 4:
                    System.out.print("Codigo para remover: ");

                    quantidade = removerProduto(
                        produtos,
                        quantidade,
                        entrada.nextInt()
                    );
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

    static void mostrarMenu() {
        System.out.print(
            "\n1-Cadastrar 2-Consultar 3-Alterar "
            + "4-Remover 5-Listar 0-Sair\nOpcao: "
        );
    }

    static int buscarIndicePorCodigo(
        Produto[] produtos,
        int quantidade,
        int codigo
    ) {

        for (int i = 0; i < quantidade; i++) {

            // TODO 5:
            // Compare o codigo procurado com o codigo do produto
            // sem acessar diretamente o atributo privado.

            if (/* COMPLETE AQUI */ false) {
                return i;
            }
        }

        return -1;
    }

    static int cadastrarProduto(
        Produto[] produtos,
        int quantidade,
        int codigo,
        double preco
    ) {

        if (quantidade == MAX_PRODUTOS) {
            System.out.println("Cadastro cheio.");
            return quantidade;
        }

        // TODO 6:
        // Antes de criar o objeto:
        //
        // 1. valide se codigo e preco sao maiores que zero;
        // 2. verifique se o codigo ja esta cadastrado;
        // 3. somente depois crie o Produto.

        // TODO 6:
        // Crie aqui o novo Produto usando seu construtor.

        System.out.println("TODO: concluir o cadastro antes de informar sucesso.");

        // TODO 6:
        // Retorne a nova quantidade somente se
        // o cadastro tiver sido realizado.

        return quantidade;
    }

    static void consultarProduto(
        Produto[] produtos,
        int quantidade,
        int codigo
    ) {

        int indice = buscarIndicePorCodigo(
            produtos,
            quantidade,
            codigo
        );

        if (indice == -1) {
            System.out.println("Produto nao encontrado.");
        } else {
            produtos[indice].exibir();
        }
    }

    static void alterarPrecoProduto(
        Produto[] produtos,
        int quantidade,
        int codigo,
        double novoPreco
    ) {

        int indice = buscarIndicePorCodigo(
            produtos,
            quantidade,
            codigo
        );

        if (indice == -1) {
            System.out.println("Produto nao encontrado.");
            return;
        }

        // TODO 5:
        // Solicite ao proprio Produto a alteracao do preco.
        //
        // Exiba:
        // "Preco alterado."
        // quando a operacao for aceita.
        //
        // Exiba:
        // "O preco deve ser maior que zero."
        // quando ela for recusada.
    }

    static int removerProduto(
        Produto[] produtos,
        int quantidade,
        int codigo
    ) {

        int indice = buscarIndicePorCodigo(
            produtos,
            quantidade,
            codigo
        );

        if (indice == -1) {
            System.out.println("Produto nao encontrado.");
            return quantidade;
        }

        for (int i = indice; i < quantidade - 1; i++) {
            produtos[i] = produtos[i + 1];
        }

        produtos[--quantidade] = null;

        System.out.println("Produto removido.");

        return quantidade;
    }

    static void listarProdutos(
        Produto[] produtos,
        int quantidade
    ) {

        if (quantidade == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (int i = 0; i < quantidade; i++) {
            produtos[i].exibir();
        }
    }
}
