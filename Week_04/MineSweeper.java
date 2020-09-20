package Week4;

import java.util.Arrays;

public class MineSweeper {
    public static void main(String[] args) {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = {3, 0};
        char[][] res = updateBoard(board, click);
        System.out.println(Arrays.deepToString(res));
    }

    private static char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0) return new char[][]{};
        int x= click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            revelEmpty(board, x, y);
        }
        return board;
    }

    static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dirY = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static void revelEmpty(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int xtemp = x + dirX[i], ytemp = y + dirY[i];
            if (xtemp < 0 || ytemp < 0 || xtemp >= board.length || ytemp >= board[0].length) continue;
            if (board[xtemp][ytemp] == 'M') count++;
        }
        if (count > 0) {
            board[x][y] = (char)(count + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int xtemp = x + dirX[i], ytemp = y + dirY[i];
                if (xtemp < 0 || ytemp < 0 || xtemp >= board.length || ytemp >= board[0].length
                        || board[xtemp][ytemp] != 'E') continue;
                revelEmpty(board, xtemp, ytemp);
            }
        }
    }
}
