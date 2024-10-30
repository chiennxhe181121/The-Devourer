package Model;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    public Scanner sc = new Scanner(System.in); // Scanner for user input

    // Method to get an integer within specified range
    public int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (min <= result && result <= max) {
                    return result;
                } else {
                    System.err.println("Out of range, must be from " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid format, please enter an integer");
            }
        }
    }

    // Method to get a valid double within a specified range
    public double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (min <= result && result <= max) {
                    return result;
                } else {
                    System.err.println("Out of range, must be from " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid format, please enter a decimal number");
            }
        }
    }

    // Method to get a non-empty string
    public String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            } else {
                System.err.println("Input cannot be empty");
            }
        }
    }

    // Method to validate a string using a regex pattern
    public String getStringRegex(String msg, String regex, String err) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty() && s.matches(regex)) {
                return s;
            } else {
                System.err.println(err);
            }
        }
    }

    // Method to validate and format a date in 'dd-MM-yyyy'
    public String getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false); // Disable leniency for strict parsing
        while (true) {
            System.out.print(msg);
            try {
                Date date = sdf.parse(sc.nextLine());
                Date currentDate = new Date();
                Date minDate = sdf.parse("31-12-1989");

                // Check if the date is within the specified range
                if (currentDate.after(date) && minDate.before(date)) {
                    return sdf.format(date);
                } else {
                    System.err.println("Out of range. Must be from 31-12-1989 to today.");
                }
            } catch (ParseException e) {
                System.err.println("Invalid date format. Please enter as dd-MM-yyyy");
            }
        }
    }

    // Method to get a "Yes" or "No" response from user
    public String getYesOrNo(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim().toUpperCase();
            if (s.equals("Y") || s.equals("N")) {
                return s;
            } else {
                System.err.println("Input must be Y/N");
            }
        }
    }
    
}
