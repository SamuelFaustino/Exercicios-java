package Service;

import Model.Livro;

public interface ILivroService {
	
	public void inserirLivro(Livro livro);
	public void alterarLivro(Livro livro);
	public void excluirLivro(Livro livro);
	public Livro pesquisarLivroId(int id);
	public Livro[]  listarLivros();
 
}
