package com.engine.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.engine.main.GameObject;
import com.engine.main.Handler;
import com.engine.main.ID;
import com.engine.textures.Assets;

public class WaterTile extends GameObject {
	
	//Water tile
	
	public WaterTile(float x, float y, ID id, Handler handler) {
		super(x, y, id);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.waterTile1, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}
}
