package P0051;

import java.util.Scanner;

public class Validation {

    // Global scanner object to be used for input
    public static Scanner sc = new Scanner(System.in);

    // Method to get an integer within a specific range (min, max)
    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.println(msg);
            try {
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

    // Method to get a double within a specific range (min, max)
    public static double getDouble(String msg, double min, double max, String err) {
        while (true) {
            System.out.println(msg);
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result;
                }
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println(err);
            }
        }
    }

    public static String getOperator(String msg, String err) {
        while (true) {
            System.out.println(msg);
            String ope = sc.nextLine().trim();
            if (!ope.isEmpty() && (ope.equals("+") || ope.equals("-") || ope.equals("*")
                    || ope.equals("/") || ope.equals("^") || ope.equals("="))) {
                return ope;
            } else {
                System.err.println(err);
            }
        }
    }
}
