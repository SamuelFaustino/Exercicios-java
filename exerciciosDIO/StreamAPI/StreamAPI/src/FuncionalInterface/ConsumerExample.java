package FuncionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerExample {
    /* CONSUMER - Representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado.
       é utilizada principalmente para realizar ações, ou efeitos colaterias nos elementos do Stream sem modificar ou retornar um valor
     */
    public static void main(String[] args) {
        /// 1) Stream.forEach espera um consumer(funcional Interface), que foi implementado externamente, mas poderia ser criado direto no Stream
        // 2) desenvolver o Consumer com expressão lambda para imprimir números pares
        /// 3) é feita a refatoração, agora como o Consumer dentro do Stream (maneira ideal)
        // 4)  é feita a refatoração com Lambda (utilização completa dos recursos)

        // 2) Usar  o Consumer para imprimir números pares no Stream //argumento -> (corpo) \\ numero-> (representa cada elemento dentro da Stream (contador)
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<Integer> imprimirNumeroPar = numero -> {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
        };
            /// 1) Usar o stream
        /// Ao chamar numeros.stream - se transforma a list em stream p/ que Consumer(int. Func) consiga percorrer pelos elementos
        /// cada elemento 'numero' é subst. pelos elementos da List numeros
        ///
        ///numeros.stream().forEach(imprimirNumeroPar);

        /// 3) Implementado Consumer (porem sem lambda)
        /*numeros.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                if(n % 2 == 0) {
                    System.out.println(n);
                }
            }
        });*/

        // 4) Utilização lambda (poderia receber filtro)
        numeros.stream().forEach(n -> {
                if( n %2 == 0) {
                    System.out.println(n);
                }
        });

        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(num -> System.out.println(num));
    }
}
