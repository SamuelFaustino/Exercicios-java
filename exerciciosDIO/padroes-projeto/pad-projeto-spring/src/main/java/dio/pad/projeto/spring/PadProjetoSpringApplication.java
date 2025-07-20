package dio.pad.projeto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
* Mõdulos adicionados no projeto:
* Spring Web, Spring Data JPA, H2, OpenFeign
* */
@EnableFeignClients
@SpringBootApplication
public class PadProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadProjetoSpringApplication.class, args);
	}

}
