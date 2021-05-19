package com.engine.textures;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	//Image or bit of an image
	private BufferedImage sprite;
	
	public SpriteSheet(BufferedImage sprite){
		this.sprite = sprite;
	}
	
	//This is how it grabbed parts of an image
	//Ints X & Y refer to the columns and rows (location) of the bit the program wanted to grab)
	//And the width and height refers to the dimensions of what they wanted
	public BufferedImage grabSection(int x, int y, int width, int height){
		return sprite.getSubimage(x, y, width, height);
	}
}
