package Week1;

import java.util.HashMap;
import java.util.Map;

public class Two_sum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] output = two_sum(nums, target);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    private static int[] two_sum(int[] nums, int target) {
        Map<Integer, Integer> numsDict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (numsDict.containsKey(res)) {
                return new int[]{numsDict.get(res), i};
            }
            numsDict.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
