import java.io.*;
public class BufferedStreams {
    public static void main(String[] args) {
        String source = "largefile.txt";
        String destinationBuffered = "buffered_copy.txt";
        String destinationUnbuffered = "unbuffered_copy.txt";

        long start, end;
        start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationBuffered))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error in buffered copy.");
        }
        end = System.nanoTime();
        System.out.println("Buffered copy time: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destinationUnbuffered)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy.");
        }
        end = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (end - start) / 1_000_000 + " ms");
    }
}
