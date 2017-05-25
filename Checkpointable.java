import java.util.*;

public interface Checkpointable
{
	ArrayList<Node> checkpoints = new ArrayList<Node>();
	/** 
	 * this method fills an arraylist of nodes representing the checkpoints of the maze
	 * @param num  the number of checkpoints
	 */
	public void makeCheckpoints(int num);
	
	/**
	 * this method returns an arraylist of nodes representing the checkpoints of the maze
	 * @return ArrayList of nodes
	 */
	public ArrayList<Node> getCheckpoints();
}