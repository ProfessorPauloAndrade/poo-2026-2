# Encontro 08 — Atividade: coleções e CRUD de itens

## Contexto e objetivo

Evolua o pedido da cafeteria do encontro 07 para vários itens. Escreva a implementação completa: este pacote contém enunciados e orientações de preenchimento, sem implementação fornecida.

Dados fictícios do catálogo: café de código 101 e preço 5.50; pão de código 202 e preço 8.00; suco de código 303 e preço 4.00. Pedido 10 começa vazio. Catálogo fixo; itens do pedido em uma coleção. Dados somente em memória.

## O que você deve preencher

O arquivo exemplos/aluno/ProjetoPedidoListaInicial.java contém somente comentários de orientação. Não há estrutura Java implementada. Escreva os imports, atributos, construtores, assinaturas, métodos e programa principal.

| Parte | Trabalho a realizar |
|---|---|
| Produto | definir código e preço; criar objetos; consultar dados; controlar alteração de preço |
| ItemPedido | relacionar produto e quantidade; consultar código; controlar quantidade; calcular subtotal; exibir |
| Pedido | definir número e coleção; criar pedido; contar itens; buscar; incluir; consultar; alterar; remover; calcular total; exibir |
| Programa principal | preparar catálogo; criar pedido; mostrar menu; ler entradas; coordenar operações e mensagens |

Justifique as responsabilidades e o que deve ficar protegido em cada classe. Escolha e documente o contrato da busca. Escreva toda a implementação sem copiar a demonstração do professor.

## Regras e menu

- O produto solicitado deve existir no catálogo.
- Cada código pode aparecer no máximo uma vez no pedido; inclusão repetida deve ser recusada.
- Quantidade e preço devem ser positivos; preço deve ser finito.
- Uma operação recusada deve preservar o estado anterior.
- Produto mantém seu preço atual. Pedido controla seus itens e não expõe sua coleção interna.
- Quantidade pertence ao item. Subtotal e total devem respeitar as responsabilidades discutidas na aula.
- Não confunda identidade do produto com posição na coleção.

Menu: 1 listar pedido; 2 incluir item; 3 consultar item; 4 alterar quantidade; 5 remover item; 6 alterar preço; 7 mostrar catálogo; 0 sair. Informe números válidos e preços com ponto. Tratamento de entradas textuais por exceções fica para depois.

## Etapas da atividade

1. **8 minutos:** escreva um experimento com uma lista de produtos. Preveja tamanho e conteúdo antes/depois de incluir, acessar e remover elementos.
2. **7 minutos:** desenhe três itens de códigos 101, 202 e 303. Rastreie a busca de 303 e de 999. Preencha posições visitadas, comparações e resultado.
3. **12 minutos:** escreva busca, inclusão e consulta. Teste pedido vazio, inclusões válidas, repetição, quantidade inválida e código ausente.
4. **15 minutos:** escreva alteração e remoção. Remova o primeiro item e opere sobre o último; investigue se sua identidade foi preservada.
5. **12 minutos de investigação, dentro do laboratório:** um programa defeituoso trata o código informado como posição e foi testado apenas com código zero, fora do catálogo final. Explique o que esse teste esconde. Crie um caso que revele a falha, proponha sua implementação corrigida e comprove seu comportamento.
6. **28 minutos de laboratório no total, incluindo a investigação:** conclua todas as partes do programa, o total e a listagem. Execute o menu completo e registre as evidências.

## Previsão e testes — preencher antes de executar

| Ação, nesta ordem | Itens antes | Total previsto | Resultado observado | Conclusão |
|---|---|---|---|---|
| listar pedido vazio | preencher | preencher | preencher | preencher |
| incluir 101, quantidade 3 | preencher | preencher | preencher | preencher |
| incluir 202, quantidade 2 | preencher | preencher | preencher | preencher |
| alterar preço de 101 para 6.00 | preencher | preencher | preencher | preencher |
| alterar quantidade de 202 para 1 | preencher | preencher | preencher | preencher |
| remover 101 | preencher | preencher | preencher | preencher |
| remover 202 | preencher | preencher | preencher | preencher |

Crie também testes de quantidade zero/negativa, preço zero/negativo/não finito, duplicidade, código 999, remoção do primeiro/intermediário/último, reinclusão após esvaziar e opção desconhecida. Reproduza o caso de um único item da aula 07 e calcule você os resultados esperados. Registre os estados, além das mensagens.

## Entrega e critérios

Entregue programa Java escrito por você, tabela preenchida e justificativas sobre código versus índice, alteração de objeto versus substituição de referência, encapsulamento e responsabilidades.

Critérios: menu completo; operações corretas; recusas preservam estado; remoções preservam a identidade dos demais itens; preço compartilhado se reflete nos cálculos; total e subtotal respeitam as responsabilidades.

Após implementar, compile e execute em uma pasta separada das versões anteriores, com JDK e editor/terminal. Registre um commit no seu Projeto 2 após testar. Sem Internet, mantenha o commit local; sem computador, escreva a proposta e rastreie em papel.
