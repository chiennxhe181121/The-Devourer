package P0051;

public class Main {

    public static void main(String[] args) {
        // Infinite loop to keep the program running until the user decides to exit
        while (true) {
            int choice = Manager.menu(); // Display the menu and get user choice
            switch (choice) {
                case 1:
                    System.out.println("----- Normal Calculator -----");
                    Manager.performNormalCalculate(); // Perform calculations using the normal calculator
                    break;
                case 2:
                    System.out.println("----- BMI Calculator -----");
                    Manager.calculateBMI(); // Calculate BMI using the BMI calculator
                    break;
                case 3:
                    System.err.println("Exiting...");
                    return; // Exit the program
            }
        }
    }
}
