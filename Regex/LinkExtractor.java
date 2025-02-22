
import java.util.*;
import java.util.regex.*;

public class LinkExtractor {
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\bhttps?://[\\w.-]+\\.[a-z]{2,6}\\b").matcher(text);
        while (matcher.find()) links.add(matcher.group());
        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        System.out.println(extractLinks(text));
    }
}

