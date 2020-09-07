package Week2;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry entry : map.entrySet()) {
            int num = (int)entry.getKey(), count = (int)entry.getValue();
            if (heap.size() == k) {
                if (count > heap.peek()[1]) {
                    heap.poll();
                    heap.offer(new int[]{num, count});
                }
            } else {
                heap.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = heap.poll()[0];
        return res;
    }
}
