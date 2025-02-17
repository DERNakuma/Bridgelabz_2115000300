public class RecVsIt {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int previous = 0, current = 1, next;
        for (int i = 2; i <= n; i++) {
            next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static void main(String[] args) {
        int[] testSizes = {10, 30, 40};

        for (int size : testSizes) {
            long startTime = System.nanoTime();
            int recursiveResult = fibonacciRecursive(size);
            long endTime = System.nanoTime();
            long recursiveTime = endTime - startTime;
            System.out.println("Size: " + size);
            System.out.println("Recursive: " + recursiveTime / 1000000.0 + " ms");

            startTime = System.nanoTime();
            int iterativeResult = fibonacciIterative(size);
            endTime = System.nanoTime();
            long iterativeTime = endTime - startTime;
            System.out.println("Iterative: " + iterativeTime / 1000000.0 + " ms");
        }
    }
}
