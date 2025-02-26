// Read & Censor CSV Data
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.List;

public class IPLCsvProcessor {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("ipl_data.csv");
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> data = csvReader.readAll();
            csvReader.close();

            for (int i = 1; i < data.size(); i++) { 
                data.get(i)[1] = censorTeamName(data.get(i)[1]); 
                data.get(i)[2] = censorTeamName(data.get(i)[2]); 
                data.get(i)[5] = censorTeamName(data.get(i)[5]); 
                data.get(i)[6] = "REDACTED"; 
            }

            FileWriter fileWriter = new FileWriter("ipl_censored.csv");
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            csvWriter.writeAll(data);
            csvWriter.close();

            System.out.println("Censored CSV file generated: ipl_censored.csv");

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        return words.length > 1 ? words[0] + " ***" : teamName;
    }
}
