# Encontro 15 — construção guiada: Coleções, pacotes e Maven

## O que você terá ao final

Você recebe o domínio da aula 14, separado em arquivos e pacotes, e uma configuração mínima de compilação e testes. Os mapas já estão declarados e o cadastro mostra um exemplo de inclusão protegida. Você completará consultas, transições, identidade, relatórios e empacotamento. A organização fornecida serve de apoio para estudar acesso; não é preciso digitar nove arquivos do zero.

Carro: R$ 10 por hora iniciada; moto: R$ 6; lavagem, quando introduzida na aula 13, R$ 20 fixos. Minutos são informados manualmente. Dados são fictícios e ficam em memória. Placa identifica o cadastro e não muda; modelo pode mudar. Use os cadastros comuns ABC1D23/Hatch e XYZ9K87/Urbana. As atividades abaixo distinguem exemplos comuns da investigação que você deve resolver.

## Preparação — antes de editar

Siga a primeira execução no [README](README.md). Salve o resultado inicial do verificador e uma cópia da etapa anterior. Leia o console para identificar as chamadas; não reescreva o menu inteiro. Abra os arquivos desta aula, procure `TODO 15.` e associe-os à tabela. Você preencherá os corpos e as pequenas alterações indicadas, mantendo a base conhecida. Os experimentos que devem falhar na compilação ficam fora de src e testes.

## Onde trabalhar

| TODO | Arquivo | Trecho a completar ou revisar |
|---|---|---|
| 15.1 | `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java` | consultarVeiculo |
| 15.2 | `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java` | registrarEntrada e registrarSaida |
| 15.3 | `src/main/java/br/edu/uva/estacionamento/modelo/Veiculo.java` | equals e hashCode |
| 15.4 | `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java` | placasAtendidas |
| 15.5 | `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java` | listarVeiculos |
| 15.6 | `pom.xml` | configuração do JAR em build/plugins |

## Sequência de construção

### TODO 15.1 — consultarVeiculo

Abra `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java`.

Use a chave normalizada no mapa já declarado e preserve a exceção de placa ausente. Observe cadastrarVeiculo como padrão de validação antes da associação; uma consulta não pode substituir cadastro.

**Como conferir:** Cheque 15.1: espaços/caixa, identidade da referência e tentativa duplicada como outra categoria.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 15.2 — registrarEntrada e registrarSaida

Abra `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java`.

Adapte a coordenação ao mapa de ativas. Não substitua uma aberta por entrada duplicada; não remova antes de encerrar com sucesso. Histórico segue List e ordem de lançamento, independentemente da ordem do mapa.

**Como conferir:** Cheque 15.2: duração inválida mantém ativa e a operação válida posterior encerra a mesma visita.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 15.3 — equals e hashCode

Abra `src/main/java/br/edu/uva/estacionamento/modelo/Veiculo.java`.

Implemente a política de identidade por placa normalizada entre categorias. Modelo mutável e tarifa ficam fora dessa identidade. Preserve simetria e compatibilidade com hash; não confunda código hash igual com prova suficiente de igualdade.

**Como conferir:** Cheque 15.3: Carro/Moto de mesma placa em HashSet e consulta depois da alteração de modelo.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 15.4 — placasAtendidas

Abra `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java`.

Derive um novo Set das cobranças do histórico a cada consulta. Não inclua cadastro sem cobrança nem crie um campo adicional permanentemente sincronizado. Duas lavagens não devem repetir uma placa no relatório.

**Como conferir:** Cheque 15.4: aberta sem cobrança, duas lavagens, limpar conjunto devolvido e consultar novamente.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 15.5 — listarVeiculos

Abra `src/main/java/br/edu/uva/estacionamento/modelo/Estacionamento.java`.

Produza uma lista nova a partir dos valores do mapa e ordene por placa usando a comparação conhecida. Não devolva a visão apoiada no mapa. Diferencie cópia estrutural de duplicação dos objetos.

**Como conferir:** Cheque 15.5: ordem, limpar cópia sem apagar cadastros e modelo alterado visível no mesmo objeto.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 15.6 — configuração do JAR em build/plugins

Abra `pom.xml`.

Compiler, JUnit e Surefire estão fornecidos como infraestrutura. Configure o plugin de JAR com a classe principal do console conforme a exposição. Confira coordenadas, release e caminhos. Não use -DskipTests para considerar a etapa aprovada.

**Como conferir:** Após TODOs Java: mvn clean package e java -jar target/estacionamento-0.15.0.jar. Todos os testes devem passar e o JAR deve abrir menu.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

## Acompanhamento durante a aula — 210 minutos com pausa

Use os blocos abaixo para acompanhar a explicação e as práticas; os TODOs ocupam os momentos de construção desses blocos, sem acrescentar outro trabalho de 210 minutos. As práticas e a investigação conservam o tempo previsto. Não tente digitar o projeto inteiro enquanto acompanha os slides.

| Intervalo | Min | Slides | Explicação, ação e retorno |
|---|---:|---|---|
| 0–20 | 20 | 1–7 | contexto/roteiro 10, retomada 8, previsão 2 |
| 20–55 | 35 | 8–16 | coleções e refatoração 22, prática 1 de 10, retorno 3 |
| 55–90 | 35 | 17–27 | identidade/Set/cópias 22, prática 2 de 10, retorno 3 |
| 90–100 | 10 | 28 | pausa |
| 100–135 | 35 | 29–38 | organização/acesso 22, prática 3 de 10, retorno 3 |
| 135–175 | 40 | 39–52 | Maven 25, prática 4 de 12, retorno 3 |
| 175–200 | 25 | 53–56 | investigação inédita 20, devolutiva e limites 5 |
| 200–210 | 10 | 57–60 | síntese 3, commit 2, saída individual 4, ponte/fontes 1 |


## Conferência antes da investigação

Rode o verificador e identifique a primeira pendência. Execute também o menu com entradas correspondentes. Um cheque automático cobre apenas os casos nomeados, não todas as exigências da aula. As tarefas de compilação experimental, leitura visual de recibo, integração do menu, acesso entre pacotes e documentação precisam de evidências próprias quando indicadas. Releia os critérios antes de marcar a etapa concluída.

## Atividades e investigação — respostas do estudante

As práticas seguintes usam o esqueleto acima. Complete a etapa relacionada no momento indicado; produza suas previsões, testes e justificativas. As tabelas permanecem vazias para registrar o que você verificou.

## Prática 1 — Organização dos dados — 10 minutos, em duplas

Identifique as perguntas atendidas por cadastro, visitas abertas e histórico. Escolha uma estrutura para cada necessidade e justifique. Adapte procura e inclusão sem permitir substituição de cadastro ou visita por uma tentativa duplicada. Verifique consulta com caixa/espaços diferentes, duplicação e saída inválida. Registre o estado antes/depois e uma operação válida posterior.

Escolhas e justificativas: ____________________
Previsões, resultados e pendências: ____________________

## Prática 2 — Identidade e proteção — 10 minutos, em duplas

Crie três objetos com uma mesma placa, variando caixa, espaços, modelo e categoria. Defina a identidade conforme o domínio. Preveja comparações em ambas as direções e a quantidade de elementos em um conjunto; só então teste. Altere o modelo e repita a consulta. Investigue o efeito de limpar uma coleção recebida do gestor sobre os dados internos.

Campos escolhidos e justificativa: ____________________
Previsões e resultados: ____________________
O que a coleção devolvida protege e o que ainda compartilha: ____________________

## Prática 3 — Arquivos e acesso — 10 minutos, em duplas

Separe seus tipos por responsabilidade. Desenhe a árvore de arquivos e registre quais precisam ser acessíveis entre pacotes. Preserve o controle do gestor sobre criação e encerramento de registros. Em experimento separado, tente uma chamada do console que contorne essa coordenação e registre a mensagem de compilação. Retire o experimento das fontes válidas e confira o fluxo permitido. Não torne tudo público para fazer desaparecer erros.

Árvore e justificativas: ____________________
Experimento, mensagem e interpretação: ____________________

## Prática 4 — Construção da versão — 12 minutos, em duplas

Confira as versões do ambiente e a raiz do projeto. Organize fontes, testes, configuração e resultados gerados. Construa e execute o artefato atual. Registre quais verificações realmente foram executadas; não use ausência de testes como evidência de correção. Faça uma solicitação recusada e uma válida posterior. Diferencie problema de ambiente, compilação e comportamento.

Ambiente, comandos e arquivo executado: ____________________
Casos, resultados e pendências: ____________________

## Investigação — Migração aparentemente pronta — 20 minutos, em duplas

Uma equipe cadastra usando apenas a associação direta da chave ao valor, mantém permanentemente uma coleção adicional de placas atendidas e apresenta um artefato antigo como prova da construção atual. Avalie cada decisão. Proponha um teste discriminante por decisão, registre previsão e observação e corrija sua versão.

Em nova execução, cadastre carro LMN2P34/Hatch e moto RST5U67/Urbana. Abra as duas visitas e registre duas lavagens da moto. Tente cadastrar a placa do carro como moto com espaços externos e caixa diferente. Altere o modelo do carro. Tente saída negativa, depois encerre carro com 121 minutos e moto com 61. Consulte histórico, total e placas distintas. Tente remover a moto; abra nova visita do carro.

Preencha seus próprios resultados; não há tabela resolvida nesta ficha.

Estado após cada recusa: ____________________
Ordem de lançamentos e justificativa: ____________________
Total, quantidade de cobranças e quantidade de placas: ____________________
Número da nova visita e justificativa: ____________________
Três testes discriminantes, resultados e correções: ____________________
Parecer sobre a entrega da equipe: ____________________

## Critérios de conclusão

- Cada coleção atende à pergunta do domínio e as decisões têm justificativa.
- Tentativas recusadas preservam o cadastro, as visitas, os valores e a numeração.
- A igualdade é coerente entre subtipos e não depende do modelo mutável.
- As listagens não expõem a estrutura interna para remoção pelo console.
- A fronteira do gestor é respeitada e a versão executada corresponde às fontes atuais.
- O registro distingue testes realizados, resultados e pendências.

Entregue sua implementação, registros e justificativas no repositório pessoal do Projeto 3 conforme orientação docente. Não inclua dados pessoais ou credenciais. Sem rede, faça commit local e registre o envio pendente. Sem ambiente disponível, desenvolva previsões e justificativas em papel e declare a execução pendente. Não apresente uma etapa não verificada como concluída.
