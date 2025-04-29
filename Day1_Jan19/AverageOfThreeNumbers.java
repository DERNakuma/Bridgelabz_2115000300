import java.util.Scanner;
public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter three numbers ");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();
        float avg=(n1+n2+n3)/3;
        System.out.println("Average is "+avg);
    }
}
