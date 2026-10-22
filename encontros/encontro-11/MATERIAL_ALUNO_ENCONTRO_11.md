# Encontro 11 — Atividade: herança no cadastro de veículos

## Objetivo e ponto de partida

Você vai comparar duas organizações de um cadastro: classes de carro e moto independentes; depois uma generalização que concentre o que for comum. Use Java, VS Code, terminal e Git. A aula 10 fornece a base sobre encapsulamento, validação e representação textual. Não é necessário importar o sistema de cafeteria.

O operador conhece placa e modelo de cada veículo e precisa consultar esses dados e corrigir o modelo. A placa não muda. O modelo não pode ser nulo ou vazio após retirar espaços externos; uma recusa preserva o valor anterior. A descrição deve identificar a categoria, placa e modelo, sem alterar o objeto. As tarifas fictícias são R$ 10/h para carro e R$ 6/h para moto; nesta etapa somente as consultamos, sem calcular permanências.

Use carro ABC1D23/Hatch e moto XYZ9K87/Urbana. Todos os dados iniciais fornecidos são válidos. A proteção de construção arbitrária e as entradas numéricas inválidas ainda não fazem parte do recorte.

## Prática 1 — comparar responsabilidades (10 min, dupla)

Leia as necessidades e classifique dados e comportamentos entre comuns, específicos e fora do escopo. Explique a razão de cada decisão. Proponha um teste que revele uma regra comum alterada em apenas uma categoria.

| Informação ou comportamento | Classificação proposta | Justificativa | Teste relacionado |
|---|---|---|---|
| | | | |
| | | | |
| | | | |
| | | | |

## Prática 2 — extrair o comum (15 min, dupla)

Construa suas classes a partir dos requisitos, preservando uma versão anterior para comparar. Decida onde declarar os dados, como protegê-los e como os construtores colaboram. Evite dados comuns duplicados ou um objeto adicional sem necessidade.

Consulte placa/modelo, faça uma alteração válida e outra vazia. Registre as observações e a localização da regra de alteração. Critério: a refatoração preserva o comportamento e concentra a responsabilidade comum.

## Microinvestigação — estado compartilhado indevidamente (8 min, individual)

Um colega tornou o modelo estático para “evitar repetição”. Criar um segundo carro alterou a descrição do primeiro. Desenhe os objetos e o campo consultado, proponha um teste e explique o problema. Não basta dizer que existe um erro: identifique a decisão responsável.

## Prática 3 — descrição das categorias (12 min, dupla)

Adapte a descrição para indicar a categoria e aproveitar a montagem dos dados comuns. Obtenha o texto em uma variável antes de imprimir, altere um cadastro e consulte novamente. Critérios: operação com assinatura adequada, nenhuma impressão ou alteração interna na descrição e comportamento específico das categorias.

## Laboratório de revisão (24 min, dupla)

Uma equipe propôs colocar modelo em static, redeclarar placa em uma categoria, acrescentar um parâmetro ao método de descrição e fazer um serviço de lavagem derivar do tipo de veículo. Produza um parecer sobre cada proposta e proponha uma organização coerente. Desenhe e teste sua própria implementação; não é necessário implementar o serviço de lavagem.

Acrescente um segundo carro QWE4R56/Sedan. Altere somente o primeiro carro para Compacto. Investigue modelo vazio, espaços e nulo por chamada direta. Verifique descrição e tarifa antes e depois. Não receba uma solução pronta para preencher a tabela.

| Cenário | Previsão | Observação | Estado anterior/posterior | Justificativa |
|---|---|---|---|---|
| Alterar somente o primeiro carro | | | | |
| Propor modelo vazio | | | | |
| Propor apenas espaços | | | | |
| Propor modelo nulo | | | | |
| Obter descrição repetidamente | | | | |
| Consultar tarifa após alterar modelo | | | | |

## Produto e conclusão

Entregue as duas versões, tabela de testes, desenho da organização e parecer. Justifique uma escolha e mostre um caso que falharia com uma proposta incorreta. Regra comum concentrada, estado independente, preservação diante de recusa e descrição sem efeito colateral são os critérios principais.

Salve no repositório de exercícios, mantendo suas versões. O repositório próprio do Projeto 3 será criado no encontro 12. Em caso de falha de Internet, faça commit local e envie depois. Sem computador, entregue desenhos e rastreamentos em papel.
