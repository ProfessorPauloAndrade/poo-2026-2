# 1. Encontro 5 — Transformar dados separados em produtos que existem

**Projeto 1: classes e objetos**

Hoje vamos preservar o CRUD do encontro anterior, mas mudar a forma de representar cada produto.

# 2. De onde partimos

No Encontro 4, cada produto era mantido por dois arrays paralelos:

```java
int[] codigos = new int[MAX_PRODUTOS];
double[] precos = new double[MAX_PRODUTOS];
```

O índice mantinha o par unido. Isso funciona, mas exige cuidado manual em toda operação.

# 3. A limitação observável

Ao remover um item, era necessário deslocar duas coisas juntas:

```java
codigos[i] = codigos[i + 1];
precos[i] = precos[i + 1];
```

Se esquecêssemos uma das linhas, um código recebia o preço de outro produto.

# 4. Pergunta-motriz

Como representar um produto para que código e preço viajem juntos, sem depender de dois arrays sincronizados?

**Produto da aula:** a mesma aplicação CRUD, agora baseada em objetos `Produto`.

# 5. Mapa do encontro

1. Observar a limitação dos arrays paralelos.
2. Criar uma classe que descreve um produto.
3. Criar objetos e entender referências.
4. Substituir os arrays paralelos por `Produto[]`.
5. Refatorar, testar e comparar o comportamento.

# 6. Situação preservada

O ponto de venda continua com as mesmas regras:

- até 5 produtos;
- código positivo e único;
- preço maior que zero;
- cadastrar, consultar, alterar, remover e listar;
- dados existem apenas enquanto o programa está aberto.

Mudaremos a representação, não as regras nem o resultado esperado.

# 7. Antes de dar o nome técnico

Pense em uma ficha física por produto:

```text
FICHA
codigo: 205
preco: 7.00
ações: exibir, alterarPreco
```

Em vez de espalhar as informações em colunas separadas, queremos uma ficha que reúna tudo que pertence ao produto.

# 8. Classe: o molde da ficha

Em Java, uma **classe** descreve quais dados e quais ações os objetos daquele tipo terão.

```java
class Produto {
    int codigo;
    double preco;
}
```

Esta classe ainda não é um produto cadastrado. Ela é a descrição de como um produto será organizado.

# 9. Objeto: uma ficha concreta criada a partir da classe

```java
Produto produto = new Produto();
produto.codigo = 205;
produto.preco = 7.00;
```

`Produto` é o tipo; `produto` é uma variável; `new Produto()` cria um objeto concreto.

# 10. Classe e objeto não são sinônimos

| Classe | Objeto |
|---|---|
| descrição/molde | instância concreta |
| diz quais atributos e métodos existem | guarda valores próprios |
| `class Produto { ... }` | `new Produto()` |

Podemos criar muitos objetos a partir de uma única classe.

# 11. Dois produtos, dois estados

```java
Produto cafe = new Produto();
cafe.codigo = 101;
cafe.preco = 5.50;

Produto suco = new Produto();
suco.codigo = 205;
suco.preco = 7.00;
```

Os objetos têm o mesmo tipo, mas cada um guarda seu próprio estado.

# 12. Estado: dados que pertencem ao objeto

No nosso recorte, o estado de um produto é formado por:

```text
codigo
preco
```

Esses dados são **atributos**. Eles representam a situação atual de cada objeto.

# 13. Comportamento: ações que o objeto sabe realizar

```java
void exibir() {
    System.out.printf("Codigo: %d | Preco: %.2f%n", codigo, preco);
}
```

`exibir()` é um método de instância: ele usa os atributos do objeto que recebeu a chamada.

# 14. Chamando um método do objeto

```java
Produto produto = new Produto();
produto.codigo = 205;
produto.preco = 7.00;

produto.exibir();
```

Saída: `Codigo: 205 | Preco: 7.00`.

O ponto antes de `exibir()` indica: “peça esta ação a este objeto”.

# 15. Alterar preço pertence ao produto

```java
void alterarPreco(double novoPreco) {
    if (novoPreco <= 0) {
        System.out.println("O preco deve ser maior que zero.");
    } else {
        preco = novoPreco;
        System.out.println("Preco alterado.");
    }
}
```

O método modifica o preço do objeto que o executa, não o preço de todos os produtos.

# 16. Comparação com C: struct e classe

```c
struct Produto {
    int codigo;
    double preco;
};
```

```java
class Produto {
    int codigo;
    double preco;
    void exibir() { /* ... */ }
}
```

Uma classe Java pode reunir dados e métodos. É essa proximidade entre estado e comportamento que exploramos agora.

# 17. Transição: uma lista de produtos, não duas colunas

O cadastro ainda precisa guardar até cinco produtos. Agora cada posição deverá apontar para um objeto `Produto`.

```java
Produto[] produtos = new Produto[MAX_PRODUTOS];
```

O array guarda referências para produtos.

# 18. Referência não é o objeto

```text
produtos[0] ──► Produto { codigo: 101, preco: 5.50 }
produtos[1] ──► Produto { codigo: 205, preco: 7.00 }
produtos[2] ──► null
```

`produtos[0]` não é o produto inteiro: é uma referência que aponta para ele. Uma posição ainda não usada contém `null`.

# 19. Capacidade e quantidade continuam importantes

```java
Produto[] produtos = new Produto[MAX_PRODUTOS];
int quantidade = 0;
```

- capacidade: 5 posições de referência;
- quantidade: quantos objetos foram cadastrados;
- posições de 0 até `quantidade - 1`: ocupadas;
- posição vazia: `null`.

# 20. Busca agora lê atributos do objeto

```java
static int buscarIndicePorCodigo(Produto[] produtos, int quantidade, int codigo) {
    for (int i = 0; i < quantidade; i++) {
        if (produtos[i].codigo == codigo) return i;
    }
    return -1;
}
```

O algoritmo da busca não mudou. Mudou apenas o caminho até o código: `produtos[i].codigo`.

# 21. Cadastro: criar, preencher e guardar a referência

```java
Produto novoProduto = new Produto();
novoProduto.codigo = codigo;
novoProduto.preco = preco;
produtos[quantidade] = novoProduto;
quantidade++;
```

Primeiro o objeto é criado; depois seus atributos recebem valores; por fim, o array passa a guardar sua referência.

# 22. Consultar e listar: delegar ao objeto

```java
produtos[indice].exibir();
```

Em vez de o cadastro formatar código e preço separadamente, ele pede que o próprio produto se exiba.

# 23. Alterar: delegar a regra ao objeto

```java
int indice = buscarIndicePorCodigo(produtos, quantidade, codigo);
if (indice == -1) {
    System.out.println("Produto nao encontrado.");
} else {
    produtos[indice].alterarPreco(novoPreco);
}
```

O cadastro encontra o produto; o produto decide se o novo preço é válido e altera seu estado.

# 24. Remover: deslocar uma referência já move o produto inteiro

```java
for (int i = indice; i < quantidade - 1; i++) {
    produtos[i] = produtos[i + 1];
}
quantidade--;
produtos[quantidade] = null;
```

Agora há uma única atribuição no deslocamento. Código e preço continuam juntos porque pertencem ao mesmo objeto.

# 25. Antes e depois da remoção

```text
antes: produtos[0] → {101, 5.50} | produtos[1] → {205, 7.00}
remove 101
depois: produtos[0] → {205, 7.00} | produtos[1] → null
```

Não copiamos atributos separadamente; copiamos a referência para o objeto que já os reúne.

# 26. Comportamento preservado: teste de comparação

| Ação | Resultado esperado antes e depois |
|---|---|
| cadastrar 101/5.50 e 205/7.00 | dois produtos listados corretamente |
| cadastrar 101 de novo | recusado |
| alterar 205 para 7.50 | só 205 muda |
| remover 101 | 205 passa ao índice 0 |
| consultar 999 | não encontrado |

A refatoração está correta quando o comportamento externo continua igual.

# 27. Sua prática

1. Complete `Produto`.
2. Crie objetos no cadastro.
3. Troque os acessos aos arrays paralelos por `Produto[]`.
4. Refaça busca, consulta, alteração, listagem e remoção.
5. Rode os testes de comparação.

**Produto esperado:** `Produto.java` e `CadastroProdutosObjetos.java` funcionando.

# 28. Perguntas para depurar

- O objeto foi criado com `new Produto()` antes de ser usado?
- A referência foi colocada na posição `quantidade`?
- O laço percorre apenas posições ocupadas?
- Há tentativa de acessar uma posição `null`?
- A alteração foi chamada no produto correto?
- Após remover, a última posição foi definida como `null`?

# 29. Limite assumido hoje

Hoje acessamos `produto.codigo` e `produto.preco` diretamente para enxergar a mudança principal: dados e ações reunidos numa classe.

Isso ainda permite qualquer alteração externa nos atributos. No próximo encontro, vamos controlar a criação e a alteração do estado.

# 30. Síntese e próximo passo

1. Classe descreve um tipo; objeto é uma instância concreta.
2. Atributos formam o estado; métodos expressam comportamento.
3. Variáveis e arrays podem guardar referências para objetos.
4. Um `Produto` mantém código e preço juntos.
5. A refatoração reduziu o risco de desalinhamento sem mudar as regras do CRUD.

**Próximo encontro:** construtores, `this` e encapsulamento.
