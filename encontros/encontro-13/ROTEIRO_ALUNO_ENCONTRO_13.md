# Encontro 13 — Meu registro da prática

Nome(s): ____________________  Data: ____________________  Commit inicial: ____________________

Use este roteiro junto com o `MATERIAL_ALUNO_ENCONTRO_13.md`. Escreva o que você previu e o que observou. Não escreva apenas OK.

## 1. Primeira execução

| Item | O que observei |
|---|---|
| Pasta aberta no editor | ___ |
| Versão de `java` e de `javac` | ___ |
| Resultado de `iniciar` | ___ |
| Resumo inicial de `verificar` | ___ |

## 2. Registro por tarefa

| TODO | O que a tarefa pede, com minhas palavras | Caso que testei e minha previsão | O que observei | Método alterado |
|---|---|---|---|---|
| 13.1 | ___ | ___ | ___ | ___ |
| 13.2 | ___ | ___ | ___ | ___ |
| 13.3 | ___ | ___ | ___ | ___ |
| 13.4 | ___ | ___ | ___ | ___ |
| 13.5 | ___ | ___ | ___ | ___ |
| 13.6 | ___ | ___ | ___ | ___ |
| 13.7 | ___ | ___ | ___ | ___ |

## 3. Uma visita, do começo ao fim (Parte 1)

Preencha com a moto `XYZ9K87` e 61 minutos.

| Chamada | Minha previsão | Resultado | Estado da visita depois |
|---|---|---|---|
| `estaEncerrada()` | ___ | ___ | ___ |
| `getMinutos()` | ___ | ___ | ___ |
| `encerrar(0)` | ___ | ___ | ___ |
| `encerrar(61)` | ___ | ___ | ___ |
| `calcularValor()` | ___ | ___ | ___ |
| `encerrar(30)` | ___ | ___ | ___ |

## 4. Os experimentos com o compilador (Partes 2 e 4)

| Experimento | Mensagem de erro que apareceu | O que ela está cobrando |
|---|---|---|
| Apagar um método do contrato em `Lavagem` | ___ | ___ |
| Tirar o `public` de um método do contrato | ___ | ___ |
| Criar um terceiro recibo mudando só o retorno | ___ | ___ |

## 5. As listas do gestor, passo a passo (Parte 3)

| Operação ou tentativa | ativas depois | cobrancas depois | Próximo número | Total |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

Três recusas que testei e o que conferi depois de cada uma:

| Tentativa recusada | Retorno | O que continuou igual |
|---|---|---|
| ___ | ___ | ___ |
| ___ | ___ | ___ |
| ___ | ___ | ___ |

## 6. Comparações de texto (Parte 5)

| Comparação | Pergunta que ela responde | Minha previsão | Resultado |
|---|---|---|---|
| ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ |

## 7. Perguntas para explicar o que implementei

Responda com um exemplo do estacionamento em cada resposta.

**Parte 1**

1. Que dados da visita existem na entrada e quais ainda não existem?
2. Por que não usamos zero para os minutos de uma visita aberta?
3. O que é uma classe wrapper? O que são boxing e unboxing?
4. O que acontece ao fazer unboxing de uma variável que vale `null`?
5. Que teste mostra que uma saída recusada não alterou a visita?

**Parte 2**

6. O que é uma interface? O que ela declara e o que ela não tem?
7. O que uma classe precisa fazer para implementar `Cobravel`?
8. Por que `Lavagem` não estende `Permanencia`?
9. Qual é a diferença entre a classe abstrata `Veiculo` e a interface `Cobravel`?

**Parte 3**

10. Por que a lista `cobrancas` é do tipo `Cobravel`?
11. O que precisa acontecer com as listas e com a numeração em uma lavagem aceita?
12. Por que o histórico pode ficar na ordem 1, 3, 2?

**Parte 4**

13. O que é sobrecarga? Como o compilador escolhe a versão?
14. Qual é a diferença entre sobrecarga e sobrescrita? Dê um exemplo de cada no projeto.
15. Por que imprimir um recibo não pode alterar o histórico?

**Parte 5**

16. Qual pergunta cada uma destas formas responde: `==`, `equals` e `compareTo`?
17. Por que comparar a placa digitada com `==` pode falhar?

## 8. Critérios de entrega

- [ ] Completei as sete tarefas e mantive o comportamento da aula 12.
- [ ] O verificador mostra `OK=6 PENDENTE=0 REVER=0`.
- [ ] Fiz os três experimentos com o compilador e anotei as mensagens.
- [ ] Conferi as listas depois de cada operação, e não só o total.
- [ ] Resolvi o laboratório com previsões próprias e um teste por proposta.
- [ ] Entrego apenas fontes e registros, sem `build/`, `target/` ou `.class`.

Commit final: ____________________

Pendências e limites que conheço na minha versão: ____________________
