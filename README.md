# MazeGame
This is a maze game project for the Outlier computer science course consisting of 7 classes, where a player moves from the top left-hand corner of a 2D board to the bottom right-hand corner without running out of health. The maze is a 2D String array. The game will start with a reserved cell for the player (P) and one random cell containing a magical gem (GEM). Every other cell will be randomly assigned to one of the following hazards: wolf, bear, elk, or hare. Hazards will have higher-value costs further into the board.

The player starts in the top-left corner with 500 health and must travel to the bottom-right corner without running out of health. For each turn, the player can move up, down, left, or right. After selecting a direction, the player is given a preview of the hazard in the chosen cell. Then, they can confirm the move or opt out and choose a new direction.

As the player traverses the maze, their health changes according to the hazards they reach. Once the player has visited a cell, the cell value changes to “X”—the hazard has been neutralized and the player can revisit the cell without any change in health.

The game ends when the player reaches the bottom right-hand corner of the maze or when they run out of health.

## UML Diagram:
![image](https://github.com/rogerqiu7/MazeGame/assets/84350865/d490c7eb-32a4-4269-a6f9-720c2a76b8b3)

## Screenshots:
![image](https://github.com/rogerqiu7/MazeGame/assets/84350865/6cca3417-746b-4c31-84e8-6794b2b1d998)
![image](https://github.com/rogerqiu7/MazeGame/assets/84350865/2ff80cbb-2c48-4eea-8983-5be5972b0455)
