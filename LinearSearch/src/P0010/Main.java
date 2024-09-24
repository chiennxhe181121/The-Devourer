package P0010;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Get the size of the array from user input
        int arrSize = getInt("Enter your number of array: ", 0, Integer.MAX_VALUE);

        // Get the target value to search for from user input
        int target = getInt("Enter search value: ", 1, Integer.MAX_VALUE);

        // Generate a random array based on the size provided by the user
        int[] arr = generateRandomArray(arrSize, arrSize);

        // Display the generated array
        displayArray(arr);
        int index = linearSearch(arr, target);
        if (index != -1) {
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println("Not found " + target + " in this array");
        }
    }

    // Global scanner object to be used for input
    public static Scanner sc = new Scanner(System.in);

    // Method to get an integer with a specific range (min, max)
    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                // Parse user input and trim whitespace
                int result = Integer.parseInt(sc.nextLine().trim());

                // Check if result is within the specified range
                if (result >= min && result <= max) {
                    return result;
                }
                // Display error if input is out of the specified range
                System.err.println("Out of range, your number must be from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                // Handle case where input is not a valid integer
                System.err.println("Wrong format. Please input an integer");
            }
        }
    }

    // Method to generate an array with random values between 1 and maxRange
    public static int[] generateRandomArray(int size, int maxRange) {
        int arr[] = new int[size];
        Random rd = new Random();

        // Populate the array with random values from 1 to maxRange
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(maxRange) + 1;
        }

        return arr;
    }

    // Method to display the array as a string
    public static void displayArray(int[] arr) {
        System.out.println("The array: " + Arrays.toString(arr));
    }

    // Method to search for a target value in the array using linear search
    public static int linearSearch(int arr[], int target) {
        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // If the target is found, return the index
            if (arr[i] == target) {
                return i;
            }
        }
        // Return -1 if the target is not found
        return -1;
    }
}
