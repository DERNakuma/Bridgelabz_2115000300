import java.io.*;
public class FileReadingEfficiency{
    public static void readFR(String path) throws IOException {
        FileReader f = new FileReader(path);
        char[] buf = new char[1024];
        int len;
        while ((len = f.read(buf)) != -1) {   
        }
        f.close();
    }

    public static void readISR(String path) throws IOException {
        InputStreamReader i = new InputStreamReader(new FileInputStream(path));
        char[] buf = new char[1024];
        int len;
        while ((len = i.read(buf)) != -1) {
            
        }
        i.close();
    }

    public static void main(String[] args) {
        try {
            String path = "large.txt";
            
            long start = System.nanoTime();
            readFR(path);
            long end = System.nanoTime();
            long frTime = end - start;
            
            start = System.nanoTime();
            readISR(path);
            end = System.nanoTime();
            long isrTime = end - start;
            
            System.out.println("File Reader Time: " + frTime / 1000000.0 + " ms");
            System.out.println("Input Stream Reader Time: " + isrTime / 1000000.0 + " ms");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
