import java.util.*;
public class Grade{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        float maths;
        float physics;
        float chemistry;
        float percentage;
        float total_marks;
        System.out.println("Enter the number of Maths:");
        maths = scanner.nextInt();
        System.out.println("Enter the number of Physics:");
        physics =scanner.nextInt();
        System.out.println("Enter the number of Chemistry:");
        chemistry = scanner.nextInt();
        total_marks= maths+physics+chemistry;
        System.out.println("Total marks are :"+total_marks);
        percentage = (total_marks/300)*100;
        System.out.println("Your percentage is :"+percentage);
        if (percentage>=80) System.out.println("Grade is A !!");
        else if (percentage>=70 && percentage<=79) System.out.println("Grade is B !!");
        else if(percentage>=60 && percentage<=69) System.out.println("Grade is C !!");
        else if (percentage>=50 && percentage<=59) System.out.println("Grade is D !! ");
        else if (percentage>=40 && percentage<49) System.out.println("Grade is E !!");
        else System.out.println("Grade is R !!");

 


    }
}