package Week1;

import java.util.Arrays;

public class Merge_sorted_array {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        System.out.println(Arrays.toString(Arrays.copyOfRange(num1,0,3)));
//        merge1(num1, m, num2, n);
        merge2(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }
    // 复制再合并
    private static void merge2(int[] num1, int m, int[] num2, int n) {
        int[] temp = Arrays.copyOfRange(num1, 0, m);
        int i = 0, j = 0, idx = 0;
        while (i < m && j < n) {
            num1[idx++] = temp[i] < num2[j] ? temp[i++] : num2[j++];
        }
        if (i < m) System.arraycopy(temp, i, num1, idx, m - i);
        if (j < n) System.arraycopy(num2, j, num1, idx, n - j);
    }

    // 从末端开始添加
    private static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }
}
