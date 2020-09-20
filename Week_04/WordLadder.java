package Week4;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    private static int ladderLength(String beginWord, String endWord, String[] wordList) {
        //1. 用Map创建便于查找的wordlist，以隐去一个char的字符串为Key，以相应所有字符串为Value
        HashMap<String, List<String>> wordListDict = new HashMap<>();
        for (String str : wordList) {
            for (int i = 0; i < str.length(); i++) {
                String newWord = str.substring(0, i) + '*' + str.substring(i + 1, str.length());
                List<String> wordListValue =  wordListDict.getOrDefault(newWord, new ArrayList<>());
                wordListValue.add(str);
                wordListDict.put(newWord, wordListValue);
            }
        }
        System.out.println(wordListDict);
        //2. 用Set储存已经遍历过的字符串
        HashSet<String> visited = new HashSet<>();
        //3. 用队列进行bfs循环
        Queue<Pair<String, Integer>> que = new LinkedList<>();
        que.add(new Pair<>(beginWord, 1));
        while (!que.isEmpty()) {
            Pair<String, Integer> newque = que.poll();
            String word = newque.getKey();
            if (visited.contains(word)) continue;
            visited.add(word);
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                if (!wordListDict.containsKey(newWord)) continue;
                List<String> list = wordListDict.get(newWord);
                for (String str : list) {
                    if (str.equals(endWord)) return newque.getValue() + 1;
                    if (!visited.contains(str))
                        que.add(new Pair<String, Integer>(str, newque.getValue() + 1));
                }
            }
        }
        return 0;
    }
}
