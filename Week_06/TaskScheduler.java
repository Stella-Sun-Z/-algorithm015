package Week6;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        int n = 2;
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval1(tasks, n));
        System.out.println(leastInterval2(tasks, n));
    }

    private static int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int count = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) break;
                if (i < 26 && map[25 - i] > 0) map[25 - i]--;
                count++;
                i++;
            }
            Arrays.sort(map);
        }
        return count;
    }

    public static int leastInterval1(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        int max = 0;
        for (int i : map) {
            max = Math.max(max, i);
        }
        int lastRow = 0;
        for (int i : map) {
            if (i == max) lastRow++;
        }
        return Math.max((n + 1) * (max - 1) + lastRow, tasks.length);
    }
}
