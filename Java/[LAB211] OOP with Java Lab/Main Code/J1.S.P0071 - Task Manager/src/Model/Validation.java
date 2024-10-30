
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    public Scanner sc = new Scanner(System.in); // Scanner for user input

    public int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg); // Print message to prompt user input
            try {
                int result = Integer.parseInt(sc.nextLine().trim()); // Read and parse integer input
                if (min <= result && result <= max) {
                    return result; // Return valid input
                } else {
                    System.err.println("Out of range, your number must be [" + min + ", " + max + "]");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input an integer"); // Handle invalid input format
            }
        }
    }

    public double getFrom(String msg, double min, double max) {
        while (true) {
            System.out.print(msg); // Print message to prompt user input
            try {
                double result = Double.parseDouble(sc.nextLine().trim()); // Read and parse double input
                if (min <= result && result <= max) {
                    if (result * 10 % 5 == 0) { // Ensure input ends with .0 or .5
                        return result; // Return valid input
                    } else {
                        System.err.println("Your number must end with .0 or .5");
                    }
                } else {
                    System.err.println("Out of range, your number must be from [" + min + ", " + max + "]");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input a real number"); // Handle invalid input format
            }
        }
    }

    public double getTo(String msg, double min, double max) {
        while (true) {
            System.out.print(msg); // Print message to prompt user input
            try {
                double result = Double.parseDouble(sc.nextLine().trim()); // Read and parse double input
                if (min < result && result <= max) {
                    if (result * 10 % 5 == 0) { // Ensure input ends with .0 or .5
                        return result; // Return valid input
                    } else {
                        System.err.println("Your number must end with .0 or .5");
                    }
                } else {
                    System.err.println("Value for 'To' must be greater than or equal to 'From' and within range: (" + min + ", " + max + "]");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input a real number"); // Handle invalid input format
            }
        }
    }

    public String getString(String msg) {
        while (true) {
            System.out.print(msg); // Print message to prompt user input
            String s = sc.nextLine().trim(); // Read user input
            if (!s.isEmpty()) {
                return s; // Return valid input
            } else {
                System.err.println("String cannot be empty"); // Handle empty input
            }
        }
    }

    public String getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Define date format
        sdf.setLenient(false); // Ensure strict parsing of dates
        while (true) {
            System.out.print(msg); // Print message to prompt user input
            try {
                Date date = sdf.parse(sc.nextLine()); // Parse user input to date
                Date currentDate = new Date(); // Get the current date
                Date minDate = sdf.parse("31-12-1989"); // Define minimum date
                if (currentDate.after(date) && minDate.before(date)) {
                    return sdf.format(date); // Return valid date
                } else {
                    System.err.println("Out of range, your date must be from Mon Jan 1 00:00:00 ICT 1990 to " + currentDate);
                }
            } catch (ParseException e) {
                System.err.println("Invalid date format, please enter again 'dd-MMM-yyyy'"); // Handle invalid date format
            }
        }
    }

    public String getYesOrNo(String msg) {
        while (true) {
            System.out.print(msg); // Print message to prompt user input
            String s = sc.nextLine().trim().toUpperCase(); // Read and convert input to uppercase
            if (!s.isEmpty()) {
                if (s.equals("Y") || s.equals("N")) {
                    return s; // Return valid input
                } else {
                    System.err.println("Please input 'Y' or 'N'"); // Handle invalid input
                }
            } else {
                System.err.println("String cannot be empty"); // Handle empty input
            }
        }
    }
}


