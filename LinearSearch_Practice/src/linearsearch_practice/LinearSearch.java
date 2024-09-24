package linearsearch_practice;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class LinearSearch {

    public static int[] generateRandomArray(int size, int maxRange) {
        int arr[] = new int[size];
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(maxRange) + 1;
        }
        return arr;
    }

    public static int linearSearch(int arr[], int target) {
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
