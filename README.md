# Project
- [ ] define interfaces
- [ ] define packages

# Tests

## Compile Tests

class first

`javac Operacoes.java`

test

`javac -cp .:lib/junit-4.12.jar OperacoesTest.java`

## Execute

`java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore OperacoesTest`


## TODO:
- [x] test size
- [ ] test registers
- [ ] test addressing

## Errors:
- -1: copy(List<String> memory, int N); tipo de endereçamento do operando 2 foi mal definido/está incorreto.
- -2: divide(List<String> memory, int N, int tipoEnd); operando inválido, não é possível realizar divisão por 0.
- -3: read(List<String> memory, int N); tipo de endereçamendo do operando é inválido.
- -4: stop(int N); (NÃO É ERRO) 
