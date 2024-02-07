# MazeGame
This is a maze game project for a computer science course, where a player moves from the top left-hand corner of a 2D board to the bottom right-hand corner without running out of health. To accomplish this, you will place hazards in the maze, check player movement validity, and develop player-board interaction.

The maze is a 2D String array. The game will start with a reserved cell for the player (P) and one random cell containing a magical gem (GEM). Every other cell will be randomly assigned to one of the following hazards: wolf, bear, elk, or hare.

The player starts in the top-left corner with 50 health and must travel to the bottom-right corner without running out of health. For each turn, the player can move up, down, left, or right. After selecting a direction, the player is given a preview of the hazard in the chosen cell. Then, they can confirm the move or opt out and choose a new direction.

As the player traverses the maze, their health changes according to the hazards they reach. Once the player has visited a cell, the cell value changes to “X”—the hazard has been neutralized and the player can revisit the cell without any change in health.

The game ends when the player reaches the bottom right-hand corner of the maze or when they run out of health.

## Screenshots:
![image](https://github.com/rogerqiu7/MazeGame/assets/84350865/4c57bbfc-ae39-4dec-8a7a-10783a7b0bc0)
![image](https://github.com/rogerqiu7/MazeGame/assets/84350865/c106dce4-5287-4bd3-9971-22007b2baeac)
