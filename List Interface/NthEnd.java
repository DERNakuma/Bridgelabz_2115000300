import java.util.LinkedList;
public class NthEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        var first = list.listIterator();
        var second = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) return null;
            first.next();
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println(findNthFromEnd(list, 2));
    }
}
