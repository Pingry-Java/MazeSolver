public class Tester{

	public static void main(String[] args){
		
		SampleMaze m = new SampleMaze(4,4);
		DepthFirstMazeSolver solver = new DepthFirstMazeSolver(m);
		
		System.out.println(solver.path());
	}
}