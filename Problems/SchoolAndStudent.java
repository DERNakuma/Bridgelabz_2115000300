import java.util.ArrayList;

class School {
    ArrayList<Student> students;

    School() {
        students = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void displayStudents() {
        System.out.println("Students in the school:");
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses;

    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    void enrollInCourse(Course course) {
        courses.add(course);
        System.out.println(this.name + " enrolled in " + course.name);
    }

    void displayCourses() {
        System.out.println("Courses enrolled by " + this.name + ":");
        for (Course course : courses) {
            System.out.println(course.name);
        }
    }
}

class Course {
    String name;

    Course(String name) {
        this.name = name;
    }
}

public class SchoolAndStudent {
    public static void main(String[] args) {
        School school = new School();
        Student student1 = new Student("Bhupender");
        Student student2 = new Student("Akuma");

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(math);

        school.addStudent(student1);
        school.addStudent(student2);
        school.displayStudents();

        student1.displayCourses();
        student2.displayCourses();
    }
}