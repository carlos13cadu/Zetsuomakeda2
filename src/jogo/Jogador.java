package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import jplay.Keyboard;
//import jplay.Mouse;
import jplay.Scene;
import jplay.Sound;
import jplay.URL;
import jplay.Window;

public class Jogador extends ator{
	
	private int I,J;
	private boolean ragefirst = true;
	public Color cor = Color.BLACK;
	public int kills = 0;
	public int muni = 15;
	public int pente = 15;
	public int maxPente = 15;
	public int medqtd = 0;
	public double dano = 35;
	static double sede = 1000;
	static double energia = 1000;
	static double maxEnergia = 1000;
	static double rage = 0;
	static int curseseries = 0;
	static boolean rg = false;
	static int [] sq = new int [] {0, 4, 8, 12, 16};
	
	public int ragePoints = 0;
	public int sorte = 0;
	public int vigor = 0;
	public int concentracao = 0;
	
	public Jogador(double x, double y) {
		super(URL.sprite("teste.png"), 60);
		this.x = x;
		this.y = y;
		this.setTotalDuration(6000);
	}
	
	controletiro tiros = new controletiro();
	public void atirar(Window janela, Scene cena, Keyboard teclado, ator inimigo) {
		//Mouse mouse = janela.getMouse();
		if(teclado.keyDown(KeyEvent.VK_SPACE)) {
            if(this.muni > 0) {
	               this.muni -= 1;
	               tiros.adicionaTiro(x + 8, y + 11, direcao, cena);  
            }else {
            	somregarregar();
            }
		}
		
		if(teclado.keyDown(KeyEvent.VK_R)) {
			if(this.pente >= this.maxPente) {
				this.pente -= (this.maxPente - this.muni);
				this.muni = this.maxPente;
				somregarregar();
			}else if (this.pente != 0){ 
				if (this.pente + this.muni >= maxPente) {
					this.pente -= (this.maxPente - this.muni);
					this.muni = this.maxPente;
					somregarregar();
				}else if (this.muni == 0){
					this.muni = this.pente;
					this.pente = 0;
					somregarregar();
				}else {
					this.muni += this.pente;
					this.pente = 0;
					somregarregar();
				}
			}
		}
		
		tiros.run(inimigo, this);
	}
	
	public void controle(Window janela, Keyboard teclado) {
		
		if(teclado.keyDown(Keyboard.LEFT_KEY) || teclado.keyDown(KeyEvent.VK_A)){
			if(this.x > 0)
				this.x -= velocidade;
			if(direcao != 1) {
				setSequence(sq[1], sq[2]);
				direcao = 1;
			}movendo = true;
		}else if(teclado.keyDown(Keyboard.RIGHT_KEY)|| teclado.keyDown(KeyEvent.VK_D)){
			if(this.x < janela.getWidth() - 60)
				this.x += velocidade;
			if(direcao != 2){
				setSequence(sq[2], sq[3]);
				direcao = 2;
			}movendo = true;
		}else if(teclado.keyDown(Keyboard.UP_KEY) || teclado.keyDown(KeyEvent.VK_W)){
			if(this.y > 0)
				this.y -= velocidade;
			if(direcao != 4) {
				setSequence(sq[3], sq[4]);
				direcao = 4;
			}movendo = true;
		}else if(teclado.keyDown(Keyboard.DOWN_KEY)|| teclado.keyDown(KeyEvent.VK_S)){
			if(this.y < janela.getHeight() - 60)
				this.y += velocidade;
			if(direcao != 5) {
				setSequence(sq[0], sq[1]);
				direcao = 5;
			}movendo = true;
		}
		
		if(movendo){
			update();//atualiza...
			movendo = false;//... e para
		}
	}
	
	public void curar(Keyboard teclado) {
		if(teclado.keyDown(Keyboard.M_KEY)) {
			if (this.medqtd >= 1) {
				if (Jogador.energia + 300 <= Jogador.maxEnergia) {
					this.medqtd--;
					Jogador.energia += 300;
				}else if (Jogador.energia != Jogador.maxEnergia){
					Jogador.energia = maxEnergia;
					this.medqtd--;
				}
			}
		}
	}
	
	public void transforma() {
		Jogador.energia = maxEnergia;//o player se transforma e recupera toda a vida
		this.dano = 50;
		Jogador.curseseries++;
	}
	
	public void denstransforma() {
		this.dano = 35;
		this.cor = Color.BLACK;
	}
	
	public void curseSeries() {
		Jogador.energia = 750;
		this.dano = 100;
		Jogador.rg = true;
		Jogador.rage = 1000;
		this.cor = Color.RED;
		this.ragePoints++;
	}
	
	public boolean isFirstTransformacao(){
		if (rage >= 1000 && ragefirst == true) {
			ragefirst = false;
			return true;
		}
		return false;
	}
	
	public void atualizaFrame(int qtdFrame) {
		this.setCurrFrame(this.getCurrFrame()+qtdFrame);
		for(int i = 0; i < Jogador.sq.length; i++) {
			Jogador.sq[i] += qtdFrame;
		}
		if(direcao == 1) { //*cadeia de ifs para resolução do problema no update dps de transformar enquanto anda que bugava os sprites
			setSequence(sq[1], sq[2]);
		}else if(direcao == 2){
			setSequence(sq[2], sq[3]);
		}else if(direcao == 4) {
			setSequence(sq[3], sq[4]);
		}else if(direcao == 5) {
			setSequence(sq[0], sq[1]);
		}
	}
	
	Font f = new Font("arial", Font.BOLD, 30);

	public void energia(Window janela) {
		I = (int)energia;
		janela.drawText("Vida: " + (I/10), 30, 30, Color.GREEN, f);
	}
	public void rage(Window janela) {
		J = (int)rage;
		janela.drawText("Fúria: " + (J/10) + "%", 30, 90, cor, f);
		if(Jogador.rage >= 1000 && Jogador.rg != true) {
			this.cor = Color.YELLOW;
		}
	}
	private void somregarregar() {
		new Sound(URL.audio("recarregar.wav")).play();
	}
}