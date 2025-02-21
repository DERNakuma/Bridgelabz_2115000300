import java.util.Scanner;
public class MultipleCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        try {
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
