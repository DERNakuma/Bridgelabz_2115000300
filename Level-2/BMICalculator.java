import java.util.Scanner;
public class BMICalculator {
    public double calculateBMI(double weight, double height) {
        height = height / 100;  
        return weight / (height * height);
    }
    public String determineStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        if (bmi >= 18.5 && bmi <= 24.9) return "Normal";
        if (bmi >= 25.0 && bmi <= 39.9) return "Overweight";
        return "Obese";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BMICalculator calculator = new BMICalculator();
        double[][] data = new double[10][3];  
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.println("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();

            data[i][2] = calculator.calculateBMI(data[i][0], data[i][1]);
            status[i] = calculator.determineStatus(data[i][2]);

            System.out.println("Person " + (i + 1) + " - Weight: " + data[i][0] + " kg, Height: " + data[i][1] + " cm, BMI: " + data[i][2] + ", Status: " + status[i]);
        }
    }
}
