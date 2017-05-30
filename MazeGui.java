import javax.swing.*;
import javax.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;


public class MazeGui{
	public static void main(String[] args){
		Maze maze = new generateMaze(10);
		GuiFrame frame = new GuiFrame("Test", maze);

	}

}