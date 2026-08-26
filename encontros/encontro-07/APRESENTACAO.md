# Encontro 7 — Fazendo objetos colaborarem sem espalhar regras

**Projeto 2: pedidos, relacionamentos e responsabilidades**

---

# 2. Por que um objeto isolado já não basta?

No Projeto 1, `Produto` passou a controlar código e preço. Agora precisamos representar uma compra: além do produto, aparecem quantidade, número do pedido, subtotal e total.

O desafio desta aula é distribuir esses dados e regras entre objetos que colaboram, sem devolver tudo ao `main`.

---

# 3. De onde partimos — e o que muda hoje

**No Encontro 6:** construtor, `this`, atributos `private`, getters e alteração controlada de preço.

**No Encontro 7:** uma classe passa a guardar referência para outra; cada regra será colocada no objeto que reúne os dados necessários.

Continuamos usando construtores e encapsulamento. A novidade é a colaboração entre objetos.

---

# 4. A pergunta que orienta o encontro

> Quando uma compra envolve produto, quantidade e pedido, qual objeto deve guardar cada dado e executar cada regra?

Ao final, você deverá conseguir:

- reconhecer associação e composição no problema, no código e no diagrama;
- justificar as responsabilidades de `Produto`, `ItemPedido`, `Pedido` e `main`;
- prever o efeito de alterar preço ou quantidade antes de executar o programa.

---

# 5. Nosso percurso e o produto final

1. Narrar a compra e separar seus dados.
2. Descobrir a classe que falta.
3. Conectar objetos por referência.
4. Distinguir associação de composição.
5. Ler o diagrama e traduzi-lo para Java.
6. Completar e testar o programa.

**Produto:** programa executável que mostra 16.50, recalcula 18.00 após mudar o preço e chega a 24.00 após mudar a quantidade.

---

# 6. Uma compra concreta na cafeteria

Ana faz o pedido **10** em uma pequena cafeteria. Ela escolhe o produto **101**, um café que custa **5.50**, e pede **3 unidades**.

O programa deve exibir:

```text
Pedido: 10
Produto: 101 | Preço: 5.50 | Quantidade: 3 | Subtotal: 16.50
Total: 16.50
```

---

# 7. O vocabulário antes das classes

- **Produto:** item do catálogo da cafeteria; possui código e preço atual.
- **Item do pedido:** participação de um produto em uma compra, com uma quantidade específica.
- **Pedido:** compra identificada por número; nesta primeira versão, contém um item.
- **Subtotal:** preço atual do produto multiplicado pela quantidade daquele item.
- **Total:** soma dos subtotais; hoje coincide com o subtotal porque há apenas um item.

---

# 8. Separe os fatos da compra

| Informação | Valor no caso de Ana | Pertence a |
|---|---:|---|
| código do café | 101 | produto do catálogo |
| preço atual | 5.50 | produto do catálogo |
| quantidade comprada | 3 | item desta compra |
| número | 10 | pedido |
| subtotal | 16.50 | calculado pelo item |
| total | 16.50 | apresentado pelo pedido |

A tabela já sugere que um único objeto não deve controlar tudo.

---

# 9. Por que quantidade não pertence a Produto?

O mesmo café pode aparecer simultaneamente em compras diferentes:

```text
Pedido 10 — 3 cafés
Pedido 11 — 1 café
```

Se `Produto` guardasse uma única quantidade, qual pedido ela representaria? Quantidade descreve o produto **dentro de uma compra**, não o produto no catálogo.

---

# 10. O recorte didático desta versão

Um pedido real possui vários itens. Hoje usamos **um pedido, um item e um produto** para enxergar cada vínculo sem misturá-lo com coleções.

Ficam fora desta aula: `ArrayList`, vários itens, banco de dados, interface gráfica, cliente e pagamento.

No próximo encontro, a limitação de um único item motivará o uso de `ArrayList`.

---

# 11. Primeiro problema: dados e regras concentrados em main

Uma solução procedural mínima poderia ser:

```java
double preco = 5.50;
int quantidade = 3;
double total = preco * quantidade;
```

A multiplicação está correta. A organização não mostra quem representa o produto, a compra ou a regra de alteração de cada valor.

---

# 12. O problema aparece quando o sistema evolui

Se `main` concentra tudo, ele precisa:

- lembrar quais valores pertencem ao catálogo e quais pertencem à compra;
- repetir a fórmula sempre que precisar do total;
- validar preço e quantidade em lugares diferentes;
- manter cópias sincronizadas quando o preço mudar.

Queremos preservar o cálculo, mas redistribuir dados e regras.

---

# 13. A pergunta de responsabilidade

Para decidir onde uma ação deve ficar, faça duas perguntas:

1. **Quem possui os dados necessários?**
2. **Quem deve proteger a regra que altera esses dados?**

Exemplo: só `ItemPedido` reúne o produto escolhido e a quantidade comprada. Portanto, ele é o candidato natural para calcular o subtotal.

---

# 14. A classe que falta: ItemPedido

`ItemPedido` representa a frase:

> “Este `Produto`, nesta quantidade, dentro de uma compra.”

Ele não copia o preço. Guarda uma referência para o produto, guarda a quantidade e calcula o subtotal consultando o preço atual.

---

# 15. Mapa inicial de responsabilidades

| Classe | Sabe | Faz |
|---|---|---|
| `Produto` | código e preço | valida alteração de preço |
| `ItemPedido` | produto e quantidade | valida quantidade e calcula subtotal |
| `Pedido` | número e item | cria/controla o item e delega operações |
| `main` | opções digitadas | coordena o menu e chama métodos |

`main` coordena; ele não reimplementa as regras dos objetos.

![Mapa visual das responsabilidades](https://raw.githubusercontent.com/ProfessorPauloAndrade/poo-2026-2/main/encontros/encontro-07/assets/imagens/responsabilidades-infografico.png)

---

# 16. Relacionamento: quando um objeto precisa de outro

Um relacionamento existe quando um objeto precisa **conhecer, usar ou pedir uma ação** a outro para cumprir sua responsabilidade.

Em Java, o vínculo costuma aparecer como um atributo cujo tipo é outra classe:

```java
private final Produto produto;
```

---

# 17. Referência não é cópia

Imagine um único objeto `cafe`, com código 101 e preço 5.50. O atributo `item.produto` aponta para esse mesmo objeto.

```text
item : ItemPedido ─────────► cafe : Produto
quantidade = 3               codigo = 101
                             preco = 5.50
```

Não existe um segundo café nem um segundo preço dentro do item.

---

# 18. Construindo o vínculo em três passos

```java
Produto cafe = new Produto(101, 5.50);     // 1. cria o produto
ItemPedido item = new ItemPedido(cafe, 3); // 2. passa a referência
```

Dentro do construtor:

```java
this.produto = produto; // 3. guarda a referência recebida
this.quantidade = quantidade;
```

`this.produto` é o atributo; `produto` é o parâmetro.

---

# 19. Preveja antes de executar

Estado inicial: preço 5.50 e quantidade 3, portanto subtotal 16.50.

Depois executamos:

```java
cafe.alterarPreco(6.00);
```

O que `item.calcularSubtotal()` devolverá?

**Resposta após a discussão:** 18.00, porque o item consulta o mesmo objeto `cafe`, agora com preço 6.00.

---

# 20. Associação: usar um objeto independente

**Associação** é o relacionamento em que um objeto usa outro que pode existir independentemente.

No projeto:

```text
ItemPedido ─────────► Produto
```

O produto já existia antes do item e pode continuar no catálogo depois que o pedido deixar de existir.

![ItemPedido aponta para o mesmo objeto Produto](https://raw.githubusercontent.com/ProfessorPauloAndrade/poo-2026-2/main/encontros/encontro-07/assets/diagramas/01-objetos-associacao.svg)

---

# 21. Associação: exemplo e não exemplo

**É associação:** `ItemPedido` guarda `Produto produto` e consulta `produto.getPreco()`.

**Não é a solução desejada:** `ItemPedido` guarda somente `double precoCopiado`.

A cópia poderia ficar desatualizada. A referência mantém uma única fonte de verdade para o preço.

---

# 22. Verificação rápida da associação

Complete oralmente:

1. O objeto independente é __________.
2. O objeto que o utiliza é __________.
3. O atributo que materializa o vínculo é __________.
4. A evidência de que não houve cópia é o total mudar de 16.50 para __________ após alterar o preço.

Registre as quatro respostas antes de avançar. A correção será discutida coletivamente.

---

# 23. Segundo problema: quem cria o item?

Poderíamos deixar `main` criar objetos separados:

```java
ItemPedido item = new ItemPedido(cafe, 3);
Pedido pedido = new Pedido(10, item);
```

Mas, nesta versão, o item só existe para formar aquele pedido. Queremos deixar explícito quem cria e controla essa parte.

---

# 24. Composição: o todo controla a parte

**Composição** é uma relação de todo e parte em que o todo cria e controla uma parte que só faz sentido dentro dele.

No recorte do projeto:

```text
Pedido ◆──────── ItemPedido
```

`Pedido` é o todo; `ItemPedido` é a parte criada por ele.

![Composição entre Pedido e ItemPedido](https://raw.githubusercontent.com/ProfessorPauloAndrade/poo-2026-2/main/encontros/encontro-07/assets/imagens/composicao-infografico.png)

---

# 25. A composição aparece na criação interna

```java
class Pedido {
    private final ItemPedido item;

    Pedido(int numero, Produto produto, int quantidade) {
        this.numero = numero;
        this.item = new ItemPedido(produto, quantidade);
    }
}
```

O construtor recebe os dados necessários e o próprio `Pedido` cria sua parte.

---

# 26. Associação e composição lado a lado

| Pergunta | Associação | Composição |
|---|---|---|
| vínculo no projeto | `ItemPedido` usa `Produto` | `Pedido` controla `ItemPedido` |
| independência | produto existe sem o item | item pertence ao pedido neste recorte |
| evidência no código | atributo `Produto produto` | `new ItemPedido(...)` dentro de `Pedido` |
| ideia central | uso de objeto existente | criação e controle da parte |

Não classifique apenas pelo desenho: explique o ciclo de vida e o controle.

---

# 27. Delegação: pedir a ação ao objeto certo

`Pedido` precisa fornecer o total, mas não precisa repetir a fórmula:

```java
double calcularTotal() {
    return item.calcularSubtotal();
}
```

**Delegar** é chamar a operação do objeto que já possui os dados e a regra necessários.

---

# 28. Por que Pedido não multiplica preço por quantidade?

Para multiplicar diretamente, `Pedido` precisaria conhecer detalhes internos de `ItemPedido` e de `Produto`.

Ao delegar:

- `ItemPedido` continua responsável pelo subtotal;
- `Pedido` oferece uma operação coerente com a compra;
- a fórmula fica em um único lugar;
- o encapsulamento é preservado.

---

# 29. Uma ação atravessa três objetos

Quando o usuário altera a quantidade:

```text
main
  └─ chama pedido.alterarQuantidade(4)
       └─ Pedido delega para item.alterarQuantidade(4)
            └─ ItemPedido valida e altera seu próprio estado
```

Cada objeto participa apenas com a responsabilidade que lhe pertence.

---

# 30. Antes do UML: o que precisamos representar

O diagrama deve responder visualmente:

- quais classes existem;
- quais dados e operações principais cada uma possui;
- quem usa um objeto independente;
- quem cria e controla uma parte;
- quantos objetos participam de cada vínculo nesta versão.

O diagrama resume decisões já compreendidas; ele não substitui a explicação do caso.

---

# 31. Diagrama de classes não é diagrama de objetos

**Diagrama de classes:** descreve os tipos `Produto`, `ItemPedido` e `Pedido`, seus atributos, métodos e relações.

**Diagrama de objetos:** mostra instâncias em execução, como `cafe : Produto` e `pedido : Pedido`, com valores concretos.

Hoje usamos o diagrama de classes para apoiar a implementação e o de objetos para compreender a referência compartilhada.

---

# 32. Como ler uma caixa UML

```text
┌─────────────────────────────┐
│ ItemPedido                  │  nome da classe
├─────────────────────────────┤
│ - produto: Produto          │  atributos privados
│ - quantidade: int           │
├─────────────────────────────┤
│ + calcularSubtotal(): double│  operações disponíveis
└─────────────────────────────┘
```

`-` indica privado; `+` indica operação acessível por outras classes.

---

# 33. O diagrama completo desta versão

O diagrama reúne classes, atributos, operações e vínculos. O número `1` registra o recorte: um pedido controla um item, e esse item referencia um produto.

![Diagrama UML completo de Produto, ItemPedido e Pedido](https://raw.githubusercontent.com/ProfessorPauloAndrade/poo-2026-2/main/encontros/encontro-07/assets/diagramas/02-uml-classes.svg)

---

# 34. Traduzindo o diagrama para Java

| Elemento do diagrama | Evidência no código |
|---|---|
| `ItemPedido ─► Produto` | `private final Produto produto;` |
| `Pedido ◆─ ItemPedido` | `this.item = new ItemPedido(...);` |
| `- quantidade: int` | `private int quantidade;` |
| `+ calcularSubtotal()` | método chamado por outro objeto |
| multiplicidade `1` | um atributo guarda uma referência nesta versão |

Diagrama e código devem contar a mesma história.

---

# 35. Fluxo completo de criação e cálculo

```text
1. main cria cafe : Produto(101, 5.50)
2. main cria pedido : Pedido(10, cafe, 3)
3. Pedido cria internamente ItemPedido(cafe, 3)
4. ItemPedido guarda referência para cafe e quantidade 3
5. Pedido pede o total ao item
6. ItemPedido consulta cafe.getPreco() e multiplica por 3
7. O programa exibe 16.50
```

---

# 36. Teste 1 — rastreie o estado inicial

```java
Produto cafe = new Produto(101, 5.50);
Pedido pedido = new Pedido(10, cafe, 3);
pedido.exibir();
```

**Previsão:** subtotal e total são 16.50.

**Por quê?** O item consulta 5.50 no produto e multiplica por sua quantidade 3. Como há um item, o total delegado coincide com o subtotal.

---

# 37. Teste 2 — altere o preço na fonte

```java
cafe.alterarPreco(6.00);
pedido.exibir();
```

**Previsão:** subtotal e total passam para 18.00.

**Trilha:** `Produto` valida e guarda 6.00 → `ItemPedido` consulta o mesmo produto → `Pedido` delega o total ao item.

---

# 38. Teste 3 — altere a quantidade por delegação

```java
pedido.alterarQuantidade(4);
pedido.exibir();
```

**Previsão:** com preço 6.00 e quantidade 4, o total passa para 24.00.

**Trilha:** `Pedido` recebe o pedido de alteração → delega para `ItemPedido` → o item valida e guarda 4.

---

# 39. Teste 4 — valores inválidos preservam o estado

Tente preço `0` e quantidade `0`.

- `Produto.alterarPreco(0)` devolve `false` e conserva 6.00.
- `ItemPedido.alterarQuantidade(0)` devolve `false` e conserva 4.
- uma nova exibição continua mostrando 24.00.

Informação inválida não deve apagar um estado válido anterior.

---

# 40. Laboratório — construa em etapas verificáveis

Abra `ProjetoPedidoInicial.java` e trabalhe em dupla.

1. Localize as três classes e o `main`.
2. Leia e explique a referência de `ItemPedido` para `Produto`.
3. Implemente validação e subtotal; confira a exibição do item.
4. Compile e teste a opção 1: espere 16.50.
5. Explique a criação interna e complete as delegações em `Pedido`.
6. Compile e execute a sequência 16.50 → 18.00 → 24.00.
7. Teste preço e quantidade inválidos.

---

# 41. Diagnóstico de erros frequentes

| Sintoma | Verifique |
|---|---|
| mudar preço não muda subtotal | o item copiou o preço em vez de guardar `Produto` |
| `NullPointerException` | a referência `produto` ou `item` não foi inicializada |
| quantidade 0 foi aceita | a validação não preserva o valor anterior |
| fórmula repetida em `Pedido` ou `main` | faltou delegar para `ItemPedido` |
| item criado em `main` | a composição não está explícita no construtor de `Pedido` |

Corrija um problema por vez e repita o menor teste capaz de confirmá-lo.

---

# 42. Síntese, evidência e ponte

Você concluiu quando consegue apontar no código e explicar:

- **associação:** `ItemPedido` usa um `Produto` independente;
- **composição:** `Pedido` cria e controla seu `ItemPedido`;
- **responsabilidade:** cada regra fica junto dos dados necessários;
- **delegação:** `Pedido` pede ao item o cálculo e a alteração;
- **referência compartilhada:** mudar `cafe` altera o subtotal consultado.

Faça o commit sugerido: `Inicia Projeto 2 com objetos relacionados`.

**Próximo encontro:** trocar o único item por vários itens usando `ArrayList`.
