package com.engine.player;

import com.engine.main.Game;
import com.engine.main.GameObject;

public class Camera {

	//Camera class was supposed to be used to follow player, it somehow broke despite it working at one point.. (has to do with clamping)
	
	//X & Y coordinates of the camera
	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//This tick function specifically is meant for following the player, but something with the camera is not enabled in the game class
	public void tick(GameObject player) {
		//Both lines are essentially saying follow the player and keep the player centered
		x = -player.getX() - Game.WIDTH / 2;
		
		y = -player.getY() - Game.HEIGHT / 2;
	}
	
	//Initallizing variables essentially
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
}
