import java.io.*;
public class ReadLargeCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("largefile.csv"));
        String line;
        int count = 0, batchSize = 100;
        while ((line = br.readLine()) != null) {
            count++;
            System.out.println(line);
            if (count % batchSize == 0) {
                System.out.println("Processed: " + count + " records");
            }
        }
        br.close();
        System.out.println("Total Records Processed: " + count);
    }
}
