import java.util.Random;
public class StudentScorecard {
    public static void main(String[] args) {
        Random rand = new Random();
        
        System.out.print("Enter number of students: ");
        int numStudents = new java.util.Scanner(System.in).nextInt();
        
        int[][] scores = generateScores(numStudents, rand);
        double[][] result = calculateResults(scores);
        displayScorecard(result);
    }
    
    public static int[][] generateScores(int numStudents, Random rand) {
        int[][] scores = new int[numStudents][3];
        
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 50 + rand.nextInt(51);
            scores[i][1] = 50 + rand.nextInt(51);
            scores[i][2] = 50 + rand.nextInt(51);
        }
        
        return scores;
    }
    
    public static double[][] calculateResults(int[][] scores) {
        double[][] result = new double[scores.length][5];
        
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            
            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
            result[i][3] = calculateGrade(percentage);
        }
        
        return result;
    }
    
    public static char calculateGrade(double percentage) {
        if (percentage >= 80) return 'A';
        if (percentage >= 70) return 'B';
        if (percentage >= 60) return 'C';
        if (percentage >= 50) return 'D';
        if (percentage >= 40) return 'E';
        return 'R';
    }
    
    public static void displayScorecard(double[][] result) {
        System.out.println("Scorecard:");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("----------------------------------------------------------------------------------");
        
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d\t", i + 1);
            System.out.printf("%d\t\t%d\t\t%d\t\t", result[i][0], result[i][1], result[i][2]);
            System.out.printf("%.2f\t%.2f\t%.2f\t%c\n", result[i][0], result[i][1], result[i][2], result[i][3]);
        }
    }
}
