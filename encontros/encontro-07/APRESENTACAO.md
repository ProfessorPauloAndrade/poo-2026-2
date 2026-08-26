# 1. Encontro 7 — Relacionamentos e responsabilidades

**Projeto 2:** por que objetos precisam colaborar.

# 2. O que vamos aprender hoje

Construir e executar um pedido com produto, item, preço, quantidade e total recalculado pelo menu.

# 3. O que já sabemos

`Produto` já controla código e preço, mas ainda não representa uma compra.

# 4. Situação de partida

Uma compra tem produto, preço, quantidade, número do pedido e total. Pergunta: todos esses dados pertencem ao mesmo objeto?

# 5. A solução que parece simples

```java
double preco = 5.50;
int quantidade = 3;
double total = preco * quantidade;
```

# 6. Qual problema essa solução cria?

O `main` concentra dados e regras de objetos diferentes. O preço pode ser copiado, desatualizado e a fórmula pode ser repetida.

# 7. Do produto isolado à compra

# 8. Definição: relacionamento entre objetos

Um relacionamento existe quando um objeto guarda, usa ou pede uma ação a outro objeto para cumprir sua tarefa. No código, ele aparece como referência.

# 9. Que problema um relacionamento resolve?

Evita valores ligados, porém soltos e duplicados. O item consulta o preço atual do produto em vez de guardar uma cópia.

# 10. Referência: o vínculo no código

```java
private final Produto produto;
```

Esse atributo aponta para um Produto existente; não é uma cópia do produto nem apenas seu código.

# 11. Associação: um objeto usa outro

![Associação](assets/imagens/associacao-infografico.png)

Associação é o vínculo em que um objeto usa outro que pode existir independentemente.

# 12. Associação no projeto

`ItemPedido` usa um `Produto`. Se o pedido for removido, o produto continua existindo. Alterar o preço do produto atualiza o subtotal consultado pelo item.

# 13. Diagrama de objetos: associação em execução

![Diagrama de objetos](assets/diagramas/01-objetos-associacao.svg)

`item.produto` aponta para o mesmo objeto `cafe`.

# 14. Construindo o vínculo passo a passo

```java
Produto cafe = new Produto(101, 5.50);
ItemPedido item = new ItemPedido(cafe, 3);
```

O construtor recebe a referência e a guarda em `this.produto`.

# 15. O construtor não copia o produto

```java
this.produto = produto;
```

Os dois lados referem-se ao mesmo objeto Produto.

# 16. Efeito observável da associação

Depois de `cafe.alterarPreco(6.00)`, `item.calcularSubtotal()` passa de 16.50 para 18.00 sem alterar ItemPedido.

# 17. Definição: responsabilidade

Responsabilidade é aquilo que uma classe deve conhecer ou fazer porque possui os dados necessários para isso.

# 18. Responsabilidades em uma compra

![Responsabilidades](assets/imagens/responsabilidades-infografico.png)

# 19. Distribuição das responsabilidades

- Produto: código, preço e validação de preço.
- ItemPedido: produto, quantidade, subtotal e validação de quantidade.
- Pedido: número, criação do item e delegação.
- main: cria objetos, lê opções e pede ações.

# 20. Onde fica a fórmula?

```java
return produto.getPreco() * quantidade;
```

`ItemPedido` possui os dois dados; por isso calcula subtotal.

# 21. Uma comparação importante

Quantidade não pertence a Produto: o mesmo café pode aparecer em quantidades diferentes. Total não pertence a `main`: a fórmula fica distante dos dados.

# 22. Composição: todo e parte

# 23. Definição: composição

Composição é relação de todo e parte quando o todo cria e controla uma parte que só faz sentido dentro dele.

# 24. Que problema a composição resolve?

Deixa claro quem cria e mantém a parte. `main` não monta um item solto; Pedido cria seu próprio ItemPedido.

# 25. Composição no pedido

![Composição](assets/imagens/composicao-infografico.png)

# 26. Associação e composição

| Associação | Composição |
|---|---|
| ItemPedido usa Produto | Pedido controla ItemPedido |
| Produto existe sem item | Item pertence ao pedido |
| atributo de referência | criação interna |

# 27. Código da composição

```java
this.item = new ItemPedido(produto, quantidade);
```

Pedido cria a parte que controla.

# 28. Delegar preserva responsabilidades

```java
return item.calcularSubtotal();
```

Pedido pede o total ao item em vez de repetir a fórmula.

# 29. Do diagrama ao código e à execução

# 30. Diagrama de classes UML simplificado

![Diagrama UML](assets/diagramas/02-uml-classes.svg)

# 31. Como ler o diagrama

Nome, atributos, operações, `-` privado, `+` operação pública, losango preenchido para composição, seta para associação e multiplicidade 1 neste recorte.

# 32. Do símbolo para Java

`ItemPedido ───► Produto` vira `private final Produto produto;`. `Pedido ◆── ItemPedido` vira `new ItemPedido(...)` dentro de Pedido.

# 33. O programa que vamos executar

```text
1-Exibir pedido 2-Alterar preco 3-Alterar quantidade 0-Sair
```

Há um único item nesta aula; vários itens entram com `ArrayList` no próximo encontro.

# 34. Ponto de partida em main

```java
Produto cafe = new Produto(101, 5.50);
Pedido pedido = new Pedido(10, cafe, 3);
```

# 35. Fluxo de execução

![Fluxo de execução](assets/imagens/execucao-infografico.png)

# 36. Fluxo de execução detalhado

![Fluxo detalhado](assets/diagramas/03-execucao-minima.svg)

# 37. Teste 1: exibir

Opção 1 exibe produto 101, preço 5.50, quantidade 3, subtotal 16.50 e total 16.50.

# 38. Teste 2: alterar preço

Opção 2 com 6.00 chama `cafe.alterarPreco(...)`; nova exibição mostra total 18.00.

# 39. Teste 3: alterar quantidade

Opção 3 com 4 chama `pedido.alterarQuantidade(...)`; nova exibição mostra total 24.00.

# 40. Prática guiada: ItemPedido

Complete referência, quantidade, alteração controlada, subtotal e exibição. Compile e teste opção 1.

# 41. Prática guiada: Pedido

Complete criação interna, delegação de quantidade, cálculo e exibição. Compile e teste opções 1 e 3.

# 42. Prática guiada: testes

Confira 16.50, 18.00 e 24.00. Preço 0 e quantidade 0 devem ser recusados, preservando valores anteriores.

# 43. Erros frequentes

Copiar preço para o item; calcular em `main`; colocar quantidade em Produto; criar ItemPedido fora de Pedido; acessar atributo privado diretamente.

# 44. Desafio e critério de conclusão

O menu deve funcionar e você deve localizar no código uma associação, uma composição e uma delegação; explicar por que o total não está no `main`.

# 45. Síntese e próximo encontro

Relacionamentos conectam objetos; associação usa objeto independente; composição controla parte; responsabilidade fica com os dados e a regra; delegação evita repetição. Próximo: vários itens com `ArrayList`.
