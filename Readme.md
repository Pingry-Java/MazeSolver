# Maze Solver

This java program automatically solves classic maze problems.

Given a labrynth with a marked start and finsih, the program finds a path from the start to finsh, and shows the path in the graphical user interface.

The program has several components outlined below

## Maze Generation and Parsing

The abstract `Maze` class represents a single maze including its start and finish locations as well as the structure (barriers, paths, obstacles, pickups etc) of the maze. It is written as an abstract class so that various concrete implementaions can be written. The first implementations are relatively imple but work well. Other implementations are more complex and offer additional features but require more careful coding and testing.

## Backend Solver

The abstract `MazeSolution` class represents the complete solution path through a `Maze`. It has a `Maze` as a field and a method for reproducing the path step-by-step. Like `Maze`, `MazeSolution` is abstract so that several different solution strategies can be coded and tested independantly starting with easy ones.

## Graphical Frontend

The GUI for this project is written in pure java using the `javax.swing` package. The fronted is responsible for providing a user interface for users to load, save, and generate new mazes as well as displaying their solutions.

## Tests

We hope to include unit tests written in `junit` to test the various components of the generator and backend. This work will be prioritized after basic funtionality of the three main components has been completed.

## Usage and Distribution

One of our tem member will fill this section in with details about how to download and use this software

## Authors

Coming soon...

## License

We will soon post a license here or in a separate `LICENSE.txt` file.