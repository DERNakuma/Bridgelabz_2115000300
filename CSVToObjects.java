import java.io.*;
import java.util.*;

class Student {
    String id, name, age, marks;
    Student(String[] data) {
        this.id = data[0];
        this.name = data[1];
        this.age = data[2];
        this.marks = data[3];
    }
    public String toString() {
        return id + " " + name + " " + age + " " + marks;
    }
}

public class CSVToObjects {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        List<Student> students = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            students.add(new Student(line.split(",")));
        }
        br.close();
        students.forEach(System.out::println);
    }
}
