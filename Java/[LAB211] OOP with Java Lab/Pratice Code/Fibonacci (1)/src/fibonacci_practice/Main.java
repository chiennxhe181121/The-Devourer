package fibonacci_practice;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;

public class Main {

    public static HashMap<Integer, Integer> fiboCache = new HashMap<>();

    public static void main(String[] args) {
        int size = Validation.getInt("Enter your number of sequence fibonacci: ", 0, Integer.MAX_VALUE);
        displayArray(size);
    }

    public static int f(int n) {
        if (n <= 1) {
            return n; // return basic cases
        } else if (fiboCache.containsKey(n)) {
            return fiboCache.get(n);
        } else {
            int result = f(n - 1) + f(n - 2);
            fiboCache.put(n, result);
            return result;
        }
    }

    public static void displayArray(int n) {
        System.out.println("The " + n + " sequence fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(f(i));
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
}
