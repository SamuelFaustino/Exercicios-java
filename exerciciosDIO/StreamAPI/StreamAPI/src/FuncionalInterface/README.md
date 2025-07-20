# Este Documento tem como objetivo mapear parte do processo de desenvolvimento através da StreamAPI
## Dados os já entendidos conceitos: Programação declarativa, Lambda Expressions e Method Reference, o texto a seguir formula o desenvolvimento passo a passo do uso StreamAPI atrelados aos demais conceitos.

### StreamAPI: Sua utilização por meio de uma IDE é o caminho ideal, já que a interface de desenvolvimento por sí só auxilía e guia os procedimentos.
### Exemplo Consumer, etapas:
 ```CONSUMER - Representa uma operação que aceita um argumento do tipo T(qualquer) e não retorna nenhum resultado.```

### 1 ) Utilização do Stream para imprimir números pares em uma List.
```
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5); // criação da List

numeros.stream().forEach(n -> {
                if( n % 2 == 0) {
                    System.out.println(n);
                }
        });
```
### Como se chega a essas declarações ?
### R:
### 1. 1 ) forEach é uma das dezenas de métodos do StreamAPI, métodos esses de conhecimento prévio do desenvolvedor, após chama-los norteiam os passos seguintes. Stream em ```stream().forEach``` espera como parâmetro um Consumer _(que é uma Functional Interface)_ esse deve ser implementado a fim de compor o método onde será utilizado, entretanto também pode ser implementado de maneira externa e posteriormente passado como parâmetro _(desde que seja do tipo Consumer)_.
### 1. 2 ) Dado a List de números já apresentada, se fosse implementado de maneira antecipada, a fins de exemplo e teorização seria como no fragmento a baixo:
``` 
 Consumer<Integer> imprimirNumeroPar = numero -> {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
        };
```
#### Perceba, até então, não foi utilizado a List quem contem os números, apenas declarado a implementação do método abstrato, ou seja como ele deve agir, criando uma variável chamada 'numero', porem não percorre ou itera sobre nenhuma List.
### 1. 3 ) De modo a utilizar de toda a praticidade do StreamAPI se torna mais eficiênte a implementação direto na declaração. Segue:
``` 
numeros.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                if(n % 2 == 0) {
                    System.out.println(n);
                }
            }
        });
```
#### Repare que agora a chamada(Stream) e a implementação(Consumer) se encontram juntas, atuando sobre a List 'numeros' a primeira a aparecer no código para ser utilizada. A instanciação do Consumer também já obriga a sobrescrita do método, que fica mais claro quando feito sem expressões lambda.
### 1. 4 ) LAMBDA - Função sem declaração, método declarado no mesmo lugar que será usado.
        // SINTAXE: (argumento) -> (corpo)
    // Exp. Lambda representam INTERFACES FUNCIONAIS (contém um único met. abstrato) e possibilita escrita de código Funcional.
        // Essas interfaces funcionais servem de BASE PARA USO DE EXPRESSÕES LAMBDA.
### Assim com a aplicação das expressões lambda conseguimos reduzir apenas a um argumento e corpo, como esperado pelo Consumer uma operação que aceita apenas um argumento (n) e não retorna nenhum resultado (no exemplo é apenas exibido os valores no output). Dispensando assim a instanciação _explicita_ do Consumer, as anotações de sobrescrita, e a assinatura do método.
```
numeros.stream().forEach(n -> {
                if( n % 2 == 0) {
                    System.out.println(n);
                }
            });
```
---
### Exemplo Supplier, etapas:
``` SUPPLIER - Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.```
### 2 ) Utilização do Supplier para imprimir uma lista de saudações
``` 
Supplier<String> saudacao = () -> "Olá, Bom dia!";
List<String> listaSaudacoes = Stream.generate(saudacao)
                .limit(3)
                .collect(Collectors.toList());
        
```
### Como chegar a essa declaração: ```Supplier<String> saudacao = () -> "Olá, Bom dia!"; ``` ? Apesar do escopo do Supplier, leva um tempo para interpretação, visto que contem um alto nível de simplificação.
### 2. 1 ) O exemplo do Supplier é feito no método .generate que ao ser chamado já indica que espera por um Supplier, sendo assim, é instânciado um novo e passado o mesmo tipo da declaração ```Supplier<String>()``` _(generics)_.
### Ao ser chamado já indica a necessidade de implementação do método, implementação essa, feita de maneira quase que automática pela própria IDE, ao clicar na indicação, confirma o tipo de entrada e retorno esperado, nesse caso: ``` get(): T```. 
### Após isso basta preecher o método:
```
List<String> listaSaudacoes = Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                return "Olá, Bom dia!";
            }
        }).toList();
```
#### Perceba, nesse exemplo, o código se sobreescrita do método foi alterado apenas no conteudo do return e adicionado o .toList().

### 2. 2 ) Lambda Expresion
```declarative
List<String> listaSaudacoes = Stream.generate(() -> "Olá, Bom dia!").limit(3).toList();
```
#### Perceba, a expressão corresponde a do método: não aceita nenhum argumento e retorna um resultado do tipo T ```(() -> "...")```, argumento vazio representado pelos parênteses e o tipo T nesse caso é uma String.
### 2. 3 ) Desta forma basta apenas imprimir utilizando o mesmo Consumer, a quantidade de código foi reduzida significativamente. Segue:
```declarative
List<String> listaSaudacoes = Stream.generate(() -> "Olá, Bom dia!").limit(3).toList();
listaSaudacoes.forEach(System.out::println);
```
#### ```listaSaudacoes.forEach(s -> System.out.println(s));``` essa é a forma utilizada no exemplo anterior (Consumer), porem também já é sugerido a alteração para o Method Reference, a fim de simplificação e redução de código. Portanto o ideal é que se chegue nessas implementações das Funcional Interfaces de maneira direta com o uso das Lambda Expresion.



### 3 ) Dessa forma a StremAPI proporciona uma forma diferente de lidar com com coleções, tornando mais simples a manipulação e principalmente escrita, agregando muito em produtividade.