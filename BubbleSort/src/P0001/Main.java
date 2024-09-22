package P0001;

public class Main {

    public static void main(String[] args) {
        // Get the size of the array from the user
        int arrSize = InputValidator.getInt("Enter number of array: ", 0, Integer.MAX_VALUE);
        
        // Generate a random array with the given size
        int[] arr = BubbleSort.generateRandomArray(arrSize, arrSize);
        
        // Display the array before and after sorting
        BubbleSort.displayArray(arr);
    }
}
