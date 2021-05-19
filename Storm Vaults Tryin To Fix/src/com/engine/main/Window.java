package com.engine.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	//The window class sets up the window and settings for it
	
	private static final long serialVersionUID = -240840600533728354L;
	
	public Window(int width, int height, String title, Game game){
		//JFrame is essentially the window
		JFrame frame = new JFrame(title);
		//The lines below determine specific details about the window
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		//This essentially starts up the game when the window is loaded
		game.start();
	}
}
