import java.io.*;
import java.util.*;

public class UpdateCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[2].equals("IT")) {
                data[3] = String.valueOf((int)(Integer.parseInt(data[3]) * 1.1));
            }
            lines.add(String.join(",", data));
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("updated_employees.csv"));
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
        bw.close();
    }
}
