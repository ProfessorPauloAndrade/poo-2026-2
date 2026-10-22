# Encontro 7 — Projeto 2: relacionamentos e responsabilidades

Neste encontro, iniciaremos um pedido formado por objetos que colaboram. `ItemPedido` usa um `Produto` já existente; `Pedido` cria e controla seu item.

1. Leia o [material do aluno](MATERIAL_ALUNO.md).
2. Consulte a [apresentação](APRESENTACAO.md) ou o [deck revisado no Gamma](https://gamma.app/docs/og9qgeravn7mbx2).
3. Copie [ProjetoPedidoInicial.java](exemplos/encontro-7/aluno/ProjetoPedidoInicial.java).
4. Preserve as responsabilidades de cada classe enquanto completa o exemplo.

A solução completa permanece fora deste repositório.

## Como compilar e começar

Abra um terminal na pasta `exemplos/encontro-7/aluno` deste encontro e execute:

```sh
javac -encoding UTF-8 ProjetoPedidoInicial.java
java ProjetoPedidoInicial
```

Compile cada encontro em sua própria pasta, pois os nomes das classes auxiliares se repetem. O esqueleto compila antes de ser preenchido; o funcionamento dos exercícios depende dos `TODO`s. Retornos provisórios não comprovam os resultados esperados. Complete uma etapa, recompile e confira o estado dos objetos com os testes do material.
