import java.util.ArrayList;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Department {
    ArrayList<Employee> employees;

    Department() {
        employees = new ArrayList<>();
    }

    void addEmployee(Employee employee) {
        employees.add(employee);
    }

    void displayEmployees() {
        System.out.println("Employees in the department:");
        for (Employee employee : employees) {
            System.out.println(employee.name);
        }
    }
}

class Company {
    ArrayList<Department> departments;

    Company() {
        departments = new ArrayList<>();
    }

    void addDepartment(Department department) {
        departments.add(department);
    }

    void displayDepartments() {
        System.out.println("Departments in the company:");
        for (Department department : departments) {
            department.displayEmployees();
        }
    }
}

public class CompanyAndDep {
    public static void main(String[] args) {
        Company company = new Company();
        Department hr = new Department();
        hr.addEmployee(new Employee("Bhupender"));
        hr.addEmployee(new Employee("Akuma"));

        Department it = new Department();
        it.addEmployee(new Employee("Krishna"));
        it.addEmployee(new Employee("Dhananya"));

        company.addDepartment(hr);
        company.addDepartment(it);
        company.displayDepartments();
    }
}