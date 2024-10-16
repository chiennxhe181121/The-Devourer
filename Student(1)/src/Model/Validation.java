package Model;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    // Method to get a double within a specific range (min, max)
    public static double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (min <= result && result <= max) {
                    return result;
                }
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input a real number");
            }
        }
    }

    public static String getStringRegex(String msg, String regex, String err) {
        while (true) {
            System.out.print(msg);
            String result = sc.nextLine().trim();
            if (!result.isEmpty() && result.matches(regex)) {
                return result;
            } else {
                System.err.println(err);
            }
        }
    }

    public static String getYorN(String msg) {
        while (true) {
            System.out.print(msg);
            String result = sc.nextLine().trim().toUpperCase();
            if (!result.isEmpty()) {
                if (result.equals("Y") || result.equals("N")) {
                    return result;
                } else {
                    System.err.println("Please input Y or N");
                }
            } else {
                System.err.println("String cannot be null");
            }
        }
    }

}
