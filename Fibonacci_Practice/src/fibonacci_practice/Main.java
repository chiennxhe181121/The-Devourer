package fibonacci_practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci: ");
        displayArray(45);
    }

    public static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
    
    public static void displayArray(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(getFibonacci(i) + " ");
        }
    }
}
