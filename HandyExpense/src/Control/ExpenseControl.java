package Control;

import Model.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseControl {
    private static List<Expense> expense = new ArrayList<>(); // List to store expenses
    private static int id = 1; // Initialize the ID for new expenses

    // Method to add an expense to the list
    public static void addExpenseToList() {
        System.out.println("-------- Add an expense --------");
        while (true) {
            // Get date, amount, and content from user
            String date = Validation.getDate("Enter date: ");
            double amount = Validation.getDouble("Enter Amount: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
            String content = Validation.getString("Enter Content: ");
            // Create a new expense and add it to the list
            expense.add(new Expense(id++, date, amount, content));
            // Ask user if they want to add another expense
            String choice = Validation.getYesOrNo("Do you want to add another expense (Y/N): ");
            if (choice.equals("N")) {
                System.out.println("*** Add successful ***");
                break; // Exit the loop if user does not want to add more
            }
        }
    }

    // Method to display all expenses
    public static void displayAllExpense() {
        System.out.println("--------- Display all expenses ------------");
        if (expense.isEmpty()) {
            // Print error if there are no expenses
            System.err.println("Not found expense table");
            return;
        } else {
            double total = 0; // Variable to calculate total expenses
            System.out.println("ID       Date        Amount     Content");
            // Iterate through expenses and display each one
            for (Expense exp : expense) {
                System.out.println(exp.toString());
                total += exp.getNumber(); // Accumulate total
            }
            // Print total expenses
            System.out.printf("Total: %.2f\n", total);
        }
    }

    // Method to delete an expense
    public static void deleteAnExpense() {
        while (true) {
            System.out.println("-------- Delete an expense --------");
            // Get the ID of the expense to delete
            int id = Validation.getInt("Enter ID: ", 1, Integer.MAX_VALUE);
            boolean found = false; // Flag to track if expense is found

            // Iterate through expenses to find the one to delete
            for (Expense exp : expense) {
                if (exp.getID() == id) {
                    found = true; // Expense found
                    expense.remove(exp); // Remove the expense from the list
                    System.out.println("Expense with ID " + id + " has been deleted.");
                    break; // Exit the loop after deleting
                }
            }

            if (!found) {
                // Print error if the expense ID was not found
                System.err.println("Cannot find the entered ID in the expense table.");
            }

            // Ask user if they want to delete another expense
            String choice = Validation.getYesOrNo("Do you want to delete another expense (Y/N): ");
            if (choice.equals("N")) {
                break; // Exit the loop if user does not want to delete more
            }
        }
    }
}
