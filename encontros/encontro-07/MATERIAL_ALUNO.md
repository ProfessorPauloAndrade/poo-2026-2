# Encontro 7 — Projeto 2: relacionamentos e responsabilidades

## Objetivo

Construir e executar um pedido interativo. `ItemPedido` usa um `Produto`; `Pedido` cria e controla seu `ItemPedido`. O menu permite observar que preço e quantidade alteram o total por meio da colaboração entre objetos.

## Roteiro

1. Abra `exemplos/encontro-7/aluno/ProjetoPedidoInicial.java`.
2. Localize `Produto`, `ItemPedido`, `Pedido` e `main` antes de alterar qualquer linha.
3. Em `ItemPedido`, leia o construtor e explique por que `this.produto = produto` guarda uma referência em vez de copiar o preço.
4. Complete `alterarQuantidade` e `calcularSubtotal`. Compile; então use a opção 1 e confirme 16.50.
5. Em `Pedido`, leia a criação interna de `ItemPedido` e complete as duas delegações. Compile novamente.
6. Use a opção 2 para alterar o preço do mesmo objeto `cafe` para 6.00; confirme 18.00 sem alterar o item.
7. Use a opção 3 para alterar a quantidade para 4; confirme 24.00.
8. Tente preço 0 e quantidade 0; confirme que os valores válidos anteriores foram preservados.

## Diagrama de apoio

```text
Pedido ◆── 1 ItemPedido ─── 1 Produto
```

- `ItemPedido` usa o produto existente: associação.
- `Pedido` cria e controla seu item: composição.

## Testes

| Situação | Resultado esperado |
|---|---|
| opção 1 com café 101 / 5.50, quantidade 3 | subtotal e total 16.50 |
| opção 2: alterar café para 6.00; opção 1 | subtotal e total 18.00 |
| opção 3: alterar quantidade para 4; opção 1 | subtotal e total 24.00 |
| informar preço 0 ou quantidade 0 | valor anterior preservado |
| exibir pedido | número, código, preço, quantidade, subtotal e total visíveis |

## Critério de conclusão

- item não guarda uma cópia de preço;
- subtotal é calculado pelo item;
- pedido delega o total ao item;
- produto continua responsável pelo preço;
- associação e composição são identificadas no diagrama e justificadas com evidências do código.

Commit sugerido: `Inicia Projeto 2 com pedido e item relacionado`.
