class Student {
    static String universityName = "GLA University";
    static int totalStudents = 0;
    final int rollNumber;
    String name, grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println(totalStudents);
    }

    void display() {
        if (this instanceof Student) {
            System.out.println(name + " " + rollNumber + " " + grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Bhupender", 1, "A");
        Student s2 = new Student("Krishna", 2, "B");
        s1.display();
        s2.display();
        displayTotalStudents();
    }
}
