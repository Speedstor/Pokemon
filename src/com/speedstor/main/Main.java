package com.speedstor.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.speedstor.Input.Input;
import com.speedstor.map.LoadMap;
import com.speedstor.map.MapRender;
import com.speedstor.objects.Trees;
import com.speedstor.players.Player1;

public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = -2578428780737535640L;
	
	//Variables
		//Global
			public boolean running = true;
			public static int frames = 0, runTime = 0;
			public static double width = 1200, height = width / 4 * 3; //Scene "blocks": 15 x 13
			public static int key = 0;
		
		//Private
			Handler handler;
			private Thread thread;
			LoadImage loader;
		
	//Notes
		/* Objects on screen max at 9500 objects
		 * 
		 */

	
			
	
	//Initial Commit
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		handler = new Handler();
		loader = new LoadImage();
		
		//Creating window
		new Window((int) width, (int)height, "Pokemon is dumb", this);
		
		//Adding elements on screen
		handler.addObjectTopMost(new LoadMap("res/Map1.txt", handler, this));
		handler.addObjectCustom(1,  new Player1("/maleSprite.png", handler, loader));
		handler.addObjectUnderMost(new MapRender(handler, loader));
		
		//keyInput
		addKeyListener(new Input(handler));
		
		run();
	}

	//Game Engine
	public void run() {
		int frames = 0;
		
		requestFocus();
		System.out.println("The game had started on " + frames + ".");
		long delta = 0, timer;
		timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 100000000 /amountOfTicks;
		int dub = 0;
		
		
		
		while(running) {
			long now = System.nanoTime();
			
			delta += (now - lastTime) / ns;
			
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta --;
			}
			
			if(running) {
				render();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer = System.currentTimeMillis();
				Main.frames = frames;
				frames = 0;
				runTime++;
				dub++;
			}
			if(dub >= 60) {
				System.out.println("RunTime: " + runTime/60 + " minutes"); 
				dub = 0;
			}
		}
		stop();
	}
	public synchronized void start() {
		this.thread = new Thread();
		thread.start();
		running = true;
		System.out.println("running = " + running);
	}
	public void stop() {
		try {
			System.out.println("Bug spotted, porogram stopped");
			thread.join();
			running = false;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void tick() {
		handler.tick();
	}
	BufferStrategy bs =  getBufferStrategy();
	public void render() {
		bs =  getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, (int)width, (int)height);
		
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	
	public void changeScene(String mapPath) {
		handler.removeAllObjects();
	}
}



