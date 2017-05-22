import javax.swing.*;
import javax.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


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
		frame.setSize(800,800);
		frame.setResizable(false);

		JPanel panel = new JPanel();

		frame.add(panel);

		JButton loadNewMaze = new JButton("Load Maze");
		panel.setLayout(null);
		loadNewMaze.setBounds(0, 700, 150, 50);
		panel.add(loadNewMaze);
		loadNewMaze.addActionListener(new LoadNewMaze(panel));
		JLabel maze = loadNewMaze.getMaze();

		JButton saveMaze = new JButton("Save Maze");
		panel.setLayout(null);
		loadNewMaze.setBounds(300, 600, 150, 50);
		panel.add(loadNewMaze);
		loadNewMaze.addActionListener(new SaveMaze(panel));

		JButton loadSavedMaze = new JButton("Load Saved Maze");
		panel.setLayout(null);
		loadSavedMaze.setBounds(500, 600, 150, 50);
		panel.add(loadSavedMaze);
		//loadSavedMaze.addActionListener(new LoadSavedMaze(panel));	


		JButton solveMaze = new JButton("Solve Maze");
		panel.setLayout(null);
		solveMaze.setBounds(700, 600, 150, 50);
		panel.add(solveMaze);
		//solveMaze.addActionListener(new SolveMaze(panel));	



	}
	static class LoadSavedMaze implements ActionListener
	{ //TODO change code so this loads a saved maze
		private JPanel panel;
		public LoadSavedMaze(JPanel panel, String fileName)
		{
			this.panel = panel; 
		}
		public void actionPerformed(ActionEvent e)
		{
			JFrame mazes = new JFrame("Saved Mazes");
			mazes.setVisible(true);
			mazes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mazes.setSize(300,800);
			mazes.setResizable(false);

		}

        
       
		
	}	
	
	static class SolveMaze implements ActionListener
	{ //Code to be changed
		private Maze maze;
		public SolveMaze(Maze maze)
		{
			this.maze = maze; 
		}
		public void actionPerformed(ActionEvent e)
		{
			DepthFirstMazeSolver solver = new DepthFirstMazeSolver(maze);
			solver.path();
		}
		
	}	
	
	static class LoadNewMaze implements ActionListener
	{
		private JPanel panel;
		private JLabel maze;
		public LoadNewMaze(JPanel panel)
		{
			this.panel = panel; 
		}
		public void actionPerformed(ActionEvent e)
		{
			String answer = ""; 
			SampleMaze maze = new SampleMaze(4, 4);
			answer += "<html>";
			for (int n = 0; n < 4; n++)
			{

				for (int i = 0; i < 4; i++)
				{
					answer += maze.getNodeByCoords(n, i).symbol();
				}
				answer += "<br>";
			}
			answer += "</html>";
			JLabel lab = new JLabel(answer);
			this.maze = lab; 
			panel.add(lab);
			lab.setBounds(300, 300, 100, 100);
		
		}	
		public JLabel getMaze(){
			return maze; 
		}
	}
	static class SaveMaze implements ActionListener
	{
		private JPanel panel;
		public SaveMaze(JPanel panel)
		{
			this.panel = panel; 
		}
		public void actionPerformed(ActionEvent e)
		{
			String answer = ""; 
			SampleMaze maze = new SampleMaze(4, 4);
			answer += "<html>";
			for (int n = 0; n < 4; n++)
			{

				for (int i = 0; i < 4; i++)
				{
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