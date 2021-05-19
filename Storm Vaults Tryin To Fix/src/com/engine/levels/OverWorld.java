package com.engine.levels;

import java.util.Random;

import com.engine.main.Handler;
import com.engine.main.ID;
import com.engine.tiles.DirtTile;
import com.engine.tiles.GrassTile;
import com.engine.tiles.PathTile;
import com.engine.tiles.RockTile;
import com.engine.tiles.SandTile;
import com.engine.tiles.TreeTile;
import com.engine.tiles.WaterTile;

public class OverWorld {
	
	//Map is semi-random, certain elements are static such as the primary tile placement and level 
	//But small things like the placement of rocks and trees, are random to a certain degree
	
	//Determines if the game is in the overworld to determine what map to show (currently no others are available
	public boolean inOverWorld = true;

	Random random = new Random();
	
	//This array of ints actually is what creates the map and determines where certain tiles go, and each number has
	//a tile linked to it
	public int[][] overWorld1 = {
			
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{4, 7, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
			{4, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 4},
			{4, 0, 0, 6, 6, 6, 5, 5, 1, 5, 5, 6, 6, 6, 6, 0, 0, 0, 0, 4},
			{4, 0, 0, 6, 0, 5, 5, 1, 1, 1, 1, 5, 5, 5, 6, 6, 0, 0, 0, 4},
			{4, 0, 0, 6, 0, 5, 1, 1, 1, 1, 1, 1, 5, 5, 0, 6, 0, 0, 0, 4},
			{4, 0, 0, 6, 6, 5, 5, 1, 1, 1, 1, 1, 1, 5, 6, 6, 0, 0, 0, 4},
			{4, 0, 0, 0, 6, 6, 5, 5, 1, 1, 1, 1, 5, 5, 6, 0, 0, 0, 0, 4},
			{4, 0, 0, 0, 0, 6, 6, 5, 5, 1, 1, 5, 6, 6, 6, 0, 0, 0, 0, 4},
			{4, 0, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 4},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
	};
	
	//Function that creates the 'linking' between tiles and numbers
	public OverWorld(Handler handler) {
		if(inOverWorld) {
			//The for loops create rows and colums of tiles across the screen, and then the 
			//if statements inside determine what tile is associated to what number
			for(int rows = 0; rows < overWorld1.length; rows++) {
				for(int columns = 0; columns < overWorld1[0].length; columns++) {
					if(overWorld1[rows][columns] == 0) {
						handler.addObject(new GrassTile(columns * 64, rows * 64, ID.GRASSTILE, handler));
					}
					
					if(overWorld1[rows][columns] == 1) {
						handler.addObject(new WaterTile(columns * 64, rows * 64, ID.WATERTILE, handler));
					}
					
					if(overWorld1[rows][columns] == 2) {
						handler.addObject(new DirtTile(columns * 64, rows * 64, ID.DIRTTILE, handler));
					}
					
					if(overWorld1[rows][columns] == 3) {
						handler.addObject(new RockTile(columns * 64, rows * 64, ID.ROCKTILE, handler));
					}
					
					if(overWorld1[rows][columns] == 4) {
						handler.addObject(new GrassTile(columns * 64, rows * 64, ID.GRASSTILE, handler));
						handler.addObject(new TreeTile(columns * 64, rows * 64, ID.TREETILE, handler));
					}
					
					if(overWorld1[rows][columns] == 5) {
						handler.addObject(new SandTile(columns * 64, rows * 64, ID.SANDTILE, handler));
					}
					
					if(overWorld1[rows][columns] == 6) {
						handler.addObject(new PathTile(columns * 64, rows * 64, ID.PATHTILE, handler));
					}
					
					if(overWorld1[rows][columns] == 6) {
						handler.addObject(new PathTile(columns * 64, rows * 64, ID.PATHTILE, handler));
					}
					
					//Random placement stuff here. Essentially if the random number generator 
					//Equalled a specific number provided by the if statement, then it would place 
					//That tile at that position, and it did it multiple times (at all AVAILABLE tile locations)
					
					if(random.nextInt(20) == 1 && overWorld1[rows][columns] == 0) {
						handler.addObject(new TreeTile(columns * 64, rows * 64, ID.TREETILE, handler));
					}
					
					if(random.nextInt(9) == 1 && overWorld1[rows][columns] == 0) {
						handler.addObject(new RockTile(columns * 64, rows * 64, ID.TREETILE, handler));
					}
				}
			}	
		}
	}
}
