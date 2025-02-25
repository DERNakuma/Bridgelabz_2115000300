import java.io.*;

public class FilterCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[3]) > 80) {
                System.out.println(line);
            }
        }
        br.close();
    }
}
