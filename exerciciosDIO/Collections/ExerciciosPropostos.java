package Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

public class ExerciciosPropostos {

	public static void main(String[] args) {
		Set<String> cores = new HashSet<>();
		cores.add("violeta");
        cores.add("anil");
        cores.add("azul");
        cores.add("verde");
        cores.add("amarelo");
        cores.add("laranja");
        cores.add("vermelho");
        System.out.println(cores);
        
        System.out.println("Exiba todas as cores o arco-íris uma abaixo da outra: ");
        for(String cor: cores) System.out.println(cor);
        
        System.out.println("\nQuantidade de Cores: "+ cores.size());
        
        Set<String> cores1 = new TreeSet<>(cores);
        System.out.println("Exiba as cores em ordem alfabética: "+cores1);
        
        Set<String> cores2 = new LinkedHashSet<>(Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        System.out.println("\nExiba as cores na ordem inversa da que foi informada: ");
        System.out.println(cores2);
        List<String> cores3 = new ArrayList<>(cores2);
        Collections.reverse(cores3);
        System.out.println(cores3);
        
        System.out.println("\nExiba todas as cores que começam com a letra ”v”: " );
        for(String cor : cores) {
        	if(cor.startsWith("v")) System.out.println(cor);
        }
        
        System.out.println("Remova todas as cores que não começam com a letra “v”: ");
        Iterator<String> itr = cores.iterator();
        while(itr.hasNext()) {
        	if(itr.next().startsWith("v")) itr.remove();
        }
        
        System.out.println(cores);
        
        System.out.println("\nLimpe o conjunto: ");
        cores.clear();
        
        System.out.println("Confira se o conjunto está vazio: " + cores.isEmpty());
	}

}
