import java.util.LinkedList;
class CustomHashMap {
    static class Entry {
        int key, value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private static final int SIZE = 1000;
    private LinkedList<Entry>[] map;
    public CustomHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }
    private int getIndex(int key) {
        return key % SIZE;
    }
    public void put(int key, int value) {
        int index = getIndex(key);
        for (Entry entry : map[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        map[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = getIndex(key);
        for (Entry entry : map[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        map[index].removeIf(entry -> entry.key == key);
    }

    public static void main(String[] args) {
        CustomHashMap hashMap = new CustomHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        System.out.println(hashMap.get(1)); 
        System.out.println(hashMap.get(3)); 
        hashMap.remove(1);
        System.out.println(hashMap.get(1));
    }
}
