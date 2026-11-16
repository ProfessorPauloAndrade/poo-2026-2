# Material do aluno — Encontro 3

## Objetivo

Completar em Java um caixa procedural de cantina que decide entre opções, repete o menu e organiza o código em pequenos métodos.

## Contexto

Durante um intervalo, uma pessoa opera o caixa da cantina. Ela informa uma opção e, ao registrar uma venda, informa o valor pago. O programa deve:

- registrar apenas valores positivos;
- acumular o total das vendas válidas;
- permitir consultar o total atual;
- rejeitar opções desconhecidas;
- continuar exibindo o menu até a opção `0`.

O programa não controla produtos, estoque, pessoas ou pagamentos. Essas decisões ficam fora deste exercício.

## Ponto de partida

Copie `exemplos/encontro-3/aluno/CaixaCantinaInicial.java` para `exercicios/encontro-3/CaixaCantina.java`. Altere o nome da classe pública para `CaixaCantina`.

Trabalhe em dupla. Antes de executar cada alteração, escreva ou diga qual saída espera observar.

**Tempo sugerido:** 70 minutos.

## Parte 1 — Complete a decisão de uma venda

No método `registrarVenda`, use `if` para distinguir dois casos:

1. `valor <= 0`: mostrar `Valor invalido.` e devolver o total sem mudança;
2. valor positivo: somar o valor, mostrar `Venda registrada.` e devolver o novo total.

O método precisa sempre devolver um `double`.

## Parte 2 — Mostre o total

No método `mostrarTotal`, use `System.out.printf(Locale.US, ...)` para exibir:

~~~text
Total: R$ 15.50
~~~

Use duas casas decimais e `%n` para terminar a linha.

## Parte 3 — Controle o menu

Dentro do `do-while`, use `switch` para tratar:

- `case 1`: ler o valor e atualizar `total` com o retorno de `registrarVenda`;
- `case 2`: chamar `mostrarTotal`;
- `case 0`: mostrar `Caixa encerrado.`;
- `default`: mostrar `Opcao invalida.`.

Use `break` ao final de cada caso. O laço deve continuar enquanto `opcao != 0`.

## Parte 4 — Preveja e teste

Execute os casos na ordem. Registre a previsão e o que realmente aconteceu.

| Caso | Entradas | Resultado esperado |
|---|---|---|
| A | `2`, `0` | total `R$ 0.00`; encerra |
| B | `1`, `10.00`, `1`, `5.50`, `2`, `0` | total `R$ 15.50`; encerra |
| C | `1`, `-2.00`, `2`, `0` | valor inválido; total `R$ 0.00` |
| D | `9`, `0` | opção inválida; menu reaparece; encerra |

Se um resultado divergir, classifique o problema antes de editar: erro de compilação, erro de execução ou erro lógico.

## Parte 5 — Explique a estrutura

No seu caderno ou em um arquivo de anotações, responda:

1. Por que `do-while` é apropriado para o menu?
2. Qual é a diferença entre o parâmetro `valor` e o argumento digitado pelo usuário?
3. Por que a chamada usa `total = registrarVenda(total, valor)` em vez de apenas `registrarVenda(total, valor)`?
4. Qual responsabilidade ficou no `main` e qual ficou em cada método?

## Parte 6 — Registre a versão

~~~text
git add exercicios/encontro-3/CaixaCantina.java
git commit -m "Organiza caixa com fluxo e metodos"
~~~

Se o GitHub estiver disponível, faça o push. Sem Internet, preserve o commit local.

## Produto esperado

- `CaixaCantina.java` compilado e executado;
- quatro casos de teste realizados;
- respostas curtas sobre laço, parâmetros, retorno e responsabilidades;
- commit local descritivo.

## Critérios de conclusão

- [ ] o menu aparece pelo menos uma vez;
- [ ] as opções `0`, `1`, `2` e uma opção inválida têm comportamentos distintos;
- [ ] somente vendas positivas alteram o total;
- [ ] o total de duas vendas válidas é acumulado corretamente;
- [ ] `registrarVenda` recebe parâmetros e devolve o novo total;
- [ ] `mostrarMenu` e `mostrarTotal` não devolvem valor;
- [ ] todos os caminhos do método que retorna `double` possuem `return`;
- [ ] os quatro casos foram testados;
- [ ] existe um commit descritivo.

## Dica inicial

Se o menu aparece, mas a opção não produz efeito, confira primeiro se o `switch` está dentro do `do-while` e se cada `case` termina com `break`.

## Desafio opcional

Adicione a opção `3 - Aplicar desconto`. Leia uma porcentagem entre `0` e `100` e devolva o total com o desconto aplicado. Preserve o total quando a porcentagem for inválida. Crie um método com parâmetros e retorno para essa regra.

## Se a Internet falhar

Continue com edição, compilação, execução, testes e commit local. O material e o código não dependem de serviço on-line.
