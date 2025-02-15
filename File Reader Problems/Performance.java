import java.io.*;
public class Performance {
    public static void main(String[] args) {
        int n = 1000000;
        String text = "hello";

        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbd.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int wordCount = countWordsUsingFileReader("largefile.txt");
        endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount + ", time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        wordCount = countWordsUsingInputStreamReader("largefile.txt");
        endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount + ", time: " + (endTime - startTime) + " ns");
    }

    private static int countWordsUsingFileReader(String filename) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static int countWordsUsingInputStreamReader(String filename) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
