package P0001;

import java.util.Scanner;

public class InputValidator {

    // Global scanner for input from user
    public static Scanner sc = new Scanner(System.in);

    // This method gets an integer from the user and makes sure it's within a specific range
    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.println(msg);
            try {
                // Get the number from the user
                int result = Integer.parseInt(sc.nextLine().trim());
                
                // Check if it's within the given range
                if (result >= min && result <= max) {
                    return result; // Return the valid number
                }
                System.err.println("Out of range, your number must be from " + min + " to " + max);
            } catch (NumberFormatException ex) {
                // If the user didn't type a number, show an error
                System.err.println("Wrong format. Please input an integer");
            }
        }
    }
}
