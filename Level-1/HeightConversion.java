
import java.util.*;
public class  HeightConversion{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter Height in cm");
	double heightcm=sc.nextFloat();
	double heightInch=heightcm/2.54;
	double  heightFoot=heightInch/12;
	double inch=heightInch%12;
	System.out.println("Your Height in cm is "+ heightcm + " while in feet is "+heightFoot+" and inches is "+ inch);
	
	}
}
 
