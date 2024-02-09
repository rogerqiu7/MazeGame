/* TODO: Create the Animal class */
public class Animal extends CellItem {

    /* TODO: Create the Animal(String, int1, int2) constructor */

    // Initializes CellItem 'name' with String argument
    // Intiializes CellItem 'cost' as int * int2
    public Animal(String name, int cost, int id) {
        super(name, cost * id);
    }
}
