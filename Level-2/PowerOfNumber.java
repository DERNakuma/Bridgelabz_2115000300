import java.util.Scanner;
public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();
        int result = 1;

        for (int i = 1; i <= power; i++) {
            result = result * number;
        }
        System.out.println(number + " raised to the power " + power + " is: " + result);
    }
}
