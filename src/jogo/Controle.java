package jogo;

import jplay.GameObject;
import jplay.TileInfo;

public class Controle {
	
	public boolean colisao(GameObject obj, TileInfo tile) {
		if((tile.id >= 13 && tile.id <= 23 || tile.id >= 45 && tile.id <= 80)&& obj.collided(tile)) {
			return true;
		}
		return false;
	}
	
}
