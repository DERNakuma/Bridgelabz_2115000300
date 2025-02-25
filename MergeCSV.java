import java.io.*;
import java.util.*;
public class MergeCSV {
    public static void main(String[] args) throws IOException {
        Map<String, String[]> dataMap = new HashMap<>();
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        String line;
        while ((line = br1.readLine()) != null) {
            String[] data = line.split(",");
            dataMap.put(data[0], data);
        }
        br1.close();
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("merged_students.csv"));
        while ((line = br2.readLine()) != null) {
            String[] data = line.split(",");
            if (dataMap.containsKey(data[0])) {
                String[] fullData = dataMap.get(data[0]);
                bw.write(String.join(",", fullData) + "," + data[1] + "," + data[2]);
                bw.newLine();
            }
        }
        br2.close();
        bw.close();
    }
}
