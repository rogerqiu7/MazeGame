import java.util.Scanner;

// create game public class
public class Game {

    // create instance variables
    GameBoard board;
    Player player;

    /**
     * Default constructor
     * Initializes 'board' and 'player' to defaults
     */
    public Game() {
        board = new GameBoard();
        player = new Player();
    }

    /**
     * Constructor that sets board to particular size
     * and the player to default
     *
     * @param row an int representing the rows for the board
     * @param col an int representing the cols for the board
     */
    public Game(int row, int col) {
        board = new GameBoard(row, col);
        player = new Player();
    }

    /**
     * Runs the game from beginning to end
     *
     * @param input Scanner object to handle user input
     */

    public void runGame(Scanner input) {

        // as long as players health is not zero or not reaches exit cell
        while ((player.getHealth() != 0) && (player.getPosition() != board.getExitCell())) {

            Cell nextCell;
            char mov;

            // Print current game state
            board.displayBoard(player);
            System.out.println("\nHealth: " + player.getHealth() + "\n");

            // ask for and validate user input for direction
            do {
                // Ask for & collect input
                // char move is 'u', 'd', 'l', or 'r'
                System.out.println("Enter a direction you want to move!");
                System.out.print("Up, down, left, or right? ");
                mov = input.nextLine().toLowerCase().charAt(0);

                // Assess move validity
                nextCell = validMove(mov);
                if (nextCell == null)
                    System.out.println("Invalid move! Try again");
                System.out.println();

            } while (nextCell == null); // while move is invalid

            // make the move
            makeMove(nextCell, input);

        }

        // if reaches exit, print results, else, you lost
        if (player.getPosition() == board.getExitCell()) { // reached exit
            board.displayBoard(player);
            System.out.println("You got to the end! You win!");
        } else {
            board.displayBoard(player);
            System.out.println("Sorry, you have no more health. Game over!");
        }

    }

    /**
     * Assesses the validity of a player's requested
     * move and returns values for the next move.
     *
     * @param move  a direction: 'u', 'd', 'l', or 'r'
     * @return   the Cell to move to or null for an invalid move
     */

    private Cell validMove(char move) {

        // get the current position of the player from the game board and store it in an array.
        int[] position = board.getCoord(player.getPosition());

        // array has two elements, row and column index of the players position
        // 0 is row, and index 1 is the column
        int y = position[0];
        int x = position[1];

        // get row and column index from the position array
        Cell[][] board = this.board.getBoard();

        // get the game board, 2D array of cell objects, from GameBoard

        // check the next cell based on the players move direction
        if (move == 'u') {
            if (y == 0) { // if cannot move up
                return null;
            } else
                return this.board.getBoard()[y - 1][x]; // get the cell above the current position

        } else if (move == 'd') {
            if (y >= board.length - 1) { // if cannot move down
                return null;
            } else
                return this.board.getBoard()[y + 1][x]; // get the cell below the current position

        } else if (move == 'l') {
            if (x == 0) { // if cannot move left
                return null;
            } else
                return this.board.getBoard()[y][x - 1]; // get the cell to the left of the current position

        } else if (move == 'r') {
            if (x >= board[0].length - 1) { // if cannot move right
                return null;
            } else
                return this.board.getBoard()[y][x + 1]; // get the cell to the right of the current position

        }

        // If none of the moves are valid then return null for invalid move
        return null;
    }

    /**
     * Moves a player through the game board and
     * updates board array and health amount accordingly.
     *
     * @param nextCell Cell object to move to
     * @param input    Scanner object to handle user input
     */
    private void makeMove(Cell nextCell, Scanner input) {

        // set the cleared status of the nextCell to true, shows the player has visited this cell
        nextCell.setCleared(true);

        // show info about the cell the player is moving to
        if (nextCell.getVisited()) {
            System.out.println("This cell has been cleared and has no cost.");
        } else {
            System.out.print("Your chosen cell has a ");

            // call methods from cellItem and Cell to get name and cost from next cell
            System.out.print(nextCell.getCellItem().getName());
            System.out.println(" with a cost of " + nextCell.getCellCost());
        }

        // confirm if player wants to move to next cell
        System.out.print("Would you like to move there? Yes or no: ");
        char confirm = input.nextLine().toLowerCase().charAt(0);

        if (confirm == 'y') { // If player wants to move

            // update player position to the ID of the nextCell
            this.player.setPosition(nextCell.getID());

            // update player health by adding the cell cost
            player.setHealth(player.getHealth() + nextCell.getCellCost());

            // mark the nextCell as visited.
            nextCell.setVisited(true);

            // health cannot go below 0
            if (player.getHealth() < 0) {
                player.setHealth(0);
            }

        }

    }
}
