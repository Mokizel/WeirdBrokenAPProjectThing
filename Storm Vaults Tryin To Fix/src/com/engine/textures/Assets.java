package com.engine.textures;

import java.awt.image.BufferedImage;

public class Assets {

	//Dimensions of the textures
	private static final int width = 64, height = 64;
	
	//List of textures or bits of the sprite sheet I wanted to grab
	public static BufferedImage grassTile, dirtTile, waterTile1, waterTile2, waterTile3, rockTile, sandTile, pathTile, treeTile;

	//How it worked: A sprite sheet would be provided with all the textures on it, and then it would go through the columns and rows and find the
	//designated texture it was required to grab, and then grabbed the required dimension amount at that position
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(BufferedImageLoader.loadImage("/StormVault_PixelArt_SpriteSheet_AllAssets.png"));
		
		grassTile = sheet.grabSection(0, 0, 64, 64);
		dirtTile = sheet.grabSection(64, 0, 64, 64);
		waterTile1 = sheet.grabSection(128, 0, 64, 64);
		waterTile2 = sheet.grabSection(192, 0, 64, 64);
		waterTile3 = sheet.grabSection(256, 0, 64, 64);
		rockTile = sheet.grabSection(320, 0, 64, 64);
		sandTile = sheet.grabSection(384, 0, 64, 64);
		pathTile = sheet.grabSection(448, 0, 64, 64);
		treeTile = sheet.grabSection(512, 0, 64, 64);
	}
}
