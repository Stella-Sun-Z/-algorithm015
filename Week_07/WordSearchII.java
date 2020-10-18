package Week7;

import java.util.*;

public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie dict = new Trie();
        for (String word : words) {
            dict.append(word);
        }

        int n = board.length, m = board[0].length;
        Set<String> res = new HashSet<String>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(res, dict.root, visited, board, i, j);
            }
        }
        return new ArrayList<>(res);
    }


    private static void dfs(Set<String> res, TrieNode node, boolean[][] visited, char[][] board,
                            int i, int j) {
        int n = board.length, m = board[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j]) return;
        visited[i][j] = true;
        if (node.contains(board[i][j])) {
            node = node.get(board[i][j]);
            if (node.isEnd) {
                res.add(node.val);
            }
        } else {
            visited[i][j] = false;
            return;
        }
        int[] tx = {1, -1, 0, 0};
        int[] ty = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            dfs(res, node, visited, board, i + tx[k], j + ty[k]);
        }
        visited[i][j] = false;
    }


    static class Trie {
        public TrieNode root = new TrieNode();

        public void append(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.contains(c)) node.add(c);
                node = node.get(c);
            }
            node.isEnd = true;
            node.val = word;
        }
    }

    static class TrieNode {
        private TrieNode[] nodes;
        public boolean isEnd;
        public String val;

        public TrieNode() {
            nodes = new TrieNode[26];
        }

        public void add(char c) {
            nodes[c - 'a'] = new TrieNode();
        }

        public boolean contains(char c) {
            return nodes[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return nodes[c - 'a'];
        }
    }
}
