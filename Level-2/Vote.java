import java.util.Scanner;
public class Vote {
    public boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vote checker = new Vote();
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            ages[i] = sc.nextInt();
            System.out.println(checker.canStudentVote(ages[i]));
        }
    }
}
