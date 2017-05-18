public class Tester{

	public static void main(String[] args){
		
		SampleMaze m = new SampleMaze(4,4);
		DepthFirstMazeSolver solver1 = new DepthFirstMazeSolver(m);
		
		WidthFirstMazeSolver solver2 = new WidthFirstMazeSolver(m);
		
		System.out.println(solver1.path());
		System.out.println(solver2.path());
	}
}