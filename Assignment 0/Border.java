import java.util.*;
public class Border{

	public void initialise(Sensor[][] grid, int width, int length ){
		//Sensor[][] grid = new Sensor[width+2][length];
		
	}
	
	public void probrabilityCalculator(Sensor[][] grid, int width, double prob, int length){
		//System.out.println("Came");
		//Sensor[][] grid = new Sensor[width+2][length];
		//initialise(grid, width, length);
		for(int i=0;i<length;i++){
			grid[0][i].off = true;
			grid[width+1][i].off = true;
		}
		//System.out.println("hello" + grid[0][1].off);
		//System.out.println("Came-");
		//System.out.println(grid[0]);
		for ( int i=1; i<=width; i++ ){
			for ( int j=0;j<1000; j++ ){
				boolean val = (Math.random()<prob)?false:true;
				grid[i][j].off = val;
			}
		}
	}
}