public class SampleMaze extends Maze
{
	private Node[][] maze; 
	
	public SampleMaze(int length, int width)
	{
		super(new MazeSquare(1, 0, 1), new MazeSquare(2, 3, 1)); 
		maze = new Node[length][width]; 
		for(int r = 0; r < 4; r++)
		{
			for(int c = 0; c < 4; c++)
			{
				if((r == 0 && c != 1) || r == 3 || c == 0 || (c == 3 && r != 2))
					maze[r][c] = new MazeSquare(r,c,-1);
				else
					maze[r][c] = new MazeSquare(r,c,1);
			}
		}
	}
	
	public Node[][] getMaze()
	{
		return maze; 
	}
	
	public int width()
	{
		return 4; 
	}
	
	public int height()
	{
		return 4; 
	}
	
	public Node getNodeByCoords(int x, int y)
	{
		return maze[x][y]; 
	}
	
	
	
}