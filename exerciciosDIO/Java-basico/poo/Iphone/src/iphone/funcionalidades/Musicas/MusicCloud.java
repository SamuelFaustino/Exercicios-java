package iphone.funcionalidades.Musicas;

public class MusicCloud implements ReprodutorMusical {

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		System.out.println("Reproduzindo musica Via Cloud");
		
	}

	@Override
	public void pausar() {
		// TODO Auto-generated method stub
		System.out.println("Musica Pausada.");
	}

	@Override
	public void selecionarMusica(String musica) {
		// TODO Auto-generated method stub
		System.out.println("Musica "+ musica+ " Selecionada via Cloud.");
		
	}

}
