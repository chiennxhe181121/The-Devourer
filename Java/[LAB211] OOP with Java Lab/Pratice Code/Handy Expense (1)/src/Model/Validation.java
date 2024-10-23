package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    
    // Global scanner object to be used for input
    public static Scanner sc = new Scanner(System.in);

    // Method to get an integer within a specific range (min, max)
    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                // Parse the input string as an integer
                int result = Integer.parseInt(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result; // Return the valid result
                }
                // Print error if the number is out of range
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                // Print error if the input format is wrong
                System.err.println("Wrong format, please input an integer");
            }
        }
    }

    // Method to get a double within a specific range (min, max)
    public static double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                // Parse the input string as a double
                double result = Double.parseDouble(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result; // Return the valid result
                }
                // Print error if the number is out of range
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                // Print error if the input format is wrong
                System.err.println("Wrong format, please input a real number");
            }
        }
    }

    // Method to get a non-empty string with a custom error message
    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                return s; // Return the valid string
            } else {
                // Print error if the string is empty
                System.err.println("String cannot be empty, please input again");
            }
        }
    }

    // Method to get a date in the format dd-MMM-yyyy
    public static String getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.setLenient(false); // Disable lenient mode to ensure strict date parsing
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            try {
                // Parse the input date string
                Date date = sdf.parse(input);
                Date currentDate = new Date();  // Get the current system date

                // Check if the input date is in the future
                if (date.after(currentDate)) {
                    System.err.println("The date cannot be in the future. Please enter a valid date.");
                } else {
                    // If valid, return the formatted date string
                    return sdf.format(date);
                }
            } catch (ParseException e) {
                // If the input format is invalid, show an error and ask for input again
                System.err.println("Invalid date format, please enter again (dd-MMM-yyyy). Example: 20-Oct-2024");
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
                    System.err.println("Please input Y or N");
                }
            } else {
                // Display error for empty input
                System.err.println("String cannot be empty. Please input again");
            }
        }
    }
}
