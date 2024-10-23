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
                int result = Integer.parseInt(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result; // Return the valid integer
                }
                System.err.println("Out of range, your number must be from " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input an integer"); // Handle invalid format
            }
        }
    }

    // Method to get a double within a specific range (min, max)
    public double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result; // Return the valid double
                }
                System.err.println("Out of range, your number must be from " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input a real number"); // Handle invalid format
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
                return s; // Return the valid string
            } else {
                System.err.println("String cannot be empty"); // Handle empty string case
            }
        }
    }

    // Method to get a valid date in the format 'dd-MMM-yyyy'
    public String getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.setLenient(false); // Ensure strict date parsing
        while (true) {
            System.out.print(msg);
            try {
                Date date = sdf.parse(sc.nextLine());
                Date currentDate = new Date();
                // Check if the date is not in the future
                if (currentDate.after(date)) {
                    return sdf.format(date); // Return the valid date
                } else {
                    System.err.println("The date cannot be in the future. Please try again");
                }
            } catch (ParseException e) {
                System.err.println("Invalid date format, please enter again 'dd-MMM-yyyy'"); // Handle parse exception
            }
        }
    }

    // Method to get a Yes or No response
    public String getYesOrNo(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim().toUpperCase();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                if (s.equals("Y") || s.equals("N")) {
                    return s; // Return 'Y' or 'N'
                } else {
                    System.err.println("Please input 'Y' or 'N'"); // Handle invalid input
                }
            }
            System.err.println("String cannot be empty"); // Handle empty string case
        }
    }

}
