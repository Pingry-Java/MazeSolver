import java.util.List;

public abstract class Node {

	
	/**
	 * A suggested char to visually represent the Node. Many UIs will find this
	 * method helpful. But no client is obligated to take this suggestion.
	 * 
	 * @return A representative character.
	 */
	public char symbol() {
	  return '.';
	}
	
	/**
   * How much effort it takes to traverse this cell. Think low numbers for
   * roads and paths, and higher numbers for sand or water. Really big numbers
   * for cliffs and any negative number is the Node is impassible.
   * 
   * @return The effort required to traverse the cell.
   */
	public int slowness() {
	  return 1;
	}
	
	/**
	 * How dangerous or treacherous a route is. Advanced mazes and Solvers may
	 * use this method to provide a damage counter along the route, or calculate
	 * a more advance cost-to-travel that considers both effort and danger. Or
	 * perhaps it could be used to estimate survival along a route.
	 * 
	 * @return The danger encounter while traversing the cell.
	 */
	public int danger() {
	  return 0;
	}
}
