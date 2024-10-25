package View;

import Model.*;
import Control.*;

public class Main {

    public static void main(String[] args) {
        Validation valid = new Validation(); // Create a validation object
        Manager ma = new Manager(); // Create a manager object to handle tasks
        while (true) {
            // Display the main menu
            System.out.println("========= Task program =========");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");

            // Get user's choice
            int choice = valid.getInt("Enter your choice: ", 1, 4);
            System.out.println("");
            
            // Process user's choice
            switch (choice) {
                case 1:
                    ma.addTask(); // Add a new task
                    System.out.println("");
                    break;
                case 2:
                    ma.deleteTask(); // Delete an existing task
                    System.out.println("");
                    break;
                case 3:
                    ma.displayTask(); // Display all tasks
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return; // Exit the program
            }
        }
    }
}
