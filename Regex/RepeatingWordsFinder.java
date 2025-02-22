import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeatedWords = new HashSet<>();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b(?=.*\\b\\1\\b)").matcher(text);
        while (matcher.find()) repeatedWords.add(matcher.group());
        return repeatedWords;
    }

    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";
        System.out.println(findRepeatingWords(input));
    }
}

