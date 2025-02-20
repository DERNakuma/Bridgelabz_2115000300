import java.util.*;
class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
class HospitalTriage {
    static <T extends Patient> List<String> triage(List<T> patients) {
        PriorityQueue<T> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.severity, a.severity));
        pq.addAll(patients);
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll().name);
        return result;
    }

    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(new Patient("Bhupender", 3), new Patient("Akuma", 5), new Patient("Rhea", 2));
        System.out.println(triage(patients));
    }
}
