import java.util.HashSet;
import java.util.Scanner;

public class Remove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Word:");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (set.add(c)) sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
