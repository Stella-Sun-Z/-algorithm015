package Week8;

import java.util.Arrays;

public class SortCollect2 {
    public static void main(String[] args) {
        int[] nums = {5, 10, 6, 2, 9, 45, 26, 16};
//        selectSort(nums);
//        insertSort(nums);
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    //选择排序
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], temp = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    temp = j;
                }
            }
            nums[temp] = nums[i];
            nums[i] = min;
        }
    }

    //插入排序
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                } else break;
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
