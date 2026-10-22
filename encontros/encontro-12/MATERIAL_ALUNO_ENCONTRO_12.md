# Encontro 12 — Atividade do Projeto 3

## Objetivo e contexto

Construa o primeiro recorte do estacionamento: veículos de categorias diferentes e histórico de visitas já concluídas, usando um cálculo comum. Trabalhe em uma pasta/repositório próprio poo-projeto-3-estacionamento, preservando o estudo de herança da aula anterior.

Use carro ABC1D23/Hatch e moto XYZ9K87/Urbana. Tarifas fictícias: R$ 10 e R$ 6 por hora iniciada, respectivamente. A duração é informada pelo operador, em minutos inteiros positivos. O tipo geral não deve permitir criação direta; as categorias devem cumprir o compromisso de tarifa. Não há entrada aberta, lavagem, relógio, banco de dados ou pagamento nesta etapa.

O registro concluído guarda número próprio, referência ao veículo, duração e valor calculado. Uma solicitação com placa ausente ou duração inválida é recusada antes de criar registro e consumir número. O histórico deve preservar os valores lançados. Construções diretas deste recorte usam os dados válidos fornecidos; proteções arbitrárias e falhas de conversão serão aprofundadas com exceções.

Recursos: JDK 21 ou posterior, VS Code, terminal e Git. Escreva integralmente a implementação, sem esqueleto pronto. Siga as práticas no momento indicado pelo professor.

## Prática 1 — compromisso e compilação (10 min, dupla)

Adapte sua hierarquia para impedir criação direta do tipo geral e exigir a tarifa das categorias. Faça dois experimentos isolados: tentar criar o tipo geral e deixar uma categoria concreta sem cumprir o compromisso. Registre mensagem, hipótese e correção justificada; não retire a regra apenas para compilar.

## Prática 2 — referências e despacho (12 min, dupla)

Reúna categorias diferentes em uma coleção tipada pelo tipo comum. Preveja a implementação usada em cada consulta, execute e inverta a ordem. Desenhe referência e objeto, sem copiar objetos desnecessariamente.

| Referência observada | Tipo declarado | Classe do objeto | Previsão de chamada | Observação |
|---|---|---|---|---|
| | | | | |
| | | | | |

## Prática 3 — regra de horas iniciadas (12 min, dupla)

Implemente o cálculo compartilhado e teste as fronteiras. Compare com uma variante experimental que descarta a fração cedo demais. Identifique um teste que diferencia as duas organizações; mantenha somente a versão coerente no projeto.

| Categoria | Minutos | Previsão de horas/valor | Valor observado | Justificativa |
|---|---|---|---|---|
| Carro | 1 | | | |
| Carro | 60 | | | |
| Carro | 61 | | | |
| Carro | 75 | | | |
| Moto | 75 | | | |
| Moto | 120 | | | |

## Rastreamento do registro (8 min, dupla)

Desenhe o gestor, o cadastro e o registro produzido após uma solicitação válida. Compare com duração inválida e placa ausente. Anote os dados que permanecem e justifique quando o número avança.

## Prática 4 — argumentos e referências (8 min, individual)

Compare alterar o modelo do objeto recebido em um método e reatribuir somente o parâmetro local a outro veículo. Preveja e observe o que o chamador mantém em cada experimento. Se usar uma verificação de tipo, explique qual pergunta ela responde.

| Experimento | Referência antes | Previsão de estado/referência depois | Observação | Explicação |
|---|---|---|---|---|
| Alteração de estado | | | | |
| Reatribuição local | | | | |

## Laboratório de revisão (18 min, dupla)

Uma revisão levantou três hipóteses de defeito: tarifa decidida pelo tipo declarado da variável; perda da fração da duração antes do arredondamento; troca de referência esperada após reatribuição somente de um parâmetro. Proponha experimentos que diferenciem essas hipóteses, confira sua implementação e produza um parecer.

Use 61 minutos do carro e 75 da moto, compare com 60 minutos e inverta a ordem na coleção. Faça uma recusa entre dois registros válidos. Registre previsão, resultado, estado e motivo. Não basta testar apenas um total.

| Hipótese | Experimento que pode distingui-la | Previsão | Observação | Parecer |
|---|---|---|---|---|
| | | | | |
| | | | | |
| | | | | |

## Entrega e critérios

Entregue implementação própria, desenho, tabelas e parecer. Mostre criação restrita às categorias, cálculo comum, tarifa fornecida pelo objeto real e histórico sem registro parcial. Explique estado compartilhado versus referência local com um efeito observável. Preserve versões e registre seus testes no commit.

Sem Internet, faça commit local e envie depois. Sem computador, use desenhos e rastreamentos em papel. Não acrescente dados pessoais, credenciais ou funcionalidades que dependam de conceitos ainda não estudados.
