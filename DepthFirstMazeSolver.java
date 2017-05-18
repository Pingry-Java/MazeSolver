import java.util.*;
public class DepthFirstMazeSolver extends MazeSolution
{
	
	private ArrayList<Node> traveled;
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