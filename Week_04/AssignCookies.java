package Week4;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[j]) {
                res++;
                j++;
            }
            if (j == g.length) break;
        }
        return res;
    }
}
