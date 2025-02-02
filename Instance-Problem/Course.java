public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Tech University";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months, Fee: " + fee);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static String getInstituteName() {
        return instituteName;
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 6, 29999.00);
        Course course2 = new Course("Python Programming", 4, 19999.99);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

        System.out.println("Institute Name: " + Course.getInstituteName());
        Course.updateInstituteName("G.L.A");
        System.out.println("Updated Institute Name: " + Course.getInstituteName());
    }
}