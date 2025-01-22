import java.util.Scanner;

public class AreaTriangle {
    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter  height of triangle");
	float height=sc.nextFloat();
    System.out.print("Enter  base of triangle");
	float base=sc.nextFloat();
    double area=(double)1/2*base*height;
        System.out.println("The area of triangle with height"+height+" and base "+base+" is "+area); 
                        

    }
}
