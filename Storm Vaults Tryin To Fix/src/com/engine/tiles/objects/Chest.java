package com.engine.tiles.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.engine.main.GameObject;
import com.engine.main.Handler;
import com.engine.main.ID;

public class Chest extends GameObject {
	
	//Meant to be an interactible object that would display an inventory when the player went up to it and pressed a key
	//But again, it never panned out
	
	public Chest(float x, float y, ID id, Handler handler ) {
		super(x, y, id);		
	}

	public void tick() {
	
	}

	public void render(Graphics g) {
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}	
}
