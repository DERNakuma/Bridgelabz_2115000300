import java.util.Random;
public class ZaraBonus {
    public static void main(String[] args) {
        Random rand = new Random();
        double[][] employeeData = new double[10][2];
        double[][] updatedData = new double[10][3];
        
        for (int i = 0; i < 10; i++) {
            employeeData[i] = determineSalaryAndService(rand);
        }
        
        updatedData = calculateNewSalaryAndBonus(employeeData, rand);
        displaySummary(employeeData, updatedData);
    }
    
    public static double[] determineSalaryAndService(Random rand) {
        double salary = 10000 + rand.nextInt(90000); 
        double yearsOfService = 1 + rand.nextInt(30); 
        return new double[] { salary, yearsOfService };
    }
    
    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData, Random rand) {
        double[][] updatedData = new double[10][3];
        
        for (int i = 0; i < 10; i++) {
            double salary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonus = 0;
            
            if (yearsOfService > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }
            
            double newSalary = salary + bonus;
            updatedData[i][0] = salary; 
            updatedData[i][1] = newSalary; 
            updatedData[i][2] = bonus; 
        }
        
        return updatedData;
    }
    
    public static void displaySummary(double[][] employeeData, double[][] updatedData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        
        System.out.println("Employee | Old Salary | New Salary | Bonus");
        System.out.println("-----------------------------------------");
        
        for (int i = 0; i < 10; i++) {
            double oldSalary = updatedData[i][0];
            double newSalary = updatedData[i][1];
            double bonus = updatedData[i][2];
            
            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;
            
            System.out.printf("%8d | %.2f | %.2f | %.2f%n", i + 1, oldSalary, newSalary, bonus);
        }
        
        System.out.println("-----------------------------------------");
        System.out.printf("Total | %.2f | %.2f | %.2f%n", totalOldSalary, totalNewSalary, totalBonus);
    }
}
