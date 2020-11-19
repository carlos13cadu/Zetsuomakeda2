package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

import jplay.GameObject;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.TileInfo;
import jplay.Window;

public abstract class Cenario {
	
	protected boolean exe; // Booleano que verifica a execucao do programa
	protected Keyboard teclado; // Variavel que detecta teclas apertadas no teclado
	protected Mouse mouse;// Variavel que detecta teclas apertadas no mouse
	protected Window janela;
	protected Scene cena;
	protected Random rnd = new Random();// Criador de numeros pseudo-randomicos(geralmente usado para posicoes de itens no cenario)
	protected Invetario Invetario;// Inventario do jogo, todas suas funcoes estao em sua respectiva classe
	protected Habilidades habilidades;// Habilidades do jogo, todas suas funcoes estao em sua respectiva classe
	
	protected Jogador jogador;// E o jogador, todas suas funcoes estao em sua respectiva classe
	
	protected Vector<Medkit> vMedkit = new Vector<Medkit>();
	protected Vector<Ammobox> vAmmobox = new Vector<Ammobox>();
	
	// contador de fps
	protected double averageFPS;
	protected long startTime;
	protected long totalTime = 0;
	protected int frameCount = 0;
	protected int MaxFrameCount = 30;
	//
	
	//fontes
	Font f = new Font("arial", Font.BOLD, 30);
	Font f2 = new Font("arial", Font.BOLD, 15);
	Font f3 = new Font("arial", Font.BOLD, 20);
	//
	
	protected boolean tileCollisio(int value, Jogador jogador, Scene cena) {
		Point min = new Point((int) jogador.x, (int) jogador.y);
		Point max = new Point((int) (jogador.x + jogador.width), (int) (jogador.y + jogador.height));
		Vector<?> tiles = cena.getTilesFromPosition(min, max);
		for(int i = 0; i < tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			if(tileCollision(jogador, tile, value) == true) {
				return true;
			}
		}
		return false;
	}
	private boolean tileCollision(GameObject object, TileInfo tile, int value) {
		if((tile.id == value) && object.collided(tile)) {
			return true;
		}
		return false;
	}
	
	protected void comandosTeclado() {
		if(teclado.keyDown(KeyEvent.VK_K)) {
			habilidades.Open(jogador);
		}
		if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
			System.exit(0);
		}
	}
	
	protected void adcionarMedkit(int qtd) {
		for(int i = 0; i < qtd; i++) {
			vMedkit.add(new Medkit(rnd.nextInt(640),rnd.nextInt(640))); // adciona medkits no cenario
		}
	}
	
	protected void adcionarAmmobox(int qtd) {
		for(int i = 0; i < qtd; i++) {
			vAmmobox.add(new Ammobox(rnd.nextInt(1000),rnd.nextInt(1000))); // adciona medkits no cenario
		}
	}
	
	protected void contarFps() {
		totalTime += System.nanoTime() - startTime;
		frameCount++;
		if(frameCount == MaxFrameCount) {
			averageFPS = 1000.0 / (((double) totalTime / frameCount) / 1000000);
			frameCount = 0;
			totalTime = 0;
		}
	}
	
	protected void fps() {
		int J = (int)averageFPS;
		janela.drawText("FPS: " + J, 30, 570, Color.GREEN, f3);
	}
}
