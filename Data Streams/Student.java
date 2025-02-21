import java.io.*;
public class Student{
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        writeStudentData();
        readStudentData();
    }

    private static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101);
            dos.writeUTF("Bhupender Singh");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Akuma");
            dos.writeDouble(3.6);

            dos.writeInt(103);
            dos.writeUTF("Radha");
            dos.writeDouble(3.9);

            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data.");
        }
    }

    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Retrieved Student Data:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data.");
        }
    }
}
