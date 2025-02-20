import java.util.Set;
public class Subset{
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(2, 3);
        Set<Integer> set2 = Set.of(1, 2, 3, 4);

        boolean result = isSubset(set1, set2);
        System.out.println("Is set1 a subset of set2? " + result); // Output: true
    }
}