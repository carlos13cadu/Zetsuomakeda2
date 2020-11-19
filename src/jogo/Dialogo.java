package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Dialogo {
	
	private Window janela;
	private Keyboard teclado;
	private GameImage dialog;
	
	public Dialogo(Window janela) {
		this.janela = janela;
		
		dialog = new GameImage(URL.sprite("dialog.png"));
		dialog.x = -10;
		dialog.y = 290;
		
	}
	
	public void exibirDialogo() {
		dialog.draw();
	}
	
	public void abrirDialogo() {
		dialog.x = -10;
	}
	
	public void fecharDialogo() {
		dialog.x = 10000;
	}
}
