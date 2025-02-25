import java.io.*;

public class SearchCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        String line, searchName = "Sarah";
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equalsIgnoreCase(searchName)) {
                System.out.println("Department: " + data[2] + ", Salary: " + data[3]);
            }
        }
        br.close();
    }
}
