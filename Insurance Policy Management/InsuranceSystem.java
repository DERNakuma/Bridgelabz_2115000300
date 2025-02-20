import java.util.*;

class Policy {
    String policyNumber;
    String policyholder;
    Date expiryDate;

    Policy(String policyNumber, String policyholder, Date expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholder = policyholder;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return policyNumber + " (" + policyholder + ", " + expiryDate + ")";
    }
}

class InsurancePolicySystem {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> insertionOrderMap = new LinkedHashMap<>();
    TreeMap<Date, Policy> expirySortedMap = new TreeMap<>();

    void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy);
        expirySortedMap.put(policy.expiryDate, policy);
    }

    Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    List<Policy> getExpiringPolicies(Date currentDate) {
        List<Policy> expiring = new ArrayList<>();
        Date limit = new Date(currentDate.getTime() + (30L * 24 * 60 * 60 * 1000));
        expirySortedMap.subMap(currentDate, limit).values().forEach(expiring::add);
        return expiring;
    }

    List<Policy> getPoliciesByHolder(String policyholder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholder.equals(policyholder)) {
                result.add(policy);
            }
        }
        return result;
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        system.addPolicy(new Policy("P001", "Bhupender", new Date(1751328000000L))); // 2025-07-01
        system.addPolicy(new Policy("P002", "Akuma", new Date(1754006400000L))); // 2025-08-01
        system.addPolicy(new Policy("P003", "Bob", new Date(1752681600000L))); // 2025-07-15

        System.out.println("Policy P002: " + system.getPolicyByNumber("P002"));
        System.out.println("Expiring within 30 days: " + system.getExpiringPolicies(new Date()));
        System.out.println("Policies for Bhupender: " + system.getPoliciesByHolder("Bhupender"));
    }
}
