import java.util.*;
public class WidthFirstMazeSolver extends MazeSolution{
	
	
	private ArrayList<Node> traveled;
	private int[][] distance;
	
	/**
	* This is the constructor for the Widthfirstmazesolver.
	* @param m The maze that is to be solied
	*/
	
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
	
		if (super.getMaze().hasCheckpoints()){
		
			ArrayList<Node> l = new ArrayList<Node>();
			ArrayList<Node> checkpoints = new ArrayList<Node>();
			
			checkpoints = super.getMaze().getCheckpoints();
			
			l.addAll(pointPath(super.getMaze().getStart(), checkpoints.get(0)));
			
			for (int i = 0; i < checkpoints.size()-1; i++){
				l.addAll(pointPath(checkpoints.get(i), checkpoints.get(i+1)));
			}	
				
			l.addAll(pointPath(checkpoints.get(checkpoints.size()-1), super.getMaze().getFinish()));
			
			return l;
			
		}
		
		return pointPath(super.getMaze().getStart(), super.getMaze().getFinish());
		
	}
	
	public List<Node> pointPath(Node start, Node finish){
		
		makeDistances(0, start);
		
		ArrayList<Node> reversePath = new ArrayList<Node>();
		ArrayList<Node> forwardPath = new ArrayList<Node>();
		
		reversePath = pathFinder(finish);
		
		for (Node n:reversePath){
			forwardPath.add(0,n);
		}
		return forwardPath;	
	}
	
	public void makeDistances(int last, Node n){
		
		Node up = super.getMaze().getNeighbors(n).get(2);
		Node right = super.getMaze().getNeighbors(n).get(1);
		Node down = super.getMaze().getNeighbors(n).get(3);
		Node left = super.getMaze().getNeighbors(n).get(0);
		
		if ((up!=null)&&(up.slowness()>=0)&&((findDistance(up)>last+1)||(findDistance(up)==-1))){
			distance[up.getX()][up.getY()]=last+1;
			makeDistances(last+up.slowness(), up);
		}
		if ((right!=null)&&(right.slowness()>=0)&&((findDistance(right)>last+1)||(findDistance(right)==-1))){
			distance[right.getX()][right.getY()]=last+1;
			makeDistances(last+right.slowness(), right);
		}
		if ((down!=null)&&(down.slowness()>=0)&&((findDistance(down)>last+1)||(findDistance(down)==-1))){
			distance[down.getX()][down.getY()]=last+1;
			makeDistances(last+down.slowness(), down);
		}
		if ((left!=null)&&(left.slowness()>=0)&&((findDistance(left)>last+1)||(findDistance(left)==-1))){
			distance[left.getX()][left.getY()]=last+1;
			makeDistances(last+left.slowness(), left);
		}	
	}
	
	public ArrayList<Node> pathFinder(Node n){
		ArrayList<Node> l = new ArrayList<Node>();
		l.add(n);
		
		if ((n.getX()==super.getMaze().getStart().getX())&&(n.getY()==super.getMaze().getStart().getY())){
			return l;
		}
		
		Node up = super.getMaze().getNeighbors(n).get(2);
		Node right = super.getMaze().getNeighbors(n).get(1);
		Node down = super.getMaze().getNeighbors(n).get(3);
		Node left = super.getMaze().getNeighbors(n).get(0);
		
		
		if ((up!=null)&&(findDistance(up) < findDistance(n))&&(findDistance(up)!=-1)){
			l.addAll(pathFinder(up));
			return l;
		}
		
		if ((right!=null)&&(findDistance(right) < findDistance(n))&&(findDistance(right)!=-1)){
			l.addAll(pathFinder(right));
			return l;
		}
		
		if ((down!=null)&&(findDistance(down) < findDistance(n))&&(findDistance(down)!=-1)){
			l.addAll(pathFinder(down));
			return l;
		}
		
		if ((left!=null)&&(findDistance(left) < findDistance(n))&&(findDistance(left)!=-1)){
			l.addAll(pathFinder(left));
			return l;
		}
		return l;
	}
	
	/**
	* This method gets the int value of distance from the start Node from the 2D for the parameter
	* @param n The node that the method gets the distance for
	* @return Returns the int value representing the distance from the Node parameter to the start Node
	*/
	 
	public int findDistance(Node n){
		return distance[n.getX()][n.getY()];
	}
	
	/**
	* This metod prints the 2D array containing distances of the nodes on the path to the endpoint 
	* @param arr the 2D array of distances of the nodes on the path to the endpoint 
	*/
	
	public void printArray(int[][] arr){
		for (int i = 0; i<arr.length; i++){
			for (int j = 0; j<arr[i].length; j++){
				if (arr[i][j]>-1){
					System.out.print(" ");
				}
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void distanceReset(){
		for (int[] a : distance){
			for (int b : a){
				b = -1;
			}
		}
	}
}