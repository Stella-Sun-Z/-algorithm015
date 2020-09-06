package Week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Valid_anagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram1(s, t));
        System.out.println(isAnagram2(s, t));
        System.out.println(isAnagram3(s, t));
    }

    // 借用数组计数器
    private static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (Character c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (Character c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;
        }
        return true;
    }

    // 简洁暴力解法
    private static boolean isAnagram2(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        return Arrays.equals(ss, ts);
    }

    // 哈希表解法
    public static boolean isAnagram1(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>();
        for (Character c : s.toCharArray()) {
            dict.put(c, dict.getOrDefault(c,0) + 1);
        }
        for (Character c : t.toCharArray()) {
            if (dict.isEmpty() || !dict.containsKey(c)) return false;
            if (dict.get(c) == 1) {
                dict.remove(c);
            } else {
                dict.put(c, dict.get(c) - 1);
            }
        }
        return dict.isEmpty();
    }
}
