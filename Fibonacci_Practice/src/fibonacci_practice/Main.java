package fibonacci_practice;

import java.util.HashMap;

public class Main {

    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci: ");
        for (int i = 0; i < 45; i++) {
            System.out.print(calculateFibinacci(i) + " ");
        }
    }

    public static int calculateFibinacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            int result = calculateFibinacci(n - 1) + calculateFibinacci(n - 2);
            memo.put(n, result);
            return result;
        }
    }
}
