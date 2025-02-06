import java.util.*;

class Patient {
    String name;
    
    Patient(String name) {
        this.name = name;
    }
    
    void display() {
        System.out.println("Patient: " + name);
    }
}

class Doctor {
    String name;
    List<Patient> patients;
    
    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }
    
    void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " is consulting " + patient.name);
    }
    
    void showPatients() {
        System.out.println("Dr. " + name + "'s Patients:");
        for (Patient patient : patients) {
            patient.display();
        }
    }
}

class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;
    
    Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    
    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    
    void addPatient(Patient patient) {
        patients.add(patient);
    }
    
    void showDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.name);
        }
        System.out.println("Patients:");
        for (Patient patient : patients) {
            patient.display();
        }
    }
}

public class HospitalAndDoc {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        
        Doctor d1 = new Doctor("Bhupender");
        Doctor d2 = new Doctor("Akuma");
        
        Patient p1 = new Patient("Rhea");
        Patient p2 = new Patient("Ram");
        
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);
        
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
        
        hospital.showDetails();
        d1.showPatients();
        d2.showPatients();
    }
}
