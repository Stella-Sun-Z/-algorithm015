package Week7;

public class FriendCircles {
    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum1(M));
        System.out.println(findCircleNum2(M));
    }

    private static int findCircleNum2(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
    static class UnionFind {
        public int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        public void union(int i, int j) {
            int p = find(i), q = find(j);
            if (p == q) return;
            parent[p] = q;
            count--;
        }
    }

    //方法一：dfs
    public static int findCircleNum1(int[][] M) {
        int n = M.length, count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (!visited[j] && M[i][j] == 1) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
