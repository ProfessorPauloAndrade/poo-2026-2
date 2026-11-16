# Encontro 6 — Projeto 1: construtores e encapsulamento

Neste encontro, concluiremos a evolução do cadastro de produtos. `Produto` deixa de ser criado vazio, passa a ter atributos privados e controla a alteração de seu preço.

1. Leia o [material do aluno](MATERIAL_ALUNO.md).
2. Consulte a [apresentação](APRESENTACAO.md) ou o [deck no Gamma](https://gamma.app/docs/fpljkrz226ib3b7).
3. Copie o arquivo inicial em [exemplos/encontro-6/aluno/CadastroProdutosEncapsuladoInicial.java](exemplos/encontro-6/aluno/CadastroProdutosEncapsuladoInicial.java).
4. Preserve as regras e os testes do CRUD enquanto refatora.

A solução completa permanece fora deste repositório.

## Como compilar e começar

Abra um terminal na pasta `exemplos/encontro-6/aluno` deste encontro e execute:

```sh
javac -encoding UTF-8 CadastroProdutosEncapsuladoInicial.java
java CadastroProdutosEncapsuladoInicial
```

Compile cada encontro em sua própria pasta, pois os nomes das classes auxiliares se repetem. O esqueleto compila antes de ser preenchido; o funcionamento dos exercícios depende dos `TODO`s. Retornos provisórios não comprovam os resultados esperados. Complete uma etapa, recompile e confira o estado dos objetos com os testes do material.

No construtor completo de `Produto`, substitua as atribuições provisórias `0` e `0.0` pelos parâmetros recebidos. Elas apenas permitem compilar o arquivo inicial.
