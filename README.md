# Maze Solver

This java program automatically solves classic maze problems.

Given a labrynth with a marked start and finsih, the program finds a path from the start to finsh, and shows the path in the graphical user interface.

The program has several components with dedicated subteams as outlined below.

## Maze Generation and Parsing

The abstract `Maze` and `Node` classes together represents a maze including its start and finish locations as well as the structure (barriers, paths, obstacles, pickups etc) of the maze. It is written as an abstract class so that various concrete implementaions can be written. The first implementations are relatively imple but work well. Other implementations are more complex and offer additional features but require more careful coding and testing.

### Goals
* Simple hard-coded static maze to allow other groups to begin
* Randomly generated finite sized maze
* Recursively generated maze
* Mazes with variable effort or danger levels per Node
* Infinite maze
* Multiple starts and finishes
* Multiple checkpoints to hit before finish

## Backend Solver

The abstract `MazeSolution` class represents the complete solution path through a `Maze`. It has a `Maze` as a field and a method for reproducing the path step-by-step. Like `Maze`, `MazeSolution` is abstract so that several different solution strategies can be coded and tested independantly starting with easy ones.

### Goals
* Depth first algorithm
* Breadth first algorithm
* A* algorithm
* Multiple starts or finishes
* Multiple checkpoints to hit before finish

## Graphical Frontend

The GUI for this project is written in pure java using the `javax.swing` package. The fronted is responsible for providing a user interface for users to load, save, and generate new mazes as well as displaying their solutions.

### Goals
* Simple inch to cm converter to practice GUI coding
* Frame that just displays a maze (not interactive, not solved)
* Highlight solution path with different color or character
* Animate solution path by moving a character through the maze
* Support infinite mazes by starting with a square around start (and finish?) and scrolling as necessary
* Game where the user gets to solve the maze

## Tests

We hope to include unit tests written in `junit` to test the various components of the generator and backend. This work will be prioritized after basic funtionality of the three main components has been completed.

## Usage and Distribution

One of our tem member will fill this section in with details about how to download and use this software

## Authors

Coming soon...

## License

We will soon post a license here or in a separate `LICENSE.txt` file.
