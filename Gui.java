import javax.swing.*;
import javax.*;
import java.awt.*;
import java.awt.event.*;

public class Gui{
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
		frame.setSize(500,500);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		frame.add(panel);

		JButton loadNewMaze = new JButton("Load New Maze");
		panel.setLayout(null);
		loadNewMaze.setBounds(50, 400, 100, 50);
		panel.add(loadNewMaze);
		loadNewMaze.addActionListener(new Action("To be Implemented"));


		JButton loadSavedMaze = new JButton("Load Saved Maze");
		panel.setLayout(null);
		loadSavedMaze.setBounds(200, 400, 100, 50);
		panel.add(loadSavedMaze);
		loadSavedMaze.addActionListener(new Action("To be Implemented"));	


		JButton solveMaze = new JButton("Solve Maze");
		panel.setLayout(null);
		solveMaze.setBounds(350, 400, 100, 50);
		panel.add(solveMaze);
		solveMaze.addActionListener(new Action("To be Implemented"));	

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
			JLabel label = new JLabel(message);
			JPanel panel = new JPanel();
			frame2.add(panel);
			panel.add(label);
		}
	}	
}