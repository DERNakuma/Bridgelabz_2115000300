import java.util.Scanner;
public class MultipleTable {
    public static void main(String[] args) {
        int[] table = new int[10];
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 1; i <= table.length; i++) {
            table[i - 1] = number * i;
        }
        for (int i = 0; i < table.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }
    }
}
