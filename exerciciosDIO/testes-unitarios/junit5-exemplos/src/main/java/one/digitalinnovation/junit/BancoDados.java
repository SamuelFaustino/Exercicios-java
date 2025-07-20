package one.digitalinnovation.junit;

import java.util.logging.Logger;

public class BancoDados {

    private static final Logger LOGGER = Logger.getLogger(BancoDados.class.getName());
    public static void inciarConexao() {
        //
        LOGGER.info("Iniciou Conexão");
    }

    public static void finalizarConexao() {
        LOGGER.info("Finalizou Conexão");
    }

    public static void insereDados(Pessoa pessoa) {
        // insere pessoas no banco de dados
        LOGGER.info("Inseriu dados");
    }

    public static void removeDados(Pessoa pessoa) {
        // remove pessoas no banco de dados
        LOGGER.info("remove dados");
    }
}
