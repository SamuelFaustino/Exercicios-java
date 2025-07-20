package FuncionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R.
é utilizada para transformar ou mapear os elementos do Stream em outros valores ou tipos.
 */
public class FunctionExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Usar a Function com expressão lambda para dobrar todos os números
        Function<Integer, Integer> dobra = numero -> numero * 2;

        // Usar a função para dobrar todos os números no Stream e armazena-los em outra lista
        List<Integer> numerosDobrados = numeros.stream()
                .map(dobra).collect(Collectors.toList());

        // Imprimir a lista de numeros dobrados
        numerosDobrados.stream().forEach(n -> System.out.println(n));


    }

}
