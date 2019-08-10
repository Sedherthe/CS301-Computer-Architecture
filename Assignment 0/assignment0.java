import java.util.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

public class assignment0{
	public static void main(String args[]){
		int w=0;
		double prob=0;
		for (int i=1;i<17;i++){
			w = i;
			for (double j=0.10;j<1.0; j = j + 0.10){
				prob = j;
				program((w+1),prob);
			}
		}
	}
	private static void program(int w, double prob){
		int distanceCovered = 0;
		int x=499,y=0;
		boolean targetReached = false;
		double time = 0;
		boolean[][] grid = new boolean[w][1000];
		grid[0][499] = true;
		//initialiseGrid(grid);
		while(!targetReached){
			probrabilityCalculator(w,grid, prob);
			if(grid[y][x] && grid[y+1][x-1]){
				distanceCovered +=1;
				x-=1; y+=1;

			} else if(grid[y][x] && grid[y+1][x]){
				distanceCovered +=1;
				y+=1;

			} else if(grid[y][x] && grid[y+1][x+1]){
				distanceCovered +=1;
				x+=1; y+=1;

			}
			time +=10;
			if(distanceCovered == w-1){
				targetReached = true;
			}
		}
		System.out.println("Time: " + time);
		System.out.println("Width: " + (w-1));
		System.out.println("Probability: " + prob);
	}
	private static void probrabilityCalculator(int w, boolean[][] grid, double prob){
		int totalSize = w*1000;
		for ( int i=0; i<w; i++ ){
			for ( int j=0;j<1000; j++ ){
				grid[i][j] = (Math.random()<prob)?true:false;
			}
		}
	}
}