# Apresentação — Encontro 1

## Programação Orientada a Objetos: de C a Java

**Formato:** 16:9 · Português do Brasil  
**Duração:** 180 minutos  
**Produto:** ambiente Java verificado e primeiro repositório com um programa executável.

## Slide 1 — O que muda quando um programa cresce?

**Função:** abertura e pergunta-motriz.

Um programa pequeno cabe em uma função. Um sistema maior precisa organizar dados, operações, responsabilidades e mudanças.

**Pergunta:** onde um programa em C começa a ficar difícil de manter?

## Slide 2 — O percurso do encontro

1. Partir de uma solução procedural conhecida.
2. Identificar uma limitação de organização.
3. Conhecer a ideia de orientação a objetos.
4. Entender como Java é executado.
5. Preparar o ambiente e publicar o primeiro programa.

**Produto:** repositório com PrimeiroPrograma.java, execução comprovada e primeiro commit.

## Slide 3 — O que já trazemos de C?

algoritmo → dados → funções → entrada/saída → teste

**Ação:** em duplas, listem três elementos de um programa em C que continuam importantes em Java.

## Slide 4 — Um cadastro simples começa assim

~~~c
char nome[50];
int idade;

void imprimirPessoa(char nome[], int idade) {
    printf("%s (%d anos)\n", nome, idade);
}
~~~

**Pergunta:** onde estão os dados? Onde está o comportamento? O que acontece quando surgem dez tipos de cadastro?

## Slide 5 — A limitação aparece antes do conceito

Quando dados e funções se espalham, fica mais difícil saber quem pode alterar cada dado, manter regras juntas, reaproveitar uma unidade completa e mudar uma parte sem quebrar outra.

## Slide 6 — Duas formas de organizar o mesmo problema

| Ênfase procedural | Ênfase orientada a objetos |
|---|---|
| funções operam sobre dados | objetos reúnem dados e comportamentos |
| fluxo de operações | colaboração entre responsabilidades |
| estrutura separada das funções | unidade de dados + operações |

**Mensagem:** paradigmas são formas de organizar o raciocínio; ambos podem produzir programas corretos.

## Slide 7 — A ideia central da disciplina

~~~text
programa procedural
        ↓ limitação observável
pequena refatoração
        ↓ comportamento preservado
classe e objeto
~~~

## Slide 8 — O que é um objeto?

Um objeto representa uma unidade do domínio com:

- **estado:** informações que ele mantém;
- **comportamento:** ações que ele sabe realizar;
- **identidade:** a unidade particular que está sendo usada.

**Exemplo:** Pessoa → nome, idade, apresentar-se.

A implementação detalhada fica para os encontros 5 e 6.

## Slide 9 — O que Java acrescenta ao nosso percurso?

Linguagem criada na década de 1990; foco em portabilidade; sintaxe familiar para quem vem de C/C++; orientação a objetos como parte central; grande biblioteca padrão.

## Slide 10 — Como Java é executado?

~~~text
PrimeiroPrograma.java
        ↓ javac
PrimeiroPrograma.class  (bytecode)
        ↓ java
JVM interpreta/compila em tempo de execução
        ↓
programa em execução
~~~

**Vocabulário:** JDK = ferramentas; JVM = máquina que executa bytecode.

## Slide 11 — Três nomes para não confundir

| Nome | Papel |
|---|---|
| JDK | conjunto usado para desenvolver e compilar |
| JVM | ambiente que executa o bytecode |
| .java | código-fonte escrito por nós |
| .class | resultado intermediário da compilação |

## Slide 12 — Primeiro programa: pequeno, mas completo

~~~java
public class PrimeiroPrograma {
    public static void main(String[] args) {
        System.out.println("Olá, Java!");
        System.out.println("Meu primeiro programa da disciplina.");
    }
}
~~~

**Pergunta:** qual nome o arquivo precisa ter? Qual método inicia a execução?

## Slide 13 — Preveja antes de executar

O que será impresso?

~~~java
System.out.println("A");
System.out.println("B");
~~~

Anotem a saída; depois comparem com o terminal.

## Slide 14 — Laboratório: preparar o ambiente

1. Confirmar o JDK LTS da turma.
2. Abrir o Visual Studio Code.
3. Verificar as extensões Java indicadas.
4. Criar ou abrir a pasta `poo-2026-02` e a subpasta `teste-instalacao`.
5. Criar PrimeiroPrograma.java dentro de `teste-instalacao`.
6. Compilar e executar.

## Slide 15 — Laboratório: criar o primeiro repositório

~~~text
git init
git add teste-instalacao/PrimeiroPrograma.java
git commit -m "Cria primeiro programa Java"
~~~

Se a turma tiver acesso ao GitHub:

~~~text
git remote add origin URL_DO_REPOSITORIO
git push -u origin main
~~~

## Slide 16 — Teste rápido de conclusão

- [ ] arquivo PrimeiroPrograma.java;
- [ ] classe com o mesmo nome do arquivo;
- [ ] método main;
- [ ] saída no terminal;
- [ ] commit descritivo.

## Slide 17 — O que fica deste encontro?

1. POO organiza dados e comportamentos em unidades com responsabilidades.
2. A disciplina começa por refatoração de soluções procedurais.
3. O JDK desenvolve e compila; a JVM executa o bytecode.
4. Um programa Java começa por uma classe e um main.
5. Código que funciona também precisa ser rastreável e versionado.

## Slide 18 — A ponte para o encontro 2

Hoje executamos um programa mínimo.

No próximo encontro:

> Como traduzir variáveis, entrada/saída e operadores de C para Java?

**Preparação:** traga uma pequena função em C que leia dois valores e produza um resultado.
