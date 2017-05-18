import java.util.*;
public class WidthFirstMazeSolver extends MazeSolution{
	
	
	private ArrayList<Node> traveled;
	private int[][] distance;
	
	public WidthFirstMazeSolver(Maze m){
		super(m);
		
		distance = new int[m.width()][m.height()];
		
		for (int i = 0; i<distance.length; i++){
			for (int j = 0; j<distance[i].length; j++){
				distance[i][j] = -1;
			}
		}
		
		distance[super.getMaze().getStart().getX()][super.getMaze().getStart().getY()]=0;
	}
	
	public List<Node> path(){
		
		makeDistances(0, super.getMaze().getStart());
		
		return pathFinder(super.getMaze().getFinish());
		
	}
	
	public void makeDistances(int last, Node n){
		
		Node up = super.getMaze().getNeighbors(n).get(0);
		Node right = super.getMaze().getNeighbors(n).get(1);
		Node down = super.getMaze().getNeighbors(n).get(2);
		Node left = super.getMaze().getNeighbors(n).get(3);
		
		if ((up!=null)&&(up.slowness()>=0)&&((findDistance(up)>last+1)||(findDistance(up)==-1))){
			distance[up.getX()][up.getY()]=last+1;
			makeDistances(last+1, up);
		}
		if ((right!=null)&&(right.slowness()>=0)&&((findDistance(right)>last+1)||(findDistance(right)==-1))){
			distance[right.getX()][right.getY()]=last+1;
			makeDistances(last+1, right);
		}
		if ((down!=null)&&(down.slowness()>=0)&&((findDistance(down)>last+1)||(findDistance(left)==-1))){
			distance[down.getX()][down.getY()]=last+1;
			makeDistances(last+1, down);
		}
		if ((left!=null)&&(left.slowness()>=0)&&((findDistance(left)>last+1)||(findDistance(down)==-1))){
			distance[left.getX()][left.getY()]=last+1;
			makeDistances(last+1, left);
		}	
	}
	
	public List<Node> pathFinder(Node n){
		ArrayList<Node> l = new ArrayList<Node>();
		l.add(n);
		
		if ((n.getX()==super.getMaze().getStart().getX())&&(n.getY()==super.getMaze().getStart().getY())){
			return l;
		}
		
		Node up = super.getMaze().getNeighbors(n).get(0);
		Node right = super.getMaze().getNeighbors(n).get(1);
		Node down = super.getMaze().getNeighbors(n).get(2);
		Node left = super.getMaze().getNeighbors(n).get(3);
		
		if (findDistance(up) == findDistance(n)-1){
			l.addAll(pathFinder(up));
			return l;
		}
		
		if (findDistance(right) == findDistance(n)-1){
			l.addAll(pathFinder(right));
			return l;
		}
		
		if (findDistance(down) == findDistance(n)-1){
			l.addAll(pathFinder(down));
			return l;
		}
		
		if (findDistance(left) == findDistance(n)-1){
			l.addAll(pathFinder(left));
			return l;
		}
		return l;
	}
	
	public int findDistance(Node n){
		return distance[n.getX()][n.getY()];
	}
}