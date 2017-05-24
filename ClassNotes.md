# Day 1

## Debrief after AP Exam

* Return any exams you borrowed to study
* Reflect on how the exam went, what was hard, what wasn't, etc

## Talk about Maze Solver

* First time ever running this project
  * Hoping it is fun and educational
  * Please buy in and don't be lazy
  * I'll consider all suggestions
    * Some may not be implementible this time around
* Working in a team
  * Be extra careful not to mess up the repo for everyone
  * Communicate clearly through the issue queue
    * Open issues when you find them
    * Close issues when you fix them
  * Only commit good work
    * Test thoroughly before you commit
    * Use `git diff` to make sure you've only changed what you intended
  * Small commits
  * API Changes

# Day 2

* Get to know the API
* Begin planning with your team
* Make a few preliminary commits

# Day 3 -- Daily Routine and Grading

## Text editor

On most systems (maybe not windows?) git uses vim as the default editor.
So you need to do one of the following:

1. Learn to use vim: http://vimsheet.com/
2. Change your editor: http://stackoverflow.com/questions/3539594

## Daily Routine

* Pull
* Review Issues, Readme
* Make goals for today
* Do some work
  * Make a new branch
  * Code, test, commit, repeat
  * Merge Back to master
  * Push
* Reflect on daily golas, issue queue, readme

## Grading

This is postAP we're here to learn and have fun, not stress out. 
But I also expect quality work and buy-in, so there will be some grading.

* Commits graded on a 5 point scale
* Defaults to get all 5 points
  * hint: use `git diff--cached` to see what you're about to commit
* Deductions
  * Poor commit message
  * Extraneous changes included
  * Undocumented API changes or additions
  * Commit clearly unnecessary or seemingly made by accident

## API Changes and additions

Applies to `Maze`, `MazoSolution`, and `Node`.

* Changes -- When a method, or constructor in  changes signature or behavior
  * Must be proposed in the issue queue and approved by members of both other subteams
* Additions -- When new methods or constructors are added
  * Must be proposed in the issue queue and approved by a member of at least one other sub team


# Day 4 -- Some Goals to Consider

## GUI Group

* Does the frame show controls correctly on OSX? See issue
* Most GUIs write their own subclass of JFrame
* Try to display an actual maze
  * You may need to pester the maze generation group about implementing the recommended character functionality

## Solver Group

* Maybe split into smaller groups
* Test out a completed solver
* Continue working on a second solver?
* Work with Maze creation group to resolve getNeighbors API issue

## Maze Creation Group

* Resolve getNeighbors API issue
* Consider implementing suggested character functionality so GUI group can use it
* Generate random Maze
  * Remember, not all maze's need to be solvable or have unique solutions. This will be more fun for the solver team if their algorithm has to detect impossible mazes or mazes with multiple solutions
* Consider a feature to save mazes
  * eg one is randomly generated, and the user likes it and wants to look into it more later. How can she save it to a file?

# Day 5 

Orndorff Absent. Good luck!

# Day 6

* Status update?
* Two new issues
* Let's write some goals for today

# Day 7

* 4 work days left
* Anyone want to try another group?
* Each group give a ~2min status update

## Final Goals

* Generation group
  * Generate a maze that has a start, finish, and 0 or more checkpoints.
  * Create a maze that has interesting Nodes
    * Actually use slowness and Danger
* Solution group
  * Solve Mazes that  have checkpoints
  * Optimally solve mazes that have Danger and Slowness
* GUI Group
  * Actually display a Maze
    * Use muscle on generation group
    * Or Write their method yourself
  * Display a solution
* Everyone -- Readme
  * Users want to know how to download, compile, run
  * What buttons should users click?
  * How about license?