# 1. Encontro 6 — Projeto 1: construtores e encapsulamento

Hoje concluiremos o CRUD de produtos: cada `Produto` será criado completo e o preço será alterado somente por uma operação controlada.

# 2. O que vamos construir hoje

O cadastro continuará cadastrando, consultando, alterando, removendo e listando até cinco produtos.

**Produto da aula:** `CadastroProdutosEncapsulado.java` funcionando e com a classe `Produto` protegendo seu estado.

# 3. De onde partimos

No Encontro 5, o produto reunia código e preço, mas ainda era criado vazio:

```java
Produto produto = new Produto();
produto.codigo = 205;
produto.preco = 7.00;
```

# 4. Problema observável

Também era possível escrever qualquer valor diretamente:

```java
produto.preco = -7.00;
```

Como fazer o produto nascer completo e impedir mudanças inválidas?

# 5. Bloco 1 — Refatorar sem mudar o comportamento

# 6. O que é refatoração?

Refatorar é melhorar a organização interna do código sem mudar o comportamento observável.

Antes: criação vazia e atributos diretos. Depois: construtor e métodos controlados. As regras e os resultados do CRUD permanecem.

# 7. O que deve permanecer

- até cinco produtos;
- código positivo e único;
- preço maior que zero;
- cadastrar, consultar, alterar, remover e listar;
- dados somente durante a execução.

# 8. Mapa da prática guiada

1. Tornar atributos privados e criar construtores.
2. Consultar por getters e alterar por método.
3. Ajustar apenas as linhas necessárias do CRUD.
4. Repetir os mesmos testes do Encontro 5.

# 9. Bloco 2 — Criar objetos completos: construtores e `this`

# 10. Construtor

Um construtor inicializa um objeto quando ele é criado.

```java
class Produto {
    Produto(int codigo, double preco) { }
}
```

Tem o nome da classe, não tem tipo de retorno nem `void`, e é chamado por `new Produto(...)`.

# 11. Construtor passo a passo

```java
Produto produto = new Produto(205, 7.00);
```

Os valores chegam como parâmetros; o construtor os usa para inicializar os atributos do novo objeto. O cadastro valida código e preço antes dessa chamada.

# 12. `this`: atributo ou parâmetro?

```java
private int codigo;

Produto(int codigo, double preco) {
    this.codigo = codigo;
}
```

`this.codigo` é o atributo deste objeto. `codigo` é o parâmetro. Leia: “o código deste produto recebe o código informado”.

# 13. Construtor completo

```java
class Produto {
    private final int codigo;
    private double preco;

    Produto(int codigo, double preco) {
        this.codigo = codigo;
        this.preco = preco;
    }
}
```

O objeto deixa de passar por uma etapa de criação vazia seguida de atribuições externas.

# 14. Sobrecarga de construtores

Sobrecarga significa construtores com o mesmo nome da classe e listas de parâmetros diferentes.

```java
Produto(int codigo, double preco) { ... }
Produto(int codigo) { ... }
```

Java escolhe de acordo com os argumentos informados em `new Produto(...)`.

# 15. Sobrecarga aplicada com cuidado

```java
Produto(int codigo) {
    this(codigo, 1.00);
}
```

`this(codigo, 1.00)` chama o construtor completo. Assim, a inicialização permanece centralizada e não repetimos código.

# 16. Bloco 3 — Proteger o estado: visibilidade e encapsulamento

# 17. Visibilidade: `private`

```java
private final int codigo;
private double preco;
```

`private` permite acesso direto somente dentro da própria classe `Produto`. O atributo existe, mas outra classe não pode gravar nele diretamente.

# 18. O efeito observável de `private`

```java
produto.preco = -7.00;
```

Agora esse comando não compila. A proteção força o cadastro a pedir a alteração ao próprio objeto.

# 19. Encapsulamento

Encapsulamento reúne estado e regras na mesma classe.

```text
Cadastro encontra o Produto → Produto valida → Produto altera seu estado
```

Isso impede estados inválidos e deixa a regra em um lugar claro.

# 20. Acessores controlados

```java
int getCodigo() { return codigo; }
double getPreco() { return preco; }
```

Getters servem para consultar. Não criamos `setPreco()` automaticamente, pois um setter livre aceitaria qualquer valor.

# 21. Alteração válida de preço

```java
boolean alterarPreco(double novoPreco) {
    if (novoPreco <= 0) return false;
    preco = novoPreco;
    return true;
}
```

Preço válido altera o estado; preço inválido devolve `false` e preserva o valor anterior.

# 22. Prática guiada — Passo 1

Complete `Produto`: atributos privados, construtor completo, construtor sobrecarregado e `alterarPreco`. Compile antes de alterar o CRUD.

# 23. Prática guiada — Passo 2

Troque acessos diretos por métodos:

```java
// antes: produtos[i].codigo == codigo
// depois:
produtos[i].getCodigo() == codigo
```

Para preço, chame `produtos[indice].alterarPreco(novoPreco)`.

# 24. Prática guiada — Passo 3

O cadastro passa a criar o objeto assim:

```java
produtos[quantidade] = new Produto(codigo, preco);
```

Permanecem: array `Produto[]`, quantidade, busca linear, menu, deslocamento de referências, duplicidade e capacidade.

# 25. Prática guiada — Passo 4

Execute: dois cadastros, duplicidade, alteração válida, alteração inválida, remoção, consulta inexistente e capacidade máxima. Refatoração correta preserva todos esses resultados.

# 26. Erros frequentes e depuração

- `void Produto(...)` declara método, não construtor.
- `codigo = codigo` altera apenas o parâmetro; use `this.codigo = codigo`.
- `produto.preco` não é acessível fora da classe quando é `private`.
- `setPreco()` sem validação reabre a possibilidade de preço inválido.
- Getter lê; `alterarPreco()` muda com regra.

# 27. Desafio e critério de conclusão

O programa está pronto quando cria produtos com o construtor, não acessa atributos diretamente, preserva preço diante de alteração inválida e passa todos os testes.

Explique: por que `private` e `alterarPreco` protegem o produto?

# 28. Síntese e próximo passo

1. Construtor inicializa quando `new` é executado.
2. `this` distingue atributo e parâmetro.
3. Sobrecarga oferece formas diferentes de criar o mesmo tipo.
4. `private` controla acesso direto ao estado.
5. Encapsulamento coloca dados e regras no objeto.

**Próximo encontro:** relacionamentos e responsabilidades entre classes.
