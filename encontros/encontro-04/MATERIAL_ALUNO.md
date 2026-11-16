# Encontro 4 — Projeto 1: cadastro procedural de produtos

## Objetivo

Construir, em Java, um pequeno cadastro que mantém até cinco produtos **somente enquanto o programa está em execução**. O programa terá um menu com as operações de cadastrar, consultar, alterar preço, remover e listar.

Nesta etapa, cada produto é identificado por dois dados: `codigo` e `preco`. Ainda não usaremos classes ou objetos: vamos organizar os dados com arrays paralelos e perceber os limites dessa escolha.

## Situação-problema

O ponto de venda da faculdade precisa manter uma lista pequena de produtos para uma atividade. A pessoa responsável deve conseguir registrar os códigos e os preços, consultar um item, corrigir um preço e retirar um produto que não será mais vendido.

## Regras do sistema

- Capacidade máxima: 5 produtos.
- O código deve ser inteiro positivo e não pode se repetir.
- O preço deve ser maior que zero.
- Consultar, alterar e remover só são possíveis para códigos existentes.
- Ao remover um produto, os demais itens devem permanecer juntos nas primeiras posições dos arrays.
- Não há gravação em arquivo: ao encerrar, os dados são perdidos.

## Comece pelo arquivo inicial

No repositório da turma, copie `exemplos/encontro-4/aluno/CadastroProdutosInicial.java` para seu projeto no IntelliJ. O arquivo já traz o menu, as assinaturas dos métodos e os arrays. Complete-o em etapas; não tente fazer tudo de uma vez.

## Roteiro de construção

1. Leia os arrays `codigos` e `precos` como duas colunas da mesma tabela. O índice liga os dados: se `codigos[1]` é `205`, então `precos[1]` é o preço do produto 205.
2. Implemente `buscarIndicePorCodigo`. Ela deve devolver a posição encontrada ou `-1` quando o código não existir.
3. Implemente o cadastro. Verifique capacidade, código positivo, preço positivo e código duplicado. Quando tudo estiver válido, grave os dois dados na posição `quantidade` e devolva `quantidade + 1`.
4. Implemente a listagem. Percorra apenas as posições de `0` até `quantidade - 1`.
5. Implemente a consulta usando a busca.
6. Implemente a alteração de preço usando a posição retornada pela busca.
7. Implemente a remoção: após encontrar a posição, desloque **código e preço** uma posição para a esquerda e devolva a nova quantidade.
8. Faça o menu chamar cada método e atualize a variável `quantidade` quando o método devolver um novo valor.

## Dica de leitura dos arrays

| Índice | `codigos` | `precos` |
|---:|---:|---:|
| 0 | 101 | 5.50 |
| 1 | 205 | 7.00 |

Se `quantidade` vale 2, só os índices 0 e 1 estão ocupados. A capacidade do array pode ser 5, mas isso não significa que existam cinco produtos cadastrados.

## Casos de teste

Execute cada caso em uma nova execução ou controle o estado anotando o que foi feito.

| Caso | Ação | Resultado esperado |
|---|---|---|
| A | Listar antes de cadastrar | Mensagem de lista vazia. |
| B | Cadastrar `101`, `5.50`; cadastrar `205`, `7.00`; listar | Os dois produtos aparecem com seus pares corretos. |
| C | Tentar cadastrar novamente `101` | O cadastro é recusado e a lista não muda. |
| D | Alterar o preço de `205` para `7.50`; consultar `205` | A consulta mostra 7.50. |
| E | Remover `101`; listar | Só resta o produto 205; código e preço continuam associados. |
| F | Consultar, alterar ou remover `999` | O programa informa que o produto não foi encontrado. |
| G | Preencher cinco posições e tentar cadastrar mais uma | O programa informa que atingiu a capacidade. |

## Entrega

Envie ou apresente:

- o arquivo `CadastroProdutos.java` funcionando;
- uma breve explicação de como o índice une código e preço;
- um commit com uma mensagem clara, por exemplo: `Implementa CRUD procedural de produtos`.

## Critérios de conclusão

- O menu repete até a opção 0.
- Nenhum código duplicado é cadastrado.
- A quantidade só aumenta após um cadastro válido.
- Consulta e alteração usam a busca.
- A remoção desloca os dois arrays.
- A listagem considera apenas as posições ocupadas.

> Próximo passo: observe o esforço para manter código e preço sempre juntos. No próximo encontro, vamos criar uma estrutura que represente um produto como uma unidade.
