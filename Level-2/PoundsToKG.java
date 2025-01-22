import java.util.Scanner;

public class PoundsToKG {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter weight in pounds");
        float pounds=sc.nextFloat();
        float kg=(float)(pounds/2.2);
        System.out.println("The weight of the person in pound is "+pounds+" and in kg is "+kg);
    }   
}