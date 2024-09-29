package P0051;

public class Manager {

    // Method to display the menu and get user choice
    public static int menu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        int choice = Validation.getInt("Please choice one option:", 1, 3); // Get user choice
        return choice; // Return the choice
    }

    private static double memory = 0.0; // Memory for calculations
    private static boolean isFirstInput = true; // Flag to check if it's the first input

    // Method to perform calculations using the normal calculator
    public static void performCalculation() {
        String operator;

        while (true) {
            double number;
            if (isFirstInput) {
                number = Validation.getDouble("Enter number: ", Double.NEGATIVE_INFINITY,
                        Double.POSITIVE_INFINITY, "Wrong format. Please input a real number");
                memory = number; // Store the first input in memory
                isFirstInput = false; // Set the flag to false after the first input
            } else {
                number = memory; // Use the previous result as the current number
            }

            operator = Validation.getOperator("Enter Operator: "); // Get the operator

            if (operator.equals("=")) {
                System.out.println("Result: " + memory); // Display the result
                break; // Exit the calculation loop
            }

            double nextNumber = Validation.getDouble("Enter number: ", Double.NEGATIVE_INFINITY,
                    Double.POSITIVE_INFINITY, "Wrong format. Please input a real number");

            // Perform the operation based on the operator
            switch (operator) {
                case "+":
                    memory += nextNumber; // Addition
                    break;
                case "-":
                    memory -= nextNumber; // Subtraction
                    break;
                case "*":
                    memory *= nextNumber; // Multiplication
                    break;
                case "/":
                    if (nextNumber != 0) {
                        memory /= nextNumber; // Division
                    } else {
                        System.err.println("Cannot divide by zero"); // Handle division by zero
                    }
                    break;
                case "^":
                    memory = Math.pow(memory, nextNumber); // Exponentiation
                    break;
                default:
                    System.err.println("Please input (+, -, *, /, ^) or '=' to see the final result");
                    continue; // Continue to the next iteration if operator is invalid
            }

            System.out.println("Memory: " + memory); // Display current memory value
        }
    }

    // Method to calculate BMI
    public static void calculateBMI() {
        double weight = Validation.getDouble("Enter Weight (kg): ", 0, Double.POSITIVE_INFINITY, "BMI is digit");
        double height = Validation.getDouble("Enter Height (cm): ", 0, Double.POSITIVE_INFINITY, "BMI is digit");

        // Calculate BMI using the formula
        double bmi = (weight * 10000) / (height * height);
        System.out.printf("BMI Number: %.2f\n", bmi); // Display BMI value
        System.out.println("BMI Status: " + getBMIStatus(bmi)); // Display BMI status
    }

    // Method to determine BMI status based on the calculated BMI
    private static String getBMIStatus(double bmi) {
        if (bmi < 19) {
            return "UNDER-STANDARD"; // Underweight
        } else if (bmi < 25) {
            return "STANDARD"; // Normal weight
        } else if (bmi < 30) {
            return "OVERWEIGHT"; // Overweight
        } else if (bmi < 40) {
            return "FAT - should lose weight"; // Obesity class I
        } else {
            return "VERY FAT - should lose weight immediately"; // Obesity class II and above
        }
    }
}
