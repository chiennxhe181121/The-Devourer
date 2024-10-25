
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

    // Method to get a valid date in the format 'dd-MMM-yyyy'
    public String getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false); // Ensure strict date parsing
        while (true) {
            System.out.print(msg);
            try {
                Date date = sdf.parse(sc.nextLine());
                Date currentDate = new Date();
                Date minDate = sdf.parse("31-12-1989");
                // Check range of date input
                if (currentDate.after(date) && minDate.before(date)) {
                    return sdf.format(date); // Return the valid date
                } else {
                    System.err.println("Out of range, your date must be from Mon Jan 1 00:00:00 ICT 1990 to " + currentDate);
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
            } else {
                System.err.println("String cannot be empty"); // Handle empty string case
            }
        }
    }
}
