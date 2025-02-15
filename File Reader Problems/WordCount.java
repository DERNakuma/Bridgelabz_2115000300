import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {
        String targetWord = "Hello";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Occurrences of '" + targetWord + "': " + count);
    }
}
