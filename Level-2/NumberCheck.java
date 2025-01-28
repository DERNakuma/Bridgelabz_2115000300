import java.util.Scanner;
public class NumberCheck {
    public boolean isPositive(int number) {
        return number >= 0;
    }

    public String isEven(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    public int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        if (num1 == num2) return 0;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }
        NumberCheck checker = new NumberCheck();
        for (int number : numbers) {
            if (checker.isPositive(number)) {
                System.out.println(checker.isEven(number));
            } else {
                System.out.println("Negative");
            }
        }
        int result = checker.compare(numbers[0], numbers[4]);
        
        if(result == 1){
            System.out.println("First is greater");
        } else if (result == 0) {
            System.out.println("Both are equal");
        } else {
            System.out.println("Last is greater");
        }
    }
}
