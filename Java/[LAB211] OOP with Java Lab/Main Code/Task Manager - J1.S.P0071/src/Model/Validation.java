package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    // Global scanner object to be used for input
    public Scanner sc = new Scanner(System.in);

    // Method to get an integer within a specific range (min, max)
    public int getInt(String msg, int min, int max) {
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

    public double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                // Parse the input string as a double
                double result = Double.parseDouble(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    if (result * 10 % 5 == 0) {
                        return result; // Return the valid result
                    } else {
                        System.err.println("Your number must .0 or .5");
                    }
                } else {
                    // Print error if the number is out of range
                    System.err.println("Out of range, your number must be from: " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                // Print error if the input format is wrong
                System.err.println("Wrong format, please input a real number");
            }
        }
    }

    // Method to get a non-empty string with a custom error message
    public String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                return s;
            } else {
                System.err.println("String cannot be empty, please input again");
            }
        }
    }
    
    public String getAssignee() {
        while (true) {
            System.out.print("Assignee: ");
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

    public String getReviewer(String ass) {
        while (true) {
            System.out.print("Reviewer: ");
            String s = sc.nextLine().trim();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                if (!s.equalsIgnoreCase(ass)) {
                    return s; // Return the valid string
                } else {
                    System.err.println("Reviewer must be different than assignee");
                }
            } else {
                // Print error if the string is empty
                System.err.println("String cannot be empty, please input again");
            }
        }
    }

    // Method to get a date in the format dd-MMM-yyyy
    public String getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.print(msg);
            try {
                Date date = sdf.parse(sc.nextLine());
                Date currentDate = new Date();
                if (date.after(currentDate)) {
                    System.err.println("The date cannot be in the future. Please enter a valid date.");;
                } else {
                    return sdf.format(date);
                }
            } catch (ParseException e) {
                System.err.println("Invalid format of date. Please input form dd-MM-yyyy");
            }
        }
    }

}
