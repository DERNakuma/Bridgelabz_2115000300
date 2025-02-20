import java.util.*;
class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholder;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    Policy(String policyNumber, String policyholder, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholder = policyholder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Policy) {
            Policy other = (Policy) obj;
            return this.policyNumber.equals(other.policyNumber);
        }
        return false;
    }

    public int hashCode() {
        return policyNumber.hashCode();
    }

    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    public String toString() {
        return policyNumber + " (" + policyholder + ", " + coverageType + ", " + premiumAmount + ", " + expiryDate + ")";
    }
}

class InsurancePolicySystem {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    List<Policy> getExpiringSoon(Date currentDate) {
        List<Policy> expiring = new ArrayList<>();
        Date limit = new Date(currentDate.getTime() + (30L * 24 * 60 * 60 * 1000));
        for (Policy policy : treeSet) {
            if (policy.expiryDate.before(limit)) {
                expiring.add(policy);
            }
        }
        return expiring;
    }

    List<Policy> getPoliciesByCoverage(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashSet) {
            if (policy.coverageType.equals(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    Set<Policy> getAllUniquePolicies() {
        return hashSet;
    }

    Set<String> getDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (Policy policy : linkedHashSet) {
            if (!seen.add(policy.policyNumber)) {
                duplicates.add(policy.policyNumber);
            }
        }
        return duplicates;
    }

    void comparePerformance() {
        List<Policy> policies = new ArrayList<>(hashSet);
        long start, end;

        start = System.nanoTime();
        hashSet.contains(policies.get(0));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.contains(policies.get(0));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start));

        start = System.nanoTime();
        treeSet.contains(policies.get(0));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start));
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        system.addPolicy(new Policy("P001", "Alice", new Date(1751328000000L), "Health", 5000));
        system.addPolicy(new Policy("P002", "Bob", new Date(1754006400000L), "Auto", 3000));
        system.addPolicy(new Policy("P003", "Alice", new Date(1752681600000L), "Home", 7000));
        system.addPolicy(new Policy("P001", "Alice", new Date(1751328000000L), "Health", 5000));

        System.out.println("All Unique Policies:");
        System.out.println(system.getAllUniquePolicies());

        System.out.println("\nPolicies Expiring Soon:");
        System.out.println(system.getExpiringSoon(new Date()));

        System.out.println("\nPolicies with Health Coverage:");
        System.out.println(system.getPoliciesByCoverage("Health"));

        System.out.println("\nDuplicate Policies:");
        System.out.println(system.getDuplicatePolicies());

        System.out.println("\nPerformance Comparison:");
        system.comparePerformance();
    }
}
