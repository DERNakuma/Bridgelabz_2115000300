import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int id;
    private String name, department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class Serialization {
    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Bhupender", "HR", 50000));
        employees.add(new Employee(2, "Akuma", "IT", 70000));
        employees.add(new Employee(3, "Rupayan", "Finance", 60000));

        serializeEmployees(employees);
        deserializeEmployees();
    }

    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(new ArrayList<>(employees));
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees.");
        }
    }

    @SuppressWarnings("unchecked")
    private static void deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> employees = (ArrayList<Employee>) ois.readObject();
            System.out.println("Retrieved Employees:");
            for (Employee e : employees) {
                e.display();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error retrieving employees.");
        }
    }
}
