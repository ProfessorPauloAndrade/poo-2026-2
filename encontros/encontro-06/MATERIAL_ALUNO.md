# Encontro 6 — Projeto 1: construtores e encapsulamento

## Objetivo

Concluir o cadastro de produtos para que cada `Produto` seja criado com seus dados e tenha o preço protegido contra alterações inválidas. O menu e as operações do CRUD devem continuar funcionando como no Encontro 5.

## Roteiro

1. Abra `exemplos/encontro-6/aluno/CadastroProdutosEncapsuladoInicial.java`.
2. Complete o construtor `Produto(int codigo, double preco)` com `this.codigo = codigo` e `this.preco = preco`.
3. Leia o construtor sobrecarregado `Produto(int codigo)`: ele chama o construtor completo com `this(codigo, 1.00)`.
4. Complete `alterarPreco(double novoPreco)` para recusar valor menor ou igual a zero.
5. Use `getCodigo()` para a busca e `alterarPreco()` para a mudança de preço. Não acesse atributos diretamente.
6. Valide código e preço no cadastro antes de criar `new Produto(codigo, preco)`.
7. Compile e execute os testes.

## Testes

| Situação | Resultado esperado |
|---|---|
| cadastrar 101 / 5.50 e 205 / 7.00 | dois produtos listados corretamente |
| cadastrar 101 novamente | código recusado |
| cadastrar 0 / 5.50 ou 101 / 0 | cadastro recusado |
| alterar 205 para 7.50 | apenas o preço de 205 muda |
| alterar 205 para -1 | preço anterior é preservado |
| remover 101 | 205 passa para o índice 0 |
| consultar 999 | produto não encontrado |
| cadastrar seis produtos | o sexto é recusado |

## Entrega

- arquivo compilável e funcional;
- todos os testes executados;
- uma frase explicando por que o cadastro não deve usar `produto.preco = novoPreco`;
- commit sugerido: `Encapsula Produto com construtores e acesso controlado`.
