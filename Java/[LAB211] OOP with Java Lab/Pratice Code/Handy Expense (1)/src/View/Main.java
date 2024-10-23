package View;

import Model.*;
import Control.*;

public class Main {
    public static void main(String[] args) {
        // Infinite loop to keep the program running until the user chooses to quit
        while (true) {
            System.out.println("======= Handy Expense program ======");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            // Get user's choice and validate it
            int choice = Validation.getInt("Your choice: ", 1, 4);
            System.out.println("");
            switch (choice) {
                case 1:
                    // Call method to add an expense to the list
                    ExpenseControl.addExpenseToList();
                    break;
                case 2:
                    // Call method to display all expenses
                    ExpenseControl.displayAllExpense();
                    System.out.println("");
                    break;
                case 3:
                    // Call method to delete an expense
                    ExpenseControl.deleteAnExpense();
                    System.out.println("");
                    break;
                case 4:
                    // Exit the program
                    System.err.println("Exiting...");
                    System.out.println("");
                    return;
            }
        }
    }
}
