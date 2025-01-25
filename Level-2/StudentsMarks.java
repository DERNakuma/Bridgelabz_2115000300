import java.util.Scanner;
public class StudentsMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] marks = new double[n][3];
        double[] percentages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                do {
                    System.out.print("Enter mark for subject " + (j + 1) + ": ");
                    marks[i][j] = scanner.nextDouble();
                } while (marks[i][j] < 0);
            }

            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = total / 3;

            if (percentages[i] > 80) grades[i] = "A";
            else if (percentages[i] >= 70) grades[i] = "B";
            else if (percentages[i] >= 60) grades[i] = "C";
            else if (percentages[i] >= 50) grades[i] = "D";
            else if (percentages[i] >= 40) grades[i] = "E";
            else grades[i] = "F";
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Grade " + grades[i]);
        }
    }
}
