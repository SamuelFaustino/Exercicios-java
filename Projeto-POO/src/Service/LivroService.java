package Service;
import Model.Livro;

public class LivroService implements ILivroService{
	
	private Livro [ ] livros;
	private int indc = 0;
	
	public LivroService(int tam) {
		this.livros = new Livro[tam];
	}
	
	@Override
	public void inserirLivro(Livro livro) {
		livro.setId(indc);
		this.livros[indc] =  livro;
		indc++;
	}
	@Override
	public void alterarLivro(Livro livro) {
		this.livros[livro.getId()] = livro;
	}
	
	@Override
	public void excluirLivro(Livro livro) {
		for(int i = livro.getId(); i< this.indc-1; i++) {
			this.livros[i] = this.livros[i+1];
			this.livros[i].setId(i);
		}
		this.livros[indc -1] = null;
		this.indc --;
	}
	
	@Override
	public Livro pesquisarLivroId(int id) {
		
		return this.livros[id];
	}
	@Override
	public Livro[] listarLivros() {
		return this.livros;
	}
	//
	
}
