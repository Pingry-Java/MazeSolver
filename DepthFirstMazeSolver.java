import java.util.*;

/**
* This class solves a maze using a depth first algorithm. It brute forces every path in an
* left, right, up, down order until it hits a dead end or the endpoint. If it hits a dead 
* end, then it goes back to the last turn and makes a different turn. This does not return 
* the fastest way to solve the maze, but it will get a working solution.
* @author Jeremy Newman, Graham Matthews, Miro Bergam, and Lindsey Yu
* @version 1.0
*/
public class DepthFirstMazeSolver extends MazeSolution
{
	/**
	* This is a private field that is an ArrayList and holds the Nodes that have been traveled
	*/
	private ArrayList<Node> traveled;
	
	/**
	* This is a constructor for the DepthFirstMazeSolver
	* Calls upon the super class MazeSolution with the parameter that is passed in which
	* is a Maze. It also initializes the private field traveled with an empty ArrayList
	* @param m The Maze that will be used to construct the maze solver around
	*/
	public DepthFirstMazeSolver(Maze m)
	{
		super(m);
		traveled = new ArrayList<Node>();
	}
	
	public List<Node> path(){
		return pathFinder(super.getMaze().getStart());
	}
	
	public ArrayList<Node> pathFinder(Node n)
	{	
		ArrayList<Node> l = new ArrayList<Node>();
		
		if (n == null)
		{
			return l;
		}
		
		for(int i = 0; i<traveled.size(); i++)
		{
			if(traveled.get(i)==n){
				return l;
			}
		}
		
		traveled.add(n);
		
		if (n.slowness()<0){
			return l;
		}
		
		if ((super.getMaze().getFinish().getX()==n.getX())&&(super.getMaze().getFinish().getY()==n.getY()))
		{
			l.add(n);
			return l;
		}
		
		ArrayList<Node> pathUp = pathFinder(super.getMaze().getNeighbors(n).get(0));
		ArrayList<Node> pathDown = pathFinder(super.getMaze().getNeighbors(n).get(2));
		ArrayList<Node> pathLeft = pathFinder(super.getMaze().getNeighbors(n).get(3));
		ArrayList<Node> pathRight = pathFinder(super.getMaze().getNeighbors(n).get(1));
		
		if ((pathUp.size()!=0)&&((pathUp.get(pathUp.size()-1).getX()==super.getMaze().getFinish().getX()))){
			if ((pathUp.size()!=0)&&((pathUp.get(pathUp.size()-1).getY()==super.getMaze().getFinish().getY()))){
				l.add(n);
				l.addAll(pathUp);
				return l;
			}
		}
		
		if ((pathDown.size()!=0)&&((pathDown.get(pathDown.size()-1).getX()==super.getMaze().getFinish().getX()))){
			if ((pathDown.size()!=0)&&((pathDown.get(pathDown.size()-1).getY()==super.getMaze().getFinish().getY()))){
				l.add(n);
				l.addAll(pathDown);
				return l;
			}
		}
		if ((pathLeft.size()!=0)&&((pathLeft.get(pathLeft.size()-1).getX()==super.getMaze().getFinish().getX()))){
			if ((pathLeft.size()!=0)&&((pathLeft.get(pathLeft.size()-1).getY()==super.getMaze().getFinish().getY()))){
				l.add(n);
				l.addAll(pathLeft);
				return l;
			}
		}
		if ((pathRight.size()!=0)&&((pathRight.get(pathRight.size()-1).getX()==super.getMaze().getFinish().getX()))){
			if ((pathRight.size()!=0)&&((pathRight.get(pathRight.size()-1).getY()==super.getMaze().getFinish().getY()))){
				l.add(n);
				l.addAll(pathRight);
				return l;
			}
		}
		return l;
	}
}