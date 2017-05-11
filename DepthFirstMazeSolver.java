public class DepthFirstMazeSolver extends MazeSolution
{
	public MazeSolver(Maze m)
	{
		super(m);
	}
	
	public List<Node> path(int row, int col, boolean[][] travelled, Maze m)
	{	
		List<Node> l = new List<Node>();
		Node n = m.getNodeByCoords(row, col);
		
		if(travelled[row][col])
		{
			return l;
		}
		
		travelled[row][col] = true;
		
		if (m.getFinish().equals(n)
		{
			l.add(n)
			return l;
		}
		
		List<Node> pathUp = path(row+1, col, travelled, finish);
		List<Node> pathDown = path(row-1, col, travelled, finish);
		List<Node> pathLeft = path(row, col+1, travelled, finish);
		List<Node> pathRight = path(row, col-1, travelled, finish);
		
		if ((pathUp.length()>6) && (pathUp.substring(pathUp.length()-6, pathUp.length()).equals("finish")))
		{
			l.add(n);
			l.add(pathUp);
			return l;
		}
		if ((pathDown.length()>6) && (pathUp.substring(pathDown.length()-6, pathDown.length()).equals("finish")))
		{
			l.add(n);
			l.add(pathDown);
			return l;
		}
		if ((pathLeft.length()>6) && (pathUp.substring(pathLeft.length()-6, pathLeft.length()).equals("finish")))
		{
			l.add(n);
			l.add(pathLeft);
			return l;
		}
		if ((pathRight.length()>6) && (pathUp.substring(pathRight.length()-6, pathRight.length()).equals("finish")))
		{
			l.add(n);
			l.add(pathRight);
			return l;
		}
		return l;
	}
}