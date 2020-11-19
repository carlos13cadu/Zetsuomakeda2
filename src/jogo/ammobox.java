package jogo;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import jplay.URL;
import jplay.Window;

public class ammobox extends itens{
	
	private Random rnd = new Random();
	
	public ammobox(int x, int y){
		super(URL.sprite("ammobox.png"), 1);
		this.x = x;
		this.y = y;
	}
	public void gerar(boolean b) {
		
	}
	
	private static Font f = new Font("arial", Font.BOLD, 30);
	
	public static void balas(Window janela, Jogador jogador) {
		janela.drawText("Balas: " + jogador.muni + "/" + jogador.pente, cenario1.Xj/2-100 , 30, Color.GREEN, f);
	}
	
	public void pegar(Jogador jogador) {
		if(this.collided(jogador)) {
			if (rnd.nextInt(2) == 1) {
				jogador.pente += jogador.sorte;
			}
			jogador.pente += 10;
			this.x = 10_000;
		}
	}
}
