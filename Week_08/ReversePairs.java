package Week8;

import java.util.Arrays;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};
        int count = reversePairs(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
    }

    private static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) return 0;
        int mid = (begin + end) / 2;
        int count = mergeSort(nums, begin, mid) + mergeSort(nums, mid + 1, end);
        count += merge(nums, begin, mid, end);
        return count;
    }

    private static int merge(int[] nums, int begin, int mid, int end) {
        int count = 0;
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0, mark = begin;
        while (j <= end) {
            while (mark <= mid && nums[mark] / 2.0 <= nums[j]) mark++;
            while (i <= mid && nums[i] <= nums[j]) temp[k++] = nums[i++];
            temp[k++] = nums[j++];
            count += mid - mark + 1;
        }
        while (i <= mid) temp[k++] = nums[i++];
        System.arraycopy(temp, 0, nums, begin, end - begin + 1);
        return count;
    }
}
