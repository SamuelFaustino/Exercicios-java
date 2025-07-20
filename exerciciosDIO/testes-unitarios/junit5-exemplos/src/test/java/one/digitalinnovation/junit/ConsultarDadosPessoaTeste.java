package one.digitalinnovation.junit;


import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

public class ConsultarDadosPessoaTeste {
    @BeforeAll
    static void configuraConexao() {
        BancoDados.inciarConexao();
    }

    @BeforeEach
    void insereDadosParaTeste() {
        BancoDados.insereDados(new Pessoa("joao", LocalDateTime.of(2000,1,1,15,0,0)));
    }

    @AfterEach
    void removeDadosTeste() {
        BancoDados.removeDados(new Pessoa("joao", LocalDateTime.of(2000,1,1,15,0,0)));
    }

    @Test
    public void validarDadosRetorno() {
        Assertions.assertTrue(true);
    }

    @AfterAll
    static void finalizarConexao() {
        BancoDados.finalizarConexao();

    }

}
