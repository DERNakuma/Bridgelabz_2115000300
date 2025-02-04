class Employee {
    static String companyName = "Capgemini";
    static int totalEmployees = 0;
    final int id;
    String name, designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println(totalEmployees);
    }

    void display() {
        if (this instanceof Employee) {
            System.out.println(name + " " + id + " " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Bhupender", 1, "Manager");
        Employee e2 = new Employee("Krishna", 2, "Developer");
        e1.display();
        e2.display();
        displayTotalEmployees();
    }
}
