package View;

import Controller.TaskManager;
import Controller.Validation;

public class Main {

    public static void main(String[] args) {
        Validation val = new Validation(); // Create an instance of Validation class for input validation
        TaskManager task = new TaskManager(); // Create an instance of TaskManager to manage tasks
        while (true) {
            System.out.println("========= Task program =========");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            int choice = val.getInt("Enter your choice: ", 1, 4); // Get user's menu choice
            System.out.println("");
            switch (choice) {
                case 1:
                    task.addTask(); // Call method to add a task
                    System.out.println("");
                    break;
                case 2:
                    task.deleteTask(); // Call method to delete a task
                    System.out.println("");
                    break;
                case 3:
                    task.displayTask(); // Call method to display all tasks
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Exiting..."); // Exit the program
                    return;
            }
        }
    }
}
