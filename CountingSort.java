public class CountingSort {
    public static void main(String[] args) {
        int[] studentAges = {14, 16, 15, 10, 18, 12, 14, 17};
        countingSort(studentAges, 10, 18);
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }

    public static void countingSort(int[] arr, int min, int max) {
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }
}
