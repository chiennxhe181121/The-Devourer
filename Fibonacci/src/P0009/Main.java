package P0009;

/**
 *
 * @author ADMIN
 */
import java.util.HashMap;

public class Main {

    // HashMap to store previously computed Fibonacci numbers
    private static HashMap<Integer, Long> memo = new HashMap<>();

    // Recursive function to calculate Fibonacci numbers with memoization
    public static long fibonacci(int n) {
        // Check if the value is already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // Base cases
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } 
        
        // Recursive case with memoization
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result); // Store the computed value
        return result;
    }

    // Main function to display the first 45 Fibonacci numbers
    public static void main(String[] args) {
        System.out.println("The 45 sequence Fibonacci:");
        for (int i = 0; i < 45; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}


