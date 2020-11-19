package jogo;

import java.awt.Point;
import java.util.List;
import java.util.Vector;

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Ator extends Sprite {

	double velocidade = 1;
	protected int direcao = 3;
	boolean movendo = false;
	
	Controle controle = new Controle();
	public double energia = 100;
	
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames);
	}
	
	//Controle de caminho que não ira permitir que o personagem ultrapasse os bloqueios
		public void caminho(Scene cena) {
			Point min = new Point((int)this.x,(int) this.y);
			Point max = new Point((int)this.x + this.width,(int) this.y + this.height);
			
			Vector<?>tiles = cena.getTilesFromPosition(min, max);
			
			for(int i = 0; i < tiles.size(); i++) {
				TileInfo tile = (TileInfo) tiles.elementAt(i);
				
				if(controle.colisao(this, tile)==true) {
					
					if(colisaoVertical(this, tile)) {
						if(tile.y + tile.height - 2 < this.y) {
							this.y = tile.y + tile.height;
						}
					
						else if(tile.y > this.y + this.height - 2) {
							this.y = tile.y - this.height;
						}
					}
					if(colisaoHorizontal(this, tile)) {
						if(tile.x > this.x + this.width - 2) {
							this.x = tile.x - this.width;
						}else {
							this.x = tile.x + tile.width;
						}
					}
				}
			}
		}
		
		public void coliSprite(GameObject obj){
	        if (this.collided(obj)) {
	            if (colisaoVertical(this, obj)) {
	                if (obj.y + obj.height - 2 < this.y) {
	                    this.y = obj.y + obj.height;
	                } else if (obj.y > this.y + this.height - 2) {
	                    this.y = obj.y - this.height;
	                }
	            }
	            if (colisaoHorizontal(this, obj)) {
	                if (obj.x > this.x + this.width - 2) {
	                    this.x = obj.x - this.width;
	                } else {
	                    this.x = obj.x + obj.width;
	                }
	            }
	        }
	    }

		private boolean colisaoVertical(GameObject obj, GameObject obj2) {
			if(obj2.x + obj2.width <= obj.x)
				return false;
			if(obj.x + obj.width <= obj2.x)
				return false;
			return true;
		}
		
		private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
			if(obj2.y + obj2.height <= obj.y)
				return false;
			if(obj.y + obj.height <= obj2.y)
				return false;
			return true;
		}
		
		public void desenha(Scene cena) {
			this.x += cena.getXOffset();
			this.y += cena.getYOffset();
			this.draw();
		}
		
		public void raioexplo(List <Explosao> explo) {
			for(int i = 0; i < explo.size(); i++) {
				if (this.collided(explo.get(i)) && explo.get(i).getCurrFrame() < 8) {
					this.energia = 0;
				}
			}
		}
}
