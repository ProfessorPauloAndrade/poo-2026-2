# Exemplos do Encontro 2

## Requisitos

- JDK LTS adotado pela turma;
- terminal;
- Visual Studio Code é recomendado, mas não obrigatório.

## Compilar e executar

Compile os três exemplos na pasta `exemplos/encontro-2`:

~~~text
javac TiposEOperadores.java ComparacaoDivisao.java CalculadoraMedia.java
~~~

Para incluir o exemplo de saídas, compile também:

~~~text
javac SaidaFormatada.java
java SaidaFormatada
~~~

Execute os exemplos sem entrada:

~~~text
java TiposEOperadores
java ComparacaoDivisao
~~~

Execute a calculadora e informe duas notas quando solicitado:

~~~text
java CalculadoraMedia
~~~

Use ponto como separador decimal, por exemplo `7.5` e `8.0`. O exemplo configura o leitor para esse formato, evitando diferenças de configuração regional entre os computadores.

## Resultados de referência

`ComparacaoDivisao` deve mostrar:

~~~text
7 / 2 = 3
(double) 7 / 2 = 3.5
~~~

Para `CalculadoraMedia`, as entradas `7.5` e `8.0` devem produzir média `7.75`.

## Alternativa sem Internet

Os exemplos não dependem de Internet. Caso o GitHub esteja indisponível, compile, execute e faça o commit localmente; o push poderá ocorrer depois.
