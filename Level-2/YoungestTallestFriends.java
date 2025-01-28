import java.util.Scanner;
public class YoungestTallestFriends {
    public int findYoungest(int[] ages) {
        int youngest = ages[0];
        for (int age : ages) {
            if (age < youngest) youngest = age;
        }
        return youngest;
    }
    public int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) tallest = height;
        }
        return tallest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }
        YoungestTallestFriends friends = new YoungestTallestFriends();
        System.out.println(friends.findYoungest(ages));
        System.out.println(friends.findTallest(heights));
    }
}
