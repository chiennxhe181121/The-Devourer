package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    // Global scanner object to be used for input
    public Scanner sc = new Scanner(System.in);

    // Method to get an integer within a specific range (min, max)
    public int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                // Parse the input string as an integer
                int result = Integer.parseInt(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    return result; // Return the valid result
                }
                // Print error if the number is out of range
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                // Print error if the input format is wrong
                System.err.println("Wrong format, please input an integer");
            }
        }
    }

    // Method to get a double value for "From" within a specific range
    public double getFrom(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                // Parse the input string as a double
                double result = Double.parseDouble(sc.nextLine().trim());
                // Check if the result is within the given range
                if (min <= result && result <= max) {
                    if (result * 10 % 5 == 0) { // Ensure the number ends with .0 or .5
                        return result; // Return the valid result
                    } else {
                        System.err.println("Your number must end with .0 or .5");
                    }
                } else {
                    // Print error if the number is out of range
                    System.err.println("Out of range, your number must be from: " + min + " to " + max);
                }
            } catch (NumberFormatException ex) {
                // Print error if the input format is wrong
                System.err.println("Wrong format, please input a real number");
            }
        }
    }

// Method to get a double value for "To" within a specific range
    public double getTo(String msg, double from, double max) {
        while (true) {
            System.out.print(msg);
            try {
                // Parse the input string as a double
                double result = Double.parseDouble(sc.nextLine().trim());
                // Check if the result is greater than or equal to from and within the given max range
                if (from <= result && result <= max) {
                    if (result * 10 % 5 == 0) { // Ensure the number ends with .0 or .5
                        return result; // Return the valid result
                    } else {
                        System.err.println("Your number must end with .0 or .5");
                    }
                } else {
                    // Print error if to is less than from
                    System.err.println("Value for 'To' must be greater than or equal to 'From' and within range: " + from + " to " + max);
                }
            } catch (NumberFormatException ex) {
                // Print error if the input format is wrong
                System.err.println("Wrong format, please input a real number");
            }
        }
    }

    // Method to get a non-empty string with a custom error message
    public String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                return s; // Return the valid string
            } else {
                System.err.println("String cannot be empty, please input again");
            }
        }
    }

    // Method to get the assignee's name
    public String getAssignee() {
        while (true) {
            System.out.print("Assignee: ");
            String s = sc.nextLine().trim();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                return s; // Return the valid string
            } else {
                // Print error if the string is empty
                System.err.println("String cannot be empty, please input again");
            }
        }
    }

    // Method to get the reviewer's name, ensuring it's different from the assignee
    public String getReviewer(String ass) {
        while (true) {
            System.out.print("Reviewer: ");
            String s = sc.nextLine().trim();
            // Check if the string is not empty
            if (!s.isEmpty()) {
                if (!s.equalsIgnoreCase(ass)) { // Ensure reviewer is different from assignee
                    return s; // Return the valid string
                } else {
                    System.err.println("Reviewer must be different than assignee");
                }
            } else {
                // Print error if the string is empty
                System.err.println("String cannot be empty, please input again");
            }
        }
    }

    // Method to get a valid date in the format 'dd-MM-yyyy'
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
                System.err.println("Invalid date format, please enter again 'dd-MM-yyyy'"); // Handle parse exception
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

    // Method to validate Requirement Name based on Task Type
    public void validateRequirementName(String requirementName, int taskTypeId) {
        String keyword = "";

        // Determine the keyword based on the task type
        switch (taskTypeId) {
            case 1:
                keyword = "Code";
                break;
            case 2:
                keyword = "Test";
                break;
            case 3:
                keyword = "Design";
                break;
            case 4:
                keyword = "Review";
                break;
            default:
                break;
        }

        // Convert both requirementName and keyword to lowercase for case-insensitive comparison
        if (!requirementName.toLowerCase().contains(keyword.toLowerCase())) {
            throw new IllegalArgumentException("Requirement Name must contain the keyword '"
                    + keyword + "' for Task Type " + taskTypeId);
        }
    }
}
