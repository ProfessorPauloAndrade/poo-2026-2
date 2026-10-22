# Encontro 14 — Atividade dos estudantes

## Objetivo e recursos

Proteger as regras do estacionamento e permitir nova tentativa após falhas previstas, justificando motivo, fluxo e estado preservado. Use o repositório próprio do Projeto 3 e guarde a versão da aula 13. Recursos: JDK 21 ou superior, VS Code, terminal e Git, sem bibliotecas externas.

Carro cobra 10 e moto 6 por hora iniciada; lavagem 20 fixos. Regras fictícias: duração inteira positiva, placa/modelo com texto, uma visita aberta por placa, saída/lavagem só com visita aberta, lavagem independente e repetível. Cadastro com ativa ou histórico não pode ser removido. Cobranças finalizadas não são apagadas para liberar remoção. Os dados ficam em memória.

Você escreve integralmente seu código, incluindo organização dos tipos, campos, construção, operações, interação e testes. Este material contém requisitos e perguntas, sem assinaturas, implementação parcial, respostas ou desenho resolvido.

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
