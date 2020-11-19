package jogo;

import jplay.Window;
import jplay.URL;

import java.awt.event.KeyEvent;
import java.util.Vector;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Mouse;

public class Main {
	
	static boolean deat = false;
	static Vector<botao> buttons = new Vector<botao>();
	
	static Mouse mouse;

	public static void main(String[] args) {
		
		Window janela = new Window(800, 600);
		mouse = janela.getMouse();
		Keyboard teclado = janela.getKeyboard();
		
		botao b1 = new botao(URL.sprite("botao1.png"), 2, 300, 230, mouse);
		botao b2 = new botao(URL.sprite("botao2.png"), 2, 301, 282, mouse);
		botao b3 = new botao(URL.sprite("botao3.png"), 2, 335, 380, mouse);
		botao b4 = new botao(URL.sprite("botao4.png"), 2, 320, 325, mouse);
		botao b5 = new botao(URL.sprite("botao5.png"), 2, 300, 380, mouse);
        
		GameImage plano = new GameImage(URL.sprite("menu.png"));
		GameImage plano2 = new GameImage(URL.sprite("gameover.png"));

		teclado.addKey(KeyEvent.VK_F11);
		teclado.addKey(KeyEvent.VK_R);
		teclado.addKey(KeyEvent.VK_I);
		teclado.addKey(KeyEvent.VK_E);
		teclado.addKey(KeyEvent.VK_N);
		teclado.addKey(KeyEvent.VK_T);
		teclado.addKey(KeyEvent.VK_K);
		teclado.addKey(KeyEvent.VK_W, Keyboard.DETECT_EVERY_PRESS);
		teclado.addKey(KeyEvent.VK_A, Keyboard.DETECT_EVERY_PRESS);
		teclado.addKey(KeyEvent.VK_S, Keyboard.DETECT_EVERY_PRESS);
		teclado.addKey(KeyEvent.VK_D, Keyboard.DETECT_EVERY_PRESS);

	    Som.play("likeitornotremix.wav");
	    
		boolean exe = true;
	    
		while(exe) {
			
			if(mouse.isLeftButtonPressed()) { // Verifica se o botao esquerdo do mouse foi pressionado
                  if(b1.isMouseOn()) { // Verifica se o mouse ta em cima do botao
                    agua.beber();
                    if(deat == false) {
    					new cenario1(janela);
    				}else{
    					deat = false;
    					Jogador.energia = 1000;
    					//Som.play("op.wav");
    					Som.play("likeitornot.wav");
    					//new cenario1(janela); comeca um novo jogo na hora ao inves de voltar pro menu
    				}
                  }else if(b3.isMouseOn()) {
                	  exe = false;
                  }else if(b5.isMouseOn()) {
                	  	deat = false;
                	  	b1.x = 300;
        				b2.x = 301;
        				b3.x = 335;
        				b4.x = 320;
  						Jogador.energia = 1000;
  						Som.play("op.wav");
                  }
            }
            
			if(deat == false) {
				plano.draw();
				b1.Draw();
				b2.Draw();
				b3.Draw();
				b4.Draw();
			}else {
				plano2.draw();
				b1.x = 1000;
				b2.x = 1000;
				b3.x = 1000;
				b4.x = 1000;
				b5.Draw();
			}
			janela.update();
			if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
				exe = false;
			}
			/*if(teclado.keyDown(Keyboard.ENTER_KEY)) {
				agua.beber();
				if(deat == false) {
					new cenario1(janela);
				}else{
					deat = false;
					Jogador.energia = 1000;
					Som.play("op.wav");
					//new cenario1(janela); comeca um novo jogo na hora ao inves de voltar pro menu
				}
			}*/
		}
		janela.exit();
	}
}
