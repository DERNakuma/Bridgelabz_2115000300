import java.util.Scanner;

public class TemperaturConversionFahrenheit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter temperature in celsius");
        float celsius=sc.nextFloat();
        float fahr=  (celsius*9/5) + 32;
        System.out.println("The "+celsius+" celsius is "+fahr+" fahrenheit");
    }
}
