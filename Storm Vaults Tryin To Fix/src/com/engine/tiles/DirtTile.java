package com.engine.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.engine.main.Game;
import com.engine.main.GameObject;
import com.engine.main.Handler;
import com.engine.main.ID;
import com.engine.textures.Assets;

public class DirtTile extends GameObject {
	
	//Most of the tiles are the same
	
	//Dirt tile
	
	public DirtTile(float x, float y, ID id, Handler handler) {
		super(x, y, id);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		//This is how it would grab and determine it's texture
		g.drawImage(Assets.dirtTile, (int)x, (int)y, null);
	}

	//Meant for collsion but basically useless
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}
}
