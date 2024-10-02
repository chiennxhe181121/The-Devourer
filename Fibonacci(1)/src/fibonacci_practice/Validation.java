package fibonacci_practice;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    // Global scanner object to be used for input

    public static Scanner sc = new Scanner(System.in);

    // Method to get an integer within a specific range (min, max)
    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result;
                }
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input an integer");
            }
        }
    }
}
