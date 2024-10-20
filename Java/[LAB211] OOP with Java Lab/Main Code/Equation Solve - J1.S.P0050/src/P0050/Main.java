package P0050;

public class Main {

    public static void main(String[] args) {
        // Infinite loop to keep the program running until the user decides to exit
        while (true) {
            int choice = Manager.menu(); // Display the menu and get user choice
            switch (choice) {
                case 1:
                    System.out.println("----- Calculate Equation -----");
                    Manager.calculateSuperlativeEquation(); // Calculate and display the result of the superlative equation
                    break;
                case 2:
                    System.out.println("----- Calculate Quadratic Equation -----");
                    Manager.calculateQuadraticEquation(); // Calculate and display the result of the quadratic equation
                    break;
                case 3:
                    System.err.println("Exiting...");
                    return; // Exit the program
            }
        }
    }
}
