package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario2 extends Cenario{
	
	private Ammobox Ammobox;
	private Monstro Enemy;
	private Medkit medkit;
	private Agua Agua;
	private Arma Arma;
	private Agua Agua2;
 
	public Cenario2(Window window){

		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario2.scn"));
		jogador = new Jogador(320, 320);
		teclado = janela.getKeyboard();
		Enemy = new Monstro(300,300); 
		Agua = new Agua(300, 30);
		Agua2 = new Agua(592, 554);
		medkit = new Medkit(600,30);
		Invetario = new Invetario(550,550);
		Arma = new Arma(557, 555, 35, 15, "arma.png");
		habilidades = new Habilidades(janela);
		
		Som.play("somcasa.wav");
		run();
	}
	private void run() {
		while(true) {
			//cena.draw();
			startTime = System.nanoTime();
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			Enemy.caminho(cena);
			Enemy.perseguir(jogador.x, jogador.y);
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			
			//jogador.atirar(janela, cena, teclado, Enemy);
			
			Enemy.x += cena.getXOffset();
			Enemy.y += cena.getYOffset();
			
			jogador.draw();
			jogador.energia(janela);
			jogador.rage(janela);
			jogador.curar(teclado);
			medkit.medkitqtd(janela, jogador);
			Agua.aguaqtd(janela);
			//Agua.beber();
			Agua.beber2(teclado);
			fps();
			
			//Enemy.draw();
			janela.update();
			
			janela.delay(3); //mude o valor do delay de acordo com o que achar melhor
			janela.update();
			
			comandosTeclado();
			
			if(Invetario.iditens[0][0] >= 1) {
				Agua2.draw();
			}
			
			Invetario.draw();
			Arma.draw();
			contarFps();
		}
	}
	public Ammobox getAmmobox() {
		return Ammobox;
	}
	public void setAmmobox(Ammobox ammobox) {
		Ammobox = ammobox;
	}
}
