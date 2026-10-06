# 1. Ana quer café e pão no mesmo pedido

Na cafeteria, Ana faz o pedido 10: café 101, preço 5.50, quantidade 3; pão 202, preço 8.00, quantidade 2.
A versão da aula 07 só guarda um item. Como representar a compra inteira sem espalhar cálculos pelo main?
Antes de executar, escreva o total que espera encontrar.

---

# 2. O que preservamos da aula 07

Produto controla código e preço. ItemPedido conhece produto e quantidade e calcula subtotal. Pedido cria e controla seus itens.
O item guarda uma referência ao Produto, sem copiar seu preço.
Hoje muda o armazenamento: um item passa a ser uma lista de itens.

---

# 3. Produto esperado e percurso

Construir um menu de pedido com inclusão, consulta, alteração, remoção e listagem.
1. Observar o limite. 2. Experimentar a lista. 3. Buscar por código. 4. Implementar CRUD. 5. Testar e justificar.
Ao final: explicar índice versus código, implementar CRUD preservando validações e comprovar a refatoração com testes.

---

# 4. Regras do pedido antes do código

Catálogo fixo: 101 → 5.50; 202 → 8.00; 303 → 4.00. Dados fictícios.
Pedido começa vazio; cada código aparece no máximo uma vez. Inclusão repetida é recusada, sem somar quantidade. Quantidade deve ser positiva. Código ausente e entrada inválida preservam o estado.
Preço permanece no Produto; total usa o preço atual. Tudo fica em memória.

---

# 5. Um campo não representa uma quantidade variável

Antes: private final ItemPedido item;
Criar item1, item2, item3 imporia um limite e repetiria métodos.
Um array permitiria vários itens, mas exigiria controlar ocupação e deslocar referências na remoção.
Em dupla: escreva duas tarefas manuais do array que a nova estrutura deverá assumir.

---

# 6. Coleção: vários elementos em uma estrutura

Uma coleção reúne elementos para operações de armazenamento e consulta.
Uma lista mantém uma sequência: cada elemento tem uma posição, começando em zero.
ArrayList é uma lista que ajusta automaticamente a capacidade de armazenamento. Ela ainda depende da memória disponível.
A sequência contém referências para ItemPedido.

---

# 7. Criar a primeira lista tipada

```java
import java.util.ArrayList;
ArrayList<Produto> produtos = new ArrayList<>();
```
ArrayList é a classe. O tipo Produto entre sinais de menor e maior restringe o elemento permitido. new cria uma lista vazia. O par de sinais à direita reaproveita o tipo indicado à esquerda.
Criar a lista não cria nenhum Produto. size() começa em zero.

---

# 8. List e ArrayList: duas funções na declaração

```java
import java.util.List;
import java.util.ArrayList;
List<ItemPedido> itens = new ArrayList<>();
```
List é uma interface da biblioteca que declara operações de lista. ArrayList é a classe concreta que as implementa e que instanciamos.
Usaremos essa declaração pronta; criação de interfaces próprias e polimorfismo serão aprofundados depois. Não se escreve new List<>().

---

# 9. Operações que usaremos

| Operação | Efeito |
|---|---|
| add(elemento) | acrescenta no fim |
| size() | quantidade de elementos |
| isEmpty() | indica lista vazia |
| get(indice) | consulta referência na posição |
| set(indice, elemento) | substitui a referência naquela posição |
| remove(indice) | retira a posição e reorganiza a sequência |
Nenhuma operação conhece as regras de um pedido.

---

# 10. Inclusão e leitura: primeira previsão

```java
Produto cafe = new Produto(101, 5.50);
Produto pao = new Produto(202, 8.00);
List<Produto> produtos = new ArrayList<>();
produtos.add(cafe);
produtos.add(pao);
System.out.println(produtos.size());
System.out.println(produtos.get(0).getCodigo());
```
Anote as duas saídas antes de executar; depois confira no terminal.

---

# 11. Índice não é código

| Índice | Código do produto |
|---|---|
| 0 | 101 |
| 1 | 202 |
get(1) consulta a segunda posição, cujo produto tem código 202. get(202) tentaria acessar uma posição inexistente.
Para size() = 2, somente índices 0 e 1 são válidos: 0 <= indice < size().
Escreva qual comparação deve procurar o código 202.

---

# 12. Array e ArrayList: a refatoração visível

| Array de objetos | Lista |
|---|---|
| vetor[i] | itens.get(i) |
| quantidade ocupada manual | itens.size() |
| inserir e incrementar contador | itens.add(item) |
| deslocar e limpar última posição | itens.remove(indice) |
length é a capacidade do array; size() conta os elementos da lista. A lista tem capacidade interna, mas não precisamos administrá-la nesta aula.

---

# 13. Prática curta: a lista em movimento

Em dupla, crie uma lista tipada de Produto, adicione café e pão, leia os códigos com get e remova a posição zero.
Tempo: 8 minutos. Produto: quatro linhas de saída com tamanho antes/depois e código em get(0) antes/depois.
Critério: prever a mudança de posição, executar e explicar a diferença entre retirar a referência e alterar o Produto.
Não use código do produto como argumento de get ou remove.

---

# 14. A nova estrutura de Pedido

```java
class Pedido {
    private final int numero;
    private final List<ItemPedido> itens = new ArrayList<>();
    Pedido(int numero) { this.numero = numero; }
}
```
private mantém a coleção sob controle do pedido. final impede trocar a referência da lista, mas permite adicionar e remover seus elementos.
Não devolveremos a lista interna ao main.

---

# 15. As responsabilidades continuam

main lê e mostra mensagens. Produto controla o preço. ItemPedido controla quantidade e calcula subtotal. Pedido controla inclusão, busca, alteração e remoção de seus itens.
Pedido cria cada ItemPedido internamente; remover o item não remove o Produto do catálogo.
Agora há vários itens, mas o aprofundamento das multiplicidades e de vários pedidos fica para a aula 09.

---

# 16. Busca por código: contrato primeiro

buscarIndice(codigo) é um método privado de Pedido.
Entrada: código do Produto, como 202. Saída: posição do item correspondente ou -1 quando não existe.
Precisamos consultar o código pelo item:
```java
int getCodigoProduto() {
    return produto.getCodigo();
}
```
Não expomos o atributo produto para procurar o item.

---

# 17. Busca por código: construir o percurso

```java
private int buscarIndice(int codigo) {
    for (int i = 0; i < itens.size(); i++) {
        if (itens.get(i).getCodigoProduto() == codigo) return i;
    }
    return -1;
}
```
get recupera o item; getCodigoProduto consulta seu código; == compara inteiros. O retorno encerra a busca no primeiro resultado.
Não usamos contains(codigo): os elementos são ItemPedido, não códigos inteiros.

---

# 18. Rastrear a busca sem computador

Lista: posição 0 → código 101; posição 1 → código 202; posição 2 → código 303.
Em dupla, preencha i, código consultado, comparação e retorno para procurar 303 e 999.
Tempo: 7 minutos. Produto: duas tabelas de rastreamento.
Critério: uma busca termina ao encontrar; a outra percorre toda a lista e retorna -1. A lista permanece intacta.

---

# 19. CRUD: operações do pedido

Create → adicionarItem(produto, quantidade).
Read → consultarItem(codigo) e exibir().
Update → alterarQuantidade(codigo, novaQuantidade).
Delete → removerItem(codigo).
Buscar por código será reutilizado nas quatro operações. Cada método decide se pode mudar o estado antes de fazê-lo.

---

# 20. Incluir: validar antes de criar

```java
if (produto == null || quantidade <= 0) return false;
if (buscarIndice(produto.getCodigo()) != -1) return false;
```
null significa que o catálogo não encontrou produto. A primeira condição protege o acesso posterior a getCodigo().
A segunda recusa código repetido: esta é uma regra do projeto, não de ArrayList. Listas permitem repetições.

---

# 21. Incluir: Pedido cria e armazena a parte

```java
boolean adicionarItem(Produto produto, int quantidade) {
    if (produto == null || quantidade <= 0) return false;
    if (buscarIndice(produto.getCodigo()) != -1) return false;
    itens.add(new ItemPedido(produto, quantidade));
    return true;
}
```
new cria o item; add guarda sua referência no fim. Pedido controla a criação; Produto continua independente. false indica recusa sem mudança.

---

# 22. Verificação incremental da inclusão

Complete buscarIndice e adicionarItem no arquivo inicial. Compile antes de continuar.
No menu: liste vazio; inclua 101 com 3 unidades; inclua 202 com 2; liste novamente.
Tempo: 12 minutos. Produto: estado exibido e duas tentativas de inclusão recusadas, uma repetida e uma inválida.
Critério: cada inclusão válida aumenta size em um; recusa preserva tamanho e total.

---

# 23. Consultar: proteger o valor-sinal

```java
boolean consultarItem(int codigo) {
    int indice = buscarIndice(codigo);
    if (indice == -1) return false;
    itens.get(indice).exibir();
    return true;
}
```
-1 é sinal de ausência, nunca índice para get. Consulta exibe um item sem alterar lista ou quantidade.
No main, false produz a mensagem de item não encontrado.

---

# 24. Atualizar: alterar o objeto existente

```java
boolean alterarQuantidade(int codigo, int novaQuantidade) {
    int indice = buscarIndice(codigo);
    if (indice == -1) return false;
    return itens.get(indice).alterarQuantidade(novaQuantidade);
}
```
Pedido localiza e delega. ItemPedido valida quantidade positiva e modifica seu estado. Preço fica no Produto.
Não é necessário substituir o elemento da lista.

---

# 25. set não é sinônimo de alterar atributo

```java
produtos.set(0, outroProduto);
produtos.get(0).alterarPreco(6.00);
```
set troca a referência da posição zero. alterarPreco modifica o objeto já referenciado.
No pedido, usamos alterarQuantidade para preservar produto e vínculo do item.
Em dupla: descreva o que permanece e o que muda nas duas operações.

---

# 26. Remover: buscar e retirar a posição certa

```java
boolean removerItem(int codigo) {
    int indice = buscarIndice(codigo);
    if (indice == -1) return false;
    itens.remove(indice);
    return true;
}
```
remove(indice) reorganiza as posições seguintes. Não precisamos deslocar manualmente.
Não usamos remove(codigo): um argumento int é interpretado como índice.

---

# 27. Depois da remoção, os índices mudam

Antes: [0:101] [1:202] [2:303]. Remover a posição 1.
Depois: [0:101] [1:303]. O código 303 não mudou; sua posição mudou.
Por isso buscamos novamente por código a cada operação, sem guardar índices como identidade.
Não removemos dentro de um for-each. Primeiro buscamos; depois removemos uma única posição.

---

# 28. Prática: consulta, atualização e remoção

Complete as três operações no código inicial. Use 101/3, 202/2 e 303/1.
Consulte 202; altere sua quantidade; remova 101; tente consultar 101 e altere 303.
Tempo: 15 minutos. Produto: registros antes/depois e resultado de duas operações com código ausente.
Critério: preservar o item 303 depois do deslocamento e não acessar get(-1).

---

# 29. Total: acumular subtotais, sem duplicar regra

```java
double calcularTotal() {
    double total = 0;
    for (int i = 0; i < itens.size(); i++) {
        total += itens.get(i).calcularSubtotal();
    }
    return total;
}
```
total é acumulador local, reiniciado a cada chamada. Cada item calcula seu subtotal. Lista vazia não executa o laço e retorna zero.

---

# 30. Listagem: um percurso, vários objetos

```java
if (itens.isEmpty()) System.out.println("Pedido vazio.");
for (int i = 0; i < itens.size(); i++) {
    itens.get(i).exibir();
}
System.out.printf("Total: %.2f%n", calcularTotal());
```
O método exibir de Pedido também mostra número e size(). A listagem e o total consultam a mesma coleção.
Não manteremos um total armazenado que possa ficar desatualizado.

---

# 31. Outra leitura do percurso: for-each

```java
for (ItemPedido item : itens) {
    total += item.calcularSubtotal();
}
```
Leia: para cada ItemPedido item da lista itens. item recebe uma referência por vez. É útil quando não precisamos da posição.
O código principal conserva for com índice para retomar a experiência com arrays. Não alterar a estrutura da lista durante esse percurso.

---

# 32. Referências continuam compartilhadas

O item do café guarda a mesma referência ao Produto 101 do catálogo.
Após incluir café e pão, altere o preço do café para 6.00. Nenhum item precisa receber uma cópia do novo preço: o subtotal consulta o Produto novamente.
Esta aula preserva o preço atual da aula 07. Um pedido real pode exigir preço histórico, assunto fora deste recorte.

---

# 33. Testes do exemplo guiado

| Sequência | Total esperado |
|---|---|
| vazio | 0.00 |
| incluir 101/3 | 16.50 |
| incluir 202/2 | 32.50 |
| alterar preço de 101 para 6.00 | 34.00 |
| alterar quantidade de 202 para 1 | 26.00 |
| remover 101 | 8.00 |
| remover 202 | 0.00 |
Faça previsão antes de executar. Repita inclusão duplicada e quantidade zero: estado deve permanecer igual.

---

# 34. Menu e limites da aplicação

1 listar; 2 incluir; 3 consultar; 4 alterar quantidade; 5 remover; 6 alterar preço; 7 catálogo; 0 sair.
O catálogo é um array pequeno e fixo; a lista variável desta aula é a de itens do pedido.
Informe códigos inteiros e preços com ponto. O menu reutiliza Scanner; texto em campo numérico não é tratado nesta etapa. Exceções ficam para a aula correspondente.
Ao encerrar, os dados em memória se perdem.

---

# 35. Investigação: o caixa retirou o item errado

Um caixa escreveu itens.remove(codigo). Testou apenas código 0, e a remoção parecia funcionar.
Use os códigos reais 101, 202 e 303. Investigue por que o teste inicial escondia o erro e proponha uma correção por busca.
Depois de remover o item intermediário, consulte e altere o último.
Tempo: 12 minutos. Produto: diagnóstico, trecho corrigido e teste que demonstra o problema.

---

# 36. Laboratório: finalizar um pedido confiável

Em dupla, conclua os TODOs e valide todas as operações do menu.
Tempo: 28 minutos no total, incluindo os 12 minutos da investigação anterior. Entrega: arquivo Java, tabela de testes e justificativa escrita de índice versus código e de quem controla os itens.
Critério: CRUD completo; repetição/ausência/quantidade inválida preservam estado; pedido vazio retorna zero; preço compartilhado continua funcionando.
Soluções e respostas da investigação serão discutidas depois da tentativa.

---

# 37. Evidências que você deve registrar

Teste também: excluir o primeiro, intermediário e último item; remover todos; incluir novamente após esvaziar; código 999; preço zero; opção desconhecida.
Registre entrada, estado antes, esperado, observado e conclusão. Se houver falha, corrija e repita o menor caso que a demonstra.
Sem computador: rastreie a sequência em papel, desenhando posições e códigos e escrevendo os métodos essenciais.

---

# 38. Comparação final: o comportamento foi preservado?

Reproduza o caso da aula 07: café 101, quantidade 3 → 16.50; preço 6.00 → 18.00; quantidade 4 → 24.00.
Agora acrescente outros produtos sem alterar as classes Produto e ItemPedido.
Explique: qual limitação desapareceu e quais responsabilidades e regras permaneceram?
Essa comparação é a evidência da refatoração.

---

# 39. Commit e síntese

Compile e execute os testes antes do commit. No repositório próprio do Projeto 2:
```text
git add .
git commit -m "Evolui pedido com lista e CRUD de itens"
git push
```
Guarde o commit local se não houver Internet.
Síntese: lista guarda referências; size mede elementos; índice não é código; CRUD valida antes de mudar; Pedido controla itens e delega cálculos.

---

# 40. Saída individual e ponte para a aula 09

Sem consultar a dupla, escreva: por que remove(202) não remove necessariamente o produto 202? Como atualizar quantidade sem set? O que final protege na lista?
Entregue também uma sequência mínima que testa código ausente após remover o primeiro item.
No encontro 09, usaremos a lista já funcional para aprofundar relações 1:1 e 1:N e a colaboração entre vários objetos.
