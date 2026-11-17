# Encontro 13 — Interfaces: um contrato para cobranças diferentes

Material do aluno. Projeto 3: estacionamento.

## 1. O que você vai construir

Até a aula 12, o programa só registrava uma visita depois que o veículo ia embora, e só cobrava estacionamento. Nesta aula ele passa a fazer duas coisas novas:

1. **Registrar a entrada antes da saída.** A visita nasce aberta, sem minutos e sem valor. Quando o operador informa a saída, a mesma visita é encerrada e o valor é calculado.
2. **Cobrar lavagens.** A lavagem custa R$ 20 fixos e aparece no mesmo histórico das permanências.

Para isso você vai usar cinco conceitos de Java:

| Conceito | Para que serve no projeto |
|---|---|
| Classes wrapper (`Integer`, `Double`) e `null` | guardar minutos e valor que ainda não existem |
| Interface | reunir `Permanencia` e `Lavagem` por um contrato comum |
| Polimorfismo por interface | somar qualquer cobrança com um único laço |
| Sobrecarga de métodos | ter dois métodos de recibo com o mesmo nome |
| Comparação de `String` | localizar e ordenar placas corretamente |

## 2. As regras do estacionamento nesta etapa

- **Tarifas:** carro R$ 10 e moto R$ 6 por hora iniciada. Lavagem R$ 20 fixos, para qualquer veículo.
- **Entrada:** só para placa cadastrada e sem visita aberta. Cada placa tem no máximo uma visita aberta.
- **Saída:** o operador informa os minutos, inteiros e positivos. Só então o valor é calculado.
- **Lavagem:** exige visita aberta, pode se repetir e não encerra a visita.
- **Histórico:** guarda apenas cobranças finalizadas. Visita aberta não entra no total.
- **Recusa:** nesta etapa, uma operação recusada devolve `false` ou `null` e não altera nada. As exceções chegam na aula 14.

Use sempre os dois cadastros de exemplo: carro `ABC1D23` (Hatch) e moto `XYZ9K87` (Urbana). Os dados são fictícios e ficam em memória.

## 3. Antes de começar

1. Siga a primeira execução descrita no `README.md` do projeto: confira `java -version` e `javac -version`, execute `iniciar` e depois `verificar`.
2. O verificador deve mostrar `RESUMO OK=0 PENDENTE=6 REVER=0`. Isso é o esperado antes do trabalho.
3. Guarde uma cópia ou um commit da sua versão da aula 12.
4. Procure no código por `TODO 13.`. São sete tarefas, numeradas de 13.1 a 13.7.

**Como ler o resultado do verificador:**

| Palavra | Significado |
|---|---|
| OK | o caso passou |
| PENDENTE | a tarefa ainda não foi implementada |
| REVER | o código executou, mas o resultado está diferente do esperado |

Cada método pendente lança `UnsupportedOperationException` com o número da tarefa. Ao implementar, apague essa linha. Não a troque por `return null`, `return 0` ou `return true` só para o aviso sumir.

## 4. Mapa do projeto: o que já vem pronto e o que você completa

| Arquivo em `src/` | Já vem pronto | Você completa |
|---|---|---|
| `Veiculo.java`, `Carro.java`, `Moto.java` | tudo, igual à aula 12 | nada |
| `Cobravel.java` | a interface, com as quatro operações | nada: leia com atenção |
| `Permanencia.java` | atributos, construtor de dois parâmetros, `getMinutos`, `getNumero`, `getPlaca`, `toString` | `estaEncerrada`, `encerrar`, `getDescricao`, `calcularValor` (13.1) e a ligação com `Cobravel` (13.2) |
| `Lavagem.java` | atributos, `getNumero`, `getPlaca`, `getDescricao`, `toString` | a ligação com `Cobravel` (13.2), o construtor e `calcularValor` (13.3) |
| `Estacionamento.java` | as três listas, cadastro, `consultarVeiculo`, `consultarAtiva`, `listarVeiculos` | `registrarEntrada`, `registrarSaida`, `registrarLavagem` (13.4) e `totalizarCobrancas` (13.5) |
| `AplicacaoConsole.java` | o menu inteiro | os dois `imprimirRecibo` (13.6), `mesmaPlaca` e `compararPlacas` (13.7) |

**Como os tipos se relacionam ao final da aula:**

```text
AplicacaoConsole  --chama-->  Estacionamento
Estacionamento    --guarda--> lista de Veiculo, lista de Permanencia (ativas),
                              lista de Cobravel (cobrancas)
Permanencia  --implements-->  Cobravel
Lavagem      --implements-->  Cobravel
Permanencia e Lavagem  --usam-->  Veiculo  (Carro ou Moto)
```

## 5. Parte 1 — Guardar um número que ainda não existe (TODO 13.1)

### A ideia

Quando a moto entra, o programa sabe o número da visita e o veículo. Ainda não sabe os minutos nem o valor. Não podemos gravar zero, porque zero é um número de verdade: a visita pareceria encerrada sem custo.

Em Java, a ausência de valor se escreve `null`. O problema é que `int` e `double` são tipos primitivos e não aceitam `null`.

### Conceitos

**Classe wrapper.** É uma classe da biblioteca Java que guarda um valor primitivo dentro de um objeto. `Integer` guarda um `int`; `Double` guarda um `double`. Como são classes, uma variável desses tipos pode valer `null`.

**Boxing.** É a conversão de primitivo para wrapper, de `int` para `Integer`. O compilador faz sozinho.

**Unboxing.** É a conversão inversa, de `Integer` para `int`. O compilador também faz sozinho.

**O risco.** Fazer unboxing de uma variável que vale `null` interrompe o programa com `NullPointerException`. Java não transforma `null` em zero.

Exemplo fora do projeto, para experimentar:

```java
Integer nota = null;          // ainda não foi lançada
if (nota == null) {
    System.out.println("Nota ainda nao lancada");
} else {
    int valor = nota;         // unboxing: só aqui, onde a nota existe
    System.out.println(valor + 1);
}
```

### O que já vem pronto

Em `Permanencia.java`, os atributos já são `Integer minutos` e `Double valorCobrado`, e o construtor recebe só número e veículo. Uma visita recém-criada tem os dois atributos em `null`. Localize essas linhas e leia antes de continuar.

### Sua tarefa

Complete quatro métodos de `Permanencia`:

| Método | O que deve fazer |
|---|---|
| `estaEncerrada` | responder se a visita já tem minutos registrados |
| `encerrar` | recusar se a visita já foi encerrada ou se a duração não é positiva; caso contrário, calcular o valor com o veículo e registrar minutos e valor |
| `getDescricao` | devolver um texto para visita encerrada, com os minutos, e outro para visita aberta |
| `calcularValor` | devolver o valor cobrado de uma visita encerrada |

Cuidados:

- Em `encerrar`, faça todas as verificações antes de alterar qualquer atributo. Uma recusa não pode deixar a visita pela metade.
- A saída não cria outra `Permanencia`. É o mesmo objeto que muda de estado.
- Não devolva zero para representar visita aberta.

### Como conferir

Crie uma permanência número 1 para o carro `ABC1D23` e faça as chamadas nesta ordem:

| Chamada | Resultado esperado |
|---|---|
| `estaEncerrada()` | `false` |
| `getMinutos()` | `null` |
| `encerrar(0)` | `false`, e a visita continua aberta |
| `encerrar(75)` | `true` |
| `calcularValor()` | `20.0` |
| `encerrar(20)` | `false`, e a visita continua com 75 minutos |

75 minutos são 2 horas iniciadas. A R$ 10 por hora, R$ 20. Depois, rode o verificador: o caso 13.1 deve ficar OK.

## 6. Parte 2 — Interfaces: o contrato Cobravel (TODO 13.2 e 13.3)

### A ideia

A lavagem é uma cobrança, mas não é uma permanência: não tem minutos, não tem estado aberta e custa um valor fixo. Mesmo assim, o histórico e o recibo precisam tratar as duas do mesmo jeito. Eles fazem as mesmas quatro perguntas a qualquer cobrança: qual é o número, de qual placa, qual é a descrição e quanto custa.

### Conceitos

**Interface.** É um tipo que declara um conjunto de métodos sem corpo. Ela diz o que um objeto sabe fazer. Não diz como ele faz e não guarda dados.

**`implements`.** É a palavra que uma classe usa para se comprometer com uma interface. A classe passa a ser obrigada a fornecer o corpo de todos os métodos declarados.

**`@Override`.** É a anotação colocada acima de cada método que cumpre uma operação do contrato. Ela pede ao compilador que confira se o método existe mesmo na interface.

**Analogia.** A tomada da parede é uma interface: define o formato do encaixe. Qualquer aparelho com o plugue certo funciona, e a tomada não precisa saber qual é.

Regras que valem para toda interface:

1. Não se cria objeto de interface com `new`.
2. A classe que implementa precisa fornecer todos os métodos.
3. Os métodos implementados precisam ser `public`.
4. Uma classe pode implementar várias interfaces, mas estende uma única classe.
5. Uma variável pode ter o tipo da interface e apontar para qualquer objeto que a implemente.

Exemplo em outro assunto, para ver a sintaxe:

```java
interface Imprimivel {
    String textoParaImprimir();
}

class Etiqueta implements Imprimivel {
    @Override public String textoParaImprimir() { return "Etiqueta de envio"; }
}

class Cupom implements Imprimivel {
    @Override public String textoParaImprimir() { return "Cupom de desconto"; }
}
```

`Etiqueta` e `Cupom` não são parentes. O que as une é o contrato `Imprimivel`.

**Classe abstrata ou interface?**

| | Classe abstrata (`Veiculo`) | Interface (`Cobravel`) |
|---|---|---|
| Relação | `Carro` é um `Veiculo` | `Lavagem` sabe ser cobrada |
| Guarda atributos | sim | não |
| Tem construtor | sim | não |
| Quantas por classe | uma | várias |
| Quando usar | classes da mesma família, que compartilham dados e código | classes sem parentesco, que precisam ser usadas do mesmo jeito |

### O que já vem pronto

O arquivo `Cobravel.java`, com as quatro operações. Abra e leia: são essas quatro assinaturas que as duas classes vão cumprir.

### Sua tarefa

**TODO 13.2.** Em `Permanencia.java` e em `Lavagem.java`, declare que a classe implementa `Cobravel`. Confira se os quatro métodos do contrato existem, são `public` e têm exatamente os mesmos nomes, parâmetros e tipos de retorno. Marque cada um com `@Override`.

**TODO 13.3.** Em `Lavagem.java`, complete o construtor, guardando o número, o veículo e o preço fixo já declarado na classe, e complete `calcularValor`.

Cuidados:

- `Lavagem` não estende `Veiculo` nem `Permanencia`.
- A lavagem não altera minutos nem valor de nenhuma permanência.

### Como conferir

- Uma lavagem de número 3 para a moto `XYZ9K87` deve devolver número 3 e valor `20.0`.
- Guarde uma permanência encerrada e uma lavagem em duas variáveis do tipo `Cobravel` e chame `getDescricao` e `calcularValor` nas duas. A mesma chamada deve devolver respostas diferentes.
- **Experimento do compilador.** Em uma cópia do projeto, fora de `src`, apague um dos métodos de `Lavagem` e compile. Leia a mensagem de erro e anote o que ela está cobrando. Depois, devolva o método sem a palavra `public` e compile de novo. Restaure a versão correta.
- No verificador, os casos 13.2 e 13.3 devem ficar OK.

## 7. Parte 3 — A interface no gestor (TODO 13.4 e 13.5)

### A ideia

O gestor `Estacionamento` tem três listas. Cada uma responde a uma pergunta:

| Lista | Tipo | Pergunta que responde |
|---|---|---|
| `veiculos` | lista de `Veiculo` | quais veículos conhecemos? |
| `ativas` | lista de `Permanencia` | quem está no pátio agora? |
| `cobrancas` | lista de `Cobravel` | o que já foi cobrado? |

A lista `cobrancas` é declarada com o tipo da interface. Por isso aceita permanências e lavagens.

### Conceito

**Polimorfismo por interface.** Uma variável do tipo `Cobravel` pode apontar para uma `Permanencia` ou para uma `Lavagem`. Ao chamar `calcularValor`, cada objeto responde com a sua própria regra. Quem chama não precisa saber qual é a classe.

### O que já vem pronto

As três listas, o cadastro de veículos, `consultarVeiculo`, `consultarAtiva` (que localiza a visita aberta de uma placa) e as listagens.

### Sua tarefa

**TODO 13.4.** Complete os três métodos, um de cada vez:

| Método | Quando recusa | O que faz quando aceita |
|---|---|---|
| `registrarEntrada` | placa não cadastrada, ou placa que já tem visita aberta: devolve `false` | cria uma visita aberta, guarda em `ativas`, avança a numeração e devolve `true` |
| `registrarSaida` | sem visita aberta, ou minutos não positivos: devolve `null` | encerra a mesma visita, coloca em `cobrancas`, retira de `ativas` e devolve a visita |
| `registrarLavagem` | sem visita aberta para a placa: devolve `null` | cria uma lavagem com o próximo número, guarda em `cobrancas`, avança a numeração e devolve a lavagem |

**TODO 13.5.** Complete `totalizarCobrancas`: percorra a lista `cobrancas` e some o valor de cada item, sem perguntar se é permanência ou lavagem.

Cuidados:

- Uma recusa não altera nenhuma lista nem a numeração.
- A saída não cria objeto novo e não consome número novo.
- A lavagem não encerra a visita.
- Uma visita nunca está em `ativas` e em `cobrancas` ao mesmo tempo.

### Como conferir

Em uma execução nova, faça a sequência abaixo e compare. Legenda: p1 é a permanência do carro, p2 a da moto e l3 a lavagem.

| Passo | Operação | ativas | cobrancas | Total |
|---|---|---|---|---|
| 1 | entrada do carro | p1 | vazia | 0 |
| 2 | entrada da moto | p1, p2 | vazia | 0 |
| 3 | saída do carro, 75 minutos | p2 | p1 = 20 | 20 |
| 4 | lavagem da moto | p2 | p1 = 20, l3 = 20 | 40 |
| 5 | saída da moto, 20 minutos | vazia | p1 = 20, l3 = 20, p2 = 6 | 46 |

No final, o histórico fica na ordem 1, 3, 2. A lista guarda a ordem em que as cobranças foram finalizadas, não a ordem dos números. Isso está correto.

Faça também três tentativas que devem ser recusadas e confira que nada mudou: entrada duplicada da moto, saída com 0 minutos e lavagem depois da saída.

Olhe além do total: confira a quantidade de itens em cada lista depois de cada passo. No verificador, o caso 13.4 e 13.5 deve ficar OK.

## 8. Parte 4 — Sobrecarga de métodos (TODO 13.6)

### Conceitos

**Sobrecarga.** É ter, na mesma classe, dois ou mais métodos com o mesmo nome e listas de parâmetros diferentes. O compilador escolhe a versão pelos argumentos da chamada. Mudar só o tipo de retorno não cria sobrecarga.

Exemplo em outro assunto:

```java
static int somar(int a, int b) { return a + b; }
static int somar(int a, int b, int c) { return somar(a, b) + c; }
```

**Sobrecarga e sobrescrita não são a mesma coisa:**

| | Sobrecarga | Sobrescrita |
|---|---|---|
| Onde ficam os métodos | na mesma classe | em classes diferentes |
| Parâmetros | diferentes | iguais |
| Quem escolhe a versão | o compilador, pelos argumentos | a execução, pelo objeto real |
| Anotação | nenhuma | `@Override` |

### Sua tarefa

Em `AplicacaoConsole.java`, complete os dois métodos `imprimirRecibo`:

- A versão de um parâmetro mostra, em uma linha, número, placa, descrição e valor com duas casas decimais.
- A versão com observação reaproveita a primeira e mostra a observação em uma segunda linha.

Cuidado: os dois métodos só consultam. Nenhum deles registra cobrança.

### Como conferir

- Use a opção 4 do menu para uma saída e a opção 5 para uma lavagem. Confira os campos do recibo.
- Use a opção 6 duas vezes seguidas e depois a opção 7. O histórico e o total devem ser os mesmos nas duas vezes.
- **Experimento do compilador.** Em uma cópia, crie uma terceira versão que muda só o tipo de retorno. Leia a mensagem de erro e anote.
- No verificador, o caso 13.6 deve ficar OK.

## 9. Parte 5 — Comparar textos (TODO 13.7)

### Conceitos

Há três formas de comparar `String`, e cada uma responde a uma pergunta diferente:

| Forma | Pergunta | Devolve |
|---|---|---|
| `a == b` | as duas variáveis apontam para o mesmo objeto? | `boolean` |
| `a.equals(b)` | os dois textos têm os mesmos caracteres? | `boolean` |
| `a.compareTo(b)` | qual dos dois vem primeiro na ordem alfabética? | `int` |

O resultado de `compareTo` é interpretado pelo sinal: negativo quer dizer que `a` vem antes, zero quer dizer que os textos são iguais e positivo quer dizer que `a` vem depois. Não espere exatamente 1 ou -1.

Um texto lido do teclado é sempre um objeto novo. Por isso `==` pode dizer que uma placa cadastrada não existe.

Antes de comparar um texto digitado, normalize: `trim()` retira os espaços das pontas e `toUpperCase()` passa para maiúsculas. O cadastro já guarda a placa normalizada.

### Sua tarefa

Em `AplicacaoConsole.java`, complete:

- `mesmaPlaca`: responde se as duas placas têm o mesmo texto.
- `compararPlacas`: devolve o número que indica a ordem entre as duas placas.

Os argumentos desses dois métodos já chegam normalizados.

### Como conferir

Antes de executar, escreva sua previsão para cada teste:

1. Duas `String` criadas com `new String` e o mesmo texto de placa: teste `==`, `equals` e `compareTo`.
2. As placas `ABC1D23` e `XYZ9K87`: teste `equals` e o sinal de `compareTo` nos dois sentidos.
3. O texto `abc1d23` com espaços nas pontas contra `ABC1D23`: teste `equals` antes e depois de normalizar.
4. Cadastre um terceiro veículo, de placa `LMN2P34`, e confira a ordem da listagem de veículos.

No verificador, o caso 13.7 deve ficar OK. Com isso, o resumo deve mostrar `OK=6 PENDENTE=0 REVER=0`.

## 10. Laboratório — Quatro propostas de mudança para investigar

Em dupla. Um colega revisou o projeto e sugeriu quatro mudanças. Todas compilam. Descubra o que cada uma quebra.

| Proposta | O que investigar |
|---|---|
| Somar as visitas abertas no total, valendo zero | O histórico ainda distingue visita aberta de visita encerrada? |
| Somar o preço da lavagem dentro da permanência | O que acontece com o recibo da lavagem e com duas lavagens? |
| Registrar a cobrança de novo ao imprimir o recibo | O total continua igual ao imprimir duas vezes? |
| Localizar a placa digitada com `==` | Uma placa cadastrada e digitada no teclado é encontrada? |

**Cenário, em uma execução nova:**

1. Registre a entrada do carro `ABC1D23` e da moto `XYZ9K87`.
2. Registre duas lavagens da moto.
3. Encerre o carro com 31 minutos.
4. Encerre a moto com 121 minutos.
5. Liste o histórico e imprima os recibos duas vezes.

Antes de executar, calcule à mão quantas cobranças haverá, o valor de cada uma e o total.

**O que entregar:** a previsão, o resultado obtido e, para cada proposta, um teste que passa no programa correto e falha no programa alterado.

**Critério:** o parecer explica o defeito de cada proposta pelo estado das listas e dos objetos, e não só pelo total final.

| Proposta | Meu teste | Resultado no programa correto | Resultado com a proposta | Conclusão |
|---|---|---|---|---|
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |
| ___ | ___ | ___ | ___ | ___ |

## 11. Para fechar

- Registre esta etapa no seu repositório do Projeto 3, com uma mensagem como: interfaces, visitas abertas, lavagens e recibos.
- Não envie `build/`, `target/` nem arquivos `.class`.
- Preencha o roteiro de registro (`ROTEIRO_ALUNO_ENCONTRO_13.md`).

**O que ainda é frágil no programa, e será tratado depois:**

- uma operação recusada não informa o motivo (aula 14);
- digitar letras onde o menu espera número interrompe o programa (aula 14);
- pedir o valor de uma visita aberta interrompe o programa (aula 14);
- todos os arquivos estão no mesmo pacote (aula 15).

**Para estudar mais:**

- Interfaces: https://dev.java/learn/interfaces/
- Boxing e unboxing: https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html
- Classe `String`: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html
