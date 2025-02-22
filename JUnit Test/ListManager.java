import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class ListManager {
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public static int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest {
    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 5);
        assertTrue(list.contains(5));
    }

    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 5);
        ListManager.removeElement(list, 5);
        assertFalse(list.contains(5));
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 5);
        ListManager.addElement(list, 10);
        assertEquals(2, ListManager.getSize(list));
        ListManager.removeElement(list, 5);
        assertEquals(1, ListManager.getSize(list));
    }
}

