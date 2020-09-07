package Week2;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    // 穷举暴力法 + 堆
    private static int nthUglyNumber(int n) {
        Ugly ugly = new Ugly();
        return ugly.nums[n - 1];
    }

    private static class Ugly {
        public int[] nums = new int[1690];
        public Ugly() {
            HashSet<Long> set = new HashSet<>();
            PriorityQueue<Long> heap = new PriorityQueue<>();
            set.add(1L);
            heap.add(1L);
            for (int i = 0; i < nums.length; i++) {
                Long cur = heap.poll();
                nums[i] = new Long(cur).intValue();
                int[] multi = new int[]{2, 3, 5};
                for (int m : multi) {
                    long number = m * cur;
                    if (!set.contains(number)) {
                        set.add(number);
                        heap.add(number);
                    }
                }
            }
        }
    }
}
