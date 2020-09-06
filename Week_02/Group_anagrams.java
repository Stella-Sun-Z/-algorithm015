package Week2;

import java.util.*;

public class Group_anagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res1 = groupAnagrams1(strs);
        System.out.println(res1);
        List<List<String>> res2 = groupAnagrams(strs);
        System.out.println(res2);
    }

    // 数组映射+hashmap
    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> dict = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for(Character c : str.toCharArray()) {
                count[c - 'a'] += 1;
            }
            String key = "";
            for (int i : count) {
                key = key + i + '#';
            }
            if (!dict.containsKey(key)) dict.put(key, new ArrayList<>());
            dict.get(key).add(str);
        }
        return new ArrayList(dict.values());
    }

    // sort + hashmap
    private static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List<String>> dict = new HashMap<>();
        for (String str :strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!dict.containsKey(key)) dict.put(key, new ArrayList<>());
            dict.get(key).add(str);
        }
        return new ArrayList(dict.values());
    }
}
