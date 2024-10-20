package P0051;

import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in); // Scanner for user input

    // Method to get an integer input within a specified range
    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int result = Integer.parseInt(sc.nextLine().trim()); // Parse the input
                if (result >= min && result <= max) {
                    return result; // Return the valid input
                }
                System.err.println("Out of range. Your number must be from " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format. Please input an integer");
            }
        }
    }

    // Method to get a double input within a specified range
    public static double getDouble(String msg, double min, double max, String err) {
        while (true) {
            try {
                System.out.print(msg);
                double result = Double.parseDouble(sc.nextLine().trim()); // Parse the input
                if (result >= min && result <= max) {
                    return result; // Return the valid input
                }
                System.err.println("Out of range. Your number must be from " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println(err); // Display the error message
            }
        }
    }

    // Method to get a valid operator input from the user
    public static String getOperator(String msg, String err) {
        while (true) {
            System.out.print(msg);
            String result = sc.nextLine().trim(); // Get the operator input
            // Check if the input is a valid operator
            if (!result.isEmpty() && (result.equals("+") || result.equals("-") || result.equals("*")
                    || result.equals("/") || result.equals("^") || result.equals("="))) {
                return result; // Return the valid operator
            } else {
                System.err.println(err);
            }
        }
    }
}
