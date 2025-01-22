
import java.util.*;
public class UniversityFeesUserInput{
    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter Fees");
	double fees=sc.nextDouble();
	 System.out.print("Enter Discount");
        double discountPercent=sc.nextDouble();
        double discount,feesAfterDiscount;
        discount=fees*discountPercent/100;
        feesAfterDiscount=fees-discount;
        System.out.println("The discount amount is INR "+ discount+ "  and final discounted fee is INR "+feesAfterDiscount);


    }
}
 
