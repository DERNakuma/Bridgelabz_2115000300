import java.util.Scanner;
public class Product {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter price of product");
        float price=sc.nextFloat();
        System.out.println("Enter quantity of product");
        int quantity=sc.nextInt();
        float totalprice=price*quantity;
	System.out.print("The total purchase price is INR "+ totalprice+ " if the quantity "+ quantity +"  and unit price is INR "+ price);
    }
}
