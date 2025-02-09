import java.util.*;

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }
    
    public double calculateSalary() {
        return getBaseSalary();
    }
    
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    
    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;
    private String department;
    
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }
    
    public double calculateSalary() {
        return workHours * hourlyRate;
    }
    
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    
    public String getDepartmentDetails() {
        return department;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee e1 = new FullTimeEmployee(1, "Bhupender", 50000);
        PartTimeEmployee e2 = new PartTimeEmployee(2, "Akuma", 200, 20);
        
        e1.assignDepartment("HR");
        e2.assignDepartment("IT");
        
        employees.add(e1);
        employees.add(e2);
        
        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}
