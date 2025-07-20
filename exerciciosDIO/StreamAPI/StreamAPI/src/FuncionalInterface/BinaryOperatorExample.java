package FuncionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/*
    BINARY OPERATOR - Representa uma operação que combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T.
    É usada para realizar operações de redução em pares de elementos, como somar números ou combinar objetos.
     */
public class BinaryOperatorExample {
        public static void main(String[] args) {
            List<Integer> numeros = Arrays.asList(1,2,3,4,5);

            // Usar o BinaryOperator com expressão lambda para somar dois números inteiros
            BinaryOperator<Integer> soma = (n1, n2) -> n1 + n2;

            // Usar o BinaryOperator para somar todos os números no Stream
            int resultado = numeros.stream()
                    .reduce(0,( n1, n2 ) -> n1 + n2); // reduce espera um BinaryOperator e um identity (Semelhante a variável de temporária, normalmente fica fora dos loop)



            System.out.println("A soma dos números é: " + resultado);

        }


}
