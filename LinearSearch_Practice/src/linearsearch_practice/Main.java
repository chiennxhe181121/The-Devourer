package linearsearch_practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int arrSize = getInt("Enter number of array: ", 0, Integer.MAX_VALUE);
        int target = getInt("Enter search value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] arr = generateRandomArray(arrSize, arrSize);
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

    // This method creates an array of random numbers
    public static int[] generateRandomArray(int size, int maxRange) {
        int[] arr = new int[size];
        Random rd = new Random();

        // Loop to fill the array with random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(maxRange) + 1;
        }
        return arr;
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void displayArray(int[] arr) {
        System.out.println("The array: " + Arrays.toString(arr));
    }
}
