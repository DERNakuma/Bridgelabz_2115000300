import java.util.Scanner;
public class Concatenate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n = sc.nextInt();
        System.out.println("Enter the strings:");
        sc.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(sc.nextLine());
        }
        System.out.println(sb.toString());
    }
}
