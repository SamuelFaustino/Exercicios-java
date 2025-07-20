package dio.gof;

/**
 *
 */
/*
*  Singleton mais otimizado em questões de memória
*
* @see <a href="https://stackoverflow.com/a/24018148">Referencia</a>
* */
public class SingletonLazyHolder {

    // encapsula instancia em uma classe estatica interna - classe apenas encapsula
    private static class InstanceHolder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
    }

    public static SingletonLazyHolder getInstance() {
        return InstanceHolder.instancia;
    }
}
