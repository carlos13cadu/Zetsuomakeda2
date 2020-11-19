package jogo;

import java.util.LinkedList;

import jplay.Scene;
import jplay.Sound;
import jplay.URL;

public class controletiro {
	
	LinkedList<tiro> tiros = new LinkedList<>();
	
	public void adicionaTiro(double x, double y, int caminho, Scene cena) {
		tiro Tiro = new tiro(x, y, caminho);
		tiros.addFirst(Tiro);
		cena.addOverlay(Tiro);
		somDisparo();
	}
	
	public void run(ator inimigo, Jogador jogador) {
		for (int i = 0; i < tiros.size(); i++) {
			tiro Tiro = tiros.removeFirst();
			Tiro.mover();
			tiros.addLast(Tiro);
			
			if(Tiro.collided(inimigo)){
				cenario1.col = true;
				cenario1.colx = Tiro.x;
				cenario1.coly = Tiro.y;
				Tiro.x = 1_000_000;
				inimigo.energia -= jogador.dano;
			}
		}
	
	}
	
	private void somDisparo() {
		new Sound(URL.audio("somtiro.wav")).play();
	}
}
