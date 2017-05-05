import java.util.List;

public abstract class MazeSolution {
  
  private Maze maze;
  
  public MazeSolution(Maze m) {
    maze = m;
  }
  
  /**
   * The maze to be solved.
   * @return The maze to be solved.
   */
  public Maze getMaze() {
    return maze;
  }
  
	/**
	 * The solution path as a List of Nodes from start to finish inclusive and in
	 * order.
	 * 
	 * @ return The solution path.
	*/
	public abstract List<Node> path();
	
	/**
	 * The total effort necessary to traverse the solution. Returns any negative
	 * number if the maze is impossible.
	 * @return The total effort
	 */
	public int travelEffort() {
	  
	  int effort = 0;
	  
	  for (Node n : path())
	    effort += n.slowness();
	  
	  return effort;
	}
}
