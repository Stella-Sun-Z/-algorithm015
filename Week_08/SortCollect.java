package Week8;

import java.util.Arrays;

public class SortCollect {

    public static void main(String[] args) {
        int[] nums = {5, 10, 6, 2, 9, 45, 26, 16};
//        quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    //快速排序
    public static void quickSort(int[] nums, int start, int end) {
        if (end <= start) return;
        int pivot = pivot(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }
    private static int pivot(int[] nums, int start, int end) {
        int count = start, pivot = end;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
        int temp = nums[pivot];
        nums[pivot] = nums[count];
        nums[count] = temp;
        return count;
    }

    //归并排序
    public static void mergeSort(int[] nums, int start, int end) {
        if (end <= start) return;
        int mid = (start + end) >> 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];

        for (int p = 0; p < end - start + 1; p++) {
            nums[start + p] = temp[p];
        }
    }
}
