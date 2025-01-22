import java.util.Scanner;
public class IntOperation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter three numbers");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        System.out.println("a + b *c:"+(a + b *c));
        System.out.println("a * b + c:"+(a * b + c));
        System.out.println(" c + a / b:"+( c + a / b));
        System.out.println("a % b + c:"+(a % b + c));
    }
}
