package P0008;

import java.util.Scanner;

public class Validation {

    // Create a global Scanner object for the Validation class
    private static Scanner sc = new Scanner(System.in);

    // Method to check if the string is not empty and contains only letters and spaces
    public static String getString(String msg, String err) {
        while (true) {
            System.out.println(msg);
            String s = sc.nextLine().trim();
            // Check if the string is not empty and contains only letters and spaces
            if (!s.isEmpty() && s.matches("[a-zA-Z\\s]+")) {
                return s;
            }
            // Display error message if validation fails
            System.err.println(err);
        }
    }
}
