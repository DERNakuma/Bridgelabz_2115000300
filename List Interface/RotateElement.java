import java.util.List;
import java.util.ArrayList;

public class RotateElement {
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        if (size == 0) return;
        positions = positions % size;
        if (positions < 0) positions += size;

        reverse(list, 0, size - 1);
        reverse(list, 0, positions - 1);
        reverse(list, positions, size - 1);
    }

    private static <T> void reverse(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        rotateList(list, 2);
        System.out.println("Rotated List: " + list);
    }
}