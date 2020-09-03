package Week1;

import java.util.Stack;

public class Trapping_rain_water {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int res1 = trap1(height);
//        System.out.println(res1);
//        int res2 = trap2(height);
//        System.out.println(res2);
//        int res3 = trap3(height);
//        System.out.println(res3);
        int res4 = trap4(height);
        System.out.println(res4);
    }

    // 双指针夹逼法
    private static int trap4(int[] height) {
        int n = height.length;
        int res = 0;
        if (n < 3) return res;

        int i = 0, j = n - 1;
        int left_max = 0, right_max = 0;
        while(i < j) {
            if (height[i] < height[j]) {
                left_max = Math.max(left_max, height[i]);
                int size = left_max - height[i];
                res += size;
                i++;
            } else {
                right_max = Math.max(right_max, height[j]);
                int size = right_max - height[j];
                res += size;
                j--;
            }
        }
        return res;
    }

    //微暴力法-空间换时间
    private static int trap3(int[] height) {
        int n = height.length;
        int res = 0;
        if (n < 3) return res;

        int[] left_max = new int[n];
        int[] right_max = new int[n];
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            left = Math.max(left, height[i]);
            left_max[i] = left;
        }
        for (int j = n-1; j >= 0; j--) {
            right = Math.max(right, height[j]);
            right_max[j] = right;
        }
        for (int k = 1; k < n - 1; k++) {
            int size = Math.min(left_max[k], right_max[k]) - height[k];
            res += size;
        }
        return res;
    }

    //暴力法
    private static int trap2(int[] height) {
        int n = height.length;
        int res = 0;
        if (n < 3) return res;

        for (int k = 1; k < n - 1; k++) {
            int max_left = height[k], max_right = height[k];
            for (int i = k - 1; i >= 0; i--) {
                max_left = Math.max(max_left, height[i]);
            }
            for (int j = k + 1; j < n; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            int size = Math.min(max_left, max_right) - height[k];
            res += size;
        }
        return res;
    }
    //调用栈
    public static int trap1(int[] height) {
        int n = height.length;
        int res = 0;
        if (n < 3) return res;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.empty()) break;
                int size = (Math.min(height[i], height[stack.peek()]) - height[bottom]) *
                        (i - stack.peek() - 1);
                res += size;
            }
            stack.push(i);
        }
        return res;
    }
}
