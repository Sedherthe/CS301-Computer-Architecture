public class Infiltrator{

	public int logic(int width, double prob, int length){
		boolean targetReached = false;
		int distanceCovered = 0;
		int x = 499;
		int y = 0;

		Sensor[][] grid = new Sensor[width + 2][length];
		for(int i = 0; i < width+2; ++i){
			for(int j=0;j<length;++j){
				grid[i][j] = new Sensor();
			}
		}

		Border border = new Border();
		//System.out.println("hello1" + grid[0][1].off);
		//border.probrabilityCalculator(grid, width, prob, length);
		//System.out.println("hello1" + grid[0][1].off);
		Timer time = new Timer();
		//System.out.println("Came1 into logic");
		while(!targetReached){
			//System.out.println(grid[y][x].off + "-" + grid[y+1][x-1].off);
			border.probrabilityCalculator(grid, width, prob, length);
			//System.out.println(grid[y][x].off + " " + grid[y+1][x-1].off);
			if(grid[y][x].off && grid[y+1][x-1].off){
				distanceCovered +=1;
				//System.out.println("Came3!");
				x-=1; y+=1;

			} else if(grid[y][x].off && grid[y+1][x].off){
				distanceCovered +=1;
				//System.out.println("Came3@");
				y+=1;

			} else if(grid[y][x].off && grid[y+1][x+1].off){
				distanceCovered +=1;
				//System.out.println("Came3#");
				x+=1; y+=1;

			}
			time.setValue();
			if(distanceCovered == width){
				targetReached = true;
			}
		}
		//System.out.println("Came2");
		return time.getValue();
	}


}