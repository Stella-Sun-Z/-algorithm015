package Week4;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 2, 3};
        System.out.println(jump(nums));
    }

    private static int jump(int[] nums) {
        int end = 0 ,reachable = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            reachable = Math.max(reachable, i + nums[i]);
            if (end == i) {
                end = reachable;
                steps++;
            }
        }
        return steps;
    }
}
