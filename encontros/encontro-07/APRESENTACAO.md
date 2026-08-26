# 1. Encontro 7 — Relacionamentos e responsabilidades

**Projeto 2:** objetos que colaboram para representar um pedido.

# 2. O que vamos construir hoje

Um `Pedido` ligado a um `Produto` e responsável por seu `ItemPedido`. O total será calculado pelos objetos, não pelo `main`.

# 3. De onde partimos

`Produto` já protege código e preço:

```java
Produto cafe = new Produto(101, 5.50);
```

# 4. Nova situação

Um cliente quer comprar três cafés. Onde ficam quantidade e total?

```text
Produto: 101 / 5,50
Pedido: 10 / quantidade 3
Total: 16,50
```

# 5. A limitação observável

```java
double preco = 5.50;
int quantidade = 3;
double total = preco * quantidade;
```

Guardar essa regra no `main` mistura responsabilidades.

# 6. Mapa da prática guiada

1. Reutilizar `Produto`.
2. Criar `ItemPedido`.
3. Criar `Pedido` e seu item.
4. Testar o cálculo e a colaboração.

# 7. Bloco 1 — Quando um objeto precisa de outro objeto

# 8. Relacionamento entre objetos

Há relacionamento quando um objeto guarda, usa ou depende de outro para cumprir sua responsabilidade.

```java
ItemPedido item = new ItemPedido(cafe, 3);
```

# 9. Associação: objetos que colaboram

Associação é vínculo em que um objeto usa outro que pode existir independentemente.

```text
ItemPedido ─── usa ───► Produto
```

# 10. Referência no relacionamento

```java
private final Produto produto;
private final int quantidade;
```

`produto` é uma referência para o objeto existente, não uma cópia de preço ou código.

# 11. Leitura do estado

```text
cafe ──► Produto { 101, 5,50 }
item ──► ItemPedido { produto: cafe, quantidade: 3 }
```

# 12. Construindo um item

```java
ItemPedido(Produto produto, int quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
}
```

# 13. Responsabilidade: quem faz o quê?

- `Produto`: código e preço.
- `ItemPedido`: produto, quantidade e subtotal.
- `Pedido`: número e organização de seus itens.
- `main`: cria objetos e pede ações.

# 14. Subtotal pertence ao item

```java
double calcularSubtotal() {
    return produto.getPreco() * quantidade;
}
```

# 15. Bloco 2 — Composição: parte controlada pelo todo

# 16. Composição

Composição representa todo e parte quando o todo cria e controla a parte.

```text
Pedido ◆── contém ──► ItemPedido
```

# 17. Associação e composição

| Associação | Composição |
|---|---|
| item usa produto existente | pedido cria e controla item |
| produto existe sem item | item pertence ao pedido |

# 18. Pedido cria sua parte

```java
Pedido(int numero, Produto produto, int quantidade) {
    this.numero = numero;
    this.item = new ItemPedido(produto, quantidade);
}
```

# 19. Delegar em vez de repetir

```java
double calcularTotal() {
    return item.calcularSubtotal();
}
```

# 20. Leitura da composição

```text
Pedido → ItemPedido → Produto
```

Pedido controla o item; o item se associa ao produto.

# 21. Bloco 3 — Diagrama como apoio ao código

# 22. Caixa de classe

```text
ItemPedido
- produto: Produto
- quantidade: int
+ calcularSubtotal()
```

`-` indica atributo privado; `+` indica operação disponível.

# 23. Linhas do diagrama

```text
Pedido ◆── 1 ItemPedido
ItemPedido ─── 1 Produto
```

Losango preenchido indica composição. Nesta versão, os vínculos são 1 para 1.

# 24. Do diagrama ao código

```text
ItemPedido ─── Produto  →  private final Produto produto;
Pedido ◆── ItemPedido   →  new ItemPedido(produto, quantidade);
```

# 25. Prática guiada — Passo 1

Reutilize `Produto`. Não coloque quantidade ou total nessa classe.

# 26. Prática guiada — Passo 2

Complete `ItemPedido`: referência, quantidade, construtor, subtotal e exibição.

# 27. Prática guiada — Passo 3

Complete `Pedido`: número, `ItemPedido`, criação interna e delegação do total.

# 28. Prática guiada — Passo 4

```java
Produto cafe = new Produto(101, 5.50);
Pedido pedido = new Pedido(10, cafe, 3);
```

Preveja total 16.50; altere café para 6.00 e preveja 18.00.

# 29. Erros frequentes

- copiar preço para o item;
- calcular total no `main`;
- colocar quantidade em `Produto`;
- confundir referência com cópia;
- usar composição quando a parte pode ser compartilhada.

# 30. Desafio e critério de conclusão

Identifique associação e composição no código. O programa deve exibir número, produto, quantidade, subtotal e total.

# 31. Síntese e próximo passo

1. Relacionamentos conectam objetos que colaboram.
2. Associação usa objeto independente.
3. Composição controla uma parte.
4. Responsabilidade fica com quem tem dados e regra.
5. O diagrama ajuda a conferir o código.

**Próximo encontro:** vários pedidos com `ArrayList` e CRUD em coleção.
