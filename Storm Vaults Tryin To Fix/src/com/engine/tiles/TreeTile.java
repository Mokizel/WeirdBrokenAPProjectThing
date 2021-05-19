package com.engine.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.engine.main.GameObject;
import com.engine.main.Handler;
import com.engine.main.ID;
import com.engine.textures.Assets;

public class TreeTile extends GameObject {
	
	//Tree tile, kinda unique because it doesn't take up all the space it's in despite
	//the program classifying it as a tile
	//I would like to make a system for 'details', for things like trees, flowers, etc
	
	public TreeTile(float x, float y, ID id, Handler handler) {
		super(x, y, id);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.treeTile, (int)x, (int)y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}
}
