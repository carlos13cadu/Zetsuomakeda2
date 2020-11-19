package jogo;

import java.awt.Color;
import java.awt.Font;

import jplay.URL;
import jplay.Window;

public class Medkit extends Itens{

	public Medkit(int x, int y) {
		super(URL.sprite("medkit.png"), 1);
		this.x = x;
		this.y = y;
	}
	
	private static Font f = new Font("arial", Font.BOLD, 30);
	
	public static void medkitqtd(Window janela, Jogador jogador) {
		janela.drawText("Medkit: " + jogador.medqtd, Cenario1.Xj-200, 30, Color.GREEN, f);
	}
	
	public void pegar(Jogador jogador) {
		if(this.collided(jogador)) {
			jogador.medqtd += 1;
			this.x = 10_000;
		}
	}
}
