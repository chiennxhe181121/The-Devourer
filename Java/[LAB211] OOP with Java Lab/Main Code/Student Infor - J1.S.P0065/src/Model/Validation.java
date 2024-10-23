package Model;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    // Method to get a double within a specific range (min, max)
    public static double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                // Parse the input to a double
                double result = Double.parseDouble(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result; // Return valid input
                }
                // Display error if input is out of range
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                // Display error for wrong format
                System.err.println("Wrong format, please input a real number");
            }
        }
    }

    // Method to get a valid string input based on regex pattern
    public static String getStringRegex(String msg, String regex, String err) {
        while (true) {
            System.out.print(msg);
            String result = sc.nextLine().trim();
            // Check if the result matches the regex and is not empty
            if (!result.isEmpty() && result.matches(regex)) {
                return result; // Return valid input
            } else {
                // Display error for invalid input
                System.err.println(err);
            }
        }
    }

    // Method to get a 'Y' or 'N' input from the user
    public static String getYOrN(String msg) {
        while (true) {
            System.out.print(msg);
            String result = sc.nextLine().trim().toUpperCase();
            if (!result.isEmpty()) {
                // Check for valid input ('Y' or 'N')
                if (result.equals("Y") || result.equals("N")) {
                    return result; // Return valid input
                } else {
                    // Display error for invalid input
                    System.err.println("Please input only Y or N");
                }
            } else {
                // Display error for empty input
                System.err.println("String cannot be null");
            }
        }
    }

}

