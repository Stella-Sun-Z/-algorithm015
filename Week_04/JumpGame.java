package Week4;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int reachMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachMost) return false;
            reachMost = Math.max(reachMost, i + nums[i]);
        }
        return true;
    }
}
