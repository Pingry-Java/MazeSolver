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
	
	/**
	 * this method checks if checkpoints exist in the maze
	 * @return boolean  if maze has checkpoints
	 */
	public boolean hasCheckpoints();
	
	/**
	 * this method adds one checkpoint based off of the given node
	 * @param the node to be made a checkpoint
	 */
	public void addCheckpoint(Node cp);
}