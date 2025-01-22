import java.util.Scanner;
public class DistanceYard {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter distance in feet");
	    float feet= sc.nextFloat();
        float yards = feet / 3;
        float miles = yards / 1760;
        System.out.print("The disatnce "+feet+" in feet "+ " in yards is "+yards+" and in miles is "+miles);
    }
}
