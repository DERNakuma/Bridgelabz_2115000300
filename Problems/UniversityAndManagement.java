import java.util.*;

class Student {
    String name;
    List<Course> courses;
    
    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    
    void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.name);
    }
    
    void showCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(course.name);
        }
    }
}

class Professor {
    String name;
    List<Course> courses;
    
    Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    
    void assignCourse(Course course) {
        courses.add(course);
        course.setProfessor(this);
        System.out.println("Professor " + name + " is assigned to " + course.name);
    }
    
    void showCourses() {
        System.out.println("Professor: " + name + " teaches:");
        for (Course course : courses) {
            System.out.println(course.name);
        }
    }
}

class Course {
    String name;
    Professor professor;
    List<Student> students;
    
    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    
    void addStudent(Student student) {
        students.add(student);
    }
    
    void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    void showDetails() {
        System.out.println("Course: " + name);
        System.out.println("Professor: " + (professor != null ? professor.name : "None"));
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}

public class UniversityAndManagement {
    public static void main(String[] args) {
        Student s1 = new Student("Bhupender");
        Student s2 = new Student("Rhea");
        
        Professor p1 = new Professor("Ram");
        Professor p2 = new Professor("Prof. Vinay");
        
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");
        
        s1.enrollCourse(c1);
        s2.enrollCourse(c2);
        s1.enrollCourse(c2);
        
        p1.assignCourse(c1);
        p2.assignCourse(c2);
        
        c1.showDetails();
        c2.showDetails();
        s1.showCourses();
        s2.showCourses();
        p1.showCourses();
        p2.showCourses();
    }
}
