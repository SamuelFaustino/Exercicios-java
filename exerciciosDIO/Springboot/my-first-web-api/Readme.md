 Criando uma API REST Documentada com Spring Web e Swagger
    ## Springboot Web - Dois Direcionamentos, sendo o Spring web MVC (aplicação web de fato com interfaces, páginas) ou somente concepção REST API(camada de disp. de recursos apenas). Ênfase no ecosistema Rest.
    Introdução - Implementar recursos HTTP para interação de arquivos JSON pelas aplicações. A proposta é disponibilizar serviços; os clientes irão ter uma comunicação de realização de requisições e respostas no formato JSON. Não se trata de Spring web mvc.
    
    Uma *API (interface application program)* é um código programável que faz a "ponte" de comunicação entre duas aplicações distintas. A API *REST (representational state transfer)* é como um guia de boas práticas e *RESTful* é a capacidade de determinado sistema aplicar os princípios de REST. 
    Para que uma arquitetura seja RESTful, é necessário ter uma série de princípios ou padrões:
        . cliente-servidor - significa aprimorar a portabilidade entre várias plataformas de interface do usuário e do servidor, permitindo uma evolução independente do sistema;
        . interface uniforme - representa uma interação uniforme entre cliente e servidor. Para isso, é preciso ter uma interface que identifique e represente recursos, mensagens autodescritivas, bem como hypermedia(HATEOAS);
        . stateless - indica que cada interação via API tem acesso a dados completos e compreensíveis;
        . cache - necessário para reduzir o tempo médio de resposta, melhorar a eficiência, desempenho e escalabilidade da comunicação;
        . camadas - permite que a arquitetura seja menos complexa e altamente flexível.
    _Glory of REST_, Modelo de maturidade para esse tipo de API.
    Nível 0: Ausência de Regras - Implementa todos os recursos mas não segue nenhum padrão.
    Nível 1: Aplicação de Resources - nome dos recurso equalizados e para não gerar ambiguidade é necessário definir um verbo apropriado
    Nível 2: Implementação de verbos HTTP - Como a definição dos verbos já foi requisitada no Nível 1, o Nível 2 se encarrega de validar a aplicabilidade dos verbos para finalidades específicas como: Todas as requisições que precisam retornar dados devem usar o GET (verbo HTTP).
    Nível 3: HATEOAS - Hypermedia as the Engine of Application State. Uma API que implementa esse nível fornece aos seus clientes links que indicarão como poderá ser feita a navegação entre seus recursos. Ou seja, quem for consumir a API precisará saber apenas a rota principal e a resposta dessa requisição terá todas as demais rotas possíveis.


### Criação de um projeto Web com ênfase de disponibilizar REST API
 
    1) Spring Initializr -> dependência Spring web. Já vem com o TomcatWebServer representando uma aplicação web.
        Como a aplicação é para disponibilizar recursos/serviços, ela não apresenta uma página http visível, dentro de uma camada springboot web esses serviços são denominados como controller.
        *Controller* é um recurso que disponibiliza as funcionalidades de negócio da aplicação através do protocolo HTTP. Ele já obtem da aplicação toda a lógica de negócio, não é no controller que se implementa as funcionalidades essenciais, ele prove externamente por uma web API. 
        ```
            @RestController                     // Indica ser um componente REST (alguns de seus mét. são rec. http)
            public class WelcomeController {
                @GetMapping("/welcome")       // Mapear quais são recursos http (nesse casso do tipo get)
                public String welcome(){
                    return "Welcome to a Spring Boot REST API ";
                }
            }
        ```
        - Criação de um pacote controller para a classe WelcomeCOntroller, a criação do método desejado e as anotações. Agora é possível executar o método (welcome) através de um controller do spring, com mapeamento do tipo get, e o método retorna apenas o texto de exemplo. Essas anotações estão disponíveis pelo starter Springboot-starter-web. Podendo tornar a classe um web service. 
        
        *Rest Controller* em Spring é uma classe contendo anotações específicas para a disponibilização de recursos HTTPs baseados em nosso serviços e regras de negócio.
        @RestController: responsável por designar o bean de component que suporta requisiçÕes HTTP com base na arquitetura REST.
        @RequestMapping("prefix"): Determina qual a URI comum para todos os recurso disponibilizados pelo Controller.
        @GetMapping: Determina que o método aceitará requisições HTTP do tipo GET.
        @PostMapping: Determina que o método aceitará requisições HTTP do tipo POST.
        @PutMapping:   Determina que o método aceitará requisições HTTP do tipo PUT.
        @DeleteMapping: Determina que o método aceitará requisições HTTP do tipo DELETE.
        @RequestBody: Converte um JSON para o tipo do objeto esperado como parâmetro no método.
        @PathVariable: Consegue determinar que parte da URI será composta por parâmetros recebidos nas requisições.

    *Exemplo com Controle de usuários:*
    Fake repository que demonstra a iteração das requisições. 1- Criação de uma estrutura de classe (usuário) no pacote Model. 2- Criação do Repositório (fake p/ representar), no pacote repository. Utilizando o IoC tornamos a classe um componente dentro do framework (usando por exemplo @Repository, @Component, @Service, @RestController), no caso o @RestController, assim o spring se encarrega de gerenciar toda a existência de instâncias desses objetos.
    Sabendo da existência do Controller, cada um deles está relacionado a um serviço ou contexto da aplicação, não necessáriamente será apenas um contendo todos os mapeamentos. 2- Criação da classe UsuarioController (+ anotation @RestController)e realizar o mapeamento/inclusão do recurso 'privado/local' p/ possibilitar que aplicações externas acessarem os nosso recursos. Com criação do método getUsers que lista usuários, p/ buscar esses usuários no repositorio ou banco de dados através do repository (controller não tem essa capacidade de obter, ou seja só direciona p/ a funcionalidade existente, não deve ter funcionalidades, regras de negócio devem estar em camadas de serviço). É Adicionado o autowired sobre o objeto UsuarioRepository, pois ela que de fato contem as funções para obter os usuários, apos isso colocado o @GetMapping (necessário para essa interação).
    ```
        @RestController
        public class UsuarioController {
            @Autowired
            private UsuarioRepository repository;
            @GetMapping
            public List<Usuario> getUsers() {
                return repository.findAll();
            }
        }
    ```
 _Ou seja, esse controller (UsuarioController) através de uma requisição HTTP (getUsers) vai delegar a outra classe(usuarioRepository repository) que realmente pode usar regras de negócio para esse finalidade._

 - Contudo após se utilizar o mesmo mapeamento (no caso o getMapping) no mesmo contexto, com métodos específicos o Spring inicialmente não sabe distinguir qual operação seria realizada sem a diferenciação (URI: "/users"), acessível por exemplo através do 'localhost:8080/users'.
 - Mapeando interações que são possíveis de incluir pela URI, sem necessidade de client http, para se passar info simples pela URI pode se utilizar de uma path variable, a variavel recebida será passada como parâmetro:
                ```
                @GetMapping("/users/{username}")
                public Usuario getOne(@PathVariable("username") String username) {
                    return repository.findByUsername(username);
                } 

                ```
 - Entretanto quando houver outros métodos as requisições HTTPs só realizam métodos gets dentro de navegadores, ou seja, para realizar um delete(@DeleteMapping) será necessário um client.

 - Recebendo um parâmetro que seja objeto/json para realizar uma inclusão baseado no corpo que estamos recebendo.
        ```
        @PostMapping("/users")
    public void postUser(@RequestBody Usuario usuario) { // Converter requisição na estrutura do metodo passado como parametro. Converte o json no objeto.
        repository.save(usuario);
    }
    
        ```
























