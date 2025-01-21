import java.util.Scanner;
public class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter base");
        float b=sc.nextFloat();
        System.out.println("Enter exponent");
        float e=sc.nextFloat();
        double value=Math.pow(b, e);

        System.out.println("Power "+ value );
    }
}

