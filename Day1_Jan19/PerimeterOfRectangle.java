import java.util.Scanner;
public class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length");
        float l=sc.nextFloat();
        System.out.println("Enter breadth");
        float b=sc.nextFloat();
        float perimeter=2*(l+b);

        System.out.println("Perimeter of Rectangle is "+ perimeter );
    }
}

