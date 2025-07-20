# O que representa uma API

## O que é uma API (neste contexto)?

Uma **API (Application Programming Interface)**, no contexto de aplicações web com **Spring Boot**, é um **conjunto de endpoints (URLs)** que expõem funcionalidades de um sistema, permitindo que outros sistemas ou clientes (como front-ends, aplicativos mobile ou outras aplicações) interajam com ele **através do protocolo HTTP**.

---

## Na prática, com Spring Boot:

* A API é **representada pelas classes anotadas com `@RestController`**, que **disponibilizam métodos mapeados para requisições HTTP** (GET, POST, PUT, DELETE, etc).

* Esses métodos expõem **serviços ou recursos da aplicação**, como retorno de dados, inserção, atualização ou exclusão.

### Exemplo:

```java
@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to a Spring Boot REST API ";
    }
}
```

Neste exemplo:

* O **endpoint `/welcome`** é exposto como parte da **API REST da aplicação**.
* A aplicação **não exibe uma página web**, mas sim **responde com dados (ex: texto, JSON)** por meio de requisições HTTP.

---


**A API representa os serviços da aplicação expostos por meio de endpoints HTTP, definidos em controladores (`@RestController`), permitindo a comunicação com sistemas externos utilizando o protocolo HTTP.**
Ela **não cuida da lógica de negócio diretamente**, mas **disponibiliza essa lógica para consumo externo**, geralmente em formatos como JSON, por meio de métodos mapeados com anotações como `@GetMapping`, `@PostMapping`, etc.

