import java.util.*; 
import java.io.Serializable;

public abstract class Maze implements Serializable, Checkpointable {
	//serialVersionUID is just so that there is not a warning when implementing serializable
	//it is used by the compiler so that the compiler knows it has imported the data for 
	// any class it is trying to read from a file
	private static final long serialVersionUID = 278L;
	private Node start;
	private Node finish;
	
	/**
	 * Default constructor for use by any subclasses
	 * @param start The starting Node
	 * @param finish The finishing Node
	 */
	 public Maze(Node start, Node finish)
	 {
	 	this.start = start; 
	 	this.finish = finish; 
	 }
	
	/**
	 * The Starting Node
	 * @return The starting Node
	 */
	public Node getStart() {
	  return start;
	}
	
	/**
	 * The Finish Node
	 * @return The finish Node
	 */
	public Node getFinish() {
	  return finish;
	}
	
	
	/**
	 * Tells the maximum width of the maze if it is finite.
	 *
	 * Finite mazes have x coordinates in the interval [0, width -1 )
	 * 
	 * @return The width of the maze or 0 if the maze extends infinitely
	 */
	public abstract int width();
	
	/**
	 * Tells the maximum height of the maze if it is finite.
	 * 
	 * Finite mazes have y coordinates in the interval [0, height - 1)
	 * 
	 * @return The height of the maze or 0 if the maze extends infinitely
	 */
	public abstract int height();
	
	/**
	 * Provides access the Node at the specified x and y coordinates.
	 * May return either a Node object or null is the coordinates are impassible.
	 * If the coordinates lie outside the maze's width or height, it is 
	 * considered impassible
	 * 
	 * This is the preferred way of accessing the Maze for most UIs and some
	 * Solvers. Advanced UIs and many Solvers will prefer to access the maze
	 * recursively through its getStart and getFinish methods.
	 * 
	 * @param x The horizontal coordinate
	 * @param y The vertical coordinate
	 * @return a Node object at the specified coordinates
	 * @throws IllegalArgumentException When either coordinate exceeds the bounds
	 *         of a finite maze
	 */
	public abstract Node getNodeByCoords(int x, int y);
	
	
	/**
	 * All adjascent Nodes in the maze. An implementation may, but is not required
	 * to, include impassible adjascent nodes in this list.
	 * Order will be left, right, above, below. Puts null if no neighbor on that side
	 * @param current The Node that we are looking for neighbors 
	 * @return A List of all neighbors
	 */
	public List<Node> getNeighbors(Node current)
	{
		List<Node> neighbors = new ArrayList<Node>(); 
		int x = current.getX(); 
		int y = current.getY(); 
		
		neighbors.add(getNodeByCoords(x, y - 1)); //Node to the left
		neighbors.add(getNodeByCoords(x, y + 1)); //Node to the right
		neighbors.add(getNodeByCoords(x - 1, y)); //Node above
		neighbors.add(getNodeByCoords(x + 1, y)); //Node below
		
		return neighbors; 
	}
	
	
	/**
	 * A string representation of the Maze
	 * 
	 * This is primarily for debugging purposes, but may be helpful for
	 * preliminary work on UIs, especially if it is overridden effectively.
	 * 
	 * @return A string representation of the maze.
	 */
	public String toString() {
	  return width() + "X" + height() + " Maze.";
	}


	/**
	 * Modifier for the start node
	 * @param x The Node to be set
	 */
	protected void setStart(Node x)
	{
		start = x; 
	}
	
	/**
	 * Modifier for the finish node
	 * @param x The Node to become the new finish node
	 */ 
	protected void setFinish(Node x)
	{
		finish = x; 
	}
	
	/**
	 * this method checks if checkpoints exist in the maze
	 * @return boolean  if maze has checkpoints
	 */
	public boolean hasCheckpoints()
	{
		return checkpoints.size() > 0;
	}
	
	/** 
	 * this method fills an arraylist of nodes representing the checkpoints of the maze
	 * @param num  the number of checkpoints
	 */
	public void makeCheckpoints(int num)
	{
		while (num > 0)
		{
			int randX = (int) (Math.random() * width()); 
			int randY = (int) (Math.random() * height());
	
			if (getNodeByCoords(randX, randY).slowness() > 0)
			{
				num--;
				checkpoints.add(getNodeByCoords(randX, randY));
			}
		}
 	}
	
	/**
	 * this method returns an arraylist of nodes representing the checkpoints of the maze
	 * @return ArrayList of nodes
	 */
	public ArrayList<Node> getCheckpoints()
	{
		return checkpoints;
	}
	
	/**
	 * this method adds one checkpoint based off of the given node
	 * @param the node to be made a checkpoint
	 */
	public void addCheckpoint(Node cp)
	{
		checkpoints.add(cp);
	}
}
