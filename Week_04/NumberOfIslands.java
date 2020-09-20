package Week4;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'}
        };
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n == 0) return 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    process(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void process(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        process(grid, i + 1, j);
        process(grid, i - 1, j);
        process(grid, i, j + 1);
        process(grid, i, j - 1);
    }
}
