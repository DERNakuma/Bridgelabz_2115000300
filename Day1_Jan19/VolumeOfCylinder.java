import java.util.Scanner;

public class VolumeOfCylinder {
    public static void main(String[] args) {
        float pi=3.14f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter radius of cylinder");
        int r=sc.nextInt();
        System.out.println("Enter height of cylinder");
        int h=sc.nextInt();
        float volume=pi*r*r*h;

        System.out.println("Area of circle is "+ volume );
    }
}
