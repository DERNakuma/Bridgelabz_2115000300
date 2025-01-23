import java.util.*;
public class PrimeNumber{
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int number = scanner.nextInt();

        boolean isPrime = true;

        if(number<=1) isPrime=false;
        else{
            for (int i=2; i< number ; i++){
                if (number%i==0){
                    isPrime=false;
                    break;
                }
            }
        }
        if (isPrime) System.out.println(number+" Number is prime.");
        else System.out.println(number+ " Number is not prime!!");
        
    }
}

