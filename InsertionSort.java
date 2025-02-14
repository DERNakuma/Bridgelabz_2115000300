public class InsertionSort {
    public static void main(String[] args) {
        int[] employeeIDs = {123, 456, 789, 234, 567};
        for (int i = 1; i < employeeIDs.length; i++) {
            int key = employeeIDs[i];
            int j = i - 1;
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }
}
