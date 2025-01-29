import java.util.Scanner;
public class SubstringCount {
    public int countOccurrences(String str, String sub) {
        int count = 0, index = 0;
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        String str = sc.nextLine();
        System.out.println("Enter the substring: ");
        String sub = sc.nextLine();
        SubstringCount scObj = new SubstringCount();
        System.out.println(scObj.countOccurrences(str, sub));
    }
}
