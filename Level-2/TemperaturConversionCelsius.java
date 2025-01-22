import java.util.Scanner;

public class TemperaturConversionCelsius {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter temperature in Fahrenheit");
        float fahrenheit=sc.nextFloat();
        float celsius=  (fahrenheit-32)* 5/9; 
        System.out.println("The "+fahrenheit+" fahrenheit is "+celsius+" celsius");
    }
}
