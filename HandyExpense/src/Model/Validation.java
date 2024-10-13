package Model;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        dateFormat.setLenient(false); // Prevent parsing of invalid dates
        while (true) {
            System.out.print(msg);
            try {
                // Read date from user
                Date date = dateFormat.parse(sc.nextLine().trim());
                Date currentDate = new Date();
                // Check if the entered date is before the current date
                if (currentDate.after(date)) {
                    return dateFormat.format(date); // Return the valid date
                } else {
                    // Print error if the date is in the future
                    System.err.println("The date cannot be in the future. Please enter again.");
                }
            } catch (Exception e) {
                // Print error if the date format is invalid
                System.err.println("Invalid date format. Please enter in the format dd-MMM-yyyy.");
            }
        }
    }

    // Method to get a yes or no response from the user
    public static String getYesOrNo(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                // Check if the input is either Y or N (case insensitive)
                if ((s.equalsIgnoreCase("Y")) || (s.equalsIgnoreCase("N"))) {
                    return s.toUpperCase(); // Return the valid response in uppercase
                } else {
                    // Print error if the response is invalid
                    System.err.println("Please enter (Y/N)");
                }
            } else {
                // Print error if the string is empty
                System.err.println("String cannot be empty, please input again");
            }
        }
    }
}
