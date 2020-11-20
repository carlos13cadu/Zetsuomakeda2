package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.URL;
import jplay.Window;

public class Habilidades {
	private Window janela;
    private Keyboard teclado;
    private Mouse mouse;
    private GameImage background, featuresPanel;
    private int fx, fy; // x e y das informaÃ§Ãµes da nave
    private int v2, c100, c200, sort, vel, fr, bd, bv, ts; // Precos das habilidades/atributos
    private Font font;
    
    private Botao vida2, casco100, casco200, sorte, veloc, firerate, bulletdamage, bulletveloc, trippleshot;
    
    public Habilidades(Window janela) {
    	this.janela = janela;
    	
    	teclado = janela.getKeyboard();
        mouse = janela.getMouse();
        
        featuresPanel = new GameImage(URL.sprite("featurespanel.png"));
        
        fx = 50;
        fy = 150;

        featuresPanel.x = fx - 10;
        featuresPanel.y = fy - 90;
        
        font = new Font("Lucida Console", Font.TRUETYPE_FONT, 15);
        
        vida2 = new Botao(URL.sprite("vida2button.png"), 2, fx - 10, fy + 180, mouse);
        casco100 = new Botao(URL.sprite("botaobase.png"/*"casco100button.png"*/), 2, fx - 10, fy + 260, mouse);
        casco200 = new Botao(URL.sprite("botaobase.png"/*"casco200button.png"*/), 2, fx - 10, fy + 340, mouse);
        sorte = new Botao(URL.sprite("sorte1.png"/*"agilitybutton.png"*/), 2, fx + 150, fy + 180, mouse);
        veloc = new Botao(URL.sprite("botaobase.png"/*"velocitybutton.png"*/), 2, fx + 150, fy + 260, mouse);
        firerate = new Botao(URL.sprite("botaobase.png"/*"fireratebutton.png"*/), 2, fx + 150, fy + 340, mouse);
        bulletdamage = new Botao(URL.sprite("botaobase.png"/*"damagebutton.png"*/), 2, fx + 310, fy + 180, mouse);
        bulletveloc = new Botao(URL.sprite("botaobase.png"/*"bulletveloc.png"*/), 2, fx + 310, fy + 260, mouse);
        trippleshot = new Botao(URL.sprite("botaobase.png"/*"trippleshot.png"*/), 2, fx + 310, fy + 340, mouse);
        
        v2 = 1;
        c100 = 1900;
        c200 = 3700;
        sort = vel = fr = bd = bv = 1;
        ts = 120000;
    }
    
    public void Open(Jogador jogador) {
        while(!teclado.keyDown(KeyEvent.VK_K) && !teclado.keyDown(Keyboard.ESCAPE_KEY)) {
            Draw(jogador);

            if(mouse.isLeftButtonPressed()) {
                if(vida2.isMouseOn()) {
                    if (jogador.ragePoints >= v2) {
                    	jogador.ragePoints -= v2;
                    	Jogador.maxEnergia += 20;
                    	Jogador.energia += 20;
                    }
                }
                if(sorte.isMouseOn()) {
                	if (jogador.ragePoints >= sort) {
                    	jogador.ragePoints -= sort;
                    	jogador.sorte++;
                    	sort *= 2;
                    }
                }
                if(veloc.isMouseOn()) {
                    
                }
            }
        }
    }
    
    private void Draw(Jogador jogador) {
        showFeatures(jogador);
    }
    
    private void showFeatures(Jogador jogador) {
        featuresPanel.draw();

        janela.drawText("Vida......: " + (int)Jogador.energia/10 + "/" + (int)Jogador.maxEnergia/10, fx, fy, Color.GREEN, font);
        janela.drawText("RagePoints...: " + jogador.ragePoints, fx, fy + 20, Color.GREEN, font);
        janela.drawText("Sorte..............." + jogador.sorte, fx, fy + 60, Color.GREEN, font);
        janela.drawText("Vigor..............." + jogador.vigor, fx, fy + 80, Color.GREEN, font);
        janela.drawText("Concentração........" + jogador.concentracao, fx, fy + 100, Color.GREEN, font);
        //janela.drawText("Danos do tiro.........." + (int)Jogador.energia, fx, fy + 120, Color.GREEN, font);
        //janela.drawText("Velocidade dos tiros..." + (int)Jogador.energia, fx, fy + 140, Color.GREEN, font);

        vida2.Draw();
        casco100.Draw();
        casco200.Draw();
        sorte.Draw();
        veloc.Draw();
        firerate.Draw();
        bulletdamage.Draw();
        bulletveloc.Draw();
        trippleshot.Draw();

        janela.drawText("RP:   1", fx + 15, fy + 235, Color.GREEN, font);
        janela.drawText("RP:   0", fx + 15, fy + 315, Color.GREEN, font);
        janela.drawText("RP:   0", fx + 15, fy + 395, Color.GREEN, font);
        janela.drawText("RP:   " + sort, fx + 175, fy + 235, Color.GREEN, font);
        janela.drawText("RP: " + (int)(vel-vel), fx + 175, fy + 315, Color.GREEN, font);
        janela.drawText("RP: " + (int)(fr-fr), fx + 175, fy + 395, Color.GREEN, font);
        janela.drawText("RP: " + (int)(bd-bd), fx + 335, fy + 235, Color.GREEN, font);
        janela.drawText("RP: " + (int)(bv-bv), fx + 335, fy + 315, Color.GREEN, font);
        janela.drawText("RP: " + (int)(ts-ts), fx + 335, fy + 395, Color.GREEN, font);

        janela.update();
    }
}
