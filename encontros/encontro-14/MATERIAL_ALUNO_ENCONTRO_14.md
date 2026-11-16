# Encontro 14 — construção guiada: Exceções e estado válido

## O que você terá ao final

Você recebe o fluxo de visitas e cobranças já conhecido. A mudança desta aula é explicar recusas por exceções e proteger o estado mesmo em chamadas diretas. O menu precisa orientar a pessoa e continuar após uma falha prevista. Não basta imprimir uma mensagem: o objeto deve continuar coerente.

Carro: R$ 10 por hora iniciada; moto: R$ 6; lavagem, quando introduzida na aula 13, R$ 20 fixos. Minutos são informados manualmente. Dados são fictícios e ficam em memória. Placa identifica o cadastro e não muda; modelo pode mudar. Use os cadastros comuns ABC1D23/Hatch e XYZ9K87/Urbana. As atividades abaixo distinguem exemplos comuns da investigação que você deve resolver.

## Preparação — antes de editar

Siga a primeira execução no [README](README.md). Salve o resultado inicial do verificador e uma cópia da etapa anterior. Leia o console para identificar as chamadas; não reescreva o menu inteiro. Abra os arquivos desta aula, procure `TODO 14.` e associe-os à tabela. Você preencherá os corpos e as pequenas alterações indicadas, mantendo a base conhecida. Os experimentos que devem falhar na compilação ficam fora de src e testes.

## Onde trabalhar

| TODO | Arquivo | Trecho a completar ou revisar |
|---|---|---|
| 14.1 | `src/RegraNegocioException.java` | construtor |
| 14.2 | `src/Veiculo.java` | normalizarPlaca e validarModelo |
| 14.3 | `src/Veiculo.java` | calcularTarifa |
| 14.4 | `src/Permanencia.java` | encerrar e calcularValor |
| 14.5 | `src/Estacionamento.java` | registrarEntrada, registrarSaida, registrarLavagem e removerVeiculo |
| 14.6 | `src/AplicacaoConsole.java` | capturas do laço interativo |

## Sequência de construção

### TODO 14.1 — construtor

Abra `src/RegraNegocioException.java`.

Complete a exceção verificada preservando a mensagem recebida na classe Exception. Identifique onde os métodos do gestor anunciam a possibilidade. Não troque o tipo por RuntimeException para escapar do compilador.

**Como conferir:** Cheque 14.1 compara a mensagem; experimento isolado de chamada sem captura nem throws.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 14.2 — normalizarPlaca e validarModelo

Abra `src/Veiculo.java`.

As versões provisórias só retiram espaços. Antes de fazê-lo, recuse null e texto vazio por IllegalArgumentException com motivo. Verifique que alterarModelo valida antes de escrever e mantém o modelo anterior.

**Como conferir:** Cheque 14.2: construção com null e alteração vazia; não aceite NullPointerException como recusa de domínio.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 14.3 — calcularTarifa

Abra `src/Veiculo.java`.

O cálculo anterior já está fornecido. Acrescente guardas para minutos não positivos e tarifa inválida antes de calcular. Não transforme argumento inválido em valor zero.

**Como conferir:** Cheque 14.3; repita uma duração válida para demonstrar que o cálculo foi preservado.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 14.4 — encerrar e calcularValor

Abra `src/Permanencia.java`.

Diferencie estado inadequado de argumento inválido: aberta não tem valor extraível; encerrada não encerra novamente. Valide estado e duração, calcule em variável local e só então atribua dados da conclusão. Exceção não desfaz escrita anterior.

**Como conferir:** Cheque 14.4: aberta, duração zero, saída 75 e segunda saída; a visita recusada deve continuar aberta.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 14.5 — registrarEntrada, registrarSaida, registrarLavagem e removerVeiculo

Abra `src/Estacionamento.java`.

Use exceção própria para recusas de negócio. Mantenha buscas e validações antes de mudar listas ou número. Na saída, exija ativa antes de verificar duração. Remoção só é permitida sem ativa e sem histórico; não apague cobrança para permitir remover cadastro. Preserve os contratos já declarados.

**Como conferir:** Cheque 14.5: duplicação, saída zero, saída válida posterior e remoção com vínculo; amplie com lavagem após saída.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 14.6 — capturas do laço interativo

Abra `src/AplicacaoConsole.java`.

Leitura por linha e conversão já estão disponíveis. Acrescente capturas específicas para formato numérico, argumento e regra de negócio, em ordem válida, com mensagens que indiquem o motivo. O apoio de TODO é temporário; não capture Exception indiscriminadamente nem apresente sucesso numa recusa.

**Como conferir:** Verificação manual obrigatória: digite abc na opção, depois 1 e 0 na mesma execução; o menu precisa continuar. Repita com duração 60min e inteiro fora do intervalo.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

## Acompanhamento durante a aula — 210 minutos com pausa

Use os blocos abaixo para acompanhar a explicação e as práticas; os TODOs ocupam os momentos de construção desses blocos, sem acrescentar outro trabalho de 210 minutos. As práticas e a investigação conservam o tempo previsto. Não tente digitar o projeto inteiro enquanto acompanha os slides.

| Intervalo | Min | Slides finais | Explicar → agir → conferir |
|---|---:|---|---|
| 0–20 | 20 | 1–7 | abertura/contexto 12, retomada 6, previsão individual 2 |
| 20–55 | 35 | 8–16 | fluxo e sintaxe 22, prática 1 de 10, retorno 3 |
| 55–90 | 35 | 17–26 | hierarquia/contrato 22, prática 2 de 10, retorno 3 |
| 90–100 | 10 | 27 | pausa |
| 100–140 | 40 | 28–38 | domínio/estado/regras 25, prática 3 de 12, retorno 3 |
| 140–175 | 35 | 39–48 | console/capturas 20, prática 4 de 12, retorno 3 |
| 175–200 | 25 | 49–53 | laboratório inédito 20, devolutiva e limites 5 |
| 200–210 | 10 | 54–57 | síntese 4, commit 2, saída 3, fontes e ponte 1 |


## Conferência antes da investigação

Rode o verificador e identifique a primeira pendência. Execute também o menu com entradas correspondentes. Um cheque automático cobre apenas os casos nomeados, não todas as exigências da aula. As tarefas de compilação experimental, leitura visual de recibo, integração do menu, acesso entre pacotes e documentação precisam de evidências próprias quando indicadas. Releia os critérios antes de marcar a etapa concluída.

## Atividades e investigação — respostas do estudante

As práticas seguintes usam o esqueleto acima. Complete a etapa relacionada no momento indicado; produza suas previsões, testes e justificativas. As tabelas permanecem vazias para registrar o que você verificou.

## Práticas distribuídas

1. **Caminho da tentativa — 10 min em dupla.** Crie uma conversão seguida de uma operação e mensagem de sucesso; teste texto interpretável e não interpretável. Preveja etapas executadas, tratamento e nova tentativa por repetição. Produto: rastreamento e saídas; critério: nenhuma retomada automática da linha que falhou nem falso sucesso.
2. **Obrigação do compilador — 10 min em dupla.** Crie experimento isolado de falha verificada e chamada sem decisão de captura/declaração. Compare duas versões válidas, uma que trata e outra que propaga. Produto: mensagens e caminho; critério: explicar lançar/declarar/capturar. Não misture experimentos inválidos à compilação do projeto.
3. **Proteção direta — 12 min em dupla.** Teste leitura de valor aberto, encerramento e cadastro sem passar pelo menu. Compare tipo/motivo e estado antes/depois; tente depois um uso válido. Produto: dois estados e testes; critério: validar antes de alterar, sem redefinir campos na resposta à falha.
4. **Integração do menu — 12 min em dupla.** Leia uma linha, converta números e responda a falhas previstas com tratamentos específicos. Intercale recusas e operações válidas. Em arquivo separado, experimente ordem incorreta de capturas relacionadas por herança. Produto: transcrição e comparação de estado; critério: motivo coerente, nova tentativa e ausência de cobrança duplicada.

## Tabelas em branco

| Tentativa | Etapas previstas | Etapas observadas | Motivo previsto/observado | Caminho da nova tentativa |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

| Operação recusada | Cadastro/campos antes/depois | Ativas antes/depois | Histórico/números antes/depois | Total antes/depois |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

## Laboratório — 20 minutos em dupla

Investigue três propostas: retirar a visita das ativas antes de verificar; capturar qualquer falha e apresentar sucesso; transformar texto não interpretável em zero. Crie um teste discriminante para cada proposta, incluindo chamadas diretas e interação pelo menu.

Nova execução: entre com carro/moto, realize duas lavagens da moto e intercale entrada duplicada e saída com duração inválida. No menu experimente “60min” e número fora do intervalo representável. Tente remover cadastro com vínculo. Depois encerre carro com 61 min e moto com 60 min; consulte e reimprima recibos.

Calcule suas previsões antes de executar. Entregue parecer, desenhos de estados e testes. Critérios: motivo interpretado no lugar responsável, recusas sem escrita parcial, continuidade após correção, mesmo objeto de visita na saída e histórico somente finalizado. Um total correto isolado não basta.

| Proposta | Teste que a distingue | Previsão de estado e saída | Observação | Decisão e justificativa |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

Registre um commit da etapa com testes e limites. Sem computador, use rastreamento e estados em papel; sem rede, faça commit local. Não é necessário informar dados pessoais. Organização e novas coleções serão tratadas no encontro seguinte.
