import java.io.*;
import java.util.*;
public class CountWords {
    public static void main(String[] args) {
        String fileName = "textfile.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Total words: " + wordCount.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println("Top 5 most frequent words:");
        sortedWords.stream().limit(5).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
