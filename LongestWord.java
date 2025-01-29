import java.util.Scanner;
public class LongestWord {
    public String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }
        return longest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String input = sc.nextLine();
        LongestWord lw = new LongestWord();
        System.out.println(lw.findLongestWord(input));
    }
}
