package com.engine.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	//Class used to create other game objects (currently only player)
	
	//X & Y coordinates
	protected float x, y;
	//Unique ID attached to the game object
	protected ID id;
	//The velocity of the object (used for moving objects)
	protected float velX, velY;
	
	public GameObject(float x, float y, ID id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//These are used for creating the framework for entities essentially
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	//Everything below is just instantiation of the basic variables essentially
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
	public void setID(ID id){
		this.id = id;
	}
	
	public ID getID(){
		return id;
	}
	
	public void setVelX(float velX){
		this.velX = velX;
	}
	
	public void setVelY(float velY){
		this.velY = velY;
	}
	
	public float getVelX(){
		return velX;
	}
	
	public float getVelY(){
		return velY;
	}
}
