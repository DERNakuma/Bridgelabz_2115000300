import java.util.Scanner;

public class SimpleIntrest {
    
       public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter principal");
        int principal=sc.nextInt();
        System.out.println("Enter time ");
        int time=sc.nextInt();
        System.out.println("Enter rate of intrest ");
        float rate=sc.nextFloat();
        float si=(principal*rate*time)/100;

        System.out.println("The Simple Interest is "+si+" for Principal "+principal+", Rate of Interest "+rate+"   and Time " +time);
       }
}