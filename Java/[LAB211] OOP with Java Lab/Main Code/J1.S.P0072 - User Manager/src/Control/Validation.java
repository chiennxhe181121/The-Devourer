package Control;

import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
                // Check if the result is within the specified range
                if (min <= result && result <= max) {
                    return result; // Return the valid input
                } else {
                    System.err.println("Out of range, must be from " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                // Handle the case when the input is not a valid integer
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
                // Check if the result is within the specified range
                if (min <= result && result <= max) {
                    return result; // Return the valid input
                } else {
                    System.err.println("Out of range, must be from " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                // Handle the case when the input is not a valid double
                System.err.println("Invalid format, please enter a decimal number");
            }
        }
    }

    // Method to get a non-empty string
    public String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                return s; // Return the valid input
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
            // Validate the string against the regex pattern
            if (!s.isEmpty() && s.matches(regex)) {
                return s; // Return the valid input
            } else {
                System.err.println(err); // Print the error message
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
                    return sdf.format(date); // Return the formatted date
                } else {
                    System.err.println("Out of range. Must be from 31-12-1989 to today.");
                }
            } catch (ParseException e) {
                // Handle the case when the date format is invalid
                System.err.println("Invalid date format. Please enter as dd-MM-yyyy");
            }
        }
    }

    // Method to get a "Yes" or "No" response from user
    public String getYesOrNo(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim().toUpperCase();
            // Validate the input to be either "Y" or "N"
            if (s.equals("Y") || s.equals("N")) {
                return s; // Return the valid input
            } else {
                System.err.println("Input must be Y/N");
            }
        }
    }

    // Method to hash a password using MD5
    public String hashPassword(String password) {
        try {
            // Create a MessageDigest instance with MD5 hashing algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Update the MessageDigest with the bytes of the password string
            md.update(password.getBytes());

            // Perform the hashing and return a byte array of the hashed value
            byte[] byteData = md.digest();

            // Initialize a StringBuilder to construct the final hashed string
            StringBuilder sb = new StringBuilder();

            // Loop through each byte in the byte array
            for (byte b : byteData) {
                // Convert each byte to a hexadecimal string (2-digit format) and append it to sb
                sb.append(String.format("%02x", b));
            }

            // Return the completed hashed password as a string
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the case where the MD5 algorithm is not available
            throw new RuntimeException(e);
        }
    }

}
