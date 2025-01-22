import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter city from travelling started");
        String fromCity=sc.next();
        System.out.println("Enter city via travelling");
        String viaCity=sc.next();
        System.out.println("Enter city to travelling");
        String toCity=sc.next();
        System.out.println("Enter distance of via city in km");
        float fromTovia=sc.nextFloat();
        System.out.println("Enter distance of final city in km");
        float viaToFinal=sc.nextFloat();
        System.out.println("Enter time to reach to via city in minutes");
        int timeTovia=sc.nextInt();
        System.out.println("Enter time to reach to final city in minutes");
        int timeToFinal=sc.nextInt();

        float totalDistancekm=fromTovia+viaToFinal;
        float totalDistancemiles=(float)(totalDistancekm*0.621371);
        int totalTime=timeTovia+timeToFinal;

        System.out.println("The Total Distance travelled by " + name + " from " + 
                         fromCity + " to " + toCity + " via " + viaCity +
                         " is " + totalDistancemiles + " miles and " +
                         "the Total Time taken is " + totalTime + " minutes");

    }
}
