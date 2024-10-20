package P0050;

import java.util.Scanner;

public class Validation {

    // Global scanner object to be used for input
    public static Scanner sc = new Scanner(System.in);

    // Method to get an integer within a specific range (min, max)
    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int result = Integer.parseInt(sc.nextLine().trim()); // Parse user input as an integer
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result; // Return valid input
                }
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input an integer");
            }
        }
    }

    // Method to get a float within a specific range (min, max)
    public static float getFloat(String msg, float min, float max) {
        while (true) {
            System.out.print(msg);
            try {
                float result = Float.parseFloat(sc.nextLine().trim()); // Parse user input as a float
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result; // Return valid input
                }
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input a real number");
            }
        }
    }
}
