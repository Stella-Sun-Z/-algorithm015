package Week9;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int len = s.length(), k = p.length();
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for (char c : p.toCharArray()) count[c - 'a']++;
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                count[s.charAt(i) - 'a']--;
            } else {
                count[s.charAt(i) - 'a']--;
                int flag = 0;
                for (int n : count) {
                    if (n != 0) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) res.add(i - k + 1);
                count[s.charAt(i - k + 1) - 'a']++;
            }
        }
        return res;
    }
}
