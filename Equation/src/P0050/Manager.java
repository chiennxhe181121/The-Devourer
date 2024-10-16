package P0050;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    // Method to display the menu and get user choice
    public static int menu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        int choice = Validation.getInt("Please choose one option: ", 1, 3); // Get user choice
        System.out.println("");
        return choice; // Return the choice
    }

    // Method to calculate and display the result of a superlative equation (linear equation)
    public static void calculateSuperlativeEquation() {
        List<Float> list = new ArrayList<>();
        float coeA = Validation.getFloat("Enter A: ", Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY); // Coefficient A
        float coeB = Validation.getFloat("Enter B: ", Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY); // Coefficient B
        list.add(coeA);
        list.add(coeB);

        if (coeA == 0 && coeB != 0) {
            System.err.println("The equation has no solution");
        } else if (coeA == 0 && coeB == 0) {
            System.err.println("The equation has many solutions");
        } else {
            float x = -coeB / coeA;
            if (x == 0) {
                System.out.println("Solution: x = 0");
            } else {
                System.out.printf("Solution: x = %.3f\n", x);
            }
            list.add(x);
        }

        // Check if the numbers in the list are odd, even, or perfect squares
        System.out.print("Number is Odd: ");
        checkOddNumber(list);
        System.out.print("Number is Even: ");
        checkEvenNumber(list);
        System.out.print("Number is Perfect Square: ");
        checkPerfectSquareNumber(list);
        System.out.println("");
    }

    // Method to calculate and display the result of a quadratic equation
    public static void calculateQuadraticEquation() {
        List<Float> list = new ArrayList<>();
        float coeA = Validation.getFloat("Enter A: ", Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY); // Coefficient A
        float coeB = Validation.getFloat("Enter B: ", Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY); // Coefficient B
        float coeC = Validation.getFloat("Enter C: ", Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY); // Coefficient C
        list.add(coeA);
        list.add(coeB);
        list.add(coeC);

        if (coeA == 0) {
            System.err.println("The equation is a superlative equation");
            if (coeB == 0 && coeC != 0) {
                System.err.println("The equation has no solution");
            } else if (coeB == 0 && coeC == 0) {
                System.err.println("The equation has many solutions");
            } else {
                float x = -coeC / coeB;
                if (x == 0) {
                    System.out.println("Solution: x = 0");
                } else {
                    System.out.printf("Solution: x = %.3f\n", x);
                }
                list.add(x);
            }
        } else {
            float delta = (float) (Math.pow(coeB, 2) - (4 * coeA * coeC)); // Calculate delta (discriminant)
            if (delta < 0) {
                System.err.println("The equation has no solution");
            } else if (delta == 0) {
                System.err.println("The equation has a unique solution");
                float x = (-coeB) / (2 * coeA); // Unique solution when delta equals 0
                System.out.printf("Solution: x = %.3f\n", x);
                list.add(x);
            } else {
                System.err.println("The equation has two distinct solutions");
                float x1 = (float) (((-coeB) + Math.sqrt(delta)) / (2 * coeA)); // First solution
                float x2 = (float) (((-coeB) - Math.sqrt(delta)) / (2 * coeA)); // Second solution
                System.out.printf("Solution: x1 = %.3f and x2 = %.3f\n", x1, x2);
                list.add(x1);
                list.add(x2);
            }
        }

        // Check if the numbers in the list are odd, even, or perfect squares
        System.out.print("Number is Odd: ");
        checkOddNumber(list);
        System.out.print("Number is Even: ");
        checkEvenNumber(list);
        System.out.print("Number is Perfect Square: ");
        checkPerfectSquareNumber(list);
        System.out.println("");
    }

    // Method to check for odd numbers in the list
    public static void checkOddNumber(List<Float> list) {
        List<Float> oddNumbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) != 0) && (list.get(i) % 2 != 0)) {
                oddNumbers.add(list.get(i));
            }
        }
        System.out.println(oddNumbers); // Print odd numbers
    }

    // Method to check for even numbers in the list
    public static void checkEvenNumber(List<Float> list) {
        List<Float> evenNumbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) != 0) && (list.get(i) % 2 == 0)) {
                evenNumbers.add(list.get(i));
            }
        }
        System.out.println(evenNumbers); // Print even numbers
    }

    // Method to check for perfect square numbers in the list
    public static void checkPerfectSquareNumber(List<Float> list) {
        List<Float> perfectSquareNumbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int temp = (int) Math.sqrt(list.get(i)); // Get the integer square root
            if ((list.get(i) != 0) && (list.get(i) == Math.pow(temp, 2))) {
                perfectSquareNumbers.add(list.get(i));
            }
        }
        System.out.println(perfectSquareNumbers); // Print perfect square numbers
    }
}
