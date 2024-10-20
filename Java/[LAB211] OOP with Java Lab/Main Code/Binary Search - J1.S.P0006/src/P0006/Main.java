package P0006;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int arrSize = getInt("Enter number of array: ", 0, Integer.MAX_VALUE);
        int target = getInt("Enter search value: ", 1, Integer.MAX_VALUE);
        int[] arr = generateRandomArray(arrSize, arrSize);
        displayArray(arr);
        int index = binarySearch(arr, target);
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
            System.out.println(msg);
            try {
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
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1, middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
