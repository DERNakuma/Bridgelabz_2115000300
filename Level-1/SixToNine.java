import java.util.Scanner;
public class SixToNine {
    public static void main(String[] args) {
        int[] multiplicationResult = new int[4];
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }
    }
}
