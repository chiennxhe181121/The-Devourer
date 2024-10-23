package Control;

import Model.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseControl {

    List<Expense> expenses = new ArrayList<>(); // List to store expenses
    Validation valid = new Validation(); // Create a validation object
    private int crId = 1; // Current ID for new expenses

    // Method to add an expense
    public void addAnExpense() {
        System.out.println("-------- Add an expense--------");
        while (true) {
            String date = valid.getDate("Enter Date: "); // Get the expense date
            double amount = valid.getDouble("Enter Amount: ", 0, Double.POSITIVE_INFINITY); // Get the expense amount
            String content = valid.getString("Enter Content: "); // Get the expense content
            expenses.add(new Expense(crId++, date, amount, content)); // Add new expense to the list
            String choice = valid.getYesOrNo("Do you want to add more (Y/N): "); // Check if user wants to add more
            if (choice.equals("N")) {
                break; // Exit the loop if the user does not want to add more
            }
        }
        System.out.println("*** Add successful ***"); // Success message
    }

    // Method to display all expenses
    public void displayAllExpenses() {
        System.out.println("---------Display all expenses------------");
        if (expenses.isEmpty()) {
            System.out.println("*** The expense list is empty ***"); // Message when the list is empty
        } else {
            double total = 0; // Initialize total amount
            System.out.printf("%-7s%-14s%-10s%s\n", "ID", "Date", "Amount", "Content"); // Print table header
            for (Expense expense : expenses) {
                System.out.println(expense.toString()); // Display each expense
                total += expense.getAmount(); // Add to total amount
            }
            System.out.printf("Total: %.2f\n", total); // Display total amount
        }
    }

    // Method to delete an expense
    public void deleteAnExpense() {
        System.out.println("--------Delete an expense------");
        boolean flag = false; // Flag to check if the expense is found
        if (expenses.isEmpty()) {
            System.out.println("*** The expense list is empty ***"); // Message when the list is empty
        } else {
            int deleteId = valid.getInt("Enter ID: ", 1, expenses.size()); // Get the ID to delete
            for (int i = 0; i < expenses.size(); i++) {
                // Check if the current expense ID matches the ID to delete
                if (expenses.get(i).getId() == deleteId) {
                    expenses.remove(i); // Remove the expense at index i
                    flag = true; // Set flag to true as the expense is found and deleted
                    System.out.println("*** Delete successful ***");
                    // Update the IDs of subsequent expenses after deletion
                    for (int j = i; j < expenses.size(); j++) {
                        expenses.get(j).setId(j + 1); // Set new ID for the remaining expenses
                    }
                    crId = expenses.size() + 1; // Update the current ID for new expenses
                    break; // Exit the loop after deletion
                }
            }
            // If no matching ID is found, display a message
            if (!flag) {
                System.out.println("*** Your ID is not exist in table ***");
            }
        }
    }
}
