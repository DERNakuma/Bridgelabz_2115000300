import java.util.Scanner;

public class YoungestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter Amar's height : ");
        int heightAmar = scanner.nextInt();

        System.out.print("Enter Akbar's age: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter Akbar's height : ");
        int heightAkbar = scanner.nextInt();

        System.out.print("Enter Anthony's age: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Enter Anthony's height : ");
        int heightAnthony = scanner.nextInt();

        String youngestFriend = "Amar";
        int youngestAge = ageAmar;
        
        if (ageAkbar < youngestAge) {
            youngestFriend = "Akbar";
            youngestAge = ageAkbar;
        } else if (ageAnthony < youngestAge) {
            youngestFriend = "Anthony";
            youngestAge = ageAnthony;
        }
        String tallestFriend = "Amar";
        int tallestHeight = heightAmar;

        if (heightAkbar > tallestHeight) {
            tallestFriend = "Akbar";
            tallestHeight = heightAkbar;
        } else if (heightAnthony > tallestHeight) {
            tallestFriend = "Anthony";
            tallestHeight = heightAnthony;
        }
        System.out.println("The youngest friend is " + youngestFriend + " with age " + youngestAge + " years.");
        System.out.println("The tallest friend is " + tallestFriend + " with height " + tallestHeight + " cm.");

        scanner.close();
    }
}
