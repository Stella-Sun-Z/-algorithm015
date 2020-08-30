package Week1;

public class Remove_duplicates_from_sorted_array {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[i] != nums[j]) {
                ++i;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
