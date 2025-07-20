package one.digitalinnovation.junit;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.*;
// importação estática permite não escrever os assertions por completo.

public class AssertionsTeste {

    @Test
    public void validarLancamentos() {
        int [] primeiroLancamento = {10,20,30,40,50};
        int [] segundoLancamento = {10,20,30,40,50};

        assertArrayEquals(primeiroLancamento, segundoLancamento);
        //Assertions.assertNotEquals();
    }
    @Test
    public void validarObjetoEstaNulo() {
        Pessoa pessoa = null;
        assertNull(pessoa);
        pessoa = new Pessoa("joao", LocalDateTime.now());
        assertNotNull(pessoa);
    }

    @Test
    public void validarNumerosDetiposDiferentes() {
        double valor = 5.0;
        double outroValor = 5.0;

        assertEquals(valor,outroValor);
    }


}
