package jogo;

import jplay.Scene;
import jplay.Sprite;

public class Itens extends Sprite {
	
	public int qtd = 0;
	
	public Itens(String fileName, int numFrames) {
		super(fileName, numFrames);
	}
	
	public void desenha(Scene cena) {
		this.x += cena.getXOffset();
		this.y += cena.getYOffset();
		this.draw();
	}
	
	public void pegar(Jogador jogador) {
		if(this.collided(jogador)) {
			this.x = 10_000;
		}
	}
	
}