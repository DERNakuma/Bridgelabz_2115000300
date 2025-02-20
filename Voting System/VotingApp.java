
import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> insertionOrderMap = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedResults = new TreeMap<>();

    void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        insertionOrderMap.put(candidate, voteMap.get(candidate));
        sortedResults.put(candidate, voteMap.get(candidate));
    }

    Map<String, Integer> getResultsInOrder() {
        return new LinkedHashMap<>(insertionOrderMap);
    }

    Map<String, Integer> getSortedResults() {
        return new TreeMap<>(sortedResults);
    }

    void displayResults(Map<String, Integer> results) {
        results.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }
}

public class VotingApp {
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Bhupender");
        system.castVote("Akuma");
        system.castVote("Ram");
        system.castVote("Rhea");
        system.castVote("Dheeraj");

        System.out.println("Votes in order of casting:");
        system.displayResults(system.getResultsInOrder());

        System.out.println("\nVotes sorted by candidate names:");
        system.displayResults(system.getSortedResults());
    }
}
