package jogo;

import jplay.URL;

public class Arma extends Itens{
	
	private int dano;
	private int pente;

	public Arma(int x, int y, int dano, int pente, String sprite) {
		super(URL.sprite(sprite), 1);
		this.x = x;
		this.y = y;
		this.dano = dano;
		this.pente = pente;
	}
	
	public void pegar(Jogador jogador) {
		if(this.collided(jogador)) {
			jogador.dano = dano;
			jogador.maxPente = pente;
			jogador.muni = pente;
			this.x = 10_000;
		}
	}

}
