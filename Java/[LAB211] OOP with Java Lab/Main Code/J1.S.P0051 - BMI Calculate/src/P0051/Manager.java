package P0051;

public class Manager {

    // Method to display the menu and get user choice
    public static int menu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        int choice = Validation.getInt("Please choice one option: ", 1, 3); // Get user choice
        return choice; // Return the choice
    }

    private static double memory = 0.0; // Memory for calculations

    // Method to perform calculation based on operator and the input number
    public static void normalCalculate(double num, String ope) {
        switch (ope) {
            case "+":
                memory += num; // Add to memory
                break;
            case "-":
                memory -= num; // Subtract from memory
                break;
            case "*":
                memory *= num; // Multiply memory
                break;
            case "/":
                if (num == 0) {
                    // Prevent division by 0
                    System.err.println("Cannot divide by 0. Please enter another number.");
                    num = Validation.getDouble("Enter number: ", Double.NEGATIVE_INFINITY,
                            Double.POSITIVE_INFINITY, "Wrong format. Please input a real number");
                    memory /= num; // Perform division after receiving a valid number
                } else {
                    memory /= num; // Divide memory
                }
                break;
            case "^":
                memory = Math.pow(memory, num); // Power calculation
                break;
        }
    }

    // Method to handle normal calculations
    public static void performNormalCalculate() {
        // Get the first number and store it in memory to begin calculation
        memory = Validation.getDouble("Enter number: ", Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY, "Wrong format. Please input a real number");

        while (true) {
            String ope = Validation.getOperator("Enter Operator: ",
                    "Please input a valid operator (+, -, *, /, ^)"); // Get operator
            if (ope.equals("=")) {
                System.out.println("Result: " + memory); // Print final result
                break; // Exit loop when "=" is entered
            }

            double num = Validation.getDouble("Enter number: ", Double.NEGATIVE_INFINITY,
                    Double.POSITIVE_INFINITY, "Wrong format. Please input a real number");
            normalCalculate(num, ope); // Perform calculation
            // Display the current result stored in memory
            System.out.println("Memory: " + memory);
        }
    }

    // Method to calculate BMI
    public static void calculateBMI() {
        double weight = Validation.getDouble("Enter Weight (kg): ",
                0, 251, "BMI is digit"); // Get weight
        double height = Validation.getDouble("Enter Height (cm): ",
                0, 251, "BMI is digit"); // Get height

        // Calculate BMI using the formula
        double bmi = (weight * 10000) / (height * height); // BMI formula
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
