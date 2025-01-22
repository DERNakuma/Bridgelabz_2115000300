import java.util.Scanner;
public class HandShake {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of students");
        int numberOfStudents=sc.nextInt();
        int totalHandshake= (numberOfStudents * (numberOfStudents - 1))/2;
        System.out.println("The number of possible handshakes "+totalHandshake);
    }
}
