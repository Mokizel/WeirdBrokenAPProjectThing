package com.engine.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	//The handler handles the gnitty gritty details of the game object class, essentially game object class is the frame work
	
	//This just makes it able to interact with the game object class
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	//Tick logic
    public void tick(){
    	for(int i = 0; i < object.size(); i++) {
    		GameObject tempObject = object.get(i);         
    		tempObject.tick();
    	}
    }
    
    //Rendering logic 
    public void render(Graphics g){
    	for(int i = 0; i < object.size(); i++) {
    		GameObject tempObject = object.get(i);         
    		tempObject.render(g);
    	}
    }
    
    //Allows basic addition and subtraction of objects from the game, although the removeObject function is a little bit weird
    public void addObject(GameObject object) {
    	this.object.add(object);
    }
    
    public void removeObject(GameObject object) {
    	this.object.remove(object);
    }
}
