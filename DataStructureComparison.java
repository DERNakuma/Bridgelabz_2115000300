import java.util.*;
public class DataStructureComparison {
    public static boolean searchInArray(int[] array, int key) {
        for (int num : array) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchInHashSet(HashSet<Integer> hashSet, int key) {
        return hashSet.contains(key);
    }

    public static boolean searchInTreeSet(TreeSet<Integer> treeSet, int key) {
        return treeSet.contains(key);
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        
        for (int size : sizes) {
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            
            for (int i = 0; i < size; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }
            int key = size / 2;
            long startTime = System.nanoTime();
            searchInArray(array, key);
            long endTime = System.nanoTime();
            long arraySearchTime = endTime - startTime;

            startTime = System.nanoTime();
            searchInHashSet(hashSet, key);
            endTime = System.nanoTime();
            long hashSetSearchTime = endTime - startTime;

            startTime = System.nanoTime();
            searchInTreeSet(treeSet, key);
            endTime = System.nanoTime();
            long treeSetSearchTime = endTime - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Array Search Time: " + arraySearchTime / 1000000.0 + " ms");
            System.out.println("HashSet Search Time: " + hashSetSearchTime / 1000000.0 + " ms");
            System.out.println("TreeSet Search Time: " + treeSetSearchTime / 1000000.0 + " ms");
            System.out.println();
        }
    }
}
