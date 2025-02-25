import java.io.*;
import java.sql.*;
public class DatabaseToCSV {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db", "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees_report.csv"));
        bw.write("Employee ID,Name,Department,Salary");
        bw.newLine();
        while (rs.next()) {
            bw.write(rs.getInt("id") + "," + rs.getString("name") + "," + rs.getString("department") + "," + rs.getInt("salary"));
            bw.newLine();
        }
        bw.close();
        rs.close();
        stmt.close();
        conn.close();
    }
}
