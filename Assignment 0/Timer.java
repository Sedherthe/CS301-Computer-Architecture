public class Timer{
	int time;
	
	public Timer(){
		time = 0;
	}
	
	public void setValue(){
		time += 10;
	}
	
	public int getValue(){
		return time;
	}
}