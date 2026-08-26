# Encontro 7 — Projeto 2: relacionamentos e responsabilidades

## Objetivo

Construir um pedido simples em que objetos colaboram sem misturar responsabilidades. `ItemPedido` usa um `Produto`; `Pedido` cria e controla seu `ItemPedido`.

## Roteiro

1. Abra `exemplos/encontro-7/aluno/ProjetoPedidoInicial.java`.
2. Complete `ItemPedido`: referência para `Produto`, quantidade, subtotal e exibição.
3. Complete `Pedido`: número, item criado internamente e delegação do total.
4. Execute com café 101 / 5.50 e quantidade 3.
5. Altere o preço do mesmo objeto `cafe` para 6.00, preveja e confira o novo total.

## Diagrama de apoio

```text
Pedido ◆── 1 ItemPedido ─── 1 Produto
```

- `ItemPedido` usa o produto existente: associação.
- `Pedido` cria e controla seu item: composição.

## Testes

| Situação | Resultado esperado |
|---|---|
| café 101 / 5.50, quantidade 3 | subtotal e total 16.50 |
| alterar café para 6.00 | subtotal e total 18.00 |
| exibir pedido | número, código, quantidade, subtotal e total visíveis |

## Critério de conclusão

- item não guarda uma cópia de preço;
- subtotal é calculado pelo item;
- pedido delega o total ao item;
- produto continua responsável pelo preço;
- associação e composição são identificadas no diagrama.

Commit sugerido: `Inicia Projeto 2 com pedido e item relacionado`.
