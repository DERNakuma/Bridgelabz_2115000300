import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight in kg: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height in cm: ");
        double heightCm = scanner.nextDouble();

        double heightMeters = heightCm / 100;
        double bmi = weight / (heightMeters * heightMeters);
        System.out.printf("Your BMI is: %.2f\n", bmi);
        if (bmi <= 18.4) {
            System.out.println("You are underweight.");
        } else if (bmi <= 24.9) {
            System.out.println("You have a normal weight.");
        } else if (bmi <= 39.9) {
            System.out.println("You are overweight.");
        } else {
            System.out.println("You are obese.");
        }

        scanner.close();
    }
}
