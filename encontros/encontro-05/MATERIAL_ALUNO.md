# Encontro 5 — Projeto 1: de arrays paralelos a objetos

## Objetivo

Refatorar o cadastro de produtos do encontro anterior para que cada produto seja representado por um objeto da classe `Produto`. O comportamento continua o mesmo: cadastrar, consultar, alterar preço, remover e listar até cinco produtos.

## Situação

Na versão anterior, o produto de código 205 e seu preço estavam ligados apenas porque ocupavam o mesmo índice em dois arrays. Agora a lista vai guardar referências para objetos. Cada objeto reúne o código, o preço e as ações que fazem sentido para um produto.

## O que muda e o que permanece

| Permanece | Muda |
|---|---|
| menu, regras de negócio, busca, CRUD e testes | dois arrays `int[]`/`double[]` viram um array `Produto[]` |
| máximo de 5 produtos | código e preço passam a ser atributos do mesmo objeto |
| métodos estáticos que coordenam o cadastro | ações próprias do produto viram métodos de instância |

## Roteiro

1. Abra `exemplos/encontro-5/aluno/CadastroProdutosObjetosInicial.java`.
2. Complete a classe `Produto`: declare `codigo` e `preco`, implemente `exibir()` e `alterarPreco(double novoPreco)`.
3. No cadastro, crie `Produto novoProduto = new Produto();`, preencha os atributos e coloque a referência no array: `produtos[quantidade] = novoProduto`.
4. Ajuste a busca para comparar `produtos[i].codigo`.
5. Atualize consulta e listagem para chamar `produtos[indice].exibir()`.
6. Atualize alteração para chamar `produtos[indice].alterarPreco(novoPreco)`.
7. Na remoção, desloque referências: `produtos[i] = produtos[i + 1]`; deixe a última posição como `null`.
8. Execute os testes e compare o comportamento com a versão do encontro 4.

## Leitura do estado

```text
produtos[0] ──► Produto { codigo: 101, preco: 5.50 }
produtos[1] ──► Produto { codigo: 205, preco: 7.00 }
produtos[2] ──► null
```

`produtos[0]` não é o produto inteiro: é uma referência que aponta para ele. A posição vazia deve conter `null`.

## Testes

Use os mesmos casos do encontro 4: lista vazia, dois cadastros, código duplicado, alteração, remoção, código inexistente e capacidade máxima.

Acrescente estas verificações:

- Ao listar dois produtos, cada linha deve trazer o código e o preço do mesmo objeto.
- Depois de remover o primeiro produto, o objeto seguinte deve estar no índice 0.
- Depois da remoção, a última posição antes ocupada deve ser `null`.
- Alterar o preço de 205 não deve modificar o objeto 101.

## Entrega

- `Produto.java` e `CadastroProdutosObjetos.java` funcionando;
- uma explicação de uma frase para a diferença entre objeto e referência;
- commit sugerido: `Refatora cadastro para objetos Produto`.

## Limite assumido hoje

Nesta versão, os atributos ainda são acessados diretamente para enxergar a refatoração com clareza. No próximo encontro, vamos proteger o estado com construtor, `this`, visibilidade e métodos de acesso controlado.
