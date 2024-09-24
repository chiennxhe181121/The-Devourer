package linearsearch_practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int arraySize = Validator.getInt("Enter number of array:", 0, Integer.MAX_VALUE);
        int target = Validator.getInt("Enter search value: ", 0, Integer.MAX_VALUE);
        int arr[] = LinearSearch.generateRandomArray(arraySize, arraySize);
        LinearSearch.displayArray(arr);
        int index = LinearSearch.linearSearch(arr, target);
        if (index != -1) {
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println("Not found " + target + " in this array");
        }
    }
}
