import java.util.Scanner;
public class Handshakes {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        int handshakes = calculateHandshakes(students);
        System.out.println(handshakes);
    }
}