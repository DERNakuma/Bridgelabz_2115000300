import java.util.Scanner;
public class BMITwoD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int number = scanner.nextInt();
        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for person " + (i + 1));
            double weight;
            do {
                System.out.print("Weight (in kg): ");
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Please enter a positive weight.");
                }
            } while (weight <= 0);

            double height;
            do {
                System.out.print("Height (in cm): ");
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Please enter a positive height.");
                }
            } while (height <= 0);

            personData[i][0] = weight;
            personData[i][1] = height;

            double heightInMeters = height / 100;  
            personData[i][2] = weight / (heightInMeters * heightInMeters);

            if (personData[i][2] < 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] >= 25 && personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\nBMI Information:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("Height: " + personData[i][1] + " cm");
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Weight Status: " + weightStatus[i]);
            System.out.println();
        }
    }
}
