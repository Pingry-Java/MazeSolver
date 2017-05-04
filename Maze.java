public abstract class Maze {

	/**
	 * Takes in a node in the maze and generates a list of all adjascent Nodes in the maze.
	 * @param current The Node whose neighbors should be generated
	 * @return A List containing all of current's neighbors
	 */
	public abstract List<Node> getNeighbors(Node current);
	
	
	/**
	 * Calculates the distance betwee two adjascent Nodes in a maze.
	 * @param a The first Node
	 * @param b The second Node
	 * @ return The distance between the adjascent Nodes, or any negative number if the 
	 *          Nodes are not adjascent.
	 */
	public abstract int distance(Node a, Node b);
	
}
