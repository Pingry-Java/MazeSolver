import javax.swing.*;
import javax.*;
import java.awt.*;
import java.awt.event.*;

public class MazeGui{
	public static void main(String[] args){
	/*

		JFrame frame = new JFrame("Test");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel (new GridBagLayout());
		frame.add(panel);
		GridBagConstraints c = new GridBagConstraints();
		JLable label1 = new JLabel("Test1"); 
	}
	*/
		//String fn = JOptionPane.showInputDialog("Enter first number");
		//String sn = JOptionPane.showInputDialog("Enter second number");
		JFrame frame = new JFrame("Test");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(770,700);
		frame.setResizable(false);

		JPanel panel = new JPanel();

		frame.add(panel);

		JButton loadNewMaze = new JButton("Load New Maze");
		panel.setLayout(null);
		loadNewMaze.setBounds(50, 600, 150, 50);
		panel.add(loadNewMaze);
		loadNewMaze.addActionListener(new Action("To be Implemented"));


		JButton loadSavedMaze = new JButton("Load Saved Maze");
		panel.setLayout(null);
		loadSavedMaze.setBounds(300, 600, 150, 50);
		panel.add(loadSavedMaze);
		loadSavedMaze.addActionListener(new Action("To be Implemented"));	


		JButton solveMaze = new JButton("Solve Maze");
		panel.setLayout(null);
		solveMaze.setBounds(550, 600, 150, 50);
		panel.add(solveMaze);
		solveMaze.addActionListener(new Action("To be Implemented"));	

		String answer = ""; 
		SampleMaze maze = new SampleMaze(4, 4);
		for (int n = 0; n < 4; n++){
			for (int i = 0; i < 4; i++){
				answer += maze.getNodeByCoords(n, i).symbol();
			}
			answer += "\n";
		}
		System.out.println(answer);
		JLabel lab = new JLabel(answer);

		panel.add(lab);
		lab.setBounds(300, 300, 100, 100);
		

	}
	static class Action implements ActionListener{
		private String message; 
		public Action(String str){
			message = str;
		}
		public void actionPerformed(ActionEvent e){
			JFrame frame2 = new JFrame("Clicked");
			frame2.setVisible(true);
			frame2.setSize(200, 200);
			JPanel panel = new JPanel();
			JLabel label = new JLabel("HELLO");
			frame2.add(panel);
			frame2.add(label);
		}
	}	
}