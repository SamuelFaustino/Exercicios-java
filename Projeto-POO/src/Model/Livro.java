package Model;

import java.util.Objects;

public class Livro extends Produto {
	private String titulo;
	private String editora;
	private String paginas;
	
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livro(int id, String tipo, String preco) {
		super(id, tipo, preco);
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash( editora, paginas, titulo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(editora, other.editora) && paginas == other.paginas
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Livro [ID=" + id +",-Tipo=" + tipo + ", -Preço="+ preco + ", -Titulo=" + titulo + ", -Editora=" + editora + ", -Paginas=" + paginas + "]";
	}
	

}
