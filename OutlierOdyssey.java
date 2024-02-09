import java.util.Scanner;

// create OutlierOdyssey class, entry point of the program
public class OutlierOdyssey {

    // main method, starting point of execution for the program
    public static void main(String[] args) {

        // read input from console
        Scanner input = new Scanner(System.in);

        // create Game object named b with dimensions 10x10
        Game b = new Game(10, 10);

        // Call and run programs to test

        // call the runGame method from the Game object to start the game and pass the text input as input
        b.runGame(input);

        // Close Scanner incantation
        input.close();

    }

}
