# Encontro 09 — Atividade: relacionamentos entre pedidos

## Objetivo e ponto de partida

Evolua a sua implementação do Projeto 2 para representar um cliente com vários pedidos e uma ficha exclusiva para cada pedido. Preserve o CRUD de itens do encontro 08. Use o esqueleto fornecido para organizar as partes ainda pendentes e retome seu código anterior nos `TODO`s de continuidade. As novas relações e operações devem ser completadas por você.

## Dados do caso fictício

Clientes cadastrados: Ana, código 1; Bruno, código 2. Dois pedidos iniciais, de números 10 e 20, pertencem a Ana. Bruno começa sem pedido. Cada pedido nasce vazio, com uma ficha de retirada. Senha da ficha igual ao número do pedido; guichê inicial 1.

Catálogo fixo: café 101/5.50; pão 202/8.00; suco 303/4.00. Os cadastros de clientes e pedidos são preparados no início. A lista de itens é dinâmica. Dados somente em memória.

## O que escrever

O arquivo `exemplos/aluno/ProjetoPedidosRelacionadosInicial.java` fornece imports, classes, atributos, construtores, assinaturas e menu executável. Complete os `TODO`s. No construtor de `Pedido`, substitua os dois `null`s provisórios pelos vínculos adequados; implemente também consultas, delegações e as operações retomadas do encontro 08. O menu abre antes do preenchimento, mas ainda não realiza os requisitos.

| Parte | Trabalho do aluno |
|---|---|
| Produto | preservar código, preço e alteração controlada |
| ItemPedido | preservar vínculo com produto, quantidade, subtotal e exibição |
| Cliente | conferir identificação, nome e consultas; completar a alteração controlada |
| FichaRetirada | conferir senha, guichê e consultas; completar a alteração controlada |
| Pedido | relacionar cliente, ficha e itens; conservar CRUD e total; oferecer operações sem expor partes |
| Programa principal | completar as buscas e a consulta por cliente; conferir a seleção e as operações no menu fornecido |

Regras: cada pedido tem um cliente cadastrado e uma ficha exclusiva. Cliente pode não ter pedidos ou ter vários. Itens pertencem a um único pedido; produto do catálogo pode ser usado em vários. Código repetido é recusado dentro do mesmo pedido. Quantidade e guichê positivos; preço positivo e finito; alteração de nome não aceita texto vazio. Operações recusadas preservam o estado.

Ao solicitar pedido inexistente, preserve a seleção anterior. Distinga cliente inexistente de cliente cadastrado sem pedidos. Não copie o nome do cliente nem o preço do produto para esconder vínculos incorretos. Decida e justifique como consultar os pedidos do cliente sem manter duas estruturas desnecessárias.

## Práticas durante a aula

1. **12 min — multiplicidade:** escreva duas frases para cada relação Cliente/Pedido, Pedido/ItemPedido e ItemPedido/Produto; desenhe um estado válido e um inválido. Preencha os limites nas duas extremidades.
2. **12 min — ficha:** implemente sua representação exclusiva, crie dois pedidos, altere só um guichê e teste valor inválido. Registre estados antes/depois.
3. **15 min — cliente:** relacione os dois pedidos ao mesmo cliente. Consulte Ana, Bruno e um código inexistente. Altere o nome de Ana e investigue o efeito nos pedidos.
4. **15 min — CRUD:** inclua o mesmo produto em pedidos diferentes com quantidades distintas. Altere/remova no primeiro e consulte o segundo. Teste repetição local, ausência e preço compartilhado.

Cada tempo está incluído no bloco da aula; reserve o retorno orientado pelo professor. Entregas: desenho, implementação própria e tabelas preenchidas. Não basta apresentar mensagens de sucesso: confira o estado dos objetos.

## Laboratório — Um terceiro pedido expôs uma falha

**25 minutos, em dupla.** Um colega acrescentou pedido 30 de Bruno. O programa lista esse pedido para Ana; alterar o guichê de 30 também muda o guichê de 20. Os totais continuam corretos.

- Formule hipóteses sobre os vínculos envolvidos e escreva como distinguir essas hipóteses com testes.
- Na sua implementação, acrescente o terceiro pedido e investigue as consultas e alterações.
- Escreva a correção necessária, desenhe antes/depois e demonstre a preservação do CRUD.

Entrega: código próprio, diagrama e evidências. Critério: explicar as duas falhas em termos dos vínculos e confirmar isolamento e compartilhamento nos casos pertinentes. Não receberá trecho defeituoso ou correção prontos.

## Folhas para preencher

| Relação | Para um objeto A, quantos B? | Para um B, quantos A? | Exemplo válido | Violação |
|---|---|---|---|---|
| Cliente/Pedido | preencher | preencher | desenhar | desenhar |
| Pedido/FichaRetirada | preencher | preencher | desenhar | desenhar |
| Pedido/ItemPedido | preencher | preencher | desenhar | desenhar |
| ItemPedido/Produto | preencher | preencher | desenhar | desenhar |

| Operação | Vínculos e valores antes | Previsão individual | Observado nos pedidos | Conclusão |
|---|---|---|---|---|
| criar pedidos 10 e 20 | preencher | preencher | preencher | preencher |
| incluir café nos dois, com quantidades distintas | preencher | preencher | preencher | preencher |
| alterar quantidade somente em 10 | preencher | preencher | preencher | preencher |
| remover item somente de 10 | preencher | preencher | preencher | preencher |
| alterar preço do catálogo | preencher | preencher | preencher | preencher |
| alterar nome de Ana | preencher | preencher | preencher | preencher |
| alterar guichê somente de 20 | preencher | preencher | preencher | preencher |
| solicitar pedido inexistente | preencher | preencher | preencher | preencher |
| consultar cliente sem pedidos e cliente ausente | preencher | preencher | preencher | preencher |
| acrescentar pedido 30 e investigar a falha | preencher | preencher | preencher | preencher |

Crie testes adicionais de duplicidade, zero/negativos, nome vazio, preço não finito, remoção intermediária e reinclusão. Calcule os resultados esperados antes de executar. Refaça os testes da sua aula 08 num único pedido.

## Menu e entrega

Menu previsto: 1 listar; 2 incluir item; 3 consultar item; 4 alterar quantidade; 5 remover item; 6 alterar preço; 7 catálogo; 8 selecionar pedido; 9 guichê; 10 clientes; 11 pedidos do cliente; 12 nome do cliente; 0 sair. No laboratório, acrescente pedido 30 à preparação e permita selecioná-lo.

Use JDK, editor e terminal. Entradas numéricas válidas, preços com ponto. Exceções e persistência ficam para depois. Compile em pasta separada das versões anteriores e registre uma versão testada no seu repositório do Projeto 2. Entregue programa, diagramas, tabelas e justificativas. Sem Internet, commit local; sem computador, representação e rastreamento em papel.

## Saída individual

Dois pedidos com o mesmo cliente violam alguma regra? Por que compartilhar a ficha é diferente? Descreva um teste que distinga quantidade local e preço compartilhado. Justifique com o seu desenho.
