# Encontro 13 — Atividade dos estudantes

## Objetivo e preparação

Evoluir seu estacionamento para visitas em andamento e cobranças de serviços distintos, justificando contratos, estados e testes. Use seu repositório próprio do Projeto 3 e preserve a versão da aula 12. Recursos: JDK 21+, VS Code, terminal e Git. Sem bibliotecas externas, datas ou banco de dados.

O operador conhece a placa na entrada, mas só informa minutos inteiros positivos na saída. Carro: 10 por hora iniciada; moto: 6; lavagem: 20 fixos. São regras fictícias. A lavagem exige visita aberta, não a encerra e pode se repetir. Há no máximo uma visita aberta por placa; histórico e total incluem somente cobranças finalizadas. Números não se repetem e só avançam após criação aceita.

Você deve escrever integralmente sua implementação: imports, tipos, campos, construção, operações, fluxo de interação e testes. Este material fornece requisitos e critérios, sem estrutura Java pronta. Reaproveite sua solução anterior com justificativa, sem copiar classes de versões diferentes na mesma compilação.

## Práticas distribuídas

1. **Estados e dados ausentes — 12 min em dupla.** Desenhe entrada, saída válida e saída recusada; represente dados ainda desconhecidos sem os confundir com zero. Evolua a mesma visita e teste preservação de estado. Produto: desenho, implementação e tabela; critério: transição coerente e ausência explícita.
2. **Contrato comum — 10 min em dupla.** Especifique as informações/operações necessárias ao relatório e faça os dois registros distintos cumpri-las. Em cópia isolada, experimente descumprir uma obrigação e interpretar a compilação. Produto: experimento e rastreamento; critério: compromisso compatível e uso sem escolher manualmente cada tipo.
3. **Integração — 12 min em dupla.** Registre entradas, uma lavagem durante a visita e uma saída; tente lavagem após saída e saída com duração inválida. Produto: teste com listas, números e total antes/depois; critério: recusa sem mudança e cobrança independente sem duplicação.
4. **Recibos — 10 min em dupla.** Crie duas formas de chamada com mesmo nome, uma simples e outra com observação. Experimente em arquivo separado uma mudança apenas no retorno. Produto: saídas e interpretação; critério: diferença nos parâmetros e apresentação sem lançar outra cobrança.
5. **Comparações — 6 min individual.** Use textos de placa de objetos distintos, mesmo conteúdo e conteúdos diferentes; inclua normalização. Investigue também a ausência de dado numérico. Produto: tabela e justificativa; critério: identidade, conteúdo e ordem distinguidos, sem operação numérica sobre valor ausente.

## Tabelas para previsão e conferência

| Passo planejado | Dados conhecidos e ausentes | Estado previsto | Estado observado | Justificativa |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

| Operação / tentativa | Ativas antes/depois | Histórico antes/depois | Números | Total previsto/observado |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

| Comparação escolhida | Pergunta que responde | Previsão | Observação | Risco de coincidência |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

## Laboratório — 18 minutos em dupla

Nova execução: entre com carro e moto; faça duas lavagens da moto; encerre o carro com 31 minutos e depois a moto com 121. Consulte recibos repetidamente. Preveja cada estado e o total antes de executar.

Investigue propostas de revisão: somar abertas como zero; incluir o preço da lavagem também na permanência; registrar outra cobrança ao imprimir recibo; localizar placa digitada pela identidade do texto. Crie testes que distingam cada proposta do comportamento correto. Não basta ajustar o total final para coincidir com uma previsão.

Entregue parecer, desenho de objetos/referências, previsões e testes. Critérios: registro de cada serviço uma vez; histórico só finalizado; valor preservado; recibo sem alteração de negócio; compromisso comum utilizado; comparação de texto adequada. Respostas e totais devem ser calculados por você.

| Proposta examinada | Teste discriminante | Resultado esperado | Resultado observado | Decisão justificada |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

## Fechamento

Registre a evolução e seus testes em commit no repositório próprio. Declare limites: tratamento amplo de falhas e entradas numéricas inválidas virá em 14; organização e coleções por chave em 15. Alternativa sem computador: desenhos, previsões e parecer em papel. Não é necessário informar dados pessoais.
