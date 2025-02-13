import java.util.*;
public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
                map.get(sum).add(i);
            } else {
                map.put(sum, new ArrayList<>(Arrays.asList(i)));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<int[]> subarrays = findZeroSumSubarrays(nums);

        for (int[] subarray : subarrays) {
            System.out.println("Subarray: [" + subarray[0] + ", " + subarray[1] + "]");
        }
    }
}