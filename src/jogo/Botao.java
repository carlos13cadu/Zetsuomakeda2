package jogo;

import jplay.Mouse;
import jplay.Sprite;

public class Botao extends Sprite{

    private Mouse mouse;
    
    public Botao(String fileName, int numFrames, int x, int y, Mouse _mouse) {
    	super(fileName, numFrames);
    	this.x = x;
    	this.y = y;
        
        mouse = _mouse;
    }
    
    public void Draw() {
    	
    	this.draw();
    	if(!mouse.isOverObject(this)) {
            this.setCurrFrame(0);
		}else {
            this.setCurrFrame(1);
		}
    	
    }
    
    public boolean isMouseOn() {
        return mouse.isOverObject(this);
    }
}
