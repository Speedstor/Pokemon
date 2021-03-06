package com.speedstor.players;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.speedstor.main.LoadImage;
import com.speedstor.main.Objects;

public class Characters extends Objects{

	public static int facing, faceDirection;
	ArrayList<BufferedImage> up, down, right, left, sprintUp, sprintDown, sprintRight, sprintLeft;
	public BufferedImage spriteSheet;
	LoadImage loader;
	
	// 102
	
	protected void init(String parentClass, String sprite, LoadImage loader) {		
		this.loader = loader;		
		spriteSheet = loader.Load(sprite);
		
		if(parentClass == "Player1") {
			down = loader.parImageAcross(spriteSheet, 16, 36, 35, 27, 35, 3);
			right = loader.parImageAcross(spriteSheet, 121, 36, 35, 27, 35, 3);
			up = loader.parImageAcross(spriteSheet, 226, 36, 35, 27, 35, 3);
			left = loader.parImageAcross(spriteSheet, 331, 36, 35, 27, 35, 3);

			sprintDown = loader.parImageAcross(spriteSheet, 16, 102, 35, 27, 35, 3);
			sprintRight = loader.parImageAcross(spriteSheet, 121, 102, 35, 27, 35, 3);
			sprintUp = loader.parImageAcross(spriteSheet, 226, 102, 35, 27, 35, 3);
			sprintLeft = loader.parImageAcross(spriteSheet, 331, 102, 35, 27, 35, 3);
		}
		
		
		
		System.out.println(parentClass + ": had been initialized with no errors.  With the spriteSheet: " + sprite);
	}
	
	
	
	
	
	
	public void tick() {
		
		
	}
	
	
	public void render(Graphics g) {
		
		
	}
	
}
