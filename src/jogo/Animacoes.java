package jogo;

import jplay.Scene;
import jplay.Sprite;

public class Animacoes extends Sprite{
	
	public Animacoes(String fileName, int numFrames) {
		super(fileName, numFrames);
	}
	
	public void ativar(Scene cena) {
        this.x += cena.getXOffset(); // faz com que a animaçao,
        this.y += cena.getYOffset(); // nao se mova pela tela
        this.draw(); // desenha a animaçao
        this.update(); // atualiza os frames
        this.setLoop(false); // nao deixa a animaçao entrar em loop
    }
}
