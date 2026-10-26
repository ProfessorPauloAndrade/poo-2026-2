#!/bin/sh
set -eu
cd "$(dirname "$0")"
mkdir -p build
POO_BUILD=$(mktemp -d build/exec.XXXXXX)
find src/main/java src/test/java -name "*.java" ! -name "TesteDeProgresso.java" -exec printf '"%s"\n' {} \; > "$POO_BUILD/fontes.txt"
javac --release 21 -encoding UTF-8 -d "$POO_BUILD/classes" @"$POO_BUILD/fontes.txt"
java -cp "$POO_BUILD/classes" br.edu.uva.estacionamento.app.VerificarAula
