import java.util.*; 

/**
 * This class generates a 2D array of Nodes to represent a maze according to our algorithm
 */ 
public class GenerateMaze extends Maze
{
	private int dimensions;
	private Node[][] maze;
	
	/**
	 * Makes a maze according to given dimensions
	 * @param dim The dimensions of the maze
	 */ 
	public GenerateMaze(int dim)
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

		while(next != null)
		{
			next.setSlowness(1);
			next.setVisited(true);
			
			System.out.println("Heading down the stack.");
			wip();
			
			carveWalls(next);
			
			System.out.println("Heading up the stack.");
			wip();
			
			next = eligible(current);
		}
	}
	
	/**
	 * Looks for eligible neighbors, which is defined as a neighbor that has two unvisited neighbors
	 * @param current The Node that you are looking for eligible neighbors 
	 */ 
	public MazeSquare eligible(Node current)
	{
		// Get all the current nodes unvisited neighbors 
		List<Node> neighbors = getUnvisitedNeighbors(current);
		
		// A list hat will contain all eligible 1st gen neighbors
		List<Node> eligibleNeighbors = new ArrayList<Node>();
		
		// List that will contain 2nd gen neighbors for one 1st gen neighbor at a time
		List<Node> secondNeighbors;

		// Loop through all the first gen neighbors, and determine whether they are eligible
		for(int j = 0; j< neighbors.size(); j++)
		{
			// Whichever 1st gen neighbor we're working on this time through the loop
			Node neighbor = neighbors.get(j);
			
			// Get all this 1st gen node's unvisited neighbor
			secondNeighbors = getUnvisitedNeighbors(neighbor);
			
			// If there are enough unvisited 2nd gen neighbors, then this 1st gen neighbor is eligible
			if (secondNeighbors.size() >= 2)
			{
				eligibleNeighbors.add(neighbor); 
			}
		}
		
		// If there are no eligible neighbors, we can't return one, so return null
		// This will trigger the terminating case in carveWalls
		if(eligibleNeighbors.size() == 0)
		{
			return null;
		}
		
		// If there were eligible neighbors, return one of them at random
		int random = (int) (Math.random() * eligibleNeighbors.size()); 
		return (MazeSquare) eligibleNeighbors.get(random); 
	}
	
	
	/**
	 * Returns all given Node's unvisited neighbors.
	 */
	public List<Node> getUnvisitedNeighbors(Node current)
	{
		List<Node> neighbors = getNeighbors(current);

		//Remove all visited neighbors from the list
		for(int i = 0; i< neighbors.size(); i++)
		{
			if (((MazeSquare)neighbors.get(i)).getVisited())
			{
				neighbors.remove(i);
				i--;
			}
		}
		
		return neighbors;
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
	
	/////// Everything below this line Just for testing purposes ///////////
		
	/**
	 * Prints the current maze using suggested characters.
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
	/**
	 * Simple main for testing. Creates a maze with size specified on the command line
	 */
	public static void main(String[] args) {
		
		int size;
		
		if (args.length == 1)
			size = Integer.parseInt(args[0]);
		else
			size = 6;
		
		GenerateMaze m = new GenerateMaze(size);
		m.printMaze();
	
	}
	
	/**
	 * For step-by-step debugging
	 * wip stands for work in progress.
	 * This just prints the maze and pauses until a key is pressed
	 */
	private void wip()
 	{ 
	 	printMaze();
		System.out.println("Press any key to continue...");
		try
		{
		    System.in.read();
		}  
		catch(Exception e)
		{}  
	}
	
}
