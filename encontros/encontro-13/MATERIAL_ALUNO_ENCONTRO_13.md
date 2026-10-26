# Encontro 13 — construção guiada: Interfaces e cobranças

## O que você terá ao final

Você recebe a hierarquia e o cálculo da etapa anterior. A visita passa a nascer aberta, com duração e valor ainda ausentes. Você completará a transição para encerrada, conectará permanência e lavagem ao contrato Cobravel e integrará entrada, saída, recibos e histórico.

Carro: R$ 10 por hora iniciada; moto: R$ 6; lavagem, quando introduzida na aula 13, R$ 20 fixos. Minutos são informados manualmente. Dados são fictícios e ficam em memória. Placa identifica o cadastro e não muda; modelo pode mudar. Use os cadastros comuns ABC1D23/Hatch e XYZ9K87/Urbana. As atividades abaixo distinguem exemplos comuns da investigação que você deve resolver.

## Preparação — antes de editar

Siga a primeira execução no [README](README.md). Salve o resultado inicial do verificador e uma cópia da etapa anterior. Leia o console para identificar as chamadas; não reescreva o menu inteiro. Abra os arquivos desta aula, procure `TODO 13.` e associe-os à tabela. Você preencherá os corpos e as pequenas alterações indicadas, mantendo a base conhecida. Os experimentos que devem falhar na compilação ficam fora de src e testes.

## Onde trabalhar

| TODO | Arquivo | Trecho a completar ou revisar |
|---|---|---|
| 13.1 | `src/Permanencia.java` | estaEncerrada, encerrar, getDescricao e calcularValor |
| 13.2 | `src/Permanencia.java` e `src/Lavagem.java` | declaração de implementação e operações do contrato |
| 13.3 | `src/Lavagem.java` | construtor e calcularValor |
| 13.4 | `src/Estacionamento.java` | registrarEntrada, registrarSaida e registrarLavagem |
| 13.5 | `src/Estacionamento.java` | totalizarCobrancas |
| 13.6 | `src/AplicacaoConsole.java` | duas versões de imprimirRecibo |
| 13.7 | `src/AplicacaoConsole.java` | mesmaPlaca e compararPlacas |

## Sequência de construção

### TODO 13.1 — estaEncerrada, encerrar, getDescricao e calcularValor

Abra `src/Permanencia.java`.

Conserve ausência de minutos/valor enquanto aberta. Nesta versão, encerramento inválido ou repetido retorna false sem mudar o objeto. Para encerrar, use a regra de tarifa já fornecida e registre duração/valor na mesma visita. Valor de aberta não deve entrar em soma; use a convenção de ausência desta etapa.

**Como conferir:** Cheque 13.1; desenhe a mesma referência antes/depois e investigue null sem unboxing prematuro.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 13.2 — declaração de implementação e operações do contrato

Abra `src/Permanencia.java` e `src/Lavagem.java`.

Leia Cobravel.java fornecido. Conecte os dois tipos ao contrato e confira acesso público, nomes, parâmetros e retornos das quatro operações. Compare uma base de veículos com esse papel de cobrança.

**Como conferir:** Cheque 13.2; remova uma obrigação apenas em cópia isolada e registre o erro de compilação.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 13.3 — construtor e calcularValor

Abra `src/Lavagem.java`.

Guarde o número e o veículo recebidos e use o preço fixo declarado. O serviço não é subclasse de Veiculo e não altera a duração ou o valor da permanência.

**Como conferir:** Cheque 13.3: lavagem número 3 da moto custa 20, independentemente de minutos.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 13.4 — registrarEntrada, registrarSaida e registrarLavagem

Abra `src/Estacionamento.java`.

Complete uma operação por vez usando as buscas disponíveis. Entrada aceita cria uma aberta; duplicada retorna false. Saída recusada retorna null e preserva a visita; aceita encerra a mesma referência e a transfere para o histórico. Lavagem exige aberta e cria uma cobrança independente sem fechar a visita. Consuma número apenas quando criar registro aceito.

**Como conferir:** Cheque integrado 13.4/13.5; observe ativas e histórico após cada passo, não apenas o total.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 13.5 — totalizarCobrancas

Abra `src/Estacionamento.java`.

Some pelo contrato comum sem selecionar concretamente permanência ou lavagem. Apenas cobranças finalizadas entram no histórico.

**Como conferir:** No exemplo comum: saída do carro 75 + lavagem da moto produzem parcial 40; após saída da moto 20, total 46 e ordem 1,3,2.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 13.6 — duas versões de imprimirRecibo

Abra `src/AplicacaoConsole.java`.

Complete a forma simples com número, placa, descrição e valor. A forma com observação deve aproveitar a primeira e apresentar o texto adicional. As duas são consultas, sem registrar outra cobrança.

**Como conferir:** Cheque 13.6 verifica as chamadas; confira visualmente os campos e repita menu 6 comparando histórico/total.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 13.7 — mesmaPlaca e compararPlacas

Abra `src/AplicacaoConsole.java`.

Complete as duas operações auxiliares com as perguntas adequadas: igualdade de conteúdo e sinal de ordem. Os argumentos desses auxiliares já são normalizados. Relacione com as buscas e com a ordenação discutidas nos slides.

**Como conferir:** Cheque 13.7 usa dois objetos String de mesmo conteúdo; acrescente ordem inversa e igualdade.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

## Acompanhamento durante a aula — 210 minutos com pausa

Use os blocos abaixo para acompanhar a explicação e as práticas; os TODOs ocupam os momentos de construção desses blocos, sem acrescentar outro trabalho de 210 minutos. As práticas e a investigação conservam o tempo previsto. Não tente digitar o projeto inteiro enquanto acompanha os slides.

| Intervalo | Min | Slides finais | Condução e ação verificável |
|---|---:|---|---|
| 0–20 | 20 | 1–7 | abertura 12, retomada/caso 6, previsão individual 2 |
| 20–55 | 35 | 8–17 | wrappers e transição 20, prática 1 de 12, correção 3 |
| 55–90 | 35 | 18–26 | limitação/contrato/UML 22, prática 2 de 10, retorno 3 |
| 90–100 | 10 | 27 | pausa |
| 100–135 | 35 | 28–36 | integração e demonstração 20, prática 3 de 12, correção 3 |
| 135–165 | 30 | 37–43 | recibos/sobrecarga 17, prática 4 de 10, retorno 3 |
| 165–185 | 20 | 44–49 | String/comparação 12, prática 5 de 6, retorno 2 |
| 185–205 | 20 | 50–52 | laboratório inédito 18, devolutiva 2; modelo e limites como apoio |
| 205–210 | 5 | 53–56 | síntese 2, commit 1, saída individual 2; fontes para consulta |


## Conferência antes da investigação

Rode o verificador e identifique a primeira pendência. Execute também o menu com entradas correspondentes. Um cheque automático cobre apenas os casos nomeados, não todas as exigências da aula. As tarefas de compilação experimental, leitura visual de recibo, integração do menu, acesso entre pacotes e documentação precisam de evidências próprias quando indicadas. Releia os critérios antes de marcar a etapa concluída.

## Atividades e investigação — respostas do estudante

As práticas seguintes usam o esqueleto acima. Complete a etapa relacionada no momento indicado; produza suas previsões, testes e justificativas. As tabelas permanecem vazias para registrar o que você verificou.

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
