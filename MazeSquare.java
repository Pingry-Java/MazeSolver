import java.util.*; 

public class MazeSquare extends Node
{
	private int x;
	private int y;
	private int slowness; 
	
	public MazeSquare(int xcoord, int ycoord, int slowness)
	{
		x = xcoord; 
		y = ycoord; 
		this.slowness = slowness; 
	}
	
	public List<Node> getNeighbors()
	{
		return null; //just for testing purposes
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
	
}