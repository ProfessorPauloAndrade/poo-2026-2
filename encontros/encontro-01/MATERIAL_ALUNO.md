# Material do aluno — Encontro 1

## Objetivo

Ao final, você terá um programa Java mínimo executável e um primeiro registro versionado do seu trabalho.

## Ponto de partida

Você já conhece programas em C, funções e compilação. Hoje vamos localizar o que continua familiar em Java e preparar as ferramentas para os próximos encontros.

## Parte 1 — antes de executar

Observe:

~~~java
public class PrimeiroPrograma {
    public static void main(String[] args) {
        System.out.println("Olá, Java!");
        System.out.println("Meu primeiro programa da disciplina.");
    }
}
~~~

Responda:

1. Qual deve ser o nome do arquivo?
2. Qual método inicia a execução?
3. Qual será a ordem das linhas impressas?

## Parte 2 — preparar e executar

1. Abra o Visual Studio Code.
2. Crie ou abra a pasta `poo-2026-02` e, dentro dela, a pasta `teste-instalacao`.
3. Crie o arquivo `PrimeiroPrograma.java` dentro de `teste-instalacao`.
4. Digite ou copie o código inicial.
5. Abra o terminal na pasta do arquivo.
6. Compile: javac PrimeiroPrograma.java.
7. Execute: java PrimeiroPrograma.
8. Compare a saída com sua previsão.

## Parte 3 — fazer uma pequena alteração

Altere as duas mensagens para incluir seu primeiro nome ou apelido e uma frase sobre o que espera aprender na disciplina. Execute novamente e verifique se a saída mudou.

## Parte 4 — registrar a versão

~~~text
git init
git add teste-instalacao/PrimeiroPrograma.java
git commit -m "Cria primeiro programa Java"
~~~

Se o professor orientar e o GitHub estiver disponível, associe o repositório remoto e faça o push.

## Produto esperado

- arquivo salvo;
- programa compilado e executado;
- saída conferida;
- primeiro commit realizado;
- respostas da Parte 1 registradas.

## Critérios de conclusão

- [ ] nome do arquivo e nome da classe coincidem;
- [ ] existe um método main válido;
- [ ] a compilação termina sem erro;
- [ ] a execução imprime as mensagens;
- [ ] a alteração pessoal aparece na saída;
- [ ] existe um commit descritivo.

## Se a Internet ou o GitHub falhar

Conclua as partes locais: arquivo, compilação, execução, git init, git add e git commit. O push poderá ser feito depois, sem apagar o commit local.

## Desafio opcional

Crie uma terceira linha de saída, execute novamente e faça um segundo commit descritivo.
