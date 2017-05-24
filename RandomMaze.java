import java.util.*; 

public class RandomMaze extends Maze
{
	private Node[][] maze; 
	private int dimensions; 
	
	public RandomMaze(int dimensions)
	{
		super(new MazeSquare(0, 1, 1, false), new MazeSquare(dimensions - 1, 2, 1, false)); 
		this.dimensions = dimensions; 
		maze = new Node[dimensions][dimensions]; 
		generate(); 
	}
	
	private void generate()
	{
		for (int row = 0; row < maze.length; row++)
		{
			for (int col = 0; col < maze[row].length; col++)
			{
				if (row == 0 || col == 0 || row == maze.length - 1 || col == maze[row].length - 1)
				{
					if (!(row == 0 && col == 1 || row == maze.length - 1 && col == 2))
						maze[row][col] = new MazeSquare(row, col, -1, true); 
					else
						maze[row][col] = new MazeSquare(row, col, 1, false); //the start and finish points
				}
				else
				{
					int passable = (int) (Math.random() * 2); 
					passable *= -1; 
					maze[row][col] = new MazeSquare(row, col, passable, false);
				}
			}
		}
	}
	
	public Node[][] getMaze()
	{
		return maze; 
	}
	
	public int width()
	{
		return dimensions; 
	}
	
	public int height()
	{
		return dimensions; 
	}
	
	public Node getNodeByCoords(int x, int y)
	{
		return maze[x][y]; 
	}
}