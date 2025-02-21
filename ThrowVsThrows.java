import java.util.Scanner;
public class ThrowVsThrows {
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            double amount = scanner.nextDouble();
            double rate = scanner.nextDouble();
            int years = scanner.nextInt();
            System.out.println("Interest: " + calculateInterest(amount, rate, years));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
