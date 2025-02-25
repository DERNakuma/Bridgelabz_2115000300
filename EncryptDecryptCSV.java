import java.io.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecryptCSV {
    private static final String KEY = "MySecretKey12345"; 

    public static void main(String[] args) throws Exception {
        String csvFile = "employees_encrypted.csv";

        encryptAndWriteCSV(csvFile);
        readAndDecryptCSV(csvFile);
    }

    public static void encryptAndWriteCSV(String csvFile) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));
        bw.write("ID,Name,Salary,Email");
        bw.newLine();

        String[][] employees = {
            {"101", "Alice", "60000", "alice@example.com"},
            {"102", "Bob", "75000", "bob@example.com"},
            {"103", "Charlie", "50000", "charlie@example.com"}
        };

        for (String[] emp : employees) {
            bw.write(emp[0] + "," + emp[1] + "," + AESUtil.encrypt(emp[2]) + "," + AESUtil.encrypt(emp[3]));
            bw.newLine();
        }
        bw.close();
        System.out.println("Data encrypted and written to CSV.");
    }

    public static void readAndDecryptCSV(String csvFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line = br.readLine(); // Read header
        System.out.println(line);

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println(data[0] + "," + data[1] + "," + AESUtil.decrypt(data[2]) + "," + AESUtil.decrypt(data[3]));
        }
        br.close();
    }

    static class AESUtil {
        public static String encrypt(String strToEncrypt) throws Exception {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
        }

        public static String decrypt(String strToDecrypt) throws Exception {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
    }
}
