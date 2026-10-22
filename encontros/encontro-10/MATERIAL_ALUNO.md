# Encontro 10 — Atividade: validação, representação e comparação

## Propósito e ponto de partida

Conclua seu Projeto 2: preserve os relacionamentos e o CRUD do encontro 09 e construa operações que mantenham dados válidos, descrições textuais úteis e um critério de comparação coerente para Produto. Use sua implementação anterior. Retome seu código nos `TODO`s de continuidade do esqueleto e complete as novas tarefas. O esqueleto fornece a estrutura básica; as decisões e a solução são suas.

O arquivo `exemplos/aluno/ProjetoPedidosConfiaveisInicial.java` contém imports, classes, atributos, construtores, assinaturas, sobrescritas e menu. Ele compila e abre antes do preenchimento. Complete os `TODO`s de validação, representação, igualdade e hash, retomando seu CRUD e os relacionamentos do encontro 09. Os vínculos `null`, textos de representação e retornos são provisórios; `equals` e `hashCode` ainda usam a identidade herdada de `Object`. Seu projeto deve continuar no repositório próprio do Projeto 2.

## Dados do caso fictício e limites

Catálogo fixo: café 101/5.50, pão 202/8.00, suco 303/4.00. Clientes Ana/1 e Bruno/2. Pedidos 10 e 20 inicialmente vazios e pertencentes a Ana, cada um com ficha exclusiva e guichê inicial 1. Senha igual ao número do pedido. Itens locais podem compartilhar a referência do mesmo produto do catálogo.

Cadastros iniciais são preparados com dados válidos; códigos e números positivos/únicos, preços válidos e cliente existente. Não há persistência. O menu recebe números no formato esperado. Não é exigido tratamento de exceções, coleção de hash ou cadastro aberto de entidades.

## O que você deve escrever

| Parte | Trabalho a completar |
|---|---|
| Validação | definir e implementar as regras no objeto responsável; testar operações aceitas e recusadas |
| Representação | escrever descrições que devolvam texto útil sem imprimir ou alterar o estado |
| Comparação de Produto | aplicar a política do projeto: mesma classe e mesmo código identificam o produto; preço pode mudar |
| Hash | escrever uma versão coerente com a política de igualdade escolhida |
| Integração | preservar menu, consultas, vínculos e CRUD; demonstrar as novas decisões |

Requisitos de alteração: preço positivo e finito; quantidade e guichê positivos; nome não nulo nem vazio após remover espaços nas extremidades. Item ausente e duplicidade local devem ser tratados com segurança. Toda recusa deve preservar o estado anterior. Não exponha a lista de itens.

## Práticas distribuídas

1. **12 min, dupla — validação:** escolha preço e outro dado; escreva a regra, implemente e teste diretamente pelo objeto. Use valor válido, zero, negativo e, para nome, nulo/espaços. Preveja retorno e estado antes de executar.
2. **12 min, individual — representação:** escreva uma descrição de classe e integre ao pedido. Guarde o texto, imprima o objeto e repita a consulta. Compare saída e estado.
3. **15 min, dupla — comparação:** construa referências ao mesmo objeto, objetos distintos de mesmo código e produtos de códigos diferentes. Investigue também nulo, outro tipo e mudança de preço. Registre previsões para identidade, igualdade e hash e desenhe as referências.
4. **4 min, individual — contrato:** julgue e justifique: igualdade exige mesmo hash? Mesmo hash exige igualdade? Preço diferente implica outro produto? Comparar pode unir instâncias?

Produto de cada prática: implementação própria, tabela de previsões/resultados e justificativa. Critérios: regra explícita, estado preservado, texto útil e contratos coerentes. O professor fará retorno após cada bloco.

## Laboratório — O relatório passou a decidir a igualdade

**25 minutos, dupla.** Um relatório novo precisa destacar preço e quantidade. Um colega propõe comparar os textos dos produtos para decidir igualdade; outro quer colocar o preço apenas no hash. Investigue as propostas sem receber implementação ou contraexemplo prontos.

Crie seus próprios casos para distinguir aparência da saída, identificação e estado mutável. Considere ainda a afirmação de que dois pedidos de Ana seriam iguais apenas porque pertencem à mesma cliente. Escreva e defenda uma política para os pedidos, sem implementar novos contratos indiscriminadamente.

Entregue um parecer com testes que sustentem ou refutem cada proposta, suas decisões de modelagem e uma versão consistente do Projeto 2. Sucesso: evidência reproduzível, justificativa pelo contrato pertinente e preservação do CRUD anterior.

## Tabelas para preencher

| Dado/operação | Estado antes | Tentativa | Previsão | Retorno observado | Estado depois | Justificativa |
|---|---|---|---|---|---|---|
| preencher | preencher | preencher | preencher | preencher | preencher | preencher |
| preencher | preencher | preencher | preencher | preencher | preencher | preencher |
| preencher | preencher | preencher | preencher | preencher | preencher | preencher |

| Referências e dados iniciais | Previsão identidade | Previsão igualdade | Previsão hash | Resultado | Explicação |
|---|---|---|---|---|---|
| preencher | preencher | preencher | preencher | preencher | preencher |
| preencher | preencher | preencher | preencher | preencher | preencher |
| preencher | preencher | preencher | preencher | preencher | preencher |

| Proposta do laboratório | Hipótese | Teste próprio | Resultado | Decisão e critério |
|---|---|---|---|---|
| preencher | preencher | preencher | preencher | preencher |
| preencher | preencher | preencher | preencher | preencher |

## Conclusão e alternativa sem computador

Confira pedido vazio, inclusão, consulta, alteração, remoção, reinclusão, duplicidade local e códigos ausentes. Teste também efeitos compartilhados e isolamento entre pedidos. Registre o que estava previsto e o que foi observado, sem preencher a previsão depois da execução.

Faça commit e envie ao repositório próprio do Projeto 2. Saída individual de 3 min: qual problema você resolveu, em qual classe ficou a decisão e qual teste a sustenta? Sem Internet, use o material baixado e faça commit local; sem computador, entregue diagramas e tabelas em papel para posterior implementação. Use apenas dados fictícios.
