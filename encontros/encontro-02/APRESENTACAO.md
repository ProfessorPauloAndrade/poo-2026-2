# Apresentação — Encontro 2

## Transição de C para Java: dados, cálculos e entrada pelo terminal

**Formato:** 16:9 · Português do Brasil  
**Duração:** 210 minutos  
**Produto:** programa Java que lê dois valores, calcula uma média, exibe o resultado e possui um commit descritivo.

## Slide 1 — O mesmo problema, outra linguagem

Em C, você já lê valores, faz cálculos e mostra resultados. Hoje vamos realizar esse mesmo percurso em Java.

**Pergunta-motriz:** como reescrever em Java um programa em C que lê dois valores e calcula um resultado?

## Slide 2 — O percurso e o produto

1. Retomar o primeiro programa Java.
2. Comparar a estrutura de C e Java.
3. Usar tipos, variáveis e operadores.
4. Ler valores com `Scanner`.
5. Testar, corrigir e versionar.

**Produto:** `CalculadoraMedia.java` executado e registrado em um commit.

## Slide 3 — Retomada: o que já funciona?

~~~java
public class PrimeiroPrograma {
    public static void main(String[] args) {
        System.out.println("Olá, Java!");
    }
}
~~~

**Ação:** em duplas, indiquem o nome do arquivo, o ponto de início da execução e a instrução que mostra texto.

## Slide 4 — O ponto de partida em C

~~~c
#include <stdio.h>

int main() {
    double nota1, nota2, media;

    scanf("%lf", &nota1);
    scanf("%lf", &nota2);
    media = (nota1 + nota2) / 2;
    printf("Media: %.1f\n", media);
    return 0;
}
~~~

**Pergunta:** quais partes desse programa precisam existir também em Java?

## Slide 5 — Mapa da estrutura Java

~~~text
arquivo .java → classe pública → main → instruções executadas em ordem
~~~

Por enquanto, a classe é o invólucro necessário do programa. A criação de classes com atributos e objetos será estudada mais adiante.

## Slide 6 — A mesma ideia em Java

~~~java
public class CalculadoraMedia {
    public static void main(String[] args) {
        double nota1 = 7.5;
        double nota2 = 8.0;
        double media = (nota1 + nota2) / 2;

        System.out.println("Média: " + media);
    }
}
~~~

**Ação:** localizem as variáveis, a expressão e a saída.

## Slide 7 — Tipos primitivos: qual valor cabe aqui?

| Tipo | Exemplo | Uso inicial |
|---|---|---|
| `int` | `18` | números inteiros |
| `double` | `7.5` | números com parte decimal |
| `char` | `'A'` | um único caractere |
| `boolean` | `true` | verdadeiro ou falso |

**Regra prática:** escolha o tipo pelo valor que o programa precisa representar, não apenas pelo valor de hoje.

## Slide 8 — Variável, constante e inicialização

~~~java
int quantidade = 3;
double preco = 12.50;
char turma = 'A';
boolean arquivoEncontrado = true;
final double PESO_DA_PROVA = 0.6;
~~~

- variável: valor que pode mudar;
- constante: valor nomeado que não deve mudar (`final`);
- inicialização: primeiro valor atribuído à variável.

## Slide 9 — Preveja antes de executar

~~~java
int total = 7 / 2;
double metade = 7.0 / 2;

System.out.println(total);
System.out.println(metade);
~~~

**Pergunta:** quais serão as duas linhas impressas? Registrem a previsão antes do teste.

## Slide 10 — Operadores: construir expressões

| Grupo | Operadores | Exemplo |
|---|---|---|
| aritméticos | `+`, `-`, `*`, `/`, `%` | `(nota1 + nota2) / 2` |
| relacionais | `>`, `<`, `>=`, `<=`, `==`, `!=` | `nota1 >= 0` |
| lógicos | `&&`, `||`, `!` | `nota1 >= 0 && nota1 <= 10` |

Parênteses tornam a intenção visível e evitam depender apenas da prioridade dos operadores.

## Slide 11 — Um resultado pode mudar de tipo

~~~java
int quantidade = 7;
int grupos = 2;

int divisaoInteira = quantidade / grupos;
double divisaoDecimal = (double) quantidade / grupos;
~~~

**Mensagem:** dois operandos inteiros produzem divisão inteira. A conversão para `double` preserva a parte decimal.

## Slide 12 — Entrada em C e em Java

| Em C | Em Java |
|---|---|
| `scanf("%lf", &nota1)` | `scanner.nextDouble()` |
| `printf("Media: %.1f", media)` | `System.out.println("Média: " + media)` |
| `#include <stdio.h>` | `import java.util.Scanner;` |

Java usa um objeto `Scanner` da biblioteca padrão para ler valores do teclado.

## Slide 13 — A sequência com `Scanner`

~~~java
import java.util.Scanner;
import java.util.Locale;

public class CalculadoraMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.print("Primeira nota: ");
        double nota1 = scanner.nextDouble();
        // ler a segunda nota, calcular e mostrar o resultado
        scanner.close();
    }
}
~~~

`scanner.useLocale(Locale.US)` permite que a turma use ponto decimal nos mesmos testes, independentemente da configuração regional do computador.

**Ação:** identifiquem as importações, a criação do leitor, a configuração da leitura, a pergunta e a leitura.

## Slide 14 — Demonstração: prever → executar → comparar

1. Digitar `7.5` e `8.0`.
2. Prever a média.
3. Compilar: `javac CalculadoraMedia.java`.
4. Executar: `java CalculadoraMedia`.
5. Comparar a saída com a previsão.

## Slide 15 — Laboratório: traduzir e testar

Em duplas, construam `CalculadoraMedia.java` usando o roteiro do aluno.

- leia duas notas com `Scanner`;
- calcule a média;
- exiba as notas e a média;
- teste os casos indicados;
- corrija erros antes de registrar a versão.

**Tempo:** 70 minutos. **Produto:** arquivo executável e resultados de teste anotados.

## Slide 16 — Testes mínimos

| Entrada | Média esperada |
|---|---:|
| `7.5` e `8.0` | `7.75` |
| `6.0` e `6.0` | `6.0` |
| `10.0` e `0.0` | `5.0` |

**Verificação adicional:** compare `7 / 2` com `(double) 7 / 2` no exemplo de divisão.

## Slide 17 — Quando algo não funciona

| Sintoma | Primeiro ponto a verificar |
|---|---|
| não compila | nome do arquivo e da classe; ponto e vírgula; importação |
| lê valor errado | usar `nextDouble()` para valor decimal |
| resultado sem casas decimais | tipos dos operandos da divisão |
| não encontra `Scanner` | `import java.util.Scanner;` |

Classifique o problema: compilação, execução ou lógica.

## Slide 18 — Registrar a versão concluída

~~~text
git add exercicios/encontro-2/CalculadoraMedia.java
git commit -m "Traduz cálculo de média de C para Java"
~~~

O commit local é o mínimo. Faça o push quando o repositório remoto estiver disponível.

## Slide 19 — O que fica deste encontro?

1. Java preserva ideias de C: dados, expressões, entrada, saída e testes.
2. Todo valor tem um tipo; a escolha do tipo altera o resultado.
3. Variáveis guardam valores; constantes tornam regras visíveis.
4. `Scanner` lê valores de entrada e `System.out` mostra resultados.
5. Prever e testar é parte da programação.

## Slide 20 — Ponte para o Encontro 3

Hoje o programa executou instruções em uma única sequência.

> Como fazer o programa escolher caminhos, repetir ações e organizar partes reutilizáveis?

No próximo encontro: seleção, repetição e métodos em Java.

## Slide 21 — Java diferencia maiúsculas de minúsculas

Java é **case sensitive**: letras maiúsculas e minúsculas formam nomes diferentes.

~~~java
int nota = 7;
int Nota = 8;
~~~

Essas são duas variáveis diferentes. Por isso, `System` não é o mesmo que `system`, e `String` não é o mesmo que `string`.

**Ação:** identifiquem o erro: `system.out.println("Olá");`.

## Slide 22 — O que significa `public class`?

~~~java
public class CalculadoraMedia {
    // instruções do programa ficam aqui
}
~~~

- `class`: declara uma classe, a estrutura que reúne o código;
- `CalculadoraMedia`: nome da classe;
- `public`: a classe pode ser acessada por código de fora dela;
- quando a classe é `public`, o arquivo deve ter o mesmo nome: `CalculadoraMedia.java`.

Nesta etapa, a classe é o contêiner obrigatório do programa. Classes com atributos e objetos serão estudadas depois.

## Slide 23 — Leia o `main` por partes

~~~java
public static void main(String[] args) {
    // execução começa aqui
}
~~~

| Parte | Significado inicial |
|---|---|
| `public` | a JVM consegue localizar o método |
| `static` | ele pertence à classe; não é preciso criar um objeto para executá-lo |
| `void` | não devolve um valor ao final |
| `main` | nome do ponto de entrada do programa |
| `String[] args` | recebe argumentos de texto enviados pela linha de comando |

**Mensagem:** memorize a estrutura agora; os detalhes de métodos serão aprofundados no Encontro 3.

## Slide 24 — `System.out`: para onde vai a saída?

~~~java
System.out.println("Olá, Java!");
~~~

~~~text
System → classe da biblioteca padrão
   out → saída padrão (terminal)
println → escreve texto e muda de linha
~~~

`System` começa com maiúscula porque Java diferencia maiúsculas de minúsculas.

## Slide 25 — `print`, `println` e `printf`

| Instrução | Comportamento |
|---|---|
| `System.out.print("A")` | escreve sem pular linha |
| `System.out.println("A")` | escreve e pula para a próxima linha |
| `System.out.printf("Média: %.2f%n", media)` | escreve texto formatado |

~~~java
double media = 7.75;
System.out.print("Média: ");
System.out.println(media);
System.out.printf("Média formatada: %.2f%n", media);
~~~

Java também formata saída: `%d` para inteiro, `%.2f` para decimal com duas casas, `%s` para texto e `%n` para nova linha.

## Slide 26 — Java tem `String`?

Sim. `String` representa texto em Java.

~~~java
String nome = "Ana";
char inicial = 'A';
~~~

| `char` | `String` |
|---|---|
| um caractere | sequência de caracteres (texto) |
| `'A'` | `"Ana"` |
| tipo primitivo | tipo de referência baseado em classe |

Por enquanto, use `String` para mensagens e dados textuais. Seus métodos serão estudados em momento apropriado.

## Slide 27 — Saída em C e Java: dois estilos de formatação

| Objetivo | C | Java |
|---|---|---|
| decimal com duas casas | `printf("%.2f\\n", media);` | `System.out.printf("%.2f%n", media);` |
| texto e número | `printf("Media: %.2f\\n", media);` | `System.out.println("Média: " + media);` |
| nova linha | `\\n` | `println` ou `%n` |

**Pergunta:** em qual situação `printf` torna a saída mais clara que a concatenação?

## Slide 28 — Miniatividade: corrija e explique

~~~java
public class Exemplo {
    public static void main(string[] args) {
        double media = 7.5;
        system.out.printf("Media: %.2f\\n", media);
    }
}
~~~

Em dupla, encontrem dois erros relacionados a maiúsculas/minúsculas e corrijam a nova linha para o formato Java recomendado.

## Slide 29 — Checklist de leitura de um programa Java

- [ ] O arquivo e a classe `public` têm o mesmo nome?
- [ ] `String`, `System` e `main` usam a capitalização correta?
- [ ] O `main` tem a estrutura `public static void main(String[] args)`?
- [ ] A saída usa `print`, `println` ou `printf` de acordo com a intenção?
- [ ] Texto usa `String` e um único caractere usa `char`?
