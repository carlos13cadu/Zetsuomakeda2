package jogo;

import jplay.GameImage;
import jplay.Sprite;
import jplay.URL;

public class Invetario extends Sprite{
	
	static GameImage iv = new GameImage(URL.sprite("inventariomenu.png"));
	static Sprite [] sitens = new Sprite[24];
	static int [][] itens = new int [][]{{290,326,362,398,434,470},{235,235,235,235,235,235}};
	static int [][] barra = new int [][]{{1,0,0,0,0,0},{Cenario1.Xj-243,Cenario1.Xj-208,Cenario1.Xj-174,Cenario1.Xj-140,Cenario1.Xj-107,Cenario1.Xj-72},{Cenario1.Yj-45,Cenario1.Yj-46,Cenario1.Yj-46,Cenario1.Yj-46,Cenario1.Yj-46,Cenario1.Yj-46}};
	static int [][] iditens = new int [2][100];
	
	public Invetario (int x, int y) {
		super(URL.sprite("inventario.png"));
		this.x = x;
		this.y = y;
		esconde();
		set();
	}
	
	private void set() {
		for(int i = 0; i < sitens.length; sitens[i++] = null);
	}
	
	public void mostrar() {
		iv.x = 280;
		iv.y = 200;
	}
	
	public void esconde() {
		iv.x = 10_000;
		iv.y = 10_000;
	}
	
}
