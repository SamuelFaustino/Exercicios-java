package one.digitalinnovation.junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTeste {

    @Test
    public void validarCenarioExcecaoTransferencia() {
        Conta contaOrigem  = new Conta("12345", 0);
        Conta contaDestino  = new Conta("67899", 110);
        // Validar cenário de erro
        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                transferenciaEntreContas.transfere(contaOrigem,contaDestino,-1));
        // Lançou a excecao quando entrou no método
        //Assertions.assertDoesNotThrow(()-> transferenciaEntreContas.transfere(contaOrigem,contaDestino,-1)); //Falha teste, porque ele espera que não lance, -1 acaba lançando a exception
    }

}
