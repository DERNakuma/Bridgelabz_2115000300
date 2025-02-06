import java.util.*;

class Faculty {
    String name;
    
    Faculty(String name) {
        this.name = name;
    }
    
    void display() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String name;
    
    Department(String name) {
        this.name = name;
    }
    
    void display() {
        System.out.println("Department: " + name);
    }
}

class University {
    String name;
    List<Department> departments;
    List<Faculty> faculties;
    
    University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }
    
    void addDepartment(Department department) {
        departments.add(department);
    }
    
    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    
    void showDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.display();
        }
        System.out.println("Faculties:");
        for (Faculty faculty : faculties) {
            faculty.display();
        }
    }
    
    void deleteUniversity() {
        departments.clear();
        System.out.println("University " + name + " deleted, along with its departments.");
    }
}

public class UniAndFaculty {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Dr. Vinay Singh");
        Faculty f2 = new Faculty("Prof. Jalal ");
        
        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Mechanical Engineering");
        
        University uni = new University("G.L.A");
        uni.addDepartment(d1);
        uni.addDepartment(d2);
        uni.addFaculty(f1);
        uni.addFaculty(f2);
        
        uni.showDetails();
        
        uni.deleteUniversity();
        
        System.out.println("Faculty members still exist:");
        f1.display();
        f2.display();
    }
}
