package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		List<Double> temperatura = new ArrayList<Double>(); 
		
		System.out.println("Digite a temperatura média dos seis primeiros meses do ano: ");
		for(int i = 0; i < 6; i++) {
			Double temp = scan.nextDouble();
			temperatura.add(temp);
		}
		System.out.println("Temperaturas Registradas: ");
		System.out.println(temperatura);
//		 System.out.print("Todas as temperaturas: ");
//		 temperaturas.forEach(t -> System.out.print(t + " "));
		
		Iterator<Double> itr = temperatura.iterator();
		Double soma = 0d;
		while(itr.hasNext()) {
			Double nxt = itr.next();
			soma = soma + nxt;
		}
		System.out.println("Média das Temperaturas: "+ soma/6);
		
		for(Double tmp : temperatura) {
			if(tmp > (soma/6)) {
				System.out.println(tmp + " No mês de: ");
				
				switch(temperatura.indexOf(tmp)) {
				case(0):
					System.out.println(" Janeiro");
				break;
				
				case(1):
					System.out.println(" Fevereiro");
				break;
				
				case(2):
					System.out.println(" Marćo");
				break;
				
				case(3):
					System.out.println(" Abril");
				break;
				
				case(4):
					System.out.println(" Maio");
				break;
				
				case(5):
					System.out.println(" Junho");
					
				}
			
			}
		}
/*	
		// EXERCICIO PROPOSTO 2
		List<String> pergunta = new ArrayList<>();
		
		System.out.println("Telefonou para a Vítima? (s/n)");
		String p = scan.next();
		pergunta.add(p);
		
		System.out.println("Esteve no local do crime? ");
		p = scan.next();
		pergunta.add(p);
		
		System.out.println("Mora perto da vítima? ");
		p = scan.next();
		pergunta.add(p);
		
		System.out.println("Devia para a Vítima? ");
		p = scan.next();
		pergunta.add(p);
		
		System.out.println("Ja trabalhou com a Vítima? ");
		p = scan.next();
		pergunta.add(p);
		
		int suspeita = 0;
		Iterator<String> itr = pergunta.iterator();
		while(itr.hasNext()) {
			String nxt = itr.next();
			if(nxt.contains("s")) suspeita ++;
			
		}
				
//		
//		  for(String prgt : pergunta) { if(prgt.equalsIgnoreCase("s")) suspeita ++;
//		  
//		  }
//		 
		System.out.println("Afirmativas: "+suspeita);
		
		switch(suspeita) {
			case(2):
				System.out.println("Classificada como Suspeita!");
			break;
			
			case(3):
			case(4):
				System.out.println("Classificada como Cúmplice!!!");
			break;
			
			case(5):
				System.out.println("Classificada como A s s a s s i n a !!!!!!!!");
			break;
			
			default:
				System.out.println("Inocente...");
				break;
		}
*/		

	}

}
