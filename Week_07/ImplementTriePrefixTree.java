package Week7;

public class ImplementTriePrefixTree {
    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsChar(c)) node.putNode(c);
            node = node.getNode(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsChar(c)) return false;
            node = node.getNode(c);
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.containsChar(c)) return false;
            node = node.getNode(c);
        }
        return true;
    }

    private class TrieNode {
        private TrieNode[] nodes;
        private boolean isEnd;

        public TrieNode() {
            nodes = new TrieNode[26];
        }

        public boolean containsChar(char c) {
            return nodes[c - 'a'] != null;
        }

        public TrieNode getNode(char c) {
            TrieNode node = nodes[c - 'a'];
            return node;
        }

        public void putNode(char c) {
            nodes[c - 'a'] = new TrieNode();
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
