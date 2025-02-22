import java.util.*;
import java.util.regex.*;

public class LanguageExtractor {
    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|Kotlin)\\b").matcher(text);
        while (matcher.find()) languages.add(matcher.group());
        return languages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        System.out.println(extractLanguages(text));
    }
}

