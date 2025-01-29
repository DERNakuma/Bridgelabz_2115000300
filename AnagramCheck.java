import java.util.Scanner;
public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        if (str1.length() != str2.length()) {
            System.out.println("No");
        } else {
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            java.util.Arrays.sort(arr1);
            java.util.Arrays.sort(arr2);
            if (java.util.Arrays.equals(arr1, arr2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
