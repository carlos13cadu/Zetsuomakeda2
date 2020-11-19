package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Agua extends Itens {
	
	private int J;
	public static Agua Agua;
	public boolean firstAgua = false;

	public Agua(int x, int y) {
		super(URL.sprite("agua.png"), 2);
		this.x = x;
		this.y = y;
		setCurrFrame(1);
	}
	
	public static void beber() {
		new Thread() {
			public void run() {
				for(int i = 0; i < Jogador.sede; i++) {
					try {
						Thread.sleep(1200);
							if (Jogador.sede != 0){
								Jogador.sede -= 2;
							}else {
								Jogador.energia -= 2;
							}
						} catch (InterruptedException a1) {

					}
				}
			}
		}.start();
	}
	
	public void beber2(Keyboard teclado) {
		if(teclado.keyDown(KeyEvent.VK_N)) {
			if (Invetario.iditens[0][0] >= 1) {
				if (Jogador.sede + 300 <= 1000) {
					Invetario.iditens[0][0]--;
					Jogador.sede += 300;
				}else if (Jogador.sede != 1000){
					Jogador.sede = 1000;
					Invetario.iditens[0][0]--;
				}
				Agua.setCurrFrame(0);
			}
		}
	}
	
	Font f = new Font("arial", Font.BOLD, 30);
	
	public void aguaqtd(Window janela) {
		J = (int)Jogador.sede;
		janela.drawText("Sede: " + (J/10), 30, 60, Color.GREEN, f);
	}
	
	public void pegar(Jogador jogador) {
		if(this.collided(jogador)) {
			if(!firstAgua) {
				firstAgua = true;
			}
			for(int i = 0; i < Invetario.barra[0].length; i++) {
				if(Invetario.barra[0][i] == 0) {
					this.qtd += 1;
					Invetario.barra[0][i] = 1;
					Invetario.iditens[0][0] += 1;
					Invetario.iditens[1][0] = i;
					this.x = 10_000;
					Agua = new Agua(Invetario.barra[1][i], Invetario.barra[2][i]);
					break;
				}
			}
			
		}
	}
}
