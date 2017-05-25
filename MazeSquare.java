import java.util.*; 

public class MazeSquare extends Node
{
	private int x;
	private int y;
	private int slowness;
	private boolean visited;  
	
	public MazeSquare(int xcoord, int ycoord, int slowness, boolean visited)
	{
		x = xcoord; 
		y = ycoord; 
		this.slowness = slowness; 
		this.visited = visited; 
	}
	
	public int getX()
	{
		return x; 
	}
	
	public int getY()
	{
		return y; 
	}
	
	public int slowness()
	{
		return slowness; 
	}
	
	public void setSlowness(int slowness)
	{
		this.slowness = slowness; 
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ")"; 
	}
	
	public boolean getVisited()
	{
		return visited; 
	}
	
	public void setVisited(boolean visited)
	{
		this.visited = visited; 
	}
	public char symbol()
	{
		if (slowness < 0)
			return '#'; 
		else
			return 'O';	
	}
}