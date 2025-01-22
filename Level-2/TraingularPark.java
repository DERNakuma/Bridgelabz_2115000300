import java.util.Scanner;

public class TraingularPark {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter sides of triangle in meters");
        float side1=sc.nextFloat();
        float side2=sc.nextFloat();
        float side3=sc.nextFloat();

        float perimeterTriangle=side1+side2+side3;
        float totalDistance=5000;
        int numberOfRounds=(int)(totalDistance/perimeterTriangle);
        System.out.println("The total number of rounds the athlete will run is "+numberOfRounds + " to complete 5 km");
    }
}
