import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        System.out.println("Enter distance in kilometers");
        Scanner sc=new Scanner(System.in);
        float d=sc.nextFloat();
        double miles=d*0.621371;
        System.out.println("Distance in miles "+ miles);
    }
}
