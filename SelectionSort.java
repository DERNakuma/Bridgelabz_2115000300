public class SelectionSort {
    public static void main(String[] args) {
        int[] examScores = {88, 92, 74, 85, 63};
        for (int i = 0; i < examScores.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < examScores.length; j++) {
                if (examScores[j] < examScores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = examScores[minIndex];
            examScores[minIndex] = examScores[i];
            examScores[i] = temp;
        }
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}
