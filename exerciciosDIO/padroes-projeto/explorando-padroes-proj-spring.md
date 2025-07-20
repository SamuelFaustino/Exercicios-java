# Explorando Padrões de Projeto na prática com Java

## Padrões de Projeto: São soluções consolidadas para problemas recorrentes no desenvolvimento e manutenção de software orientado a objetos.

## Serão utilizados:
## Como Criacional - Singleton: Possui o objetivo de prover sempre uma instância única de uma determinada classe. Ex: O Autowired do Spring utiliza o bean definido, reaproveitando a instância sempre que possível p/ aquele objeto.
## Como Comportamental - Strategy: Que representa uma interface que irá definir um contrato para que seja seguido por muitas implementações/variações de um mesmo algorítmo que respeitam uma mesma interface. Ex: List Interface em Java.
## Como Estrutural - Facade: Interface que abstrai a integração com múltiplos subsistemas/sistemas internos que requerem integração complexa, ou seja, prover uma interface simplificada e abstrair a complexidade de eventuais integrações, sejam elas internas ou externas.

# Implementações Spring Framework
## Singleton: @Bean e @Autowired
    Objetos da aplicação gerenciados pelo Spring são sempre entregues como Singleton, inclusive para otimizar memória.
## Strategy: @Service e Repository
    Alguns componentes implementam direta ou indiretamente. @Service (pode ser usada na camada de serviço p/ indicar que será um componente injetável dentro da camada de regras de negócio).
## Facade: A construção de uma API REST com o mesmo objetivo desse padrão, abstrair a complexidade das integrações: Spring Data JPA e ViaCEP(Feign).
    Usar Facade como análoga a API REST, pois a função de uma API REST é expor uma interface simples/coesa, que eventualmente haverão diversas abstrações de complexidade relacionada a banco de dados, sistemas externos etc.

### Projeto Base
    1) Criação do projeto base nesse exemplo com: SpringWeb, Spring DataJPA, H2 e OpenFeign (Client REST declarativo p/ criar client http consumir api externa, maneira simples), declarado interface, utiliza-se das mesmas anotations dos endpoints rest.  Dependencia adicional, OpenAPI adicionado via POM(novo Swagger), tem como função expor interface visual p/ consumir API (dispensando uso do Postman por exemplo).
    2) Cada uma das entidades possui um repository, ou seja a interface que provê todos os métodos de acesso a dados de uma determinada entidade. Exemplo: ClienteRepository extends CrudRepository -> Sendo esse CrudRepository uma strategy (obriga a seguir extratégia de implementação), dispença inclusive o uso do '@Repository' sobre a classe porque apenas o fato da classe extender de Repository o Spring já entende a necessidade de implementar algo concreto e o injeta.
    3) Camada de Serviço (negócio) onde estão as regras e complexidade de integração, onde normalmente é de responsabilidade da Facade. Foi criado uma interface (que representa uma strategy) que contem todas operações de crud. Posteriormente o ClienteService Implementa essa interface. Nessa camada também está contido o client do Feign, que é representado por uma interface com anotation e a url base do client(disp. no próprio site do viaCEP). Nessa classe contem o método com @RequestMapping passando que é um GET, que busca o JSON, o qual é convertido no objeto anteriormente mapeado (endereco) e devolve o endereço populado (Feign usa mesmas anotações do Spring).
    4) Dado a estrutura do projeto: segue a inicialmente pelo ClienteRestController - que é quem recebe as requisições, ou seja o primeiro componente a ser acionado, pois expõe os end-points (é a interface de consumo, apresentada inclusive pelo swagger visualmente). 



