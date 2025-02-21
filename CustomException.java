import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        super("Age must be 18 or above");
    }
}
public class CustomException {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException();
        }
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int age = scanner.nextInt();
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
