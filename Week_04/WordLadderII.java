package Week4;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "red";
        String endWord = "tax";
        String[] wordList = {"ted","tex","red","tax","tad","den","rex","pee"};
        List<List<String>> res = ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }

    private static List<List<String>> ladderLength(String beginWord, String endWord, String[] wordList) {
        HashMap<String, List<String>> wordListDict = new HashMap<>();
        for (String str : wordList) {
            for (int i = 0; i < str.length(); i++) {
                String newWord = str.substring(0, i) + '*' + str.substring(i + 1);
                List<String> value = wordListDict.getOrDefault(newWord, new ArrayList<>());
                value.add(str);
                wordListDict.put(newWord, value);
            }
        }
        List<List<String>> res = new ArrayList<>();
        int count = Integer.MAX_VALUE;

        Queue<ArrayList<String>> que = new LinkedList<>();
        que.add(new ArrayList<String>(){{add(beginWord);}});
        while (!que.isEmpty()) {
            ArrayList<String> wordRes = que.poll();
            if (wordRes.size() >= count) break;
            String word = wordRes.get(wordRes.size() - 1);
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1);
                if (!wordListDict.containsKey(newWord)) continue;
                List<String> list = wordListDict.get(newWord);
                for (String str : list) {
                    int flag = 0;
                    for (String s : wordRes) {
                        if (s.equals(str)) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) continue;
                    if (str.equals(endWord)) {
                        wordRes.add(str);
                        count = wordRes.size();
                        res.add(wordRes);
                    } else {
                        ArrayList<String> newlist = new ArrayList<>(wordRes);
                        newlist.add(str);
                        que.add(newlist);
                    }
                }
            }
        }
        return res;
    }
}
