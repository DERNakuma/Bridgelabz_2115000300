import java.util.Scanner;

public class Calsius {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter temperature in celsius");
        int celsius=sc.nextInt();
        int fahr=(celsius*9/5)+32;

        System.out.println("Temperature in fahrenheit is "+ fahr);
    }

}
