package one.digitalinnovation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class CondicionaisTeste {

    @Test
    //@EnabledIfEnvironmentVariable(named = "USER", matches = "samuelf")
    //@EnabledOnOs(OS.MAC)
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    public void validarAlgoSementeNoUsuarioSamuel() {

        Assertions.assertEquals(10, 5 + 5);
    }

}
