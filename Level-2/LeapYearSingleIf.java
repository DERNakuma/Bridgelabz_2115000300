import java.util.*;
public class LeapYearSingleIf{
    public static void main (String[] args){
    Scanner scanner =new Scanner(System.in);
    System.out.println("Enter the year to be checked:");
    int year = scanner.nextInt();
    if( (year % 4==0 && year%100!=0) || year%400==0){
        System.out.println(year+" is a leap year.");
    }
    else{
        System.out.println(year+" is not a leap year.");
    }

    }
}