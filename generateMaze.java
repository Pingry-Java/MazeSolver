import java.util.*; 

public class generateMaze extends Maze
{
	private int dimensions;
	private Node[][] maze;
	public generateMaze(int dim)
	{
		super(new MazeSquare(1, 1, 1, true), new MazeSquare(1, 1, 1, true)); //just using super constructor from maze - starting Node: 1, 1, - will change finish later
		dimensions = dim;
		maze = new MazeSquare[dimensions][dimensions];
		defaultMaze();
		carveWalls(maze[1][1]);
		
	}
	
	private void defaultMaze()
	{
		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{
				if (i == 0 || j == 0 || i == dimensions - 1 || j == dimensions - 1) //outside walls
					maze[i][j] = new MazeSquare(i, j, -1, true); //outside walls impassable and already visited
				else if (i == 1 && j == 1)
					maze[i][j] = new MazeSquare(i, j, 1, true); 
				else
					maze[i][j] = new MazeSquare(i, j, -1, false); //rest of squares have not been visited
			}
		}
	}
	
	private void carveWalls(Node current)
	{
		MazeSquare next = eligible(current);
		int x = next.getX();
		int y = next.getY();
		while(next != null)
		{
			((MazeSquare) (maze[x][y])).setSlowness(1);
			((MazeSquare) (maze[x][y])).setVisited(true);
			carveWalls(maze[x][y]);
			next = eligible(current);
			x = next.getX();
			y = next.getY();
		}
		
		
		
		
	} 
	public MazeSquare eligible(Node current)
	{
		List<Node> eligibleNeighbors = new ArrayList<Node>(); 
		List<Node> neighbors = getNeighbors(current);
		for(int i = 0; i< neighbors.size(); i++)
		{
			if (((MazeSquare)neighbors.get(i)).getVisited())
			{
				neighbors.remove(i);
				i--;
			}
			
		}
		List<Node> visitedNeighbors;
		for(int j = 0; j< neighbors.size(); j++)
		{
			visitedNeighbors = getNeighbors(neighbors.get(j));
			for (int k = 0; k < visitedNeighbors.size(); k++)
			{
				if(((MazeSquare)visitedNeighbors.get(k)).getVisited())
				{
					visitedNeighbors.remove(k);
					k--; 	
				}
			}
			if (visitedNeighbors.size() >= 2)
			{
				eligibleNeighbors.add(neighbors.get(j)); 
			}
		}
		int random = (int) (Math.random() * eligibleNeighbors.size()); 
		if(eligibleNeighbors.size() == 0)
		{
			return null;
		}
		return (MazeSquare) eligibleNeighbors.get(random); 
	}
	
	public Node getNodeByCoords(int x, int y)
	{
		return maze[x][y]; 
	}
	
	public int height()
	{
		return dimensions; 
	}
	
	public int width()
	{
		return dimensions; 
	}
	
}