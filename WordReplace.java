import java.util.Scanner;
public class WordReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String oldWord = sc.nextLine();
        String newWord = sc.nextLine();
        System.out.println(replace(sentence, oldWord, newWord));
    }

    public static String replace(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }
}
