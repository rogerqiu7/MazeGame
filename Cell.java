// create the cell class
public class Cell {

    // define instance variables
    private static int count = 0;
    private int id;
    private CellItem cellItem;
    private boolean cleared;
    private boolean visited;

    /**
     * Constructor that initializes Cell attributes:
     *     'num': current count
     *     'cellItem': a River with cost -15 or a random Animal
     *     'cleared' and 'visited': false
     */
    public Cell() {
        this.id = count; // assign ID number
        count++; // increment counter

        // create a random number between 0 and 99
        int randNum = (int) (100 * Math.random());

        // if the random number is divisible by 4, make it a river
        if ((randNum % 4) == 0)
            this.cellItem = new CellItem("River", -15);
        else {

            // else, place an animal
            randNum = (int) (4 * Math.random());
            this.cellItem = initAnimal(randNum);
        }

        // set cleared and visited to false to show that cells are neither at creation
        this.cleared = false;
        this.visited = false;

    }

    /**
     * Creates a random Animal object
     *
     * @param randNum a random integer 1-4
     * @return an Animal object
     */
    private Animal initAnimal(int randNum) {
        /* TODO: return a new Animal instance using Animal(String, int1, int2) */
        // int2 is the id of the Cell
        // If randNum is 0, String is "Wolf" and int1 is -2
        // If randNum is 1, String is "Boar" and int1 is -1
        // If randNum is 2, String is "Elk" and int1 is 0
        // If randNum is 3 or 4, String is "Hare" and int1 is 1
        if (randNum == 0) {
            return new Animal("Wolf", -2, id);
        } else if (randNum == 1) {
            return new Animal("Boar", -1, id);
        } else if (randNum == 2) {
            return new Animal("Elk", 0, id);
        } else {
            return new Animal("Hare", 1, id);
        }

    }

    /* TODO: Add getter methods: */
    // cellItem getter
    // id getter
    // cleared getter
    // visited getter
    // cellCost getter
    // If a cell has been visited, the cellCost getter returns 0

    // create getvisited method
    public boolean getVisited() {
        return visited; // when called, returns the current state of visited
    }

    // getters
    public CellItem getCellItem() { return cellItem; }
    public int getID() { return id; }
    public boolean isCleared() { return cleared; }
    public boolean isVisited() { return visited; }
    public int getCellCost() { return visited ? 0 : cellItem.getCost(); }

    /* TODO: Add setter methods: */
    // cellItem setter
    // cleared setter
    // visited setter

    // setters
    public void setCellItem(CellItem item) { this.cellItem = item; }
    public void setCleared(boolean cleared) { this.cleared = cleared; }
    public void setVisited(boolean visited) { this.visited = visited; }

    /**
     * Overriding toString() method that returns:
     *     " X " if Cell has been cleared and visited
     *     The first letter the item's name if Cell has been cleared but not visited
     *     A blank string ("   ") if the cell has not been cleared
     *
     * @return String containing cell's information
     */
    @Override
    public String toString() {

        // if the cell is cleared and visited
        if (this.cleared) {
            if (this.visited) {

                // return X
                return " X ";
            } else

                // else return the first letter of the item name if cleared but not visited
                return " " + this.cellItem.toString().charAt(0) + " ";

        } else

            // else if uncleared, return empty
            return "   ";

    }

    /*
     * Check if two cells are the same in a grid, based on id.
     *
     * @param other the other cell to compare to this
     * @return true if same, false otherwise.
     */

    @Override
    /* TODO: declare equals() method */
    // method to check if two Cell objects are equal based on their id field.
    public boolean equals(Object obj) {

        // TODO: return true if cells have the same id
        // Otherwise, return false

        // check if the current object, 'this', and the object being compared to are actually the same object, return true
        if (this == obj) {
            return true;
        }

        // cast obj to a cell to compare their id
        Cell otherCell = (Cell) obj;

        // if the ids are the same, then true
        return this.id == otherCell.id;

    }
}
