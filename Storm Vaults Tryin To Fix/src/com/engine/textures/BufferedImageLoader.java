package com.engine.textures;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	//This essentially would try to locate and load an image into the program
	//Path in this is also referring to the location of the image
	public static BufferedImage loadImage(String path){
		//It would try to find it and load the image into the game
		try {
			return ImageIO.read(BufferedImageLoader.class.getResource(path));
		} catch (IOException e) {
			//And if it couldn't it would output an error to the console and close the progam
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
