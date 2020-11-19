package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class cenario2 extends cenario{
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private ammobox Ammobox;
	private Keyboard teclado;
	private enemy Enemy;
	private medkit Medkit;
	private agua Agua;
	private invetario Invetario;
	private arma Arma;
	private agua Agua2;
 
	public cenario2(Window window){

		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario2.scn"));
		jogador = new Jogador(320, 320);
		teclado = janela.getKeyboard();
		Enemy = new enemy(300,300); 
		Agua = new agua(300, 30);
		Agua2 = new agua(592, 554);
		Medkit = new medkit(600,30);
		Invetario = new invetario(550,550);
		Arma = new arma(557, 555, 35, 15, "arma.png");
		
		Som.play("somcasa.wav");
		run();
	}
	private void run() {
		while(true) {
			//cena.draw();
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
			Medkit.medkitqtd(janela, jogador);
			Agua.aguaqtd(janela);
			//Agua.beber();
			Agua.beber2(teclado);
			
			//Enemy.draw();
			janela.update();
			
			janela.delay(3); //mude o valor do delay de acordo com o que achar melhor
			janela.update();
			
			if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
				System.exit(0);
			}
			if(invetario.iditens[0][0] >= 1) {
				Agua2.draw();
			}
			
			Invetario.draw();
			Arma.draw();
			
		}
	}
	public ammobox getAmmobox() {
		return Ammobox;
	}
	public void setAmmobox(ammobox ammobox) {
		Ammobox = ammobox;
	}
}
