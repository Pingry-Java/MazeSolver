import java.util.ArrayList;
public class DepthFirstMazeSolver extends MazeSolution
{
	
	ArrayList<Node> traveled;
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
		
		if (super.getMaze().getFinish()==n)
		{
			l.add(n);
			return l;
		}
		
		ArrayList<Node> pathUp = pathFinder(super.getMaze().getNeighbors(n).get(0));
		ArrayList<Node> pathDown = pathFinder(super.getMaze().getNeighbors(n).get(2));
		ArrayList<Node> pathLeft = pathFinder(super.getMaze().getNeighbors(n).get(3));
		ArrayList<Node> pathRight = pathFinder(super.getMaze().getNeighbors(n).get(1));
		
		if ((pathUp.get(pathUp.size()-1)==super.getMaze().getFinish()))
		{
			l.add(n);
			l.add(pathUp);
			return l;
		}
		if ((pathDown.get(pathDown.size()-1)==super.getMaze().getFinish()))
		{
			l.add(n);
			l.add(pathDown);
			return l;
		}
		if ((pathLeft.get(pathLeft.size()-1)==super.getMaze().getFinish()))
		{
			l.add(n);
			l.add(pathLeft);
			return l;
		}
		if ((pathRight.get(pathRight.size()-1)==super.getMaze().getFinish()))
		{
			l.add(n);
			l.add(pathRight);
			return l;
		}
		return l;
	}
}