import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        Map<String, String> recordMap = new HashMap<>();
        Set<String> duplicates = new HashSet<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (recordMap.containsKey(data[0])) {
                duplicates.add(line);
            } else {
                recordMap.put(data[0], line);
            }
        }
        br.close();
        System.out.println("Duplicate Records:");
        duplicates.forEach(System.out::println);
    }
}
