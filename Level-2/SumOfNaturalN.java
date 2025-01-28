import java.util.Scanner;
public class SumOfNaturalN{
    public static int findSumRecursive(int n) {
        if (n == 1) return 1;
        return n + findSumRecursive(n - 1);
    }
    public static int findSumFormula(int n) {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) return;
        int sumRecursive = findSumRecursive(n);
        int sumFormula = findSumFormula(n);
        System.out.println(sumRecursive == sumFormula);
    }
}
