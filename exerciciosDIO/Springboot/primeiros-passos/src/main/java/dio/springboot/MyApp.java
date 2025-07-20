package dio.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Inversão de controle
public class MyApp implements CommandLineRunner {
    @Autowired //Injeta dependencia de um componente a outro
    private Calculadora calculadora;
@Override
    public void run(String... args) throws Exception {
        System.out.println("RESULTADO::::: "+ calculadora.soma(2,5));

    }
}
