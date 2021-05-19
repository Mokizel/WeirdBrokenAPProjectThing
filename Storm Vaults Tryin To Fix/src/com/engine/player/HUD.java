package com.engine.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;

import com.engine.main.Game;

public class HUD extends KeyAdapter {

	//Okay so this actually works, but I disabled it because it's not staying in one spot for whatever reason
	//This class has a bar at the top that decreases in color length and changes color depending on the player health 
	//The HUD also displayed a score and the level 
	
	public static float Health = 100;
	private float greenValue = 255;
	public float score = 0;
	public float level = 1;
	
	public void tick(){
		//Essentially instantiating it and then telling it to stay in one spot
		Health = Game.clamp(Health, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = Health * 2;
		
		score++;
		
		//If health was equal too or lower than zero, the program would close
		if(Health <= 0){
			System.exit(0);
		}
	}
	
	//Rendered the HUD
	public void render(Graphics g){
		/*g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75,(int) greenValue, 0));
		g.fillRect(15, 15, (int) (Health * 2), 32);
		g.setColor(Color.gray);
		g.drawRect(15, 15, (int) (Health * 2), 32);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);*/
	}
	
	//Declaring and instantiating the variables
	public void score(float score){
		this.score = score;
	}
	
	public float getScore(){
		return score;
	}
	
	public float getLevel(){
		return level;
	}
	
	public void setLevel(float level){
		this.level = level;
	}
}
