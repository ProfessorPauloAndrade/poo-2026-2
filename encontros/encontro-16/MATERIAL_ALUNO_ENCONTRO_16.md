# Encontro 16 — Integração e conclusão do Projeto 3

## Objetivo e recursos

Conclua sua implementação do estacionamento já desenvolvido. Preserve a etapa anterior no mesmo repositório do Projeto 3. Use JDK 21 ou posterior, VS Code, terminal, Maven e Git. Escreva integralmente suas alterações e testes; este material não contém implementação, configuração resolvida ou gabarito.

Faça previsões antes de executar. Registre estado inicial, ação, resultado esperado, resultado observado e interpretação. Não use somente “OK” como evidência. Dados, tarifas e regras continuam os definidos em aula; não acrescente funcionalidades fora do escopo para substituir verificações pendentes.

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
