import java.util.Scanner;
public class ArrayBMI{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmi = new double[numPersons];
        String[] weightStatus = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.println("Enter details for person " + (i + 1));

            System.out.print("Weight (in kg): ");
            weights[i] = scanner.nextDouble();

            System.out.print("Height (in cm): ");
            heights[i] = scanner.nextDouble();

            double heightInMeters = heights[i] / 100;

            bmi[i] = weights[i] / (heightInMeters * heightInMeters);

            if (bmi[i] < 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi[i] >= 25 && bmi[i] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\nBMI Information:");
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("Height: " + heights[i] + " cm");
            System.out.println("Weight: " + weights[i] + " kg");
            System.out.println("BMI: " + bmi[i]);
            System.out.println("Weight Status: " + weightStatus[i]);
            System.out.println();
        }
    }
}
