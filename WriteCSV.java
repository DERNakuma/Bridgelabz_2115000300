import java.io.*;
public class WriteCSV {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"));
        String[] employees = {
            "101,Bhupender,IT,60000",
            "102,AKuma,HR,55000",
            "103,Rhea,Finance,70000",
            "104,Dhananya,IT,65000",
            "105,Deep,Marketing,50000"
        };
        for (String emp : employees) {
            bw.write(emp);
            bw.newLine();
        }
        bw.close();
    }
}
