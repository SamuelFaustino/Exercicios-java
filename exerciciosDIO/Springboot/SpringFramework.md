# Spring Framework

## Baseado em padrões de projeto *inversão de controle* e injeção de dependência.

### Inversion of Control (IoC), se trata do redirecionamento do fluxo de execução de um código retirando parcialmente o controle sobre ele e delegando-o para um container. Tendo como propósito a minimização do acoplamento do código.
### Conteiner quem gerencia os objetos da aplicação.
### Injetar especificações para interface - prover referências (recursos) necessários para aplicação sem torná-los explícitos, acoplados como normalmente se faz fora de um conteiner.
### Beans: Objeto que é instanciado, montado e gerenciado por um container através do princípio da inversão de controle.
### Escopos: 5 tipos (standalone, http); Ênfase em Singleton e Prototype (conceito standalone).
Singleton um único objeto sendo compartilhado por toda aplicação quando solicitado. Prototype é criado uma nova instância a cada requisição de um objeto(referência) ao Conteiner. (subentende que não se pode enviar o mesmo objeto p/ camadas diferêntes da aplicação). *HTTP - Request* Um bean será criado para cada requisição http, objeto só requisição pode ser transicionado em toda cadeia da aplicação. *HTTP - Session* Um bean será criado para a sessão de usuário. *HTTP - GLOBAL* Ou aplicação Scope cria um bean para o ciclo de vida do contexto da aplicação (compart. entre toda aplicação). *Autowired* uma anotação _(indicação)_ onde deverá ocorrer uma injeção automática de dependência. _byName:_ É buscado um método set que corresponde ao nome do Bean. _byType:_ É considerado o tipo da classe para inclusão do Bean. _byConstrutor:_ Usamos o construtor para incluir a dependência.

### Spring Framework é uma biblioteca (ecosistema, disposição de vários recursos baseados em injeção de dependência e inversão de controle), o Springboot foca na produtividade, na configuração automática, nos padrões de estruturação de projetos.
### Starters -Descritores de dependência (reduzindo como se fosse a uma única dependência, trazendo coesão e versões compatíveis).
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

Starters mais utilizados: *Spring-boot-starter- * :
*data-jpa:* Integração ao banco de dados via JPA - Hibernate(imp. padrão).
*data-mongodb:* Interação com banco de dados MongoDb.
*web:* Inclusão do container Tomcat para aplicações REST.
*web-services:* Webservices baseados na arquitetura SOAP.
*batch:* Implementação de JOBs de Processos.
*test:* Disponibilização de recurso para testes unitários como JUnit.
*openfeign:* Client HTTP baseado em interfaces.
*actuator:* Gerenciamento de monitoramento da aplicação.

 * 1) Na Classe Principal (SpringApplication.run) gerada pelo Spring representando o container: * Visto que se introduz o contexto do Springboot por exemplo, se dispensa a criação de objetos tradicionalmente (new Object() - criar instâncias), pois eles não estão inclusos nesse cenário. Deve-se portanto utilizar o conceito de Command Line Runner (comando disp. pelo Springboot através de uma interface p/ inicializar aplicação com objetos disponibilizados pelo container).
 * 2)  Classe do projeto:* Nova classe simbolizando método Main (class MyApp implements CommandLineRunner) que contem o método run. *Inversão de Controle: * indicar nas classes que os respectivos objetos dela agora serão beans (@Component), tanto na classe main quanto na classe que se tem os componentes que serão usados. É criado o objeto mas não instânciado, apenas indicado (@AutoWired) a injeção de dependências.
  * 3)Executar a classe Principal container: * Através da execução do Container se tem toda a cadeia de dependência obtida através das outras classes, pois eles serão inicializados anteriormente para depois serem associados as dependências do projeto. Ou seja o container quando inicializado percebeu os componentes do projeto e quais outros o chamavam e utilizaram através da injeção de dependências, se espera então que agora se tenha um objeto dentro do contexto e devidamente associado como dependência.

### Beans vs Components
    - Bean utilizado quando não se tem acesso ao código fonte (biblioteca externa).
    - Component utilizado quando uma classe que tem possibilidade de ser provida através de injeção de dependências.

    Explanação: Um programa que recebe um json de endereço e converte em gson para poder manipular na aplicação; Tanto bean quanto component são objetos gerenciados pelo container. classe 'ConversorJson' é component porque componentes serão escaneados na aplicação, quando tem acesso ao código fonte para colocar a anotação pois é um objeto que preciso manipular, podendo injeta-lo em qualquer parte do container, criando uma implementação de um Command Line Runner ou somente criar um bean de CLR na classe Principal com (@Bean). Criada uma classe (CommandLineRunner run) no principal ela terá o aspecto de executar os recurso da aplicação, informando que é um bean pois esse CommandLineRunner não é uma implementação própria da minha aplicação ele é de uma biblioteca externa, _mas_ eu quero inicializar a construção de um bean através dele, então preciso indicar com o _@Bean_.  
    O fato de ele ser um bean, o método run (CommandLineRunner run (ConversonJson conversor)) permite injetar dependências, similar ao AutoWired, no caso o _conversor_.
    Já na classe que implementa o conversor (a qual recebeu a anotação Component) ela possui uma biblioteca externa, entretanto não se deve ao criar um objeto do _tipo para conversão_, instancia-lo como 'private Gson gson = new Gson();' e sim apenas acrescer o ' @Autowired private Gson gson ', ainda assim, Gson não deixa de ser biblioteca externa e não contem o '@Component' em sua implementação para que possa ser utilizado dentro do container, então deve se criar uma estrutura para que ele se torne um bean:
    - Criando dentro da Classe Principal (Springboot) exemplo:
        ``` @Bean
            public Gson gson() {
                return new Gson();
            }
        ```
        * Agora poderia ser injetado em qualquer parte da aplicação *

    - Criando uma classe separada chama 'Beans' com o intuito de armazenar todos os Beans (se houver necessidade de criar vários por excesso de recursos externos), pode exigir anotação '@Configuration' na classe.

### Scopes - Singleton ou Prototype (Pad. projeto)
    * Quantos irei precisar ? *
    Passos: No contexto que se precisaria de prototype (um novo objeto para enviar email por exemplo) - Para que um único objeto criado dentro de uma aplicação, está sofrendo alterações e refletindo outra referência, por ser singleton duas variáveis apontam para mesma referência. Para impedir, será necessário então indicar no bean (exemp. de bean 'Remetente') que ele é do escopo _ @Scope ("prototype") _. Então a cada @Autowired que o programa identificar no caso um para cada execução (chamada) ('@Autowired Remetente noreply','@Autowired Remente techTeam') ele agora criará um objeto pertinente.

### Properties Value
    Nem todas as atribuições utilizadas dentro de uma aplicação (declarações), precisam ser _explicitas_, de forma declativa, podendo estar centralizadas no arquivo * application.properties * - Esse pode manter informações, estados da aplicação, propriedades e etc que garantimos que não haverá mudanças de iteração (valores) durante execução. Vantajoso pois pode deixar código com menos declarações e mais flexível também. Entretanto está suscetível a gerar reescrita.
    Notação como forma iterativa com o conteiner, por exemplo outras camadas podem precisar desses valores. Utilizando o arquivo application.properties, definir informações que serão utilizadas (ex: 'email=noreply@email.com.br') e substituir forma declarativa 'String email = "email@email.com" junto com a anotação * @Value() * _ (obs: essa anotação utiliza EL expression): _
    ```
        @Value("${email}")
        private String email;

        // definir valor padrão caso application.properties não ache pelo email e retorne um erro na aplicação: 
        @Value("${email:NoReply-email}")
    ```
        * Dentro de uma string temos uma expressão, sendo essa atrás do campo email (uma para cada atributo). *
    
### Configuration Properties
    Vantagem forte associação com o application.properties, todos valores e estrutura dependem dele, para que se tenha beans de configuração, propriedades de forma centralizada todas informações pertinentes a um contexto.  Proposta de que teremos um bean de configuração que todas os seus valores virão do aplication proprierties (centralização). 
    Exemplo: sistema de mensagem, através do '@Value()' se torna possivel obter informações do nome,email,telefone pelo application.properties -> "remetente.email=email@email.com" -> "@Value("${remetente.email}") " =Essas informações são pertinente no contexto de um remetente (alguem que envia emails ao remetente). Quando atributos esvirem associados a um contexo, no que se refere a um bean, Se torna válido a criação de uma classe para objeto centralizado geranciado pelo container, Com a criação de uma classe Remetente, e no princial CLR apenas criação do objeto remetente junto ao autowired; No entanto na classe remente não se pode apenas colocar o @component para injeção de dependências, pois se refere a uma configuração deve se determinar que a classe é um '@Configuration' que está assoado a todo ecossistema do application.properties. Tendo também muitas outras propriedades no arquivo application.properties para determinar quais ele deve usar -> passar que vai obter dados do configuration mas também as propriedades que se quer oberter com - '@ConfigurationProprierties(prefix = "remetente") - sinalizando ser um bean através de uma configuração e todos os atributos são pertinentes a esse prefixo especificado, sendo isso o suficiente para obter os dados do properties constituindo um objeto da aplicação.

### Conceito de ORM e JPA (Java Persistence API)
    * ORM - Mapeamento objeto relacional * é um recurso para aproximar paradigma da orientação a objetos ao contexto de banco de dados relacional.
    Objeto -> (framework/biblioteca) -> Tabela
     * JPA * - especificação baseada em interfaces, que através de um framework realiza operações de persistência de objetos em Java, (é somente o descritor). 
     Para realizar o mapeamento se faz necessário que a classe tenha: Identificação, Definição(atributo, DDL), Relacionamento, Herança, Persistência. Todas as configurações são baseadas em anotações:
     ```
        @Entity
        @Table(name="tb_usuario")
        public class Usuario {
           
            @Id                     //campo id é a chave primária com estratégia de geração automática de acordo com o BD
            @GeneratedValue(strategy=GenerationType.AUTO)
            @Column(name="id_usuário") // Nome coluna pode não ser igual nome atributo
            private Long id;

            private String nome;        // JPA subentende nova coluna mesmo sem anotação - nome semelhante ao da tabela

            @Column(name="login_usuario")
            private String login;

            @Column(name="senha_usuario")
            private String senha;

        }

     ```
    * EntityManager * no JPA é a classe responsável por gerenciar o ciclo de vida das entidades (capaz de localizar entidades por meio do método find, executar consultas usando JPQL ou SQL, persistir entidades, atualizar etc).
    Persistência de Frameworks p/ interagir como todas entidades para que possa ter uma sincronização com banco de dados. Através do JDBC(implementação nativa do java p/ integrar com banco) o JPA tem uma estrutura de Connection, criando estruturas de implementação até chegar no EntityManager que é capaz de realizar todas as operações CRUD. 

    * Spring Data JPA * 
    Recurso disponibilizado pelo Spring Framework, adicionando uma camada sobre o JPA, diminuindo gargalos como iterações complexas e repetitivas, melhorando produtividade em questões de persistência. Interação como o banco de dados se da pormeio de herança de interfaces e declaração de métodos com anotações, dentre as mais relevantes interfaces estão _CrudRepository_, _JPARepository_, _PagingAndSortingRepository_ e anotações como @Query e @Param. 
    Trabalhando com JPA não devemos inserir manualmente as dependências, já usando então os starters.
        Contexto = Na camada de negócios na classe inicializadora, a criação de uma camada de persistência para teste.
        1. todas as aplicações usam contexto de _Controle de Acesso_ - criar usuário na camada de modelo (Model) essa classe é um POJO qualquer porem com o JPA através das anotações será determinado que essa classe se torne uma entidade.
        2. Anteriormente se fazia necessária implementações de persistência no banco, agora se cria um repositório em um pacote 'repository' com a classe 'UserRepository' que agora não precisa de uma implementação, pois essa classe deve ser uma _interface_ que extende _JpaRepository_ (framework) dizendo sobre qual classe irá trabalhar e qual o seu tipo de id, sendo então: "public interface UserRepository extends JpaRepository<User, Integer>. Isso já disponibiliza uma série de métodos para serem utilizados relacionados a persistência.
        3. Para a devida inicialização é necessário habilitar (na classe principal - Application) um recurso do framework, o CommandLineRuner (instr. similar ao met. Main); Para isso se faz necessário a criação de uma outra classe, que ao inicializar o conteiner vai executar automaticamente. No exemplo a classe criada foi _StartApp_ que implementa CommandLineRunner que tem por obrigação a implementação do mét. run. Com isso essa classe passa a ser um @Component para injeção do Repository: '@Autowired private UserRepository repository;'.

        * JPA Repository *
        _Repository Pattern_ - Repository é um padrão de projeto similar ao DAO (Data Access Object) no sentido de que seu objetivo é abstrair o acesso a dados de forma genérica a partir do seu modelo. O projeto Spring Data Jpa facilita a implementação do padrão Repository através de Aspect Oriented Programming - AOP.


---


~ Anotações: EL = Expression Language = Linguagem de expressão:

A EL permite que o desenvolvedor use simples expressões para acessar dinamicamente dados de componentes Beans (JavaBeans). A EL possibilita uma forma de utilizar simples expressões para comunicar os scripts de tela (XHTML, JSP ou outros) com o código Java que roda no servidor. Com isto é possível que possamos facilmente transmitir e manipular dados entre ambas camadas sem precisar nos preocuparmos com todo o empasse que ocorre entre ambas.

~ Anotações: POJO
Em java, um POJO (Plain Old Java Object) é uma classe Java simples que não depende de frameworks ou bibliotecas específicas e segue convenções básicas de programação. É um objeto Java comum que encapsula dados e fornece métodos para acessá-los e modificá-los (getters e setters), sem herdar de classes específicas de frameworks ou implementar interfaces específicas de framework.
