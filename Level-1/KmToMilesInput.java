import java.util.*;
public class  KmToMilesUserInput{
        public static void main(String arg[]){
	System.out.print("Enter distance in Km");
	Scanner sc=new Scanner(System.in);
        double distanceKm=sc.nextDouble();

        double distanceMiles=distanceKm*0.621371;
        System.out.println("The total miles is "+distanceMiles+" the given " +distanceKm+"km");
        }
}
