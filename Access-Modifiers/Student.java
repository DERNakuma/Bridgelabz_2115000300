public class Student {
    public int rollNumber; 
    protected String name; 
    private double cgpa;   

    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

class PostgraduateStudent extends Student {
  
    public PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }

    public void displayDetails() {
       
        System.out.println("Roll Number: " + getRollNumber() + ", Name: " + getName());
    }


    public static void main(String[] args) {
        PostgraduateStudent pgStudent = new PostgraduateStudent(70, "Bhupender", 8.8);
        pgStudent.displayDetails();
        System.out.println("CGPA: " + pgStudent.getCgpa());
    }
}