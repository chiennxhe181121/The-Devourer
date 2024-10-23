
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
                int result = Integer.parseInt(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result;
                } else {
                    System.err.println("Out of range, your number must be from: " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input an integer");
            }
        }
    }

    // Method to get a double within a specific range (min, max)
    public static double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result;
                } else {
                    System.err.println("Out of range, your number must be from: " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input a real number");
            }
        }
    }

    // Method to get a non-empty string with a custom error message
    public static String getString(String msg, String err) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                return s;
            } else {
                System.err.println(err);
            }
        }
    }

    // Method to get a string that matches a given regex pattern
    public static String getStringRegex(String msg, String regex, String err) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            // Check if the string is not empty and matches the regex
            if (!s.isEmpty() && s.matches(regex)) {
                return s;
            } else {
                System.err.println(err);
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
}
