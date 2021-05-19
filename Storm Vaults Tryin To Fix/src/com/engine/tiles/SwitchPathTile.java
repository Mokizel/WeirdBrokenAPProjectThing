package com.engine.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.engine.main.Game;
import com.engine.main.GameObject;
import com.engine.main.Handler;
import com.engine.main.ID;
import com.engine.player.Camera;

public class SwitchPathTile extends GameObject {

	//Was meant to be able to load other scenes and worlds, but never got fully implemented
	
	public SwitchPathTile(float x, float y, ID id, Handler handler ) {
		super(x, y, id);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		//g.drawImage(, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}
}
