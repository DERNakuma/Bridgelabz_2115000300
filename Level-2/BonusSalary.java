import java.util.Scanner;

public class BonusSalary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter salary");
        float salary=sc.nextFloat();
        
        System.out.println("Enter bonus");
        float bonus=sc.nextFloat();

        float totalSalary=  salary+bonus; 
        System.out.println(" The salary is INR "+ salary+" and bonus is INR "+ bonus+". Hence Total Income is INR  "+totalSalary+"\r\n");
    }
}
