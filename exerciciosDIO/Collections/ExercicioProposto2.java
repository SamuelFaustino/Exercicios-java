package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
public class ExercicioProposto2 {

	public static void main(String[] args) {
		Set<LinguagemFavorita> linguagem = new HashSet<>();
		linguagem.add(new LinguagemFavorita("cobol",1959,"opencobolide"));
		linguagem.add(new LinguagemFavorita("fortran",1957,"CBfortran"));
		linguagem.add(new LinguagemFavorita("paschal",1970,"lazarus"));

		System.out.println(linguagem);
		
		Set<LinguagemFavorita> linguagem1 = new LinkedHashSet<>() {{
			add(new LinguagemFavorita("zcobol",1959,"opencobolide"));
			add(new LinguagemFavorita("fortran",1957,"zCBfortran"));
			add(new LinguagemFavorita("paschal",1970,"lazarus"));
		}};
		System.out.println("Ordem de inserção; ");
		//System.out.println(linguagem1);
		for (LinguagemFavorita lingm : linguagem1) System.out.println(lingm);
		
		Set<LinguagemFavorita> linguagem2 = new TreeSet<>(linguagem1);
		System.out.println("Ordem de Natural; ");
		System.out.println(linguagem2);
		
		System.out.println("Ordenacao por IDE: ");
		Set<LinguagemFavorita> linguagem3 = new TreeSet<>(new ComparatorIDE());
		linguagem3.addAll(linguagem1);
		System.out.println(linguagem3);
		
		System.out.println("Ordenacao por ANO/nome: ");
		Set<LinguagemFavorita> linguagem4 = new TreeSet<>(new ComparatorAnoNome());
		linguagem4.addAll(linguagem1);
		System.out.println(linguagem4);
		
		System.out.println("Ordenacao por nome/Ano/Ide: ");
		Set<LinguagemFavorita> linguagem5 = new TreeSet<LinguagemFavorita>(new ComparatorNomeAnoCriacao());
		linguagem5.addAll(linguagem1);
		for (LinguagemFavorita lingm : linguagem5) System.out.println(lingm);
		
	}

}
