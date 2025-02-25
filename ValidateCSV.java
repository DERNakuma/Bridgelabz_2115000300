import java.io.*;
import java.util.regex.*;
public class ValidateCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
        String line;
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (!emailPattern.matcher(data[1]).matches() || !phonePattern.matcher(data[2]).matches()) {
                System.out.println("Invalid: " + line);
            }
        }
        br.close();
    }
}
