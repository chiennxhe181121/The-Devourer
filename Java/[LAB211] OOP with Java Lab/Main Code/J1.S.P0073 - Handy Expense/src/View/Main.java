package View;

import Control.Validation;
import Model.*;
import Control.*;

public class Main {

    public static void main(String[] args) {
        Validation valid = new Validation(); // Create a validation object
        ExpenseControl ec = new ExpenseControl(); // Create an expense control object
        while (true) {
            System.out.println("=======Handy Expense program======");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            int choice = valid.getInt("Your choice: ", 1, 4); // Get user choice
            System.out.println("");
            switch (choice) {
                case 1:
                    ec.addAnExpense(); // Call method to add an expense
                    System.out.println("");
                    break;
                case 2:
                    ec.displayAllExpenses(); // Call method to display all expenses
                    System.out.println("");
                    break;
                case 3:
                    ec.deleteAnExpense(); // Call method to delete an expense
                    System.out.println("");
                    break;
                case 4: 
                    System.out.println("Exiting..."); // Exit message
                    return; // Exit the program
            }
        }
    }
}
