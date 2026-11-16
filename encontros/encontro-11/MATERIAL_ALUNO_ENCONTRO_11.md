# Encontro 11 — construção guiada: Herança no cadastro de veículos

## O que você terá ao final

O cadastro começa com Carro e Moto independentes e funcionando. Você vai retirar a duplicação de placa, modelo e alteração sem perder esse comportamento. Veiculo foi incluído com lacunas: primeiro complete a responsabilidade comum, depois conecte as categorias. Não há cálculo de permanência nesta etapa.

Carro: R$ 10 por hora iniciada; moto: R$ 6; lavagem, quando introduzida na aula 13, R$ 20 fixos. Minutos são informados manualmente. Dados são fictícios e ficam em memória. Placa identifica o cadastro e não muda; modelo pode mudar. Use os cadastros comuns ABC1D23/Hatch e XYZ9K87/Urbana. As atividades abaixo distinguem exemplos comuns da investigação que você deve resolver.

## Preparação — antes de editar

Siga a primeira execução no [README](README.md). Salve o resultado inicial do verificador e uma cópia da etapa anterior. Leia o console para identificar as chamadas; não reescreva o menu inteiro. Abra os arquivos desta aula, procure `TODO 11.` e associe-os à tabela. Você preencherá os corpos e as pequenas alterações indicadas, mantendo a base conhecida. Os experimentos que devem falhar na compilação ficam fora de src e testes.

## Onde trabalhar

| TODO | Arquivo | Trecho a completar ou revisar |
|---|---|---|
| 11.1 | `src/Veiculo.java` | construtor, getters, alterarModelo e toString |
| 11.2 | `src/Carro.java` e `src/Moto.java` | declarações, campos e construtores |
| 11.3 | `src/Carro.java` e `src/Moto.java` | toString |
| 11.4 | `src/Carro.java` e `src/Moto.java` | campos de categoria e alteração herdada |

## Sequência de construção

### TODO 11.1 — construtor, getters, alterarModelo e toString

Abra `src/Veiculo.java`.

Complete os corpos marcados. A placa é imutável e normalizada; modelo pertence a cada objeto. Na alteração, null, vazio e espaços devem ser recusados por boolean sem apagar o valor anterior. A descrição comum retorna texto e não imprime. Os dados iniciais desta etapa têm precondição de validade.

**Como conferir:** Cheque 11.1: placa com espaços, alteração válida seguida de vazia e preservação de Compacto.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 11.2 — declarações, campos e construtores

Abra `src/Carro.java` e `src/Moto.java`.

Faça as categorias estenderem Veiculo. Retire apenas campos e regras comuns duplicados. Preserve as duas formas de construção; o construtor de dois argumentos encaminha a inicialização comum, e o de um argumento fornece Não informado. Não crie um segundo cadastro dentro de cada categoria.

**Como conferir:** Cheque 11.2: ambas derivam diretamente de Veiculo e não redeclaram placa/modelo.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 11.3 — toString

Abra `src/Carro.java` e `src/Moto.java`.

Sobrescreva a mesma assinatura da descrição. Acrescente a categoria usando a descrição da base. Não acrescente parâmetro para distinguir a categoria e não imprima dentro de toString.

**Como conferir:** Cheque 11.3 e menu 1: Carro | ABC1D23 | Hatch; consulta não altera modelo.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

### TODO 11.4 — campos de categoria e alteração herdada

Abra `src/Carro.java` e `src/Moto.java`.

Revise o que deve ser de instância e o que pode ser constante de categoria. Use os três veículos que o menu já cria; altere somente o primeiro. Se o outro mudar, localize o campo responsável.

**Como conferir:** Cheque 11.4; menu 2 com Compacto, depois 1 e 5. Sedan e tarifas devem permanecer.

Antes de seguir, registre no roteiro: entrada usada, previsão, resultado observado e linha/método alterado. Não marque concluído apenas porque compila.

## Acompanhamento durante a aula — 210 minutos com pausa

Use os blocos abaixo para acompanhar a explicação e as práticas; os TODOs ocupam os momentos de construção desses blocos, sem acrescentar outro trabalho de 210 minutos. As práticas e a investigação conservam o tempo previsto. Não tente digitar o projeto inteiro enquanto acompanha os slides.

| Minutos | Duração | Cards | Ciclo e evidência |
|---|---:|---|---|
| 0–20 | 20 | 1–10 | contexto, explicação do percurso e retomada; previsão individual de 2 min com correção verbal |
| 20–55 | 35 | 11–16 | demonstrar versão duplicada e divergência por 15 min; prática 1 por 10; comparação e síntese por 10 |
| 55–100 | 45 | 17–30 | explicar/generalizar/construir por 25 min; prática 2 por 15; testar e corrigir por 5 |
| 100–110 | 10 | 31 | pausa |
| 110–150 | 40 | 32–41 | explicação e demonstração por 18 min; microinvestigação por 8; prática 3 por 12; síntese por 2 |
| 150–170 | 20 | 42–46 | explicar limites por 12 min; julgamento individual por 5; correção por 3 |
| 170–200 | 30 | 47–53 | diagrama e demonstração preparada por 4 min; laboratório por 24; devolutiva inicial por 2 |
| 200–210 | 10 | 54–57 | síntese/correção por 4 min, commit por 3, saída individual por 3; fontes ficam disponíveis |


## Conferência antes da investigação

Rode o verificador e identifique a primeira pendência. Execute também o menu com entradas correspondentes. Um cheque automático cobre apenas os casos nomeados, não todas as exigências da aula. As tarefas de compilação experimental, leitura visual de recibo, integração do menu, acesso entre pacotes e documentação precisam de evidências próprias quando indicadas. Releia os critérios antes de marcar a etapa concluída.

## Atividades e investigação — respostas do estudante

As práticas seguintes usam o esqueleto acima. Complete a etapa relacionada no momento indicado; produza suas previsões, testes e justificativas. As tabelas permanecem vazias para registrar o que você verificou.

## Prática 1 — comparar responsabilidades (10 min, dupla)

Leia as necessidades e classifique dados e comportamentos entre comuns, específicos e fora do escopo. Explique a razão de cada decisão. Proponha um teste que revele uma regra comum alterada em apenas uma categoria.

| Informação ou comportamento | Classificação proposta | Justificativa | Teste relacionado |
|---|---|---|---|
| | | | |
| | | | |
| | | | |
| | | | |

## Prática 2 — extrair o comum (15 min, dupla)

Complete os TODOs do projeto inicial, preservando uma versão anterior para comparar. Decida onde declarar os dados, como protegê-los e como os construtores colaboram. Evite dados comuns duplicados ou um objeto adicional sem necessidade.

Consulte placa/modelo, faça uma alteração válida e outra vazia. Registre as observações e a localização da regra de alteração. Critério: a refatoração preserva o comportamento e concentra a responsabilidade comum.

## Microinvestigação — estado compartilhado indevidamente (8 min, individual)

Um colega tornou o modelo estático para “evitar repetição”. Criar um segundo carro alterou a descrição do primeiro. Desenhe os objetos e o campo consultado, proponha um teste e explique o problema. Não basta dizer que existe um erro: identifique a decisão responsável.

## Prática 3 — descrição das categorias (12 min, dupla)

Adapte a descrição para indicar a categoria e aproveitar a montagem dos dados comuns. Obtenha o texto em uma variável antes de imprimir, altere um cadastro e consulte novamente. Critérios: operação com assinatura adequada, nenhuma impressão ou alteração interna na descrição e comportamento específico das categorias.

## Laboratório de revisão (24 min, dupla)

Uma equipe propôs colocar modelo em static, redeclarar placa em uma categoria, acrescentar um parâmetro ao método de descrição e fazer um serviço de lavagem derivar do tipo de veículo. Produza um parecer sobre cada proposta e proponha uma organização coerente. Desenhe e teste sua própria implementação; não é necessário implementar o serviço de lavagem.

Acrescente um segundo carro QWE4R56/Sedan. Altere somente o primeiro carro para Compacto. Investigue modelo vazio, espaços e nulo por chamada direta. Verifique descrição e tarifa antes e depois. Preencha a tabela com seus próprios testes e justificativas.

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
