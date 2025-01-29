import java.util.Scanner;
public class FrequentChar {
    public char findMostFrequentChar(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        char maxChar = s.charAt(0);
        for (char c : s.toCharArray()) if (freq[c] > freq[maxChar]) maxChar = c;
        return maxChar;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        FrequentChar mfc = new FrequentChar();
        System.out.println("Most Frequent Character: " + mfc.findMostFrequentChar(s));
    }
}
