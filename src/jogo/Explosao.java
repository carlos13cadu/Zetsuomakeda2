package jogo;

import jplay.URL;

public class Explosao extends Animacoes{

	public Explosao(double x, double y) {
		super(URL.sprite("Explosion_2.png"), 12);
		this.x = x;
		this.y = y;
		this.setTotalDuration(1000);
	}
	
	public void ativar() {
		this.setSequence(2, 8);
	}
	
}
