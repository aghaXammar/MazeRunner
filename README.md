# Maze Runner Game

This is a simple text-based Maze Runner game developed in Java as an assignment for the CSCS290 Java Programming course. The objective of the game is to guide the player (P) through the maze to reach the exit (E) while avoiding the walls (#). The game keeps track of the number of steps taken by the player to reach the exit, and the highest score achieved in multiple game plays.

## How to Play

1. The maze is represented by '#' for walls, '.' for paths, 'P' for the player, and 'E' for the exit.
2. Use 'w' to move upwards, 's' to move downwards, 'a' to move left, and 'd' to move right.
3. You cannot move through walls ('#').
4. Reach the exit ('E') to win the game.
5. The number of steps taken will be recorded.
6. You can quit the game by typing 'e'.

## Instructions

To play the game, follow these steps:

1. Run the `Maze_runner.java` file in your Java development environment.
2. The game menu will be displayed with the following options:
   a. Play Game
   b. Instructions
   c. Credits
   d. High Score
   e. Exit
3. Select the option by entering the corresponding letter (a, b, c, d, or e) and pressing Enter.
4. If you choose "Play Game" (option 'a'), the maze will be displayed, and you can start playing the game using the 'w', 'a', 's', and 'd' keys to move the player (P) upwards, left, downwards, and right, respectively.
5. Try to reach the exit (E) to win the game. The number of steps taken will be recorded.
6. If you choose "Instructions" (option 'b'), the game rules and instructions will be displayed.
7. If you choose "Credits" (option 'c'), the credits for the game development will be displayed.
8. If you choose "High Score" (option 'd'), the highest score achieved in the game will be displayed.
9. If you choose "Exit" (option 'e'), the game will terminate.

## Notes

- The game uses a simple 2D array to represent the maze and the player's position.
- The game continues until the player reaches the exit (E) or decides to quit.
- The highest score is updated after each game play and persists until the program is closed.

Feel free to explore and modify the code to add more features or improve the game experience. Enjoy the Maze Runner game!
