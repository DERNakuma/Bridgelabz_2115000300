import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalaries = new double[10];
        
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary and years of service for employee " + (i + 1));

            while (true) {
                System.out.print("Salary: ");
                salaries[i] = scanner.nextDouble();

                System.out.print("Years of Service: ");
                yearsOfService[i] = scanner.nextDouble();

                if (salaries[i] <= 0 || yearsOfService[i] < 0) {
                    System.out.println("Invalid input. Please enter valid values.");
                    i--; 
                    break;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salaries[i] * 0.05; 
            } else {
                bonus[i] = salaries[i] * 0.02;
            }

            newSalaries[i] = salaries[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total Bonus payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
