package P0009;

/**
 *
 * @author ADMIN
 */
public class Main {
    // Hằng số để tính toán modulo
    private static final long MOD = 1000000007;

    // Hàm tính số Fibonacci bằng đệ quy
    public static long fibonacciRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)) % MOD;
    }

    // Hàm chính
    public static void main(String[] args) {
        // In ra 45 số Fibonacci đầu tiên
        System.out.println("45 số Fibonacci đầu tiên là:");
        for (int i = 0; i <= 45; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
    }
}
