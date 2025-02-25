import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;

public class JsonCsvConverter {
    public static void main(String[] args) throws IOException {
        String jsonFile = "students.json";
        String csvFile = "students.csv";

        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, "converted_students.json");
    }

    public static void jsonToCsv(String jsonFile, String csvFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> students = mapper.readValue(new File(jsonFile), new TypeReference<List<Map<String, String>>>(){});

        BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));
        bw.write("ID,Name,Age,Marks");
        bw.newLine();
        for (Map<String, String> student : students) {
            bw.write(student.get("ID") + "," + student.get("Name") + "," + student.get("Age") + "," + student.get("Marks"));
            bw.newLine();
        }
        bw.close();
        System.out.println("JSON to CSV conversion completed.");
    }

    public static void csvToJson(String csvFile, String jsonFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        List<Map<String, String>> students = new ArrayList<>();
        String[] headers = br.readLine().split(",");
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            Map<String, String> student = new HashMap<>();
            for (int i = 0; i < headers.length; i++) {
                student.put(headers[i], data[i]);
            }
            students.add(student);
        }
        br.close();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), students);
        System.out.println("CSV to JSON conversion completed.");
    }
}
