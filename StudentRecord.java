import java.util.Scanner;
class StudentNode {
    int rollNo;
    String name;
    int age;
    String grade;
    StudentNode next;


    public StudentNode(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private StudentNode head;

    
    public StudentList() {
        this.head = null;
    }

    public void addAtBeginning(int rollNo, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
        System.out.println("Student " + name + " added at the beginning.");
    }


    public void addAtEnd(int rollNo, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNo, name, age, grade);
        if (head == null) { 
            head = newStudent;
        } else {
            StudentNode current = head;
            while (current.next != null) { 
                current = current.next;
            }
            current.next = newStudent;
        }
        System.out.println("Student " + name + " added at the end.");
    }

   
    public void addAtPosition(int rollNo, String name, int age, String grade, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position must be >= 1.");
            return;
        }
        StudentNode newStudent = new StudentNode(rollNo, name, age, grade);
        if (position == 1) { 
            newStudent.next = head;
            head = newStudent;
        } else {
            StudentNode current = head;
            for (int i = 1; i < position - 1; i++) { 
                if (current == null) {
                    System.out.println("Position out of range.");
                    return;
                }
                current = current.next;
            }
            newStudent.next = current.next;
            current.next = newStudent;
        }
        System.out.println("Student " + name + " added at position " + position + ".");
    }

    public void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty. No student to delete.");
            return;
        }
        if (head.rollNo == rollNo) { 
            head = head.next;
            System.out.println("Student with Roll Number " + rollNo + " deleted.");
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            if (current.next.rollNo == rollNo) {
                current.next = current.next.next;
                System.out.println("Student with Roll Number " + rollNo + " deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }

    public void searchByRollNo(int rollNo) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                System.out.println("Student found: Roll No: " + current.rollNo + ", Name: " + current.name +
                        ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }
        StudentNode current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name +
                    ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    
    public void updateGrade(int rollNo, String newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNo + ". New Grade: " + newGrade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();
        int choice;

        do {
            
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add a new student at the beginning");
            System.out.println("2. Add a new student at the end");
            System.out.println("3. Add a new student at a specific position");
            System.out.println("4. Delete a student by Roll Number");
            System.out.println("5. Search for a student by Roll Number");
            System.out.println("6. Display all student records");
            System.out.println("7. Update a student's grade");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNo1 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age1 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Grade: ");
                    String grade1 = scanner.nextLine();
                    studentList.addAtBeginning(rollNo1, name1, age1, grade1);
                    break;

                case 2:
                    System.out.print("Enter Roll Number: ");
                    int rollNo2 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age2 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Grade: ");
                    String grade2 = scanner.nextLine();
                    studentList.addAtEnd(rollNo2, name2, age2, grade2);
                    break;

                case 3:
                    System.out.print("Enter Roll Number: ");
                    int rollNo3 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age3 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Grade: ");
                    String grade3 = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    studentList.addAtPosition(rollNo3, name3, age3, grade3, position);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int rollNo4 = scanner.nextInt();
                    studentList.deleteByRollNo(rollNo4);
                    break;

                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    int rollNo5 = scanner.nextInt();
                    studentList.searchByRollNo(rollNo5);
                    break;

                case 6:
                    studentList.displayAll();
                    break;

                case 7:
                    System.out.print("Enter Roll Number to update grade: ");
                    int rollNo7 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();
                    studentList.updateGrade(rollNo7, newGrade);
                    break;

                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}