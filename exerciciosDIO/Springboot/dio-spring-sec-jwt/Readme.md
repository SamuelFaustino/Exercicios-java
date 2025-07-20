# Adicionando Segurança a uma API REST com Spring Security

## Spring Security é apenas um grupo de filtros de servlet que ajudam a adicionar autenticação e autorização ao seu aplicativo web.
### Para habilitar a segurança em um projeto Spring Boot Web é necessário incluir somente a dependência no pom.xml
    ```pom.xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
    ```

## JWT - JSON Web Token
    Projeto Spring para demonstração de uso de Springboot, API Rest, Spring Security com JWT e Integração com banco de dados com Spring Data Jpa.
---

### O Json Web Token é um padrão da internet para a criação de dados com assinatura opcional e/ou criptografia cujo conteúdo contém o JSON que afirma algum número de declarações. Os tokens são assinados usando um segredo privado ou uma chave pública/privada. 
    Então temos um arquivo json, representando uma estrutura que possui algumas informações relacionadas a credenciais p/ acessar nossas aplicações. Essas credenciais podem ser o usuário, data de expiração, perfis de acesso a esse usuário.
    Estrutura JWT: Header, Payload, Signature:
    *Esse Token é constituido por* um Header; um Payload que é o próprio json (a estrutura do objeto que trafega na aplicação), para que o sistema de segurança valide o token criptografado que é transmitido a cada requisição; e uma camada de Assinatura para garantir que as chaves utilizadas para geração do token é a mesma para verificar uma requisição, por exemplo.
        
        *Header* ou cabeçalho consiste de duas partes: O tipo de token, que é o JWT e o algoritimo de assinatura que está sendo utilizado, como HMAC SHA256 ou RSA.
        ```
            {
                "alg":"HS256",
                "typ":"JWT"
            }
        ```
        *Payload* é de fato a estrutura do corpo contendo as informações de autênticação e autorização de um usuário.
        ```
            {
                "sub":"sml",
                "name":"SAMUEL",
                "roles": ["USERS","MANAGERS"]
            }
        ```
        *Signature*, para criar a parte da assinatura, devemos pegar o cabeçalho modificado, o payload codificado,a chave secreta, o algoritmo especificado no cabeçalho e assina-ló. 

### Spring Security + JWT
    Será desenvolvido um aplicativo Spring Boot que usa autenticação JWT para proteger uma API REST. Usaremos um usuário com perfis de acesso para geração e validação do token que é transferido pelos clientes da nossa API.
    No projeto Maven será usado as seguintes dependências: Spring web, Spring Security, Spring Data JPA, H2 (qualquer DB), e adicionalmente o jwt.
    *Estrutura do Projeto* -> classes são dividadas em pacotes de acordo com responsabilidades.
    _Model_ -> camada que contém as entidades da aplicação
    _dto_ -> camada que contém os dtos(Data Transfer Object - não deixar entidades expostas na aplicação) da aplicação
    _repository_ -> camada que contém os repositórios com base no Spring Data JPA
    _service_ -> camada que detém da regra de negócio e comunicação com base de dados via repositorys
    _controller_ -> camada que contém os recursos http expostos na API
    _security_ -> camada responsável para toda configuração de segurança;

    *Classes utilitárias*
        _JWTObject_ -> Classe que representa um Objeto correspondente a estrutura JWT ( p/ tornar objeto um token é necessário est. do objeto)
        _JWTCreator_ -> Classe responsável por gerar o Token com base no Objeto e ou instanciar o Objeto JWT com base no Token
        _SwaggerConfig_ -> Classe responsável pela documentação da API

     1) Criar camada de Modelo model.User.java (definindo classe de entidade p/ interação com bd (JPA).
     2) Criar classe de repositório repository.UserRepository.java (interface que estende de JPARepository).
        -> Contém mét. herdados, comuns de operações crud, mas é preciso trazer usuário pelo seu Username. Seguindo então o padrão JPA é possível montar uma JPQL (@Query) sobre objetos que irá retornar usuário.
     3) Criação da classe Service service.UserService.java contendo a regra de negócio.
        -> Tem forte dep. com repositório e tem propósito único de criar o usuário (usuário será salvo através do service, antes da persistência é criptografada a senha e salva, posteriormente é validade pelo framework). 
        ```
        private PasswordEncoder encoder;
        public void createUser(User user) {
            String pass = user.getPassword();
            // Criptografando antes de salvar no banco
            user.setPassword(encoder.encode(pass));
            repository.save(user);
        }
        ```

    4) Criar classe que disponibiliza um recurso HTTP para cadastrar usuário controller.UserController.java
        -> é um @RestController, com cadastro simples. Porém uma aplicação SpringBoot todas as requisições irão solicitar via tela de login uma autenticação; Nesse caso autenticaremos tendo uso JWT devemos configurar filtros que ficarão encarregados de acompanhar as req. e respectivos tokens enviados no header da aplicação, iremos através do filtro fazer a verificação estrutural do token. 

    5) Configurando o JWT no projeto, sabemos que JWT é um objeto JSON criptografado, sendo assim devemos criar uma representação deste objeto e o mecanismo de geração e interpretação do token. security.JWTObject: classe que representará um objeto p/ gerar o token. Esse token será _transacionado_ pelas requisições através de um atributo(pode ser usado autorization/autentication) enviado em um header da aplicação.
    6) Criação do security.SecurityConfig: Classe componente que receberá as propriedades e credenciais do token via application.proprierties. -> Creator que solicita config. p/ interpretar ou gerar tokens, esse configurações existirão no aplication.properties, mas será criada a classe que através do recurso do Spring de ler propriedades ele consiguira criar um objeto com esses atributos correspondêntes.
    - security.config.prefix = prefixo do token
    - security.config.key = sua chave privada
    - security.config.expiration = tempo de expiração do token
    ```application.properties
        security.config.prefix=Bearer
        security.config.key=SECRET_KEY
        security.config.expiration=3600000
    ```

    7) Criar security.JWTCreator: classe responsável por gerar token com base no objeto e vice-versa. Recurso que faz toda interação entre Java Spring Security com o mecanismo de JWT. Basicamente contém um método que utiliza o prefixo, chave e objeto e gera o Token o qual precisa das informações e método de criptografia. Após isso é montado o token com prefixo p/ enviar nas requisições.  

    8) Criação de do filtro de fato: security.JWTFilter, classe que possui toda lógica de validação quanto a integridade do token recebido em todas as requisições.
    
    ~ É adicionado ao aplication.properties configurações de banco de dados pra visualizar o H2 Databese na WEB.
    9) Criação da classe security.WebSecurityConfig: responsável por centralizar toda configuração de segurança da API.







_fontes:_
https://www.toptal.com/spring/spring-security-tutorial
https://www.baeldung.com/spring-enablewebsecurity-vs-enableglobalmethodsecurity
