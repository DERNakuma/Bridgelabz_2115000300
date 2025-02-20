import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FrequencyOfElement {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "apple", "orange");
        Map<String, Integer> frequencyMap = countFrequency(list);
        System.out.println("Frequency Map: " + frequencyMap);
    }
}