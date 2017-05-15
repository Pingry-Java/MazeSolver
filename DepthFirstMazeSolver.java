import java.util.List;
public class DepthFirstMazeSolver extends MazeSolution
{
	List<Node> traveled;
	public DepthFirstMazeSolver(Maze m)
	{
		super(m);
		traveled = new List<Node>();
	}
	
	public List<Node> path(){
		return pathFinder(m.getStart());
	}
	
	public List<Node> pathFinder(Node n)
	{	
		List<Node> l = new List<Node>();
		
		for(int i = 0; i<traveled.length(); i++)
		{
			if(traveled.get(i)==n){
				return l;
			}
		}
		
		traveled.add(n);
		
		if (m.getFinish().equals(n))
		{
			l.add(n);
			return l;
		}
		
		List<Node> pathUp = path(n.getNeighbors().get(0));
		List<Node> pathDown = path(n.getNeighbors().get(2));
		List<Node> pathLeft = path(n.getNeighbors().get(3));
		List<Node> pathRight = path(n.getNeighbors().get(1));
		
		if ((pathUp.get(pathUp.length()-1)==m.getFinish())
		{
			l.add(n);
			l.add(pathUp);
			return l;
		}
		if ((pathDown.get(pathDown.length()-1)==m.getFinish())
		{
			l.add(n);
			l.add(pathDown);
			return l;
		}
		if ((pathLeft.get(pathLeft.length()-1)==m.getFinish())
		{
			l.add(n);
			l.add(pathLeft);
			return l;
		}
		if ((pathRight.get(pathRight.length()-1)==m.getFinish())
		{
			l.add(n);
			l.add(pathRight);
			return l;
		}
		return l;
	}
}