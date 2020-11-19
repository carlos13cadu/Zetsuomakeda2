package jogo;

import jplay.GameImage;
import jplay.Sprite;
import jplay.URL;

public class invetario extends Sprite{
	
	static GameImage iv = new GameImage(URL.sprite("inventariomenu.png"));
	static Sprite [] sitens = new Sprite[24];
	static int [][] itens = new int [][]{{290,326,362,398,434,470},{235,235,235,235,235,235}};
	static int [][] barra = new int [][]{{1,0,0,0,0,0},{cenario1.Xj-243,cenario1.Xj-208,cenario1.Xj-174,cenario1.Xj-140,cenario1.Xj-107,cenario1.Xj-72},{cenario1.Yj-45,cenario1.Yj-46,cenario1.Yj-46,cenario1.Yj-46,cenario1.Yj-46,cenario1.Yj-46}};
	static int [][] iditens = new int [2][100];
	
	public invetario (int x, int y) {
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
