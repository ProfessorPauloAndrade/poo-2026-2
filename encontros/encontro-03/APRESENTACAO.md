# Encontro 3 — Controle de fluxo e métodos

**Programação Orientada a Objetos — transição de C para Java**

Hoje: decidir, repetir e organizar um programa procedural.

---

# Um programa que só calcula é suficiente?

No encontro anterior, a calculadora:

1. leu duas notas;
2. calculou a média;
3. exibiu o resultado.

**Desafio:** como fazê-la classificar o resultado, atender vários casos e evitar um `main` gigante?

---

# Preveja antes de programar

Para cada média, qual mensagem deve aparecer?

| Média | Resultado |
|---:|---|
| `7.0` | ? |
| `6.4` | ? |
| `4.9` | ? |

Política do exemplo: `>= 7` aprovado; `>= 5` recuperação; abaixo de `5` reprovado.

---

# Percurso e produto do encontro

1. **Decidir:** `if`, `else if`, `else`, `switch`.
2. **Repetir:** `while`, `do-while`, `for`.
3. **Organizar:** métodos, parâmetros e retorno.
4. **Construir:** caixa procedural de cantina.
5. **Verificar:** casos de teste + commit.

---

# De onde partimos: expressões booleanas

~~~java
double media = 6.4;

media >= 7.0              // false
media >= 5.0              // true
media >= 0 && media <= 10 // true
~~~

Uma expressão booleana produz `true` ou `false`. Hoje ela passa a controlar o caminho da execução.

---

# Seleção simples: C e Java quase lado a lado

~~~c
if (media >= 7.0) {
    printf("Aprovado\n");
}
~~~

~~~java
if (media >= 7.0) {
    System.out.println("Aprovado");
}
~~~

Mesma ideia: a instrução dentro das chaves só executa quando a condição é verdadeira.

---

# Rastreie o `if`

~~~java
double media = 6.4;

if (media >= 7.0) {
    System.out.println("Aprovado");
}

System.out.println("Fim");
~~~

**Previsão:** quais linhas aparecem? A condição muda o fluxo, mas não encerra o programa.

---

# Dois caminhos: `if` e `else`

~~~java
if (media >= 7.0) {
    System.out.println("Aprovado");
} else {
    System.out.println("Ainda nao aprovado");
}
~~~

Exatamente um dos dois blocos executa.

---

# Três faixas: a ordem importa

~~~java
if (media >= 7.0) {
    System.out.println("Aprovado");
} else if (media >= 5.0) {
    System.out.println("Recuperacao");
} else {
    System.out.println("Reprovado");
}
~~~

A cadeia para na primeira condição verdadeira.

---

# Um erro lógico por ordem incorreta

~~~java
if (media >= 5.0) {
    System.out.println("Recuperacao");
} else if (media >= 7.0) {
    System.out.println("Aprovado");
}
~~~

**Teste mental:** para `media = 8.0`, qual ramo executa? O segundo ramo consegue ser alcançado?

---

# Prática guiada: complete as condições

Política:

- menor que `0` ou maior que `10`: nota inválida;
- de `7` a `10`: aprovado;
- de `5` até menos que `7`: recuperação;
- abaixo de `5`: reprovado.

Em dupla, escrevam apenas a cadeia de condições. Comecem pelo caso inválido.

---

# Quando a escolha é uma opção discreta

~~~text
1 - Registrar venda
2 - Consultar total
0 - Encerrar
~~~

Para faixas e combinações, `if` é natural. Para comparar uma mesma variável com valores discretos, `switch` pode deixar a intenção mais visível.

---

# `switch` em Java: estrutura básica

~~~java
switch (opcao) {
    case 1:
        System.out.println("Registrar venda");
        break;
    case 2:
        System.out.println("Consultar total");
        break;
    case 0:
        System.out.println("Encerrar");
        break;
    default:
        System.out.println("Opcao invalida");
}
~~~

---

# O papel de `case`, `break` e `default`

- `case`: valor que pode coincidir com a expressão.
- `break`: encerra o `switch` atual.
- `default`: trata valores não listados.

Sem `break`, o fluxo continua no próximo caso. Neste encontro, cada opção deve terminar claramente.

---

# `switch` em C e Java

~~~c
switch (opcao) {
    case 1: printf("Registrar\n"); break;
    case 0: printf("Encerrar\n"); break;
    default: printf("Invalida\n");
}
~~~

~~~java
switch (opcao) {
    case 1: System.out.println("Registrar"); break;
    case 0: System.out.println("Encerrar"); break;
    default: System.out.println("Invalida");
}
~~~

A estrutura de controle é familiar; mudam tipos, entrada e saída.

---

# Verificação 1 — qual estrutura escolher?

1. Classificar média por faixas.
2. Tratar opções `0`, `1` e `2` de um menu.
3. Validar `nota >= 0 && nota <= 10`.

Para cada caso, escolha `if` ou `switch` e justifique pela forma da condição.

---

# Agora precisamos repetir

Um menu que executa uma única opção não é um sistema interativo.

**Necessidade:** mostrar opções, ler a escolha, executar e voltar ao menu — até o usuário encerrar.

Pergunta: a condição deve ser testada antes ou depois da primeira exibição?

---

# `while`: teste antes

~~~java
int contador = 1;

while (contador <= 3) {
    System.out.println("Teste " + contador);
    contador++;
}
~~~

Se a condição começar falsa, o bloco executa zero vezes.

---

# Rastreando um laço

| Antes da iteração | `contador <= 3` | Saída | Depois de `contador++` |
|---:|---|---|---:|
| `1` | `true` | `Teste 1` | `2` |
| `2` | `true` | `Teste 2` | `3` |
| `3` | `true` | `Teste 3` | `4` |
| `4` | `false` | — | — |

Um laço precisa de estado inicial, condição e progresso.

---

# `do-while`: execute e depois teste

~~~java
int opcao;

do {
    System.out.println("1 - Registrar");
    System.out.println("0 - Encerrar");
    opcao = scanner.nextInt();
} while (opcao != 0);
~~~

O menu aparece pelo menos uma vez. Observe o ponto e vírgula após `while (...)`.

---

# `for`: contagem reunida em uma linha

~~~java
for (int contador = 1; contador <= 3; contador++) {
    System.out.println("Teste " + contador);
}
~~~

~~~text
inicialização → condição → corpo → atualização → condição...
~~~

Use quando início, limite e passo formam uma contagem clara.

---

# Repetição em C e Java

~~~c
for (int contador = 1; contador <= 3; contador++) {
    printf("Teste %d\n", contador);
}
~~~

~~~java
for (int contador = 1; contador <= 3; contador++) {
    System.out.println("Teste " + contador);
}
~~~

O algoritmo permanece; a saída muda de linguagem.

---

# Escolha do laço

| Situação | Estrutura útil | Motivo |
|---|---|---|
| repetir enquanto houver condição | `while` | testa antes |
| menu que aparece ao menos uma vez | `do-while` | testa depois |
| repetir exatamente 5 vezes | `for` | contagem explícita |

Não existe “laço melhor” fora do problema; existe escolha coerente com a condição.

---

# Desvios: `break` e `continue`

- `break`: encerra o laço ou `switch` mais próximo.
- `continue`: pula o restante da iteração atual.

~~~java
if (valor < 0) {
    continue;
}
~~~

Use com parcimônia: muitos desvios tornam o fluxo difícil de rastrear.

---

# Prática guiada: encontre o laço infinito

~~~java
int contador = 1;

while (contador <= 3) {
    System.out.println(contador);
}
~~~

1. Qual estado nunca muda?
2. Onde inserir o progresso?
3. Qual será o último valor impresso após a correção?

---

# Verificação 2 — previsão antes da execução

~~~java
for (int i = 0; i < 5; i++) {
    if (i == 2) {
        continue;
    }
    System.out.print(i + " ");
}
~~~

Anote a saída exata. Depois explique o que `continue` mudou e o que não mudou.

---

# Pausa — até aqui controlamos o caminho

Já conseguimos:

- escolher um ramo;
- repetir um bloco;
- encerrar ou pular parte do fluxo.

Depois da pausa: como evitar que toda a lógica fique amontoada no `main`?

---

# O problema do `main` gigante

~~~text
main
 ├─ mostra menu
 ├─ lê opção
 ├─ valida venda
 ├─ atualiza total
 ├─ formata consulta
 └─ controla repetição
~~~

Quando tudo está no mesmo bloco, localizar, testar e alterar uma responsabilidade fica mais difícil.

---

# Função em C, método em Java

~~~c
double somar(double a, double b) {
    return a + b;
}
~~~

~~~java
static double somar(double a, double b) {
    return a + b;
}
~~~

Na ponte procedural, o método fica dentro da classe e usa `static` para ser chamado diretamente pelo `main`.

---

# Anatomia de um método

~~~java
static double calcularMedia(double nota1, double nota2) {
    double media = (nota1 + nota2) / 2;
    return media;
}
~~~

- `double`: tipo devolvido.
- `calcularMedia`: nome em camelCase.
- `nota1`, `nota2`: parâmetros.
- `return media`: entrega o resultado ao chamador.

---

# Parâmetros não são argumentos

~~~java
static double somar(double a, double b) { // parâmetros
    return a + b;
}

double total = somar(10.0, 5.5);          // argumentos
~~~

Parâmetros são nomes no contrato do método; argumentos são os valores enviados em uma chamada.

---

# Capturar o retorno faz parte do algoritmo

~~~java
total = registrarVenda(total, valor);
~~~

Fluxo:

~~~text
argumentos → método calcula → return → atribuição atualiza total
~~~

Chamar `registrarVenda(total, valor);` sem atribuição descartaria o novo total.

---

# Quando o método não devolve valor

~~~java
static void mostrarTotal(double total) {
    System.out.printf(Locale.US, "Total: R$ %.2f%n", total);
}
~~~

`void` significa “sem valor de retorno”. O método produz uma saída no terminal, mas não entrega um resultado para uma variável.

---

# `static`: uso operacional neste encontro

~~~java
public static void main(String[] args) {
    mostrarMenu();
}

static void mostrarMenu() {
    System.out.println("1 - Registrar venda");
}
~~~

Por enquanto, os métodos auxiliares são `static` porque são chamados pelo `main` estático. Métodos ligados a objetos virão depois.

---

# Escopo: onde uma variável existe

~~~java
if (opcao == 1) {
    double valor = scanner.nextDouble();
    System.out.println(valor); // existe aqui
}

// valor não existe aqui
~~~

Variável local existe do ponto em que é declarada até o fim do bloco `{ ... }` correspondente.

---

# Decompor por responsabilidade

~~~text
main
 ├─ controla o ciclo do menu
 ├─ chama mostrarMenu()
 ├─ chama registrarVenda(total, valor)
 └─ chama mostrarTotal(total)
~~~

Um bom nome permite ler o fluxo antes de ler os detalhes.

---

# Antes e depois: o comportamento deve permanecer

**Antes:** toda a validação, soma e saída no `main`.

**Depois:** decisões distribuídas em métodos pequenos.

Teste de preservação:

- mesmas entradas;
- mesmas mensagens essenciais;
- mesmo total final;
- código mais fácil de localizar e alterar.

---

# O caixa procedural: regras do domínio

Quem usa: operador da cantina.

Entradas: opção do menu e valor da venda.

Saídas: confirmação, total, erro ou encerramento.

Regras:

- apenas valor positivo altera o total;
- opção desconhecida não altera o total;
- o menu volta até a opção `0`.

---

# Fluxo integrado

~~~text
INÍCIO → total = 0
          ↓
       mostrar menu
          ↓
       ler opção
      ↙    ↓     ↘
 vender  consultar  encerrar
      ↘    ↓
       voltar ao menu
~~~

Seleção escolhe a ação; repetição mantém o programa ativo; métodos separam responsabilidades.

---

# Esqueleto do `main`

~~~java
double total = 0.0;
int opcao;

do {
    mostrarMenu();
    opcao = scanner.nextInt();

    switch (opcao) {
        // tratar 1, 2, 0 e default
    }
} while (opcao != 0);
~~~

O `main` coordena. Os métodos executam partes nomeadas.

---

# Contratos dos métodos

~~~java
static void mostrarMenu()

static double registrarVenda(double total, double valor)

static void mostrarTotal(double total)
~~~

Antes de implementar, responda para cada método:

1. O que recebe?
2. O que devolve?
3. Qual responsabilidade assume?

---

# Laboratório — complete o caixa

Em dupla, use `CaixaCantinaInicial.java`.

1. Complete `registrarVenda` com decisão e retorno.
2. Complete `mostrarTotal`.
3. Implemente o `switch` dentro do `do-while`.
4. Preveja, compile, execute e corrija.
5. Registre as respostas e faça commit.

**Tempo:** 45 minutos de construção + 10 minutos de correção coletiva.

---

# Casos de teste obrigatórios

| Caso | Entradas | Verificação |
|---|---|---|
| A | `2`, `0` | total inicial `R$ 0.00` |
| B | `1`, `10.00`, `1`, `5.50`, `2`, `0` | total `R$ 15.50` |
| C | `1`, `-2.00`, `2`, `0` | rejeita e preserva `R$ 0.00` |
| D | `9`, `0` | informa opção inválida e repete |

Um programa “compilar” não prova que todos os caminhos funcionam.

---

# Checklist de depuração

- A condição usa comparação, não atribuição?
- Todo `case` termina corretamente?
- A variável do laço é atualizada?
- Todo caminho do método `double` possui `return`?
- O retorno foi capturado em `total = ...`?
- O valor local está sendo usado dentro do seu escopo?
- O erro é de compilação, execução ou lógica?

---

# Produto e commit

Produto:

- caixa compilado e executado;
- casos A–D registrados;
- explicação de laço, parâmetros, retorno e responsabilidades.

~~~text
git add exercicios/encontro-3/CaixaCantina.java
git commit -m "Organiza caixa com fluxo e metodos"
~~~

Sem Internet, o commit local continua válido.

---

# Verificação final — explique sem executar

1. Por que o menu usa `do-while`?
2. Quando `switch` é mais claro que uma cadeia de `if`?
3. Qual diferença entre parâmetro, argumento e retorno?
4. Por que `registrarVenda` devolve `double`, mas `mostrarTotal` usa `void`?
5. O que aconteceria se o retorno da venda fosse descartado?

---

# Cinco ideias que ficam

1. Condições booleanas controlam caminhos.
2. A ordem dos ramos pode mudar o resultado.
3. O laço deve combinar com a forma da repetição.
4. Método tem contrato: entrada, ação e possível retorno.
5. Testar caminhos diferentes é parte da implementação.

---

# Ponte para o Encontro 4

Já temos a estrutura procedural de um sistema com menu e operações nomeadas.

No próximo encontro, ela cresce para um CRUD em memória:

~~~text
cadastrar → consultar → alterar → remover
~~~

Pergunta que levaremos adiante: quando dados e funções aumentam, onde começa a aparecer a limitação da solução procedural?
