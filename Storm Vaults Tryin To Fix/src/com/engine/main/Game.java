package com.engine.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.engine.levels.OverWorld;
import com.engine.player.Camera;
import com.engine.player.HUD;
import com.engine.player.Player;
import com.engine.textures.Assets;
import com.engine.textures.BufferedImageLoader;

/*CREDIT TO RealTutsGML for helping me make a large part of this program, as I made this years ago when I
was first learning Java (https://www.youtube.com/watch?v=1gir2R7G9ws&list=PLWms45O3n--6TvZmtFHaCWRZwEqnz2MHa) 
(https://www.youtube.com/watch?v=DXT11ZbB2Mk&list=PLWms45O3n--54U-22GDqKMRGlXROOZtMx) */

public class Game extends Canvas implements Runnable {
	
	//This game is incomplete, and at one point had lots of featues in it, and then I somehow broke it
	
	private static final long serialVersionUID = -240840600533728354L;
	
	//For Anyone Looking At The Code, I Know These Are Weird Dimensions, But It Is For Level Purposes
    public static final int WIDTH = 1286, HEIGHT = 733;
    
    private Thread thread;
    
    //Is the program running
    private boolean running = false;
  
    //Providing names to classes
    private Handler handler;
    private HUD hud;
    private Camera camera;
    
    private OverWorld overWorld;
    
    //Game state to determine different levels, currently broken 
    public STATE gameState = STATE.OVERWORLD;
    
    //Declaring classes and setting up the program 
    public Game() {    
    		BufferedImageLoader loader = new BufferedImageLoader();
    		
            handler = new Handler();
            
            overWorld = new OverWorld(handler);
            
            hud = new HUD();
            camera = new Camera(0, 0);
            
            this.addKeyListener(new KeyInput(handler));
            
        	new Window(WIDTH, HEIGHT, "Storm Vaults Prototype", this); 
            
            handler.addObject(new Player(0, 0, ID.PLAYER, handler));
    }
    
    //Initializes textures and assets for the game
    private void init() {
    	Assets.init();
    }

    //Starts up the program
	public synchronized void start() {
            thread = new Thread(this);
            thread.start();
            running = true;
    }
	
	//Ends program
    public synchronized void stop() {
            try {
                    thread.join();
                    running = false;
            } catch(Exception e) {
                    e.printStackTrace();
            }
    }
    
    //Essentially the 'logic' that runs the game (the loop), but most of it is disabled right now since I found a simpler way of doing it
    public void run() {
            /*this.requestFocus();
            long lastTime = System.nanoTime();
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int frames = 0;
            while(running){ 
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >= 1){
                            tick();
                            delta--;
                    }
                    if(running)
                    	render();
               

                    frames++;
                    if(System.currentTimeMillis() - timer > 1000){
                            timer += 1000;
                            System.out.println("FPS: " + frames);
                            frames = 0;
                    }
            }
            stop();*/
    	
    	init();
		
		while(running){
			tick();
			render();
		}
		
		stop();
    }
    
    //Update loop for certain things in the program, such as the HUD (which is currently disabled)
    private void tick() {
    	handler.tick();
    	
    	if(gameState == STATE.OVERWORLD || gameState == STATE.SKYWORLD || gameState == STATE.DUNGEON) {
    	//	hud.tick();
    	}
    	
    	for(int i = 0; i < handler.object.size(); i++) {
    		if(handler.object.get(i).getID() == ID.PLAYER) {
    			camera.tick(handler.object.get(i));
    		}
    	}
    }
    
    //Renders the graphics for the game 
    public void render() {
            BufferStrategy bs = this.getBufferStrategy();
            if(bs == null){
                    this.createBufferStrategy(3);
                    return;
            }      
            
            Graphics g = bs.getDrawGraphics();
            Graphics2D g2d = (Graphics2D) g;
            
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            //g2d.translate(camera.getX(), camera.getY());
            
            handler.render(g);
            
            //g2d.translate(camera.getX(), camera.getY());
            g2d.translate(-camera.getX(), -camera.getY());      
              
            if(gameState == STATE.OVERWORLD || gameState == STATE.SKYWORLD || gameState == STATE.DUNGEON) {
        		hud.render(g);
        	}
            
            g.dispose(); 
            bs.show();
    }
    
    //Clamps certain things for screen purposes
    public static float clamp(float var, float min, float max) {
            if(var >= max)
                    return var = max;
            else if(var < min)
                    return var = min;
            else
                    return var;
    }

    //Main function that initiates program essentially
    public static void main(String args[]) {
    		new Game();
    }
}
