# Encontro 15 — Atividade do estudante

## Objetivo e recursos

Evolua o estacionamento que você já construiu. Preserve sua etapa anterior e implemente integralmente suas próprias alterações. Use JDK 21 ou posterior, VS Code, terminal, Maven e o mesmo repositório do Projeto 3. Não há implementação inicial pronta neste material. Faça previsões antes de executar e registre divergências. Tarifas e dados do domínio continuam os definidos em aula.

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
