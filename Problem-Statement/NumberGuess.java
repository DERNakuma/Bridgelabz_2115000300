import java.util.Random;
import java.util.Scanner;
public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100, and I will try to guess it.");
        String feedback = "";
        int lowerBound = 1;
        int upperBound = 100;
        while (!feedback.equals("correct")) {
            int guess = generateGuess(lowerBound, upperBound);
            System.out.println("Is the number " + guess + "? (high/low/correct)");
            feedback = sc.nextLine().toLowerCase();
            if (feedback.equals("high")) {
                upperBound = guess - 1;
            } else if (feedback.equals("low")) {
                lowerBound = guess + 1;
            }
        }
        System.out.println("Yay! I guessed the correct number.");
    }

    public static int generateGuess(int lowerBound, int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
