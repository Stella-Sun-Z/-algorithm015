package Week4;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(robotSim(commands, obstacles));
    }

    private static int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        for (int[] list : obstacles) {
            String str = list[0] + "*" + list[1];
            obs.add(str);
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, x = 0, y = 0, dis = 0;
        for (int com : commands) {
            if (com < 0) {
                i = com == -1 ? (i + 1) % 4 : (i + 3) % 4;
            } else {
                for (int j = 0; j < com; j++) {
                    String check = (x + dir[i][0]) + "*" + (y + dir[i][1]);
                    if (obs.contains(check)) break;
                    x += dir[i][0];
                    y += dir[i][1];
                    dis = Math.max(x * x + y * y, dis);
                }
            }
        }
        return dis;
    }
}
