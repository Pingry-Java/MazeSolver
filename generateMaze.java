import java.util.*; 

/**
 * This class generates a 2D array of Nodes to represent a maze according to our algorithm
 */ 
public class generateMaze extends Maze
{
	private int dimensions;
	private Node[][] maze;
	
	/**
	 * Makes a maze according to given dimensions
	 * @param dim The dimensions of the maze
	 */ 
	public generateMaze(int dim)
	{
		//Use constructor from Maze 
		super(null, null);
		
		dimensions = dim;
		
		maze = new MazeSquare[dimensions][dimensions];
		
		defaultMaze();
		carveWalls(maze[1][1]);
		
		//reset the finish line to an open space in the last row
		int randomColumn = 0; 
		while (true)
		{
			randomColumn = (int) (Math.random() * (dimensions - 2)) + 1; 
			if (maze[dimensions - 2][randomColumn].slowness() > 0)
			{
				setFinish(maze[dimensions - 2][randomColumn]); 
				break; 
			}
		}
		
	}
	
	/**
	 * Provides a default maze with outside walls being impassable and inside squares passable. 
	 * Walls have already been visited and inner squares are unvisited
	 */ 
	private void defaultMaze()
	{
		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{
				if (i == 0 || j == 0 || i == dimensions - 1 || j == dimensions - 1) //outside walls
					maze[i][j] = new MazeSquare(i, j, -1, true); //outside walls impassable and already visited
				else if (i == 1 && j == 1) //the start
				{
					Node start = new MazeSquare(i, j, 1, true); 
					maze[i][j] = start; 
					setStart(start);  
				}
				else
					maze[i][j] = new MazeSquare(i, j, -1, false); //rest of squares have not been visited
			}
		}
	}
	
	/**
	 * The recursive algorithm that uses eligible to carve walls in order to minimize open spaces
	 * @param current The current Node that you are looking to carve walls around
	 */
	private void carveWalls(Node current)
	{
		((MazeSquare) current).setVisited(true);
		MazeSquare next = eligible(current);
		if(next == null)
		{
			return;
		}
		while(next != null)
		{
			next.setSlowness(1);
			next.setVisited(true);
			carveWalls(next);
			next = eligible(current);
		}
	}
	
	/**
	 * Looks for eligible neighbors, which is defined as a neighbor that has two unvisited neighbors
	 * @param current The Node that you are looking for eligible neighbors 
	 */ 
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
	
	
	/**
	 * Gets a node in the 2D array
	 */ 
	public Node getNodeByCoords(int x, int y)
	{
		return maze[x][y]; 
	}
	
	/**
	 * Accessor for the height of the maze
	 * @return The height of the maze
	 */ 
	public int height()
	{
		return dimensions; 
	}
	
	/**
	 * Accessor for the width of the maze
	 * @return The width of the maze
	 */ 
	public int width()
	{
		return dimensions; 
	}
	
	/**
	 * Just for testing purpose
	 */ 
	public void printMaze()
	{
		for(int i = 0; i < maze.length; i++)
		{
			for(int z = 0; z < maze[i].length; z++)
			{
				System.out.print(maze[i][z].symbol());
			}
			System.out.println();
		}
		
	}
	
}