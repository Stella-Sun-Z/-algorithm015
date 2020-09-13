package Week3;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        genList(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }

    private static void genList(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int idx) {
        if (nums.length == idx) {
            res.add((List<Integer>) list.clone());
            return;
        }

        for (int i = 0; i <= list.size(); i++) {
            list.add(i, nums[idx]);
            genList(res, nums, list, idx + 1);
            list.remove(i);
        }
    }
}
