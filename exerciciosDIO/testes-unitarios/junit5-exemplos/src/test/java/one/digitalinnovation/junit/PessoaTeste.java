package one.digitalinnovation.junit;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaTeste {

    /*
    Como Fazer Validações ?
    - Todos os métodos devem ter @Test ; todos métodos jUnit retornam void

     */
    @Test
    public void deveCalcularIdadeCorretamente() {
        Pessoa joao = new Pessoa("joao", LocalDateTime.of(2000, 01, 01, 15,0,0,0));
        Assertions.assertEquals(25,joao.getIdade());

    }

    @Test
    public void deveRetornarSeMaiorDeIdade() {
        Pessoa joao = new Pessoa("joao", LocalDateTime.of(2000, 01, 01, 15,0,0,0));
        Assertions.assertTrue(joao.atingiuMaioridade());

        Pessoa maria = new Pessoa("maria", LocalDateTime.of(2025, 02, 02, 5,0,0,0));
        Assertions.assertFalse(maria.atingiuMaioridade());
        //AssertFalse pois eu espero que de falso, sendo assim o teste deve possitivar (passed).
    }
}
