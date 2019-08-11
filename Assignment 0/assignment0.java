import java.util.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.Writer;
import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;

public class assignment0{
	public static void main(String args[]){
		int width = 0;
		int length = 1000;
		double prob = 0;
		int time = 0;
		Infiltrator infiltrator = new Infiltrator();
		//FileWriter myWriter = new FileWriter("filename.txt", true);
		//BufferedWriter writer = new BufferedWriter(
                                //new FileWriter("c:/temp/samplefile.txt", true)  //Set true for append mode
                            //);
		//FileWriter writer = new FileWriter("samplefile.txt", true);
		

		try { 
		      FileWriter myWriter = new FileWriter("filename4.txt", true);
		      //myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      for (int i=1;i<17;i++){
				width = i;
				//System.out.println(width+"width");
				for (double j=0.10;j<0.9; j = j + 0.10){
					int avg_time = 0;
					System.out.println("For "+ width + "," + prob + ": ");
					for(int k=0;k<16;k++){
						prob = j;
						time = infiltrator.logic(width,prob,length);
						System.out.print(time + " ");	
						avg_time += time;
					}
					avg_time = avg_time / 15;
					//System.out.println("Ccaammee");
					
					//System.out.println(width + " " + prob + length + "params");
					
					myWriter.write(Integer.toString(width)+ "," +Double.toString(prob)+ "," + Integer.toString(avg_time) + "\n");
					//writer.newLine();
					System.out.println("Width: " + width + " Prob " + prob + " Time: " + avg_time);
					
				}
			}

		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } 
	    catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    } 


		/*for (int i=1;i<17;i++){
			width = i;
			//System.out.println(width+"width");
			for (double j=0.10;j<0.9; j = j + 0.10){
				//System.out.println("Ccaammee");
				prob = j;
				//System.out.println(width + " " + prob + length + "params");
				time = infiltrator.logic(width,prob,time);
				//writer.write(Integer.toString(width)+ "," +Double.toString(prob)+ "," + Integer.toString(length));
				//writer.newLine();
				System.out.println("Width: " + width + " Prob " + prob + " Time: " + time);
				
			}
		}*/

	}
}
	/*private static void program(int w, double prob){
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
}*/