package Week3;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = combine(n, k);
        System.out.println(res);
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        genComb(n, k, res, new ArrayList<Integer>(), 1);
        return res;
    }

    private static void genComb(int n, int k, List<List<Integer>> res, ArrayList<Integer> list, int idx) {
        if (list.size() == k) {
            res.add((List<Integer>) list.clone());
            return;
        }

        for (int i = idx; i <= n; i++) {
            list.add(i);
            genComb(n, k, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
