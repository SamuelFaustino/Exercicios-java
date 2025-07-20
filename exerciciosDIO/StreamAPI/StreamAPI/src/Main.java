import java.util.ArrayList;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
    Java também atende o paradigma Funcional a partir do Java 8 com os Streams.
    Utilizado para manipulação de Coleções de maneira declarativa.


    // Metodo para Calcular valor total dos itens sem Stream API
    // Nessa forma é esperado o controle por parte do desenvelvedor, do que será feito em cada elemento(regras de process)
    // e a forma como vai ocorrer a iteração.
    public double calcularValorTotal() {
        if(!itemList.isEmpty()) {
            for(Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuant();
                valorTotal += valorItem;
            }
            return valorTotal;
        }else {
            throw new RuntimeException("A Lista está vazia!");
        }
    }

    // Metodo para calcular valor total dos itens utilizando Stream API
    // Não necessita variavel temporaria, iterador, etc
    // Metodo .stream(), traz variedade de métodos utilizados nas manipulações de colecoes
    // Combinado com Expressoes LAMBDA e METHOD REFERENCE
    public double calcularValorTotal() {
        if (itemList.isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        }
        return itemList.stream().mapToDouble(item -> item.getPreco() * item.getQuant()).sum();
    }
    // LAMBDA - Função sem Declaração, metodo declarado no mesmo lugar que será usado.
        // SINTAXE: (argumento) -> (corpo)
    // Exp. Lambda representam INTERFACES FUNCIONAIS (único met. abstrato) e possib. escrita cod. Funcional.
        // Essas interfaces funcionais servem de BASE PARA USO DE EXPRESSÕES LAMBDA.
    //----------------------------------------------------------------------------------------------------
    // METHOD REFERENCE
        // PERMITE FAZER REF. A METO OU CONSTRUTOR DE CLASSE DE FORMA FUNCIONAL, INDICANDO UTILIZACAO EM PONTO ESP. DO CODIGO
        // UTILIZACAO BASTA:  CLASSE :: METODO
    // Metodo normal apenas com exp. lambida
    public List<Pessoa> ordenarPorAltura() {
        ...
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoaList);
        pessoasPorAlutra.sort((p1,p2) -> Double.compare(p1.getAlura(), p2.getAltura()));
        return pessoaPorAltura;
    }
    // Metodo agora com uso do METHOD REFERENCE
    public List<Pessoa> ordenarPorAltura() {
        ...
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoaList);
        pessoaPorAltura.sort(Comparator.comparingDouble(Pessoa::getAltura));
        return pessoaPorAltura;

    }
*///

    public static void main(String[] args) {

        }
    }