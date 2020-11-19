package jogo;

import java.util.LinkedList;

import jplay.Scene;
import jplay.Sound;
import jplay.URL;

public class ControleDeTiro {
	
	LinkedList<Tiro> tiros = new LinkedList<>();
	
	public void adicionaTiro(double x, double y, int caminho, Scene cena) {
		Tiro Tiro = new Tiro(x, y, caminho);
		tiros.addFirst(Tiro);
		cena.addOverlay(Tiro);
		somDisparo();
	}
	
	public void run(Ator inimigo, Jogador jogador) {
		for (int i = 0; i < tiros.size(); i++) {
			Tiro Tiro = tiros.removeFirst();
			Tiro.mover();
			tiros.addLast(Tiro);
			
			if(Tiro.collided(inimigo)){
				Cenario1.col = true;
				Cenario1.colx = Tiro.x;
				Cenario1.coly = Tiro.y;
				Tiro.x = 1_000_000;
				inimigo.energia -= jogador.dano;
			}
		}
	
	}
	
	private void somDisparo() {
		new Sound(URL.audio("somtiro.wav")).play();
	}
}
