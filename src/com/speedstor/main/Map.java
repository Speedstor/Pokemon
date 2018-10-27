package com.speedstor.main;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Map {
	//Variables
		int[][] map;
		Handler handler;
		int row = 0, col;
		
	public Map(String location) {
		try {
			File file = new File(location);
		Scanner s = new Scanner(file);
		boolean holder = false;
		for(int i=0; s.hasNextInt(); i++) {
			if(s.nextInt() == 1) {
				row ++;
				if(holder == false) {
					col = i;
					holder = true;
				}
			}
		}
		map = new int[col][row];
		System.out.println("The dimensions of the Map is " + col + " x " + row );
		s.close();
		}catch(Exception e) {
			System.out.println("cannot read file");
		}
		
		try {
			Scanner s2 = new Scanner(new File(location));
			int c = 0, r = 0;
			while(s2.hasNextInt()) {
				int temp = s2.nextInt();
				if(temp != 1) {
					map[c][r] = temp;
					c++;
				}else if(temp == 1) {
					c = 0;
					r++;
				}
			}
			s2.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(map));
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
	
	
	
	
}
