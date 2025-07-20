package FuncionalInterface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
    SUPPLIER - Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.
    É comumente usada para criar ou fornecer novos objetos de um determinado tipo.
 */
public class SupplierExample {
    public static void main(String[] args) {
        // Usar o Supplier com expressão lambda para fornecer uma saudação personalizada
        //Supplier<String> saudacao = () -> "Olá, seja bem-vindo!";

        // Padrão : Cria Supplier (variavel) -> passa como parametro no Stream -> imprime com consumer
        // Usar o Supplier para obter uma lista com 5 saudações - stream.generate recebe Supplier
        // Operação Met. Stream: gerando as saudacoes(passando o supplier), o limit (qtd de vezes geradas), e tolist (pegar tds saudacoes geradas e incluir em uma List).
        /*List<String> listaSaudacoes = Stream.generate(saudacao)
                .limit(3)
                .collect(Collectors.toList());
        */
        //List<String> listaSaudacoes = Stream.generate(() -> "Olá, Seja bem-vindo!").limit(3).toList();

        List<String> listaSaudacoes = Stream.generate(() -> "Olá, Bom dia!").limit(3).toList();
        // Imprimir as saudações geradas
        // .forEach recede um Consumer que está implicito na declaração com lambda (Consumer: arg->corpo)
        // forEach -> new Consumer -> implement method -> lambda.
        listaSaudacoes.forEach(s -> System.out.println(s));
        //listaSaudacoes.forEach(System.out::println); // Method Reference

    }

}
