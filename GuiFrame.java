import javax.swing.*;
import javax.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

public class GuiFrame extends JFrame {
	private String mazeString; 
	private Maze maze;
	private JPanel panelLM = new JPanel();
	private JPanel panelSM = new JPanel();
	private JPanel panelSave = new JPanel();
	private JPanel panelLoad = new JPanel();

	public GuiFrame(String name, Maze maze){
		super(name);
		this.maze = maze;
		this.mazeString = "";
		panelLM.setVisible(true);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setResizable(false);

		add(panelLM);
		add(panelSM);
		add(panelSave);
		add(panelLoad);

		JButton loadMaze = new JButton("Load Maze");
		panelLM.setLayout(null);
		loadMaze.setBounds(400, 700, 150, 50);
		panelLM.add(loadMaze);
		loadMaze.addActionListener(new LoadNewMaze());


		JButton solveMaze = new JButton("Solve Maze");
		DepthFirstMazeSolver solver = new DepthFirstMazeSolver(maze);
		solver.path();
		panelSM.setLayout(null);
		solveMaze.setBounds(600, 700, 150, 50);
		panelSM.add(solveMaze);
		//solveMaze.addActionListener(new SolveMaze(panel));	

		JButton saveMaze = new JButton("Save Maze");
		panelSave.setLayout(null);
		saveMaze.setBounds(300, 600, 150, 50);
		panelSave.add(saveMaze);
		//loadNewMaze.addActionListener(new SaveMaze(panel));

		JButton loadSavedMaze = new JButton("Load Saved Maze");
		panelLoad.setLayout(null);
		loadSavedMaze.setBounds(500, 600, 150, 50);
		panelLoad.add(loadSavedMaze);
		//loadSavedMaze.addActionListener(new LoadSavedMaze(panel));	


		



	}

	public Maze getMaze(){
		return maze;
	}

	public String getMazeString(){
		return mazeString;
	}

	class LoadNewMaze implements ActionListener
	{
	
		public LoadNewMaze()
		{
		
		}
		public void actionPerformed(ActionEvent e)
		{
			createMaze(panelLM);
		
		}	
	}

	class LoadSavedMaze implements ActionListener
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
	
	class SolveMaze implements ActionListener
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
			for (int n = 0; n < maze.height(); n++){
				for (int i = 0; i < maze.width(); i++){
					if (in(maze.getNodeByCoords(n, i), solver.path())){
					
					}
				}
			}
		}
		
	}	
	private boolean in(Node node, List<Node> l){
		for (int n = 0; n <l.size(); n++){
			if (node.equals(l.get(n))){
				return true;
			}
		}
		return false; 
	}
	
	class SaveMaze implements ActionListener
	{
		private JPanel panel;
		public SaveMaze(JPanel panel)
		{
			this.panel = panel; 
		}
		public void actionPerformed(ActionEvent e)
		{
		  
		}	
	}

	public void createMaze(JPanel panel){
		String answer = ""; 
		answer += "<html>";
		for (int n = 0; n < maze.height(); n++)
		{
			for (int i = 0; i < maze.width(); i++)
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