package View;

import javax.swing.JOptionPane;

import Model.Livro;
import Service.ILivroService;
import Service.LivroService;

public class Menu {
	
	public static final String menu = " "
			+" 1 - Inserir Livro \n"
			+" 2 - Alterar Livro \n"
			+" 3 - Excluir Livro \n"
			+" 4 - Pesquisar Livro por ID \n"
			+" 5 - Listar Livros \n"
			+" 6 - Sair \n";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ILivroService ILS = getLivroService();
		
		String opc = " ";
		while(!opc.equals("6")) {
			opc = JOptionPane.showInputDialog(menu);
			
			switch(opc) {	
			case "1": 
				Livro lvr = getLivro();
				ILS.inserirLivro(lvr);
				break;
				
			case "2": 
				int indc = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do contato: "));
				lvr = getLivro();
				lvr.setId(indc);
				ILS.alterarLivro(lvr);
				break;
				
			case "3":
				indc = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do livro que deseja excluir"));
				lvr = new Livro();
				lvr.setId(indc);
				ILS.excluirLivro(lvr);
				break;
				
			case "4": 
				indc = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Livro que deseja pesquisar: "));
				lvr = ILS.pesquisarLivroId(indc);
				JOptionPane.showMessageDialog(null,lvr);
				break;
				
			case "5":
				String resposta = "";
				for(Livro i : ILS.listarLivros()) {
					if(i != null) 
						resposta += i + "\n";
					}
					JOptionPane.showMessageDialog(null, resposta);
					break;
					
			case "6": 
				break;
			
			default: JOptionPane.showMessageDialog(null, "Digite uma opcao VALIDA!!!");
			
				}
				
			}
		}
	public static Livro getLivro() {
		Livro livro = new Livro();
		livro.setTipo(JOptionPane.showInputDialog("Digite o Tipo do Produto: "));
		livro.setPreco(JOptionPane.showInputDialog("Digite o Preço do Produto: "));
		
		livro.setTitulo(JOptionPane.showInputDialog("Digite o titulo do Livro:"));
		livro.setEditora(JOptionPane.showInputDialog("Digite o nome da editora:"));
		livro.setPaginas(JOptionPane.showInputDialog("Digite a quantidade de paginas"));
		return livro;
	}
	
	public static ILivroService getLivroService() {
		return new LivroService(100);
	}

}


