package P0001;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

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

    // This method sorts the array using Bubble Sort
    public static void sortByBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false; // Keeps track of whether any numbers were swapped
            
            // Loop to compare numbers next to each other
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if the current number is bigger than the next one
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Mark that a swap happened
                }
            }
            
            // If no swaps happened, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // This method displays the array before and after sorting
    public static void displayArray(int[] arr) {
        System.out.println("Unsorted array: " + Arrays.toString(arr)); // Show unsorted array
        sortByBubbleSort(arr); // Sort the array
        System.out.println("Sorted array: " + Arrays.toString(arr)); // Show sorted array
    }
}
