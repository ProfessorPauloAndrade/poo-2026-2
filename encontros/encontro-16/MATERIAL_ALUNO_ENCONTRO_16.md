# Encontro 16 — construção guiada: Integração e conclusão

## O que você terá ao final

Você recebe a versão intermediária funcional da aula 15. Agora vai escrever uma jornada de integração, extrair duas responsabilidades pequenas e verificar entrega reproduzível. As operações já aprendidas permanecem disponíveis. O trabalho novo está nos TODOs, nos testes e na justificativa das mudanças; não há novo sistema a construir.

Carro: R$ 10 por hora iniciada; moto: R$ 6; lavagem, quando introduzida na aula 13, R$ 20 fixos. Minutos são informados manualmente. Dados são fictícios e ficam em memória. Placa identifica o cadastro e não muda; modelo pode mudar. Use os cadastros comuns ABC1D23/Hatch e XYZ9K87/Urbana. As atividades abaixo distinguem exemplos comuns da investigação que você deve resolver.

## Preparação — antes de editar

Siga a primeira execução no [README](README.md). Salve o resultado inicial do verificador e uma cópia da etapa anterior. Leia o console para identificar as chamadas; não reescreva o menu inteiro. Abra os arquivos desta aula, procure `TODO 16.` e associe-os à tabela. Você preencherá os corpos e as pequenas alterações indicadas, mantendo a base conhecida. Os experimentos que devem falhar na compilação ficam fora de src e testes.

## Onde trabalhar

| TODO | Arquivo | Trecho a completar ou revisar |
|---|---|---|
| 16.1 | `src/test/java/br/edu/uva/estacionamento/app/MeuTeste.java` | montarJornada |
| 16.2 | `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java` | possuiCobrancaDaPlaca e removerVeiculo |
| 16.3 | `src/main/java/br/edu/uva/estacionamento/app/AplicacaoConsole.java` | apresentarAbertas |
| 16.4 | `README_ENTREGA.md e pom.xml` | entrega em cópia independente |

## Sequência de construção

### TODO 16.1 — montarJornada

Abra `src/test/java/br/edu/uva/estacionamento/app/MeuTeste.java`.

Use a API pública já funcional para montar o cenário descrito no comentário e devolva o gestor. Não altere a verificação para acomodar um defeito. Acrescente seus casos de recusa e referência em testes próprios ou no roteiro.

**Como conferir:** Cheque 16.1 compara jornada conhecida, histórico, total, placas e nova visita distinta. Os resultados da investigação inédita continuam a seu cargo.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 16.2 — possuiCobrancaDaPlaca e removerVeiculo

Abra `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java`.

Extraia a pergunta sobre vínculo com histórico para o auxiliar marcado. Substitua o percurso duplicado na remoção por essa consulta. Preserve guarda de ativa, motivo e ordem das recusas. Não acrescente coleção persistente ou mude regra para facilitar o teste.

**Como conferir:** Cheque 16.2: sem vínculo/com cobrança e remoção recusada. Revise também o código para confirmar que removerVeiculo usa o auxiliar.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 16.3 — apresentarAbertas

Abra `src/main/java/br/edu/uva/estacionamento/app/AplicacaoConsole.java`.

Complete o auxiliar que a opção 3 já chama. Obtenha a listagem uma vez, trate lista vazia e apresente cada aberta sem extrair preço. Consulta não deve encerrar visita nem criar cobrança.

**Como conferir:** Cheque 16.3: mensagem vazia, descrição ABERTA, histórico preservado; confira uma única consulta no método.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 16.4 — entrega em cópia independente

Abra `README_ENTREGA.md e pom.xml`.

A configuração 0.16.0 está fornecida. Complete o registro de ambiente, comandos, casos, resultados e limites. Construa em outra pasta sem build/target, execute o JAR produzido e peça revisão da instrução por outra dupla.

**Como conferir:** mvn clean package, JAR atual, transcrição e instruções executáveis. Os cheques Java não substituem documentação, investigação ou revisão por colega.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

## Acompanhamento durante a aula — 210 minutos com pausa

Use os blocos abaixo para acompanhar a explicação e as práticas; os TODOs ocupam os momentos de construção desses blocos, sem acrescentar outro trabalho de 210 minutos. As práticas e a investigação conservam o tempo previsto. Não tente digitar o projeto inteiro enquanto acompanha os slides.

| Intervalo | Min | Slides | Exposição, prática e retorno |
|---|---:|---|---|
| 0–20 | 20 | 1–7 | contexto e panorama 10, retomada 8, previsão individual 2 |
| 20–60 | 40 | 8–17 | integração guiada 25, prática 1 de 12, devolutiva 3 |
| 60–90 | 30 | 18–25 | regressão 18, prática 2 de 10, síntese 2 |
| 90–100 | 10 | 26 | pausa |
| 100–140 | 40 | 27–35 | diagnóstico/refatoração 25, prática 3 de 12, devolutiva 3 |
| 140–180 | 40 | 36–43 | construção/entrega 20, prática 4 de 15, conferência 5 |
| 180–200 | 20 | 44–47 | investigação inédita 15, discussão 5 |
| 200–210 | 10 | 48–51 | síntese 3, commit/registro 2, saída individual 4, fontes/continuidade 1 |


## Conferência antes da investigação

Rode o verificador e identifique a primeira pendência. Execute também o menu com entradas correspondentes. Um cheque automático cobre apenas os casos nomeados, não todas as exigências da aula. As tarefas de compilação experimental, leitura visual de recibo, integração do menu, acesso entre pacotes e documentação precisam de evidências próprias quando indicadas. Releia os critérios antes de marcar a etapa concluída.

## Atividades e investigação — respostas do estudante

As práticas seguintes usam o esqueleto acima. Complete a etapa relacionada no momento indicado; produza suas previsões, testes e justificativas. As tabelas permanecem vazias para registrar o que você verificou.

## Prática 1 — Jornada completa — 12 minutos, em duplas

Com carro ABC1D23/Hatch e moto XYZ9K87/Urbana cadastrados, abra as duas visitas. Registre saída do carro com 75 minutos, lavagem da moto e saída da moto com 20. Acrescente tentativa de entrada duplicada enquanto houver uma visita aberta e uma nova entrada do carro depois da saída.

Preveja e acompanhe ativas, lançamentos, total, placas atendidas, números e referências relevantes. Distinga uma nova visita da primeira. Entregue quadro próprio e justificativa de uma divergência ou hipótese rejeitada.

Previsão e observação: ____________________
Referências/estados comparados e conclusão: ____________________

## Prática 2 — Regressão — 10 minutos, em duplas

Escolha um caso de limite, um de recusa, um de identidade e um de coleção ou numeração. Defina a hipótese que cada teste pode revelar. Execute, compare e acrescente uma operação válida depois da recusa. Não dependa da ordem de percurso das estruturas que não a garantem.

Caso, estado inicial, ação, esperado e obtido: ____________________
Hipótese, interpretação e pendências: ____________________

## Prática 3 — Diagnóstico e melhoria — 12 minutos, em duplas

Investigue uma falha observada ou uma melhoria pequena e justificável. Registre o comportamento anterior, a hipótese e o teste discriminante. Preserve a etapa, altere um trecho e repita as verificações relacionadas. Não enfraqueça regras ou acesso para ocultar a falha. Se não houver defeito, não invente um: justifique melhorar ou manter.

Hipótese e evidência inicial: ____________________
Mudança realizada e justificativa: ____________________
Comparação antes/depois e regressão: ____________________

## Prática 4 — Entrega reproduzível — 15 minutos, em duplas

Prepare uma cópia independente com fontes, testes, configuração e instruções. Outra dupla deve construir e abrir a versão atual sem depender dos resultados gerados anteriormente. Registre ambiente, comandos, casos conferidos e dificuldades. Ajuste uma instrução ambígua ou declare a pendência.

Ambiente, raiz e instruções verificadas: ____________________
Construção, execução e casos observados: ____________________
Revisão da outra dupla e ajuste: ____________________

## Investigação final — 15 minutos, em duplas

Um novo operador suspeita de três problemas: receita duplicada ao reimprimir recibo, segunda visita reaproveitando o registro anterior e cadastro sem cobrança aparecendo entre placas atendidas. Esses relatos são hipóteses, não defeitos confirmados. Proponha um teste discriminante para cada relato e emita parecer: confirmado, refutado ou não verificado, com evidência.

Em nova execução, cadastre carro LMN2P34/Hatch, moto RST5U67/Urbana e carro UVW8X90/Reserva. Abra visitas dos dois primeiros e registre uma lavagem da moto. Remova o terceiro cadastro sem vínculos e cadastre-o novamente. Encerre o primeiro carro com 60 minutos, abra nova visita dele e registre sua lavagem. Tente saída com zero e entrada duplicada da moto. Encerre moto com 61 e carro com 121 minutos. Consulte histórico, total e placas; repita consultas dos recibos e relatórios. Tente remover a moto e abra outra visita do primeiro carro.

Não há resultados resolvidos nesta ficha. Monte o acompanhamento dos estados, inclusive após as recusas, e calcule antes da execução.

Previsão de números, estado, histórico, receita e placas: ____________________
Resultados observados e divergências: ____________________
Três testes discriminantes e parecer para o operador: ____________________
Responsabilidade localizada, correção proposta e regressão necessária: ____________________

## Entrega e critérios

Entregue sua implementação no mesmo repositório pessoal, documentação de primeira execução, registros dos testes e pendências. Preserve a etapa anterior e confira quais arquivos farão parte do commit. Não inclua dados pessoais ou credenciais.

- Jornada completa coerente, com visita encerrada preservada e nova visita distinta.
- Recusas preservam dados e numeração e permitem solicitação válida posterior.
- Relatórios distinguem quantidade de cobranças, identidades e soma.
- Alterações pequenas têm justificativa e comparação antes/depois.
- A execução corresponde às fontes atuais e a outra dupla consegue seguir as instruções.
- O parecer diferencia observado, inferido e não verificado; limites são declarados.

Sem rede, mantenha o commit local e registre envio pendente. Maven offline exige cache preparado. Sem ambiente, faça previsões e revisão documental em papel e declare a execução pendente; não apresente como concluída uma etapa não verificada.
