# Material do aluno — Encontro 2

## Objetivo

Traduzir para Java um programa simples de C que lê duas notas, calcula a média e mostra o resultado no terminal.

## Antes de começar

Você já criou e executou `PrimeiroPrograma.java`. Hoje continuará usando a pasta `poo-2026-02` e o terminal.

Crie a pasta `exercicios/encontro-2` dentro do seu repositório local.

## Parte 1 — Compare C e Java

Observe o programa em C:

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

Antes de programar, responda no seu caderno ou arquivo de anotações:

1. Quais variáveis o programa precisa guardar?
2. Que tipo é adequado para cada nota e para a média?
3. Qual valor você espera obter para as notas `7.5` e `8.0`?

## Parte 2 — Crie o ponto de partida

Crie o arquivo `CalculadoraMedia.java` com este código:

~~~java
import java.util.Scanner;
import java.util.Locale;

public class CalculadoraMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Segunda nota: ");
        double nota2 = scanner.nextDouble();

        // Calcule a média e mostre o resultado.

        scanner.close();
    }
}
~~~

Complete apenas o trecho marcado pelo comentário. Use uma variável `media` do tipo `double` e mostre uma mensagem que contenha as duas notas e a média.

O código já configura a leitura para usar ponto decimal. Portanto, nos testes, digite `7.5`, e não `7,5`.

## Parte 3 — Compile e execute

No terminal, dentro da pasta que contém o arquivo:

~~~text
javac CalculadoraMedia.java
java CalculadoraMedia
~~~

Teste estes valores e anote a saída:

| Primeira nota | Segunda nota | Média esperada |
|---:|---:|---:|
| 7.5 | 8.0 | 7.75 |
| 6.0 | 6.0 | 6.0 |
| 10.0 | 0.0 | 5.0 |

Se o resultado estiver diferente, identifique se o problema é de compilação, execução ou lógica antes de alterá-lo.

## Parte 4 — Observe a divisão

Crie também `ComparacaoDivisao.java`:

~~~java
public class ComparacaoDivisao {
    public static void main(String[] args) {
        int divisaoInteira = 7 / 2;
        double divisaoDecimal = (double) 7 / 2;

        System.out.println("7 / 2 = " + divisaoInteira);
        System.out.println("(double) 7 / 2 = " + divisaoDecimal);
    }
}
~~~

Antes de executar, preveja as duas linhas. Depois compile, execute e compare sua previsão.

## Parte 5 — Registre a versão

~~~text
git add exercicios/encontro-2/CalculadoraMedia.java exercicios/encontro-2/ComparacaoDivisao.java
git commit -m "Traduz cálculo de média de C para Java"
~~~

Se o GitHub estiver disponível, faça o push. Se não estiver, preserve o commit local e publique depois.

## Produto esperado

- `CalculadoraMedia.java` compilado e executado;
- média correta nos três casos de teste;
- `ComparacaoDivisao.java` executado com a previsão conferida;
- commit descritivo criado.

## Critérios de conclusão

- [ ] o arquivo e a classe pública se chamam `CalculadoraMedia`;
- [ ] as notas e a média usam `double`;
- [ ] o programa lê dois valores com `Scanner`;
- [ ] a média é calculada e exibida;
- [ ] os três testes foram realizados;
- [ ] a diferença entre divisão inteira e decimal foi observada;
- [ ] existe um commit descritivo.

## Se a Internet falhar

Continue com edição, compilação, execução, `git add` e `git commit` localmente. O push para o GitHub pode ser feito em outro momento.

## Desafio opcional

Adicione uma constante `final double PESO_DA_PROVA = 0.6;` e outra nota com peso complementar. Calcule a média ponderada, teste com valores diferentes e explique em uma frase por que a constante recebeu um nome em maiúsculas.
