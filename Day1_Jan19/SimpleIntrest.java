import java.util.Scanner;
public class SimpleIntrest {
       public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter principal");
        int p=sc.nextInt();
        System.out.println("Enter time ");
        int t=sc.nextInt();
        System.out.println("Enter rate of intrest ");
         float r=sc.nextFloat();
        float si=(p*r*t)/100;

        System.out.println("Simple interest:"+ si );
       }
}
