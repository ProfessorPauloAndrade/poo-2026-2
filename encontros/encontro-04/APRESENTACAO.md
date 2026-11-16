# 1. Encontro 4 — De um menu a um cadastro que guarda produtos

**Projeto 1: CRUD procedural em memória**

Hoje vamos transformar o menu do encontro anterior em um programa que guarda vários produtos durante a execução.

**Visual:** título grande, ilustração simples de etiquetas de produtos organizadas em uma prateleira; sem personagens decorativos.

# 2. O que já conseguimos fazer?

No encontro 3, construímos programas que:

- mostram um menu;
- escolhem caminhos com `switch` e `if`;
- repetem ações com `do-while` e `for`;
- dividem tarefas em métodos estáticos.

Mas o programa ainda não mantinha uma lista de dados.

**Pergunta:** depois de cadastrar um produto, como o programa vai se lembrar dele?

# 3. O problema que vamos resolver

Um ponto de venda da faculdade precisa manter uma lista pequena de produtos para uma atividade.

Quem opera o sistema precisa conseguir:

1. cadastrar um produto;
2. consultar pelo código;
3. alterar o preço;
4. remover;
5. listar os produtos atuais.

Isso é um CRUD: **Create, Read, Update, Delete**.

# 4. Nosso mapa de hoje

1. Guardar vários dados com arrays.
2. Usar o mesmo índice para unir código e preço.
3. Buscar um produto pelo código.
4. Construir cada operação do CRUD.
5. Testar e identificar o limite dessa solução.

**Produto da aula:** um cadastro procedural funcional, limitado a cinco produtos e mantido só na memória.

# 5. Regras do cadastro

- Máximo de 5 produtos.
- Código: inteiro positivo e sem repetição.
- Preço: maior que zero.
- Consulta, alteração e remoção exigem código existente.
- Ao remover, os produtos restantes ficam juntos.
- Ao encerrar o programa, os dados desaparecem.

**Fora do escopo:** nome, estoque, arquivo, banco de dados, login e classes.

# 6. Como deve parecer para quem usa

```text
--- CADASTRO DE PRODUTOS ---
1 - Cadastrar
2 - Consultar
3 - Alterar preco
4 - Remover
5 - Listar
0 - Sair
Opcao: 1
Codigo: 101
Preco: 5.50
Produto cadastrado.
```

O menu já é conhecido. A novidade é que os dados cadastrados precisam ficar disponíveis para a próxima opção.

# 7. De uma variável para várias posições

Uma variável guarda um valor por vez:

```java
int codigo = 101;
double preco = 5.50;
```

Para guardar vários códigos e vários preços, precisamos de coleções de posições. Nesta aula, usaremos **arrays**.

# 8. Array em C e Java

| C | Java |
|---|---|
| `int codigos[5] = {0};` | `int[] codigos = new int[5];` |
| `double precos[5] = {0};` | `double[] precos = new double[5];` |

Nos dois casos, cada posição é acessada por um índice: `0`, `1`, `2`...

**Atenção:** nesta disciplina, Java é a linguagem de implementação; C é a comparação com o conhecimento que a turma já possui.

# 9. Índice: a posição dentro do array

```text
codigos: [ 101 | 205 |     |     |     ]
índice:     0     1     2     3     4
```

O primeiro índice é 0; em um array de tamanho 5, o último é 4.

```java
codigos[0] = 101;
codigos[1] = 205;
```

# 10. Capacidade não é quantidade

```java
static final int MAX_PRODUTOS = 5;
int[] codigos = new int[MAX_PRODUTOS];
double[] precos = new double[MAX_PRODUTOS];
int quantidade = 0;
```

- `MAX_PRODUTOS`: quantas posições existem.
- `quantidade`: quantas posições já representam produtos válidos.

No início, há capacidade para 5, mas há 0 produtos cadastrados.

# 11. Arrays paralelos: uma tabela dividida em colunas

| Índice | `codigos` | `precos` | Está ocupado? |
|---:|---:|---:|---|
| 0 | 101 | 5.50 | Sim |
| 1 | 205 | 7.00 | Sim |
| 2 | 0 | 0.00 | Não |
| 3 | 0 | 0.00 | Não |
| 4 | 0 | 0.00 | Não |

Se `quantidade` vale 2, só os índices 0 e 1 formam produtos.

# 12. A regra que não podemos quebrar

O mesmo índice representa o mesmo produto.

```text
codigos[1] = 205
precos[1]  = 7.00
```

Logo, o produto 205 custa 7.00. Sempre que movemos um código, devemos mover o preço correspondente também.

# 13. Pare e preveja

Estado atual:

```text
codigos = [101, 205, 0, 0, 0]
precos  = [5.50, 7.00, 0, 0, 0]
quantidade = 2
```

Qual é o preço de `codigos[1]`? Quais índices a listagem deve percorrer?

**Resposta para discutir:** 7.00; somente 0 e 1.

# 14. A listagem respeita a quantidade

```java
for (int i = 0; i < quantidade; i++) {
    System.out.printf("codigo: %d | preco: %.2f%n",
            codigos[i], precos[i]);
}
```

Não use `i < MAX_PRODUTOS` para listar produtos: isso exibiria posições vazias como se fossem dados reais.

# 15. Antes do CRUD: encontrar uma posição

Todas estas operações começam com a mesma pergunta:

> Em qual índice está o produto de código informado?

Vamos transformar a pergunta em um método: `buscarIndicePorCodigo`.

# 16. O contrato da busca

| Entrada | Saída |
|---|---|
| array de códigos, quantidade ocupada, código procurado | índice do código, ou `-1` |

`-1` é um valor-sinal: ele significa “não encontrei”. Não é uma posição válida do array.

# 17. Busca linear em Java

```java
static int buscarIndicePorCodigo(int[] codigos, int quantidade, int codigo) {
    for (int i = 0; i < quantidade; i++) {
        if (codigos[i] == codigo) {
            return i;
        }
    }
    return -1;
}
```

O método percorre somente as posições ocupadas e para assim que encontra o código.

# 18. A mesma ideia em C

```c
int buscarIndicePorCodigo(const int codigos[], int quantidade, int codigo) {
    int i;
    for (i = 0; i < quantidade; i++) {
        if (codigos[i] == codigo) return i;
    }
    return -1;
}
```

Mudam detalhes de sintaxe; o algoritmo é o mesmo: percorrer, comparar, devolver índice ou `-1`.

# 19. Rastreando uma busca

Procurar 205 quando `codigos = [101, 205]` e `quantidade = 2`:

| Passo | `i` | `codigos[i]` | Igual a 205? |
|---:|---:|---:|---|
| 1 | 0 | 101 | Não |
| 2 | 1 | 205 | Sim → devolve 1 |

Se procurássemos 999, o laço terminaria e o retorno seria `-1`.

# 20. Decidir depois da busca

```java
int indice = buscarIndicePorCodigo(codigos, quantidade, codigo);

if (indice == -1) {
    System.out.println("Produto nao encontrado.");
} else {
    System.out.printf("Preco: %.2f%n", precos[indice]);
}
```

Primeiro decidimos se encontramos. Só depois usamos `indice` para acessar um array.

# 21. O menu coordena; os métodos realizam

```text
main
 ├─ mostrarMenu
 ├─ cadastrarProduto
 ├─ consultarProduto
 ├─ alterarPreco
 ├─ removerProduto
 └─ listarProdutos
        └─ buscarIndicePorCodigo (quando necessário)
```

O `main` lê a opção e chama a tarefa certa. Cada método recebe os arrays e a quantidade de que precisa.

# 22. Criar: cadastrar um produto

Sequência segura:

1. Há espaço?
2. Código é positivo?
3. Preço é positivo?
4. Código já existe?
5. Gravar código e preço na posição `quantidade`.
6. Aumentar `quantidade`.

# 23. Cadastro: trecho central em Java

```java
if (buscarIndicePorCodigo(codigos, quantidade, codigo) != -1) {
    System.out.println("Ja existe produto com esse codigo.");
} else {
    codigos[quantidade] = codigo;
    precos[quantidade] = preco;
    quantidade++;
    System.out.println("Produto cadastrado.");
}
return quantidade;
```

O método devolve a quantidade porque ela pode ter mudado.

# 24. Cadastro: a mesma operação em C

```c
codigos[quantidade] = codigo;
precos[quantidade] = preco;
quantidade++;
return quantidade;
```

Em C e Java, os arrays são modificados pelo método; a variável `quantidade` do `main` recebe o valor retornado.

# 25. Erro comum: aumentar antes da hora

```java
quantidade++;                 // cedo demais
codigos[quantidade] = codigo; // grava na posição errada
```

O índice livre atual é `quantidade`. Grave primeiro; incremente somente se todas as regras forem atendidas.

# 26. Ler e listar: duas leituras diferentes

**Consultar**: procurar um código específico e mostrar seu preço.

**Listar**: percorrer de 0 até `quantidade - 1` e mostrar todos os pares.

As duas usam os mesmos arrays, mas respondem a perguntas diferentes.

# 27. Atualizar: alterar o preço encontrado

```java
int indice = buscarIndicePorCodigo(codigos, quantidade, codigo);
if (indice == -1) {
    System.out.println("Produto nao encontrado.");
} else if (novoPreco <= 0) {
    System.out.println("O preco deve ser maior que zero.");
} else {
    precos[indice] = novoPreco;
    System.out.println("Preco alterado.");
}
```

O código continua no mesmo índice; apenas seu preço muda.

# 28. Remover cria um espaço no meio

Estado antes de remover o código 205:

| Índice | Código | Preço |
|---:|---:|---:|
| 0 | 101 | 5.50 |
| 1 | 205 | 7.00 |
| 2 | 309 | 9.25 |

Se apenas diminuirmos `quantidade`, o produto 309 não ocupará o lugar esperado. Precisamos deslocar o que vem depois.

# 29. Remover passo a passo

Para remover o índice 1:

```text
antes: [101/5.50] [205/7.00] [309/9.25]
move:  [101/5.50] [309/9.25] [309/9.25]
qtd--: [101/5.50] [309/9.25] [vazio]
```

O par 309/9.25 se move junto: não existe deslocamento de código sem deslocamento de preço.

# 30. Remoção em Java

```java
for (int i = indice; i < quantidade - 1; i++) {
    codigos[i] = codigos[i + 1];
    precos[i] = precos[i + 1];
}
quantidade--;
codigos[quantidade] = 0;
precos[quantidade] = 0;
return quantidade;
```

O limite é `quantidade - 1`, pois `i + 1` precisa apontar para uma posição ocupada.

# 31. Remoção em C

```c
for (i = indice; i < quantidade - 1; i++) {
    codigos[i] = codigos[i + 1];
    precos[i] = precos[i + 1];
}
quantidade--;
return quantidade;
```

Novamente, o algoritmo é o mesmo. A limpeza da última posição é útil, mas a nova `quantidade` é o que define os dados válidos.

# 32. Bug que muda o preço de um produto

```java
for (int i = indice; i < quantidade - 1; i++) {
    codigos[i] = codigos[i + 1];
    // precos[i] ficou parado: erro!
}
```

Depois desse código, um código pode ficar associado ao preço de outro produto. A tabela deixa de fazer sentido.

# 33. O programa integrado: estado e fluxo

```text
arrays + quantidade
       ↓
menu → opção → método escolhido → validação/busca → alteração ou mensagem
       ↑                                                   ↓
       └──────────────── repete até opção 0 ──────────────┘
```

O estado é formado pelos arrays e pela quantidade; ele permanece enquanto o `do-while` continua executando.

# 34. Esqueleto do `main`

```java
do {
    mostrarMenu();
    opcao = entrada.nextInt();
    switch (opcao) {
        case 1: /* cadastrar */ break;
        case 2: /* consultar */ break;
        case 3: /* alterar */ break;
        case 4: /* remover */ break;
        case 5: /* listar */ break;
        case 0: System.out.println("Programa encerrado."); break;
        default: System.out.println("Opcao invalida.");
    }
} while (opcao != 0);
```

O que o menu faz bem: escolher uma ação. O que cada método faz bem: executar uma única responsabilidade.

# 35. Sua prática: ordem recomendada

1. Abra `CadastroProdutosInicial.java`.
2. Faça a busca e teste existente/inexistente.
3. Faça o cadastro e a listagem.
4. Acrescente consulta e alteração.
5. Implemente a remoção por deslocamento.
6. Conecte todas as opções do menu.
7. Rode os casos A–G do roteiro.

# 36. Casos mínimos de teste

| Caso | Entrada-chave | O que observar |
|---|---|---|
| Lista vazia | opção 5 | Não aparecem zeros como produtos. |
| Dois produtos | 101/5.50 e 205/7.00 | Índices e pares corretos. |
| Duplicidade | cadastrar 101 novamente | Quantidade não muda. |
| Alteração | 205 para 7.50 | Só o preço de 205 muda. |
| Remoção | remover 101 | 205 ocupa o índice 0. |
| Limite | sexto cadastro | Nenhuma escrita fora do array. |

# 37. Como depurar sem adivinhar

Quando algo falhar, responda nesta ordem:

1. Qual era o estado antes da operação?
2. Qual índice a busca devolveu?
3. Qual condição foi verdadeira?
4. Em que posição houve leitura ou escrita?
5. `quantidade` mudou no momento correto?

Escreva a tabela dos arrays; ela revela erros de índice e desalinhamento.

# 38. Compartilhe seu avanço

Antes de encerrar:

```text
git add CadastroProdutos.java
git commit -m "Implementa CRUD procedural de produtos"
git push
```

No repositório, o código mostra as escolhas que você fez e permite retomar o projeto na próxima aula.

# 39. O limite que apareceu de propósito

Para cada produto, precisamos lembrar manualmente que:

```text
codigos[i]  ↔  precos[i]
```

Hoje são dois dados. E se cada produto também tiver nome, estoque, categoria e regras próprias? A chance de desalinhamento cresce.

# 40. Ponte para o próximo encontro

No próximo encontro, vamos criar uma forma de representar **um produto como uma unidade**.

Por enquanto, guarde esta observação:

> Arrays paralelos funcionam para o nosso problema pequeno, mas exigem cuidado manual para manter os dados relacionados.

# 41. Síntese: cinco ideias para levar

1. Array oferece posições; `quantidade` diz quais estão ocupadas.
2. Arrays paralelos usam o mesmo índice para representar um registro.
3. A busca devolve índice ou `-1`.
4. CRUD é uma sequência de métodos coordenados pelo menu.
5. Remover exige deslocar todos os dados relacionados.

# 42. Verificação final

Você consegue explicar, sem olhar o código?

- Por que a listagem usa `i < quantidade`?
- Por que `-1` deve ser testado antes de acessar o array?
- Por que a remoção desloca código **e** preço?
- Por que `cadastrarProduto` devolve a nova quantidade?

Se as quatro respostas estiverem claras, você tem a base do Projeto 1 para a próxima etapa.
