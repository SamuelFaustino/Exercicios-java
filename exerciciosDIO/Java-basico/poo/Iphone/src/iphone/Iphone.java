package iphone;

import iphone.funcionalidades.Musicas.ReprodutorMusical;
import iphone.funcionalidades.chamadas.AparelhoTelefonico;
import iphone.funcionalidades.internet.NavegadorInternet;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{
	
	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		System.out.println("Tocando Musica... .. . ");
	}

	@Override
	public void pausar() {
		// TODO Auto-generated method stub
		System.out.println("Pausado.");
	}

	@Override
	public void selecionarMusica(String musica) {
		// TODO Auto-generated method stub
		
		System.out.println("A musica Selecionada foi "+ musica);
		
	}

	@Override
	public void exibirPagina(String url) {
		// TODO Auto-generated method stub
		System.out.println("Abrindo site: "+url);
		
	}

	@Override
	public void adicionarNovaAba() {
		// TODO Auto-generated method stub
		System.out.println("Nova Aba Adicionada");
	}

	@Override
	public void atualizarPagina() {
		// TODO Auto-generated method stub
		System.out.println("Atualizando.... ... .. . ");
	}

	@Override
	public void ligar(String numero) {
		// TODO Auto-generated method stub
		System.out.println("CHAMANDO NÚMERO "+ numero);
		
	}

	@Override
	public void atender() {
		// TODO Auto-generated method stub
		System.out.println("CHAMADA ATENDIDA");
	}

	@Override
	public void iniciarCorreioVoz() {
		// TODO Auto-generated method stub
		System.out.println("TOCANDO CORREIO DE VOZ... .. .");
		
	}

}
