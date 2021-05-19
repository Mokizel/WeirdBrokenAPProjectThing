package com.engine.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	//This class just determines keyboard input, very straight forward
	
	private Handler handler;
	
	private float playerSpeed = 0.15f;

	public KeyInput(Handler handler) {
		this.handler = handler; 
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.PLAYER) {
				//Key events for player 1
				
				if(key == KeyEvent.VK_D) tempObject.setVelX(playerSpeed);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-playerSpeed);
				if(key == KeyEvent.VK_W) tempObject.setVelY(-playerSpeed);
				if(key == KeyEvent.VK_S) tempObject.setVelY(playerSpeed);
				
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(playerSpeed);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-playerSpeed);
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-playerSpeed);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(playerSpeed);
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.PLAYER){
				//Key events for player 1
				
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);

				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
			}
		}
	}
}
