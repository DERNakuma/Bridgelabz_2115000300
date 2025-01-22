import java.util.Scanner;

public class DivideChocolates {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of children");
        int noOfChildren=sc.nextInt();
        
        System.out.println("Enter number of chocolates");
        int noOfChcolates=sc.nextInt();
        int numberOfChocolatesPerChildren=noOfChcolates/noOfChildren;
        int remainingChoclates=noOfChcolates%noOfChildren;

        System.out.println("The number of chocolates each child gets is "+ numberOfChocolatesPerChildren+" and the number of remaining chocolates are "+remainingChoclates);
    }
}