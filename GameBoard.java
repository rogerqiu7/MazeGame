// create the gameboard class
public class GameBoard {

    // create 2D array of Cell objects as the board
    private Cell[][] board;

    // stores number of rows and columns
    private int rows;
    private int cols;

    // starts with -1 as a placeholder
    private int exitCell = -1; // ID of final board cell

    /**
     * Default constructor
     * Creates a 5x5 board and initializes cells
     */

    // default constructor that creates the game board with 5 rows and 5 cells
    public GameBoard() {
        this(5, 5);
    }

    /**
     * Parameterized constructor
     * Creates a board of specified size and initializes cells
     *
     * @param rows  number of rows in board
     * @param cols  number of columns in board
     */

    // constructor creates a board given rows and columns
    public GameBoard(int rows, int cols) {

        /* TODO: complete constructor */
        // Initialize 'rows' and 'cols'
        // Initialize 'board' to a new 2D Cell array with 'rows' rows and 'cols' columns
        // Run initBoard(), initCell0(), and initGemCell()

        // set number of rows and columns for the board game
        this.rows = rows;
        this.cols = cols;

        // create board given rows, columns, and call methods to set up board, cell for player and cell for gem
        board = new Cell[rows][cols];
        initBoard();
        initCell0();
        initGemCell();
    }

    /**
     * Initializes every board element to a new Cell object
     * and increments the exitCell attribute
     */
    private void initBoard() {

        /* TODO: Initialize the board */
        // Initialize every element to a new Cell object with the no-argument constructor
        // For every new element, increment exitCell

        // create a new cell for each position on the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell();
                exitCell++; // increment the exitCell for each cell created

            }
        }

    }

    /**
     * Sets cell 0 as player start
     */

    // sets the first cell as start position
    private void initCell0() {
        // marks the first cell as cleared and visited
        board[0][0].setCleared(true);
        board[0][0].setVisited(true);
    }

    /**
     * Places the gem in a random spot on the board
     * that is not the first or last cells
     */
    private void initGemCell() {

        // set variables for the random row and column
        int randI;
        int randJ;

        do {

            // create random index within the bounds of the board dimensions
            randI = (int) ((board.length) * Math.random());
            randJ = (int) ((board[0].length) * Math.random());

            // as long as the gem is not placed in the first or last cell
        } while ((randI == 0 && randJ == 0) || ((randI == (board.length - 1) && randJ == (board[0].length - 1))));

        // creates a new cell item with a gem and +5000 health
        CellItem gem = new CellItem("GEM", 5000);

        // put the gem in the random cell
        board[randI][randJ].setCellItem(gem);

    }

    /**
     * Returns the value of the last cell
     *
     * @return an int representing the last cell value counting from 0
     */
    public int getExitCell() {
        return this.exitCell;
    }

    /**
     * Returns the 2D board array
     *
     * @return the 2D array of cells
     */
    public Cell[][] getBoard() {
        return this.board;
    }

    /**
     * Returns the coordinates of a cell position
     *
     * @return int coordinates in a 1D array
     */
    public int[] getCoord(int position) {

        // set the coordinate array with -1 so invalid position by default
        int[] coord = { -1, -1 };

        // checks if current cell ID matches the given position
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (position == this.board[i][j].getID()) {

                    // update the coordinates with the current row and column
                    coord[0] = i;
                    coord[1] = j;

                    // return the coordinates of the cell
                    return coord;
                }
            }
        }

        // returns the coordinates, which will be -1, -1 if the position was not found
        return coord;

    }

    /**
     * Displays the current game board
     *
     * @param player current Player object
     */

    public void displayBoard(Player player) {

        // checks if the current cell is the player's position
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j].getID() == player.getPosition()) {

                    // print P to show the players position
                    System.out.print("|");
                    System.out.print(" P ");
                } else {
                    // else just prints the current cell
                    System.out.print("|");
                    System.out.print(board[i][j]);
                }

            }
            // print a new line to separate rows
            System.out.println("|");

        }

    }

}
