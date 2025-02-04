class Patient {
    static String hospitalName = "Sarvodaya Hospital";
    static int totalPatients = 0;
    final int patientID;
    String name;
    int age;
    String ailment;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println(totalPatients);
    }

    void display() {
        if (this instanceof Patient) {
            System.out.println(name + " " + age + " " + ailment);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Bhupender", 22, "Flu", 101);
        p1.display();
        getTotalPatients();
    }
}
