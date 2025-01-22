import java.util.Scanner;
public class PerimeterSquare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter  side of square");
        float side=sc.nextFloat();
        double perimeter=4*side;
        System.out.println("The length of the side is "+side + " whose perimeter is " + perimeter);
    }
}
