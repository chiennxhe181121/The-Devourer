package caculteapplication;

import java.util.Scanner;

public class CaculateApplication {

    private static final Scanner input = new Scanner(System.in);

    // Method to validate integer input
    public int validateInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(input.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Input needs to be a positive integer. Please try again.");
            }
        }
    }

    // Method to validate double input
    public double validateInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(input.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Input needs to be a double type. Please try again.");
            }
        }
    }

    public double validateInputDoubleBMI() {
        while (true) {
            try {
                double result = Double.parseDouble(input.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Input needs to be a double type. Please try again.");
            }
        }
    }

    // Method to check valid operator
    public String checkInputOperator() {
        System.out.println("Please input operator (+, -, *, /, ^, =):");
        while (true) {
            String operator = input.nextLine().trim();
            if (operator.equals("+") || operator.equals("-")
                    || operator.equals("*") || operator.equals("/")
                    || operator.equals("^") || operator.equals("=")) {
                return operator;
            } else {
                System.out.println("Invalid operator! Please enter one of the following: +, -, *, /, ^, =.");
            }
        }
    }

    // Method to perform the normal calculator function
    public double calculate(double a, String operator, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException();
                } else {
                    return a / b;
                }
            case "^":
                return Math.pow(a, b);
            default:
                return 0;

        }
    }

    // Method to handle the normal calculator operation
    public void calculateNormal() {
        System.out.print("Enter Number: ");
        double memory = validateInputDouble();

        while (true) {
            String operator = checkInputOperator();
            if (operator.equals("=")) {
                System.out.println("Memory: " + memory);
                break;
            }
            double number;
            while (true) {
                System.out.print("Enter Number: ");
                number = validateInputDouble();

                if (operator.equals("/") && number == 0) {
                    System.out.println("Can not div 0, please Agian");
                } else {
                    break;
                }
            }
            try {
                memory = calculate(memory, operator, number);
                System.out.println("Memory: " + memory);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Method to calculate BMI
    public void calculateBMI() {
        System.out.print("Enter Weight(kg):  ");
        double weight = validateInputDoubleBMI();
        System.out.print("Enter Height(cm):  ");
        double height = validateInputDoubleBMI();

        double bmi = 10000 * weight / (height * height);

        System.out.printf("BMI is %.2f", bmi);
        System.out.println("");

        if (bmi < 19) {
            System.out.println("BMI Status: Under-standard");
        } else if (bmi >= 19 && bmi <= 25) {
            System.out.println("BMI Status: Standard");
        } else if (bmi > 25 && bmi <= 30) {
            System.out.println("BMI Status: Overweight");
        } else if (bmi > 30 && bmi <= 40) {
            System.out.println("BMI Status: Fat - should lose weight");
        } else {
            System.out.println("BMI Status: Very fat - should lose weight immediately");
        }
    }
}
