package dio.gof;

/*
* Singleton "preguiçoso" -> que no primeiro momento já não disp. a instância p/ usuário
*
* */
public class SingletonLazy {
    // Singleton possui uma instância dele mesmo.
    private static SingletonLazy instancia;

    // Como garantir que ninguem externamente o instancie ? -> construtor privado.
    private SingletonLazy() {
        super(); // chamada apenas explicita que é um construtor da classe pai
    }

    // Garantir que a instância será exposta de alguma forma p/ quem a chama - Controla sua própria instância.
    public static SingletonLazy getInstance() {
        // necessita ser instanciada p/ que haja futuro retorno dela.
        if(instancia == null)
            instancia = new SingletonLazy();

        return instancia;
    }


}
