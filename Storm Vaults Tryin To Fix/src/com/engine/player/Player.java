package com.engine.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.engine.main.Game;
import com.engine.main.GameObject;
import com.engine.main.Handler;
import com.engine.main.ID;

public class Player extends GameObject {
	
	//Game object classes are very minimal in design to make and run, but are very expandable
	//Nothing is in here because I didn't need much at the time for the player since I was testing stuff
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
	}

	public void tick() {
		//Movement stuff that involved velocity
		x += velX;
        y += velY;     
        
       //collision();	
	}
	
	public void render(Graphics g) {
		//Made a white square
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, 64, 64);
	}

	@Override
	//Meant for collision detection, but this is essentially non-existant in the game
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
