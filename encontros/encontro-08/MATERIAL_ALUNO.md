# Encontro 08 — CRUD de itens com ArrayList

## Objetivo e contexto

Evoluir o pedido da cafeteria do encontro 07 para vários itens, preservando associação, composição e validações. Duplas durante a prática; resposta de saída individual. Dados fictícios: café 101/5.50, pão 202/8.00 e suco 303/4.00. Catálogo fixo; pedido 10 começa vazio.

## Recursos e execução

Use JDK, editor e terminal. Copie `exemplos/aluno/ProjetoPedidoListaInicial.java` para a pasta do seu Projeto 2. Não compile junto com as versões antigas: elas possuem classes com os mesmos nomes.

```text
javac -encoding UTF-8 ProjetoPedidoListaInicial.java
java ProjetoPedidoListaInicial
```

O arquivo inicial compila, mas os métodos com TODO ainda não executam o CRUD. Informe números válidos e preços com ponto; entrada textual em campos numéricos ainda não é tratada. Nenhum dado é salvo ao sair.

## Regras

- Código deve existir no catálogo. Cada código aparece no máximo uma vez no pedido; repetição é recusada sem somar quantidade.
- Quantidade deve ser positiva. Preço deve ser positivo. Pedido vazio tem total zero.
- Operação recusada preserva o estado. Busca devolve índice ou -1; nunca usar -1 em get/remove.
- Pedido cria seus itens, mantém a lista privada e delega quantidade/subtotal. Produto mantém preço atual, compartilhado por referência.

## Etapas de prática

1. **8 min:** experimente add, size, get e remove em uma lista de produtos; registre posições antes/depois.
2. **7 min:** rastreie buscarIndice para 303 e 999 numa lista com 101, 202, 303.
3. **12 min:** complete busca, inclusão e consulta; teste vazio, duas inclusões, repetição, quantidade inválida e código 999.
4. **15 min:** complete alteração e remoção. Teste um código existente e um ausente; remova o primeiro e opere sobre o último.
5. **12 min — investigação:** um caixa escreveu `itens.remove(codigo)` e testou um rascunho defeituoso com código 0 (fora do catálogo final). Explique por que o teste escondia o erro. Construa um teste com códigos 101, 202, 303; corrija por busca e teste remoção intermediária seguida de alteração do último item.
6. **28 min no total — integração (inclui os 12 min da investigação):** conclua total e listagem; execute a tabela abaixo e os casos adicionais. Produza arquivo, tabela observada e justificativas.

## Sequência principal de testes

| Ação, nesta ordem | Total esperado |
|---|---:|
| listar vazio | 0.00 |
| incluir 101, quantidade 3 | 16.50 |
| incluir 202, quantidade 2 | 32.50 |
| alterar preço 101 para 6.00 | 34.00 |
| alterar quantidade 202 para 1 | 26.00 |
| remover 101 | 8.00 |
| remover 202 | 0.00 |

Casos adicionais: quantidade zero/negativa; inclusão duplicada; código 999 nas quatro operações; remoção primeiro/meio/último; reinclusão depois de vazio; preço zero; opção de menu desconhecida. Refaça também a sequência da aula 07: 16.50 → 18.00 → 24.00.

## Entrega e conclusão

Entregue Java compilável, tabela com entrada/estado anterior/esperado/observado/conclusão e justificativa de índice versus código, alteração do objeto versus set, e controle da lista pelo Pedido. Registre um commit no repositório próprio do Projeto 2. IA pode apoiar, mas não substitui a previsão individual e a escrita da saída final.

Critérios: todas as operações funcionam; recusas preservam estado; deslocamento não altera identidade; preço compartilhado afeta subtotal; cálculo permanece delegado. Sem Internet, use os arquivos locais; sem computador, rastreie posições, códigos, quantidade e total em papel e escreva busca/remoção.

## Organização para acompanhar os slides

1. Coleções: criar e experimentar uma lista (slides 8–18).
2. Refatoração: proteger a coleção em Pedido (19–23).
3. Busca por código e retorno -1 (24–28).
4. CRUD: implementar inclusão/consulta e depois atualização/remoção (29–39).
5. Percursos: total, listagem e preço compartilhado (40–47).
6. Laboratório, testes e comparação com o encontro 07 (48–55).

Na prática de inclusão/consulta (12 minutos), complete também consultarItem e teste o código 999. O código 0 da investigação representa um rascunho defeituoso; não integra o catálogo do programa final. Os diagramas estão em assets/ e também no repositório público.
