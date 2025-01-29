import java.util.Scanner;
public class PalindromeCheck {
    public boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        PalindromeCheck pc = new PalindromeCheck();
        System.out.println(pc.isPalindrome(input) ? "Palindrome" : "Not a Palindrome");
    }
}
