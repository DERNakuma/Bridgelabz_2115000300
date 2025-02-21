import java.util.Scanner;
public class Nested {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};
        try {
            int index = scanner.nextInt();
            try {
                int divisor = scanner.nextInt();
                System.out.println(arr[index] / divisor);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}
