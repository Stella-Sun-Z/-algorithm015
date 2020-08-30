package Week1;

public class Move_zeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        move_zeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void move_zeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                if (i != j) {
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
