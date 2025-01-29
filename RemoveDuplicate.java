import java.util.Scanner;
public class RemoveDuplicate {
    public String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256];
        for (char c : str.toCharArray()) {
            if (!seen[c]) {
                result.append(c);
                seen[c] = true;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        RemoveDuplicate rd = new RemoveDuplicate();
        System.out.println(rd.removeDuplicates(input));
    }
}
