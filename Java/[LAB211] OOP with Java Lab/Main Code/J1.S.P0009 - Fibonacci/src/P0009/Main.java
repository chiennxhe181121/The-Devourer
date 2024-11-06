package P0009;

import java.util.HashMap;

public class Main {

    // Use HashMap to store pre-calculated Fibonacci values
    private static HashMap<Integer, Integer> fibonacciCache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci: ");
        for (int i = 0; i < 45; i++) {
            System.out.print(calculateFibonacci(i));
            if (i < 44) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
    
    // Method to calculate Fibonacci using memoization
    public static int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        // Check if the value has already been calculated
        if (fibonacciCache.containsKey(n)) {
            return fibonacciCache.get(n);
        }

        // If not, calculate the value and store it in the cache
        int result = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        fibonacciCache.put(n, result);
        return result;
    }
}
