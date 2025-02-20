import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Duplicate{
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (seen.add(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(3, 1, 2, 2, 3, 4);
        List<Integer> uniqueList = removeDuplicates(list);
        System.out.println("List without duplicates: " + uniqueList);
    }
}