import java.io.*;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "download.jpg";
        String destinationImage = "copy.jpg";

        byte[] imageData = readImageToByteArray(sourceImage);
        if (imageData != null) {
            writeByteArrayToImage(imageData, destinationImage);
            if (verifyFiles(sourceImage, destinationImage)) {
                System.out.println("Image copied successfully and verified.");
            } else {
                System.out.println("Verification failed. Files are not identical.");
            }
        }
    }

    private static byte[] readImageToByteArray(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image.");
            return null;
        }
    }

    private static void writeByteArrayToImage(byte[] data, String filename) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(filename)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error writing image.");
        }
    }

    private static boolean verifyFiles(String file1, String file2) {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            byte[] data1 = fis1.readAllBytes();
            byte[] data2 = fis2.readAllBytes();
            return Arrays.equals(data1, data2);
        } catch (IOException e) {
            System.out.println("Error verifying files.");
            return false;
        }
    }
}
