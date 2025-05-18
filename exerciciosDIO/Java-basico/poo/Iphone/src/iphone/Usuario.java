package iphone;
import iphone.funcionalidades.*;
import iphone.funcionalidades.Musicas.MusicCloud;
import iphone.funcionalidades.Musicas.ReprodutorMusical;
import iphone.funcionalidades.chamadas.AparelhoTelefonico;
import iphone.funcionalidades.internet.*;

public class Usuario {
	public static void main(String[] args) {
		Iphone iphone13 = new Iphone();
		MusicCloud soundCloud = new MusicCloud();
		
		String uol = "www.oul.com.br";
		String hino = "Hino Nacional";
		
		ReprodutorMusical appMusic = iphone13;
		//ReprodutorMusical appMusic2 = soundCloud;
		
		AparelhoTelefonico tell = iphone13;
		
		NavegadorInternet safari = iphone13;
		
		appMusic.selecionarMusica(hino);
		appMusic.tocar();
		appMusic.pausar();
		
		safari.exibirPagina(uol);
		safari.atualizarPagina();
		safari.adicionarNovaAba();
		
		
		
		
		
		
		
		
	}
}
