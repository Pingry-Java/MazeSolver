import javax.swing.*;
import javax.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;


public class GuiFrame extends JFrame {
	//serialVersionUID is just so that there is not a warning when implementing serializable
	//it is used by the compiler so that the compiler knows it has imported the data for 
	// any class it is trying to read from a file
	private static final long serialVersionUID = 787L;
	private String mazeString; 
	private Maze maze;
	private JPanel panel = new JPanel();
	private ArrayList<Maze> mazeList = new ArrayList<Maze>();


	public GuiFrame(String name, Maze maze){
		super(name);
		try
		{
			FileInputStream fileIn = new FileInputStream(new File("SavedMazes.txt"));
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);	
			ArrayList temp = (ArrayList)objectIn.readObject();
			for (int i = 0; i < temp.size(); i++)
			{
				mazeList.add((Maze) temp.get(i)); 
			}
			fileIn.close();
		} catch (FileNotFoundException ex) 
		{
			mazeList = new ArrayList<Maze>();
		} catch(IOException io)
		{
			System.out.println("io exception");
		} catch (ClassNotFoundException c)
		{
			System.out.println("Maze class not found.");
		}
		this.maze = maze;
		this.mazeString = "";
		

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
			//	FileOutputStream clearer = new FileOutputStream("SavedMazes.txt");
		//		clearer.write(("").getBytes());
		///		clearer.close();
				try 
				{
				FileOutputStream saveMazeList = new FileOutputStream("SavedMazes.txt");
				ObjectOutputStream listSaver = new ObjectOutputStream(saveMazeList);
				listSaver.writeObject(getMazeList());
				} catch(FileNotFoundException ex)
				{
					System.out.println("File not found");
				} catch(IOException io)
				{
					System.out.println("io exception");
				}
				e.getWindow().dispose();
			}
		});
		setSize(800,800);
		setResizable(true);

		add(panel);


        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());

		JButton loadMaze = new JButton("Load Maze");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
		panel.add(loadMaze, gbc);
		loadMaze.addActionListener(new LoadNewMaze());



		JButton solveMaze = new JButton("Solve Maze");
        gbc.gridx = 1;
        gbc.gridy = 0;
		panel.add(solveMaze, gbc);
		solveMaze.addActionListener(new SolveMaze(maze));	



		JButton saveMaze = new JButton("Save Maze");
        gbc.gridx = 2;
        gbc.gridy = 0;
		panel.add(saveMaze, gbc);
		saveMaze.addActionListener(new SaveMaze(panel));



		JButton loadSavedMaze = new JButton("Load Saved Maze");
        gbc.gridx = 3;
        gbc.gridy = 0;
		panel.add(loadSavedMaze, gbc);
		loadSavedMaze.addActionListener(new LoadSavedMaze(panel));
        
        setVisible(true);


		



	}
	public ArrayList<Maze> getMazeList()
	{
		return mazeList;
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
			createMaze(panel);
		
		}	
	}

	class LoadSavedMaze implements ActionListener
	{ //TODO change code so this loads a saved maze
		private JPanel panel;
		public LoadSavedMaze(JPanel panel)
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
			mazeString = "<html>";
			DepthFirstMazeSolver solver = new DepthFirstMazeSolver(maze);
			List<Node> path = solver.path();
			if (path.size() <= 1){
				JLabel noSolution = new JLabel("No Solution");
				panel.add(noSolution);
				noSolution.setBounds(400, 600, 200, 200);
			}
			else{
				for (int n = 0; n < maze.height(); n++){
						for (int i = 0; i < maze.width(); i++){
						if (maze.getNodeByCoords(n, i).equals(path.get(0)))
							mazeString += "S";
						else if (maze.getNodeByCoords(n, i).equals(path.get(path.size() - 1)))
							mazeString += "F";
						else if (in(maze.getNodeByCoords(n, i), path)){
							mazeString += "-";
						}
						else{
							mazeString += maze.getNodeByCoords(n, i).symbol();
						}
					}
					mazeString += "<br>";
				}
				mazeString += "</html>";
				JLabel lab = new JLabel(mazeString);
				lab.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
				panel.add(lab);
				lab.setBounds(600, 300, 200, 200);
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
		DepthFirstMazeSolver solver = new DepthFirstMazeSolver(maze);
		List<Node> path = solver.path();
		for (int n = 0; n < maze.height(); n++)
		{
			for (int i = 0; i < maze.width(); i++)
			{
				if (maze.getNodeByCoords(n, i).equals(path.get(0)))
					answer += "S";
				else if (maze.getNodeByCoords(n, i).equals(path.get(path.size() - 1)))
					answer += "F";
				else
					answer += maze.getNodeByCoords(n, i).symbol();
			}
			answer += "<br>";
		}
		answer += "</html>";
		JLabel lab = new JLabel(answer);
		lab.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
		panel.add(lab);
		lab.setBounds(300, 300, 200, 200);
	}




}