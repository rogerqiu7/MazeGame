// create player class
public class Player {

    // create health and position objects
    private int health;
    private int position;

    /**
     * Default constructor,
     * sets player health to 500 and position 0
     */
    public Player() {

        health = 500;
        position = 0;
    }

    /**
     * Constructor sets player health to a parameter
     *
     * @param health the health for the player object
     */
    public Player(int health) {

        // set health and position
        this.health = health;
        position = 0;
    }

    /**
     * Health getter method for the player object
     *
     * @return the health for the player object
     */
    public int getHealth() {

        // return the health
        return this.health;
    }

    /**
     * Health setter method for the player object
     *
     * @param f the health for the player object
     */
    public void setHealth(int f) {

        // return new heatlh
        this.health = f;
    }

    /**
     * Position getter method for the player object
     *
     * @return the current position for the player object
     */
    public int getPosition() {
        // return the position
        return this.position;
    }

    /**
     * Postion setter method for the player object
     *
     * @param p the new position for the player object
     */
    public void setPosition(int p) {
        // return new position
        this.position = p;
    }

}
