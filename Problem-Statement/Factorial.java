import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        int number = takeInput("Enter a number: ");
        int result = calculateFactorial(number);
        displayResult(result);
    }

    public static int takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextInt();
    }

    public static int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }

    public static void displayResult(int result) {
        System.out.println("The factorial is: " + result);
    }
}
