import java.util.Arrays;
import java.util.Random;
public class TargetInLarge {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();
        
        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) data[i] = random.nextInt(n);
            int target = data[random.nextInt(n)];
            
            long start = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - start;
            
            Arrays.sort(data);
            start = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;
            
            System.out.println("Dataset Size: " + n);
            System.out.println("Linear Search Time: " + linearTime / 1000000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1000000.0 + " ms");
            System.out.println();
        }
    }
    
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == target) return i;
        return -1;
    }
    
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
