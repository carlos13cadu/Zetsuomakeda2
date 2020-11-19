package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.Sound;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

public class cenario1 extends cenario{
	
	boolean exe;
	static boolean col = false;
	static double colx;
	static double coly;
	private boolean iva = false;
	private static int h;
	private static Sprite aux = null;
	private Mouse mouse;
	static boolean furia = false;
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private invetario Invetario;
	private arma Arma;
	private arma ak47 = new arma(400,300,18,30,"ak47p.png");
	private medkit VMedkit[];
	private ammobox VAmmobox[];
	private agua Agua;
	private static ammobox am = new ammobox(326, 235);
	private Keyboard teclado;
	private Vector<enemy> lenemy = new Vector<enemy>();
	private Vector<Zumbi2> lzumbi2 = new Vector<Zumbi2>();
	private int Xs, Ys, X2, Y2;
	static int Xj, Yj;
	private int [] v = new int[100];
	private int [] v2 = new int[10];
	private Random rnd = new Random();
	teste t = new teste(janela, false);
	private Point posi;
	private boolean hold = false;
	private Habilidades habilidades;
	
	private Dialogo dialogos;
	private String frase = "Bem-vindo ao Zetsuomakeda, tente sobreviver as hordas de zumbis e    colete recursos para continuar vivo!";
	private String titulo = "Zetsuomakeda";
	private String palavra = " ";
	private String palavra2 = " ";
	private String palavra3 = " ";
	private String palavra4 = " ";
	// maximo de letras = 98
	private boolean blinkrage = false;
	private boolean firstblink = false;
	private boolean blinkwater = false;
	private boolean firstblink2 = false;
	private boolean firstwater = false;
	
	private double averageFPS;
	long startTime;
	long totalTime = 0;
	int frameCount = 0;
	int MaxFrameCount = 30;
	
	private Explosao explo;
	private List<Explosao> lexplo = new ArrayList<Explosao>();

	public cenario1(Window window){
		
		janela = window;
		mouse = janela.getMouse();
		Xj = janela.getWidth();
		Yj = janela.getHeight();
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn"));
		teclado = janela.getKeyboard();
		Invetario = new invetario((Xj-250),(Yj-50));
		Arma = new arma(Xj-243, Yj-45, 35, 15, "arma.png");
		jogador = new Jogador(640,320);
		explo = new Explosao(640, 320);
		Agua = new agua(300, 30);
		VAmmobox = new ammobox[10];
		VMedkit = new medkit[5];
		invetario.sitens[0] = agua.Agua;
		invetario.sitens[1] = am;
		habilidades = new Habilidades(janela);
		dialogos = new Dialogo(janela);
		
		Som.play("likeitornot.wav");
		run();
	}
	private void run() {
		exe = true;
		for (int i = 0; i < VAmmobox.length; i++) {
			Xs = rnd.nextInt(1000);
			Ys = rnd.nextInt(1000);
			VAmmobox[i]= new ammobox(Xs, Ys);
		}
		new Thread() {
            public void run() {
            	while(exe) {
            		try {
                        sleep(3000);
                        Xs = rnd.nextInt(1000);
            			Ys = rnd.nextInt(1000);
            			lenemy.add(new enemy(Xs + 1000, Ys + 1000));
                    } catch (InterruptedException ex) {

                    }
            	}
            }
        }.start();
        new Thread() {
            public void run() {
            	while(exe) {
            		try {
                        sleep(6500);
                        X2 = rnd.nextInt(1000);
            			Y2 = rnd.nextInt(1000);
            			lzumbi2.add(new Zumbi2(Xs + 1000, Ys + 1000));
                    } catch (InterruptedException ex) {

                    }
            	}
            }
        }.start();
        new Thread() {
            public void run() {
            	while(exe) {
            		try {
            			/*for(int i = -10; i < 1000; i++) {
            				sleep(1);
            				Dialogo.dialog.x = i;
            			}*/
            			while (frase == " ") {
            				sleep(50);
            			}
	                    for (int i = 1; i <= frase.length(); i++) {
	                    	sleep(40);
	                    	if (i < 70) {
	                    		palavra = frase.substring(0, i);
	                    	}else if(i < 140){
	                    		palavra2 = frase.substring(69, i);
	                    	}else if(i < 210){
	                    		palavra3 = frase.substring(139, i);
	                    	}else {
	                    		palavra4 = frase.substring(209, i);
	                    	}
	                    	
	                    	if(teclado.keyDown(Keyboard.ENTER_KEY)) {
	                    		i++;
	                    	}
	                    	if (i == frase.length()) {
	                    		sleep(4000);
	                    		titulo = " ";
	                    		palavra = " ";
	                            palavra2 = " ";
	                            palavra3 = " ";
	                            palavra4 = " ";
	                            frase = " ";
	                            dialogos.fecharDialogo();
	                            if(firstblink) {
	                            	firstblink = false;
	                            }
	                            if(firstblink2) {
	                            	firstblink2 = false;
	                            }
	                            sleep(500);
	                            if(blinkrage) {
	                            	blinkrage = false;
	                            }
	                            if(blinkwater) {
	                            	blinkwater = false;
	                            }
	                    	}
	                    }
                        
                    } catch (InterruptedException ex) {

                    }
            	}
            }
        }.start();
        new Thread() {
            public void run() {
            	while(exe) {
            		try {
            			if(firstblink) {
	            			sleep(400);
	            			if(blinkrage == true) {
	            	    		blinkrage = false;
	            	    	}else {
	            	    		blinkrage = true;
	            	    	}
            			} else if (firstblink2){
            				sleep(400);
            				if(blinkwater == true) {
            					blinkwater = false;
	            	    	}else {
	            	    		blinkwater = true;
	            	    	}
            			} else {
            				sleep(50);
            			}
                    } catch (InterruptedException ex) {

                    }
            	}
            }
        }.start();
        
		for(int i = 0; i < VMedkit.length; i++) {
			VMedkit[i] = new medkit(rnd.nextInt(640),rnd.nextInt(640));
		}
		while(exe) {
			Jogador.curseseries = 3;
		Jogador.rage = 1000;
			
			startTime = System.nanoTime();
			//cena.draw();
			posi = mouse.getPosition();
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			
			cena.moveScene(jogador);
			
			jogador.desenha(cena);
			
			jogador.curar(teclado);
			
			for (int i = 0; i < lenemy.size(); i++) {
				lenemy.get(i).desenha(cena);
				lenemy.get(i).caminho(cena);
				lenemy.get(i).perseguir(jogador.x, jogador.y);
				jogador.atirar(janela, cena, teclado, lenemy.get(i));
				lenemy.get(i).morrer();
				lenemy.get(i).atacar(jogador);
				lenemy.get(i).raioexplo(lexplo);
			}
			
			for (int i = 0; i < lzumbi2.size(); i++) {
				lzumbi2.get(i).desenha(cena);
				lzumbi2.get(i).caminho(cena);
				lzumbi2.get(i).perseguir(jogador.x, jogador.y);
				jogador.atirar(janela, cena, teclado, lzumbi2.get(i));
				lzumbi2.get(i).morrer();
				lzumbi2.get(i).atacar(jogador);
				lzumbi2.get(i).raioexplo(lexplo);
			}
			
			for (int i = 0; i < VAmmobox.length; i++) {
				VAmmobox[i].desenha(cena); // adiciona todas as caixas de muniçao no jogo
				VAmmobox[i].pegar(jogador);
			}
			
			for (int i = 0; i < VMedkit.length; i++) {
				VMedkit[i].desenha(cena); // adiciona todos os medkits no jogo
				VMedkit[i].pegar(jogador);
			}
			
			Agua.desenha(cena); // adiciona garrafa da agua no jogo
			
			if(jogador.isFirstTransformacao()) {
				titulo = "Zetsuomakeda";
				frase = "Sua fúria chegou a 100%, utilize a tecla ''T'' para ativar sua trans-formação!";
				dialogos.abrirDialogo();
				firstblink = true;
			}
			if(Agua.firstAgua == true && firstwater == false) {
				titulo = "Zetsuomakeda";
				frase = "Cuidado para sua sede não chegar a 0, senão você começara a tomar da-no até ela voltar ao normal!  Para beber água aperte a tecla ''N'', é necessário ter uma garrafa cheia ou um cantil!";
				dialogos.abrirDialogo();
				firstwater = true;
				firstblink2 = true;
			}
			
			if(col && Jogador.rg) {	// verifica se curse series está ativada e se a bala acerta algum inimigo
				lexplo.add(new Explosao(colx-20, coly-20)); // caso verdadeiro cria uma entidade para animaçao da explosao
			}
			col = false;
			for (int i = 0; i < lexplo.size(); i++) {
				lexplo.get(i).ativar(cena); // ativa a animaçao
				if (!lexplo.get(i).isPlaying()) {
					lexplo.remove(i); // remove a animacao assim que ela acaba
				}
			}
			
			Agua.pegar(jogador);
			Invetario.draw();
			Arma.draw();
			
			ak47.desenha(cena);
			ak47.pegar(jogador);
			
			if(Agua.qtd >= 1) {
				agua.Agua.draw();
			}
			
			//iv.draw();
			Invetario.iv.draw();
			
			if(iva == false && teclado.keyDown(KeyEvent.VK_E)) {
				iva = true;
				Invetario.mostrar();
			}else if (iva == true && teclado.keyDown(KeyEvent.VK_E)){
				iva = false;
				hold = false;
				Invetario.esconde();;
			}
			//teste inventario
			
			if(iva) {
				for(int i = 0; i < invetario.sitens.length; i++) {
					if(invetario.sitens[i] != null) {
						invetario.sitens[i].draw();
					}
				}
			}
			
			if(iva) {
				if(mouse.isLeftButtonPressed()) {
					if(mouse.isOverArea(491, 205, 518, 235)) {
						iva = false;
						hold = false;
						Invetario.esconde();
					}else if(mouse.isOverArea(288, 235, 324, 265)) {
						if(hold == false && invetario.sitens[0] != null) {
							hold = true;
							h = 0;
						}else if(hold == true){
							hold = false;
							if(invetario.sitens[0] == null) {
								invetario.sitens[h].x = invetario.itens[0][0];
								invetario.sitens[h].y = invetario.itens[1][0];
								invetario.sitens[0] = invetario.sitens[h];
								invetario.sitens[h] = null;
							}else {
								invetario.sitens[h].x = invetario.itens[0][0];
								invetario.sitens[h].y = invetario.itens[1][0];
								invetario.sitens[0].x = invetario.itens[0][h];
								invetario.sitens[0].y = invetario.itens[1][h];
								aux = invetario.sitens[0];
								invetario.sitens[0] = invetario.sitens[h];
								invetario.sitens[h] = aux;
							}
						}
					}else if(mouse.isOverArea(324, 235, 360, 265)) {
						if(hold == false && invetario.sitens[1] != null) {
							hold = true;
							h = 1;
						}else if(hold == true){
							hold = false;
							if(invetario.sitens[1] == null) {
								invetario.sitens[h].x = invetario.itens[0][1];
								invetario.sitens[h].y = invetario.itens[1][1];
								invetario.sitens[1] = invetario.sitens[h];
								invetario.sitens[h] = null;
							}else {
								invetario.sitens[h].x = invetario.itens[0][1];
								invetario.sitens[h].y = invetario.itens[1][1];
								invetario.sitens[1].x = invetario.itens[0][h];
								invetario.sitens[1].y = invetario.itens[1][h];
								aux = invetario.sitens[1];
								invetario.sitens[1] = invetario.sitens[h];
								invetario.sitens[h] = aux;
							}
						}
					}else if(mouse.isOverArea(360, 235, 396, 265)) {
						if(hold == false && invetario.sitens[2] != null) {
							hold = true;
							h = 2;
						}else if(hold == true){
							hold = false;
							if(invetario.sitens[2] == null) {
								invetario.sitens[h].x = invetario.itens[0][2];
								invetario.sitens[h].y = invetario.itens[1][2];
								invetario.sitens[2] = invetario.sitens[h];
								invetario.sitens[h] = null;
							}else {
								invetario.sitens[h].x = invetario.itens[0][2];
								invetario.sitens[h].y = invetario.itens[1][2];
								invetario.sitens[2].x = invetario.itens[0][h];
								invetario.sitens[2].y = invetario.itens[1][h];
								aux = invetario.sitens[2];
								invetario.sitens[2] = invetario.sitens[h];
								invetario.sitens[h] = aux;
							}
						}
					}else if(mouse.isOverArea(396, 235, 422, 265)) {
						if(hold == false && invetario.sitens[3] != null) {
							hold = true;
							h = 3;
						}else if(hold == true){
							hold = false;
							if(invetario.sitens[3] == null) {
								invetario.sitens[h].x = invetario.itens[0][3];
								invetario.sitens[h].y = invetario.itens[1][3];
								invetario.sitens[3] = invetario.sitens[h];
								invetario.sitens[h] = null;
							}else {
								invetario.sitens[h].x = invetario.itens[0][3];
								invetario.sitens[h].y = invetario.itens[1][3];
								invetario.sitens[3].x = invetario.itens[0][h];
								invetario.sitens[3].y = invetario.itens[1][h];
								aux = invetario.sitens[3];
								invetario.sitens[3] = invetario.sitens[h];
								invetario.sitens[h] = aux;
							}
						}
					}else if(mouse.isOverArea(422, 235, 458, 265)) {
						if(hold == false && invetario.sitens[4] != null) {
							hold = true;
							h = 4;
						}else if(hold == true){
							hold = false;
							if(invetario.sitens[4] == null) {
								invetario.sitens[h].x = invetario.itens[0][4];
								invetario.sitens[h].y = invetario.itens[1][4];
								invetario.sitens[4] = invetario.sitens[h];
								invetario.sitens[h] = null;
							}else {
								invetario.sitens[h].x = invetario.itens[0][4];
								invetario.sitens[h].y = invetario.itens[1][4];
								invetario.sitens[4].x = invetario.itens[0][h];
								invetario.sitens[4].y = invetario.itens[1][h];
								aux = invetario.sitens[4];
								invetario.sitens[4] = invetario.sitens[h];
								invetario.sitens[h] = aux;
							}
						}
					}else if(mouse.isOverArea(458, 235, 494, 265)) {
						if(hold == false && invetario.sitens[5] != null) {
							hold = true;
							h = 5;
						}else if(hold == true){
							hold = false;
							if(invetario.sitens[5] == null) {
								invetario.sitens[h].x = invetario.itens[0][5];
								invetario.sitens[h].y = invetario.itens[1][5];
								invetario.sitens[5] = invetario.sitens[h];
								invetario.sitens[h] = null;
							}else {
								invetario.sitens[h].x = invetario.itens[0][5];
								invetario.sitens[h].y = invetario.itens[1][5];
								invetario.sitens[5].x = invetario.itens[0][h];
								invetario.sitens[5].y = invetario.itens[1][h];
								aux = invetario.sitens[5];
								invetario.sitens[5] = invetario.sitens[h];
								invetario.sitens[h] = aux;
							}
						}
					}
				}
			}
			
			if(hold) {
				invetario.sitens[h].x = posi.getX()-15;
				invetario.sitens[h].y = posi.getY()-10;
			}
			//
			
			//teste fullscreen
			if(teclado.keyDown(KeyEvent.VK_F11)) {
				janela.setFullScreen();
				Xj = janela.getWidth();
				Yj = janela.getHeight();
				invetario.barra[1][0] = Xj-243;
				invetario.barra[2][0] = Yj-45;
				invetario.barra[1][1] = Xj-208;
				invetario.barra[2][1] = Yj-46;
				invetario.barra[1][2] = Xj-174;
				invetario.barra[2][2] = Yj-46;
				invetario.barra[1][3] = Xj-140;
				invetario.barra[2][3] = Yj-46;
				invetario.barra[1][4] = Xj-107;
				invetario.barra[2][4] = Yj-46;
				invetario.barra[1][5] = Xj-72;
				invetario.barra[2][5] = Yj-46;
				Invetario = new invetario((Xj-250),(Yj-50));
				agua.Agua = new agua(invetario.barra[1][invetario.iditens[0][0]], invetario.barra[2][invetario.iditens[0][0]]);
				Arma = new arma(invetario.barra[1][0], invetario.barra[2][0], 35, 15, "arma.png");
			}
			//
			
			jogador.energia(janela);
			if(!blinkrage) {
				jogador.rage(janela);
			}
			ammobox.balas(janela, jogador);
			medkit.medkitqtd(janela, jogador);
			if(!blinkwater) {
				Agua.aguaqtd(janela);
			}
			//Agua.beber();
			Agua.beber2(teclado);
			this.Fps(janela);
			this.pal(janela);
			
			janela.update();
			janela.delay(3); //mude o valor do delay de acordo com o que achar melhor
			mudarCenario();
			mudarCenario2();
			mudarCenario3();
			
			if(teclado.keyDown(KeyEvent.VK_K)) {
				habilidades.Open(jogador);
			}
			
			if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
				System.exit(0);
			}

			if(Jogador.energia <= 0) {
				Jogador.rage = 0;
				exe = false;
				continuo();
				Som.play("death.wav");
				Main.deat = true;
			}

			if(jogador.kills % 10 == 0 && jogador.kills >= 10) {
				jogador.ragePoints += 1;
			}
			
			if(Jogador.rage >= 1000 && furia == false && Jogador.rg == false && teclado.keyDown(KeyEvent.VK_T)) {
				desespero();
				jogador.transforma();
				jogador.atualizaFrame(20);
				furia = true;
			}
			if(furia == true) {
				if (Jogador.rage >= 0) {
					Jogador.rage -= 0.25;//diminui a furia depois de um tempo
				}
				if (Jogador.curseseries == 3 && Jogador.energia <= 1000) { // <= 500
					Som.play("op2.wav");
					jogador.atualizaFrame(20);
					furia = false;
					jogador.curseSeries();
				}
				if (Jogador.rage <= 0) {
					jogador.atualizaFrame(-20);
					furia = false;
					jogador.denstransforma();
				}
			}
			if(Jogador.rg == true) {
				Jogador.energia -= 0.05; // a curse series toma a vida do individuo
				if(Jogador.energia <= 100) {
					Jogador.rg = false; // se a vida chega a 10% ou menos a curse series se esvai pela falta de força
					jogador.atualizaFrame(-40);
					jogador.denstransforma();
					Jogador.rage = 0;
					Som.play("fundo.wav");
				}
			}
			totalTime += System.nanoTime() - startTime;
			frameCount++;
			if(frameCount == MaxFrameCount) {
				averageFPS = 1000.0 / (((double) totalTime / frameCount) / 1000000);
				frameCount = 0;
				totalTime = 0;
			}
		}
		
	}
	
	private void mudarCenario() {
		if(tileCollisio(38, jogador, cena)==true)
			new cenario2(janela);
	}
	private void mudarCenario2() {
		if(tileCollisio(84, jogador, cena)==true)
			new cenario2(janela);
	}
	private void mudarCenario3() {
		if(tileCollisio(85, jogador, cena)==true)
			new cenario2(janela);
	}
	private void continuo() {
		new Sound(URL.audio("continue.wav")).play();
	}
	private void desespero() {
		new Sound(URL.audio("desespero.wav")).play();
	}
	
	Font f = new Font("arial", Font.BOLD, 30);
	Font f2 = new Font("arial", Font.BOLD, 15);
	Font f3 = new Font("arial", Font.BOLD, 20);
	
	public void Fps(Window janela) {
		int J = (int)averageFPS;
		janela.drawText("FPS: " + J, 30, 570, Color.GREEN, f3);
	}
	public void pal(Window janela) {
		dialogos.exibirDialogo();
		janela.drawText(titulo, 105, 400, Color.YELLOW, f3);
		janela.drawText(palavra, 130, 445, Color.WHITE, f2);
		janela.drawText(palavra2, 130, 465, Color.WHITE, f2);
		janela.drawText(palavra3, 130, 485, Color.WHITE, f2);
		janela.drawText(palavra4, 130, 505, Color.WHITE, f2);
	}
}
