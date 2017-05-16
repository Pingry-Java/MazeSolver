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
		loadNewMaze.addActionListener(new LoadNewMaze(panel));


		JButton loadSavedMaze = new JButton("Load Saved Maze");
		panel.setLayout(null);
		loadSavedMaze.setBounds(300, 600, 150, 50);
		panel.add(loadSavedMaze);
		loadSavedMaze.addActionListener(new LoadNewMaze(panel));	


		JButton solveMaze = new JButton("Solve Maze");
		panel.setLayout(null);
		solveMaze.setBounds(550, 600, 150, 50);
		panel.add(solveMaze);
		solveMaze.addActionListener(new LoadNewMaze(panel));	



	}
	static class LoadNewMaze implements ActionListener{
		private JPanel panel;
		public LoadNewMaze(JPanel panel){
			this.panel = panel; 
		}
		public void actionPerformed(ActionEvent e){
			String answer = ""; 
			SampleMaze maze = new SampleMaze(4, 4);
			answer += "<html>";
			for (int n = 0; n < 4; n++){

				for (int i = 0; i < 4; i++){
					answer += maze.getNodeByCoords(n, i).symbol();
				}
				answer += "<br>";
			}
			answer += "</html>";
			JLabel lab = new JLabel(answer);

			panel.add(lab);
			lab.setBounds(300, 300, 100, 100);
		}
		
	}	
}