import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course Type: " + name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + ", " + courseType;
    }
}

class CourseManager {
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<?> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityCourse {
    public static void main(String[] args) {
        Course<ExamCourse> mathCourse = new Course<>("Calculus", new ExamCourse());
        Course<AssignmentCourse> programmingCourse = new Course<>("Java Programming", new AssignmentCourse());
        Course<ResearchCourse> thesisCourse = new Course<>("Advanced Research Methods", new ResearchCourse());

        List<Course<? extends CourseType>> courses = new ArrayList<>();
        courses.add(mathCourse);
        courses.add(programmingCourse);
        courses.add(thesisCourse);

        System.out.println("All Courses:");
        CourseManager.displayAllCourses(courses);
    }
}