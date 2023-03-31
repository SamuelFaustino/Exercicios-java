package Model;

import java.util.Objects;

public class Produto {
	public int id;
	public String tipo;
	public String preco;
	
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produto(int id, String tipo, String preco) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, preco, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return id == other.id && Objects.equals(preco, other.preco) && Objects.equals(tipo, other.tipo);
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", tipo=" + tipo + ", preco=" + preco + "]";
	}
	
	

}
