import java.io.*;
public class UpperToLower {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "converted.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {
            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase(ch));
            }
            System.out.println("File converted successfully.");
        } catch (IOException e) {
            System.out.println("Error processing file.");
        }
    }
}
