# Encontro 12 — Abstração e polimorfismo

Você recebe a hierarquia de veículos já construída. Agora precisa impedir a criação direta do tipo geral, calcular horas iniciadas com a tarifa da categoria e guardar visitas já concluídas. A aula termina com histórico e total; ainda não há visita aberta nem lavagem.

## Comece por aqui

1. Baixe o repositório inteiro pelo botão **Code → Download ZIP** e extraia, ou use sua cópia Git atualizada. Abra no VS Code a pasta `encontros/encontro-12`. Não abra somente o antigo arquivo Java da raiz.
2. Preserve sua versão anterior no seu repositório pessoal. Use esta pasta como ponto de partida desta etapa; ela inclui a base já ensinada. Compare com seu trabalho anterior e traga suas alterações conscientemente. Não junte duas versões das mesmas classes numa compilação.
3. No terminal dessa pasta, confira `java -version` e `javac -version`: JDK 21 ou posterior, ambos disponíveis. Execute `./iniciar.cmd` no PowerShell do Windows. Em Linux/macOS, execute `sh iniciar.sh`.
4. O menu deve aparecer. Digite `0` para sair. Depois execute `./verificar.cmd` (Windows) ou `sh verificar.sh` (Linux/macOS).
5. Abra [o material guiado](MATERIAL_ALUNO_ENCONTRO_12.md). Localize `TODO 12.1`, complete a etapa indicada e rode a verificação novamente. Os números dos TODOs aparecem no código, no material e nas mensagens do verificador.

## O que está pronto e o que falta

O console, a organização dos arquivos, os tipos, as assinaturas e a base de conhecimentos anteriores são fornecidos. Os pontos novos a construir estão marcados com `TODO 12.N`. Corpos ainda não implementados lançam `UnsupportedOperationException` com a identificação da tarefa; remova esse lançamento ao implementar. Não substitua por `null`, zero ou sucesso para silenciar a pendência.

O estado inicial conferido é **`RESUMO OK=0 PENDENTE=5 REVER=0`**. Isso é esperado antes do trabalho. `OK` indica que aquele caso passou; `PENDENTE` indica uma lacuna; `REVER` indica diferença de comportamento que precisa ser investigada. O comando retorna código de saída diferente de zero enquanto houver pendências ou divergências. Um caso pode depender de vários TODOs; resolva na ordem do material. Compilar e abrir o menu não significam concluir a aula.

Fontes para editar: `src/`. O verificador é infraestrutura fornecida: não é necessário estudar reflexão, lambdas ou streams para preencher esta aula. Não altere seus resultados esperados para fazer um código incorreto passar. Registre casos adicionais e a investigação no [roteiro](ROTEIRO_ALUNO_ENCONTRO_12.md).

## Arquivos da prática

- [Material: tarefas por arquivo, sequência e atividades](MATERIAL_ALUNO_ENCONTRO_12.md).
- [Roteiro: previsões, observações e critérios](ROTEIRO_ALUNO_ENCONTRO_12.md).
- [Iniciar no Windows](iniciar.cmd) e [verificar no Windows](verificar.cmd).
- [Iniciar em Linux/macOS](iniciar.sh) e [verificar em Linux/macOS](verificar.sh).

Os scripts compilam as fontes atuais numa pasta de execução nova dentro de `build/`, sem reutilizar classes antigas. Não entregue `build/`, `target/` ou `.class`. Os arquivos Java antigos da raiz são avisos de compatibilidade; o projeto está em `src/`.

## Se algo não funcionar

- “java/javac não reconhecido”: confira instalação do JDK e PATH e reabra o terminal. O script precisa dos dois comandos.
- Erro de compilação: leia o primeiro arquivo/linha indicado, confira assinatura, imports, construtores e chaves da etapa que alterou. Não avance apagando o teste.
- “ETAPA PENDENTE”: veja o número do TODO citado; é uma operação ainda não construída. Uma tarefa dependente pode citar uma etapa anterior.
- Resultado diferente: reproduza a entrada do caso, compare estado antes/depois e localize quem decide a regra. Registre a hipótese antes de alterar.
- Dados desaparecem ao fechar: esta versão usa memória; cada início do menu cria uma sessão nova com os cadastros de demonstração.
