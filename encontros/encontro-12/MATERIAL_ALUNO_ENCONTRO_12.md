# Encontro 12 — construção guiada: Abstração e polimorfismo

## O que você terá ao final

Você recebe a hierarquia de veículos já construída. Agora precisa impedir a criação direta do tipo geral, calcular horas iniciadas com a tarifa da categoria e guardar visitas já concluídas. A aula termina com histórico e total; ainda não há visita aberta nem lavagem.

Carro: R$ 10 por hora iniciada; moto: R$ 6; lavagem, quando introduzida na aula 13, R$ 20 fixos. Minutos são informados manualmente. Dados são fictícios e ficam em memória. Placa identifica o cadastro e não muda; modelo pode mudar. Use os cadastros comuns ABC1D23/Hatch e XYZ9K87/Urbana. As atividades abaixo distinguem exemplos comuns da investigação que você deve resolver.

## Preparação — antes de editar

Siga a primeira execução no [README](README.md). Salve o resultado inicial do verificador e uma cópia da etapa anterior. Leia o console para identificar as chamadas; não reescreva o menu inteiro. Abra os arquivos desta aula, procure `TODO 12.` e associe-os à tabela. Você preencherá os corpos e as pequenas alterações indicadas, mantendo a base conhecida. Os experimentos que devem falhar na compilação ficam fora de src e testes.

## Onde trabalhar

| TODO | Arquivo | Trecho a completar ou revisar |
|---|---|---|
| 12.1 | `src/Veiculo.java` | declaração do tipo e getTarifaHora |
| 12.2 | `src/Veiculo.java` | calcularTarifa(int minutos) |
| 12.3 | `src/Permanencia.java` | construtor |
| 12.4 | `src/Estacionamento.java` | registrarPermanencia |
| 12.5 | `src/Estacionamento.java` | totalizarPermanencias |

## Sequência de construção

### TODO 12.1 — declaração do tipo e getTarifaHora

Abra `src/Veiculo.java`.

Substitua a implementação provisória do contrato de tarifa por uma obrigação abstrata e impeça criação direta da base. Carro/Moto já fornecem a tarifa. Faça os experimentos inválidos da prática em pasta separada, fora de src.

**Como conferir:** Cheque 12.1; registre também as mensagens dos dois experimentos de compilação.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 12.2 — calcularTarifa(int minutos)

Abra `src/Veiculo.java`.

Complete o cálculo comum para minutos positivos usando a tarifa obtida do objeto real. Considere horas iniciadas e preserve a fração antes do arredondamento. Não escolha categoria por if, cast ou instanceof no cálculo.

**Como conferir:** Cheque 12.2 compara 60 e 61 min do carro; amplie com 1, 75 e 120 e com moto.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 12.3 — construtor

Abra `src/Permanencia.java`.

Inicialize os campos finais declarados a partir dos argumentos válidos. Guarde o valor da visita concluída nesse momento. Preserve a referência ao veículo; não crie outra categoria a partir de sua placa.

**Como conferir:** Cheque 12.3: número 1, moto, 20 minutos, valor consultável.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 12.4 — registrarPermanencia

Abra `src/Estacionamento.java`.

Use a busca fornecida. Recuse placa ausente e minutos não positivos com false antes de criar registro ou consumir número. Na aceitação, inclua uma visita concluída no histórico e avance a sequência uma vez.

**Como conferir:** Cheque 12.4: tentativa com zero seguida de 75; primeira visita aceita continua número 1.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 12.5 — totalizarPermanencias

Abra `src/Estacionamento.java`.

Percorra as permanências e acumule os valores já registrados. A consulta não cria visita, não recalcula pela categoria no gestor e não muda numeração.

**Como conferir:** Cheque 12.5: carro 75 e moto 20 totalizam 26 no exemplo comum; confira lista separadamente.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

## Acompanhamento durante a aula — 210 minutos com pausa

Use os blocos abaixo para acompanhar a explicação e as práticas; os TODOs ocupam os momentos de construção desses blocos, sem acrescentar outro trabalho de 210 minutos. As práticas e a investigação conservam o tempo previsto. Não tente digitar o projeto inteiro enquanto acompanha os slides.

| Intervalo | Min | Slides finais | Explicar → praticar → conferir |
|---|---:|---|---|
| 0–20 | 20 | 1–8 | abertura, percurso, produto e previsão individual de 2 min com retorno |
| 20–50 | 30 | 9–14 | abstração: demonstração 18 min, prática 1 de 10, correção 2 |
| 50–90 | 40 | 15–21 | referências/despacho: explicar e demonstrar 25, prática 2 de 12, correção 3 |
| 90–100 | 10 | 22 | pausa |
| 100–140 | 40 | 23–30 | cálculo: 25 de demonstração/rastreamento, prática 3 de 12, correção 3 |
| 140–165 | 25 | 31–37 | registro: 15 de explicação/demonstração, desenho de 8, correção 2 |
| 165–185 | 20 | 38–45 | instanceof/parâmetros: 10 de explicação, prática 4 de 8, retorno 2 |
| 185–205 | 20 | 46–51 | laboratório de 18 e devolutiva de 2; diagrama/limites abertos como apoio |
| 205–210 | 5 | 52–55 | síntese 2, commit 1, saída individual 2; fontes para consulta posterior |


## Conferência antes da investigação

Rode o verificador e identifique a primeira pendência. Execute também o menu com entradas correspondentes. Um cheque automático cobre apenas os casos nomeados, não todas as exigências da aula. As tarefas de compilação experimental, leitura visual de recibo, integração do menu, acesso entre pacotes e documentação precisam de evidências próprias quando indicadas. Releia os critérios antes de marcar a etapa concluída.

## Atividades e investigação — respostas do estudante

As práticas seguintes usam o esqueleto acima. Complete a etapa relacionada no momento indicado; produza suas previsões, testes e justificativas. As tabelas permanecem vazias para registrar o que você verificou.

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
