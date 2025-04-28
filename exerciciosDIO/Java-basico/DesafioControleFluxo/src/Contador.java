import java.util.Scanner;

public class Contador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o parametro 1: ");
		int p1 = scan.nextInt();
		System.out.println("Digite o parametro 2: ");
		int p2  = scan.nextInt();
		
		try {
			contar(p1,p2);
		} catch (ParametrosInvalidosException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Os parâmetros Náo se encontram na ordem desejada!");
			
		}
		
		
	}
	
	
	
	static void contar(int p1, int p2)  throws ParametrosInvalidosException {
		
		if( p1 > p2 ) {
			throw new ParametrosInvalidosException();
		}
		
		int contagem  = p2 - p1;
		for(int i = 1; i < contagem; i++ ) {
			System.out.println("Imprimindo numero "+ i + "...");
			
		}
	}

}
