public class MazeSolver{

	public static void main(String[] args){
		
		
	}
	
	public String depth(int row, int col, boolean[][] travelled, int[] finish){
		
		if(travelled[row][col]){
			return "";
		}
		travelled[row][col] = true;
		
		if ((finish[0] == row) && (finish[1] == col)){
			return "finish";
		}
		
		String pathUp = depth(row+1, col, travelled, finish);
		String pathDown = depth(row-1, col, travelled, finish);
		String pathLeft = depth(row, col+1, travelled, finish);
		String pathRight = depth(row, col-1, travelled, finish);
		if ((pathUp.length()>6) && (pathUp.substring(pathUp.length()-6, pathUp.length()).equals("finish"))){
			return "up" + pathUp;
		}
		if ((pathDown.length()>6) && (pathUp.substring(pathDown.length()-6, pathDown.length()).equals("finish"))){
			return "dn" + pathDown;
		}
		if ((pathLeft.length()>6) && (pathUp.substring(pathLeft.length()-6, pathLeft.length()).equals("finish"))){
			return "lf" + pathLeft;
		}
		if ((pathRight.length()>6) && (pathUp.substring(pathRight.length()-6, pathRight.length()).equals("finish"))){
			return "rt" + pathRight;
		}
		return "";
	}
}