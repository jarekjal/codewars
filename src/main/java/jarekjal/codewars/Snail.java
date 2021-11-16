package jarekjal.codewars;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snail {

    private static int n;
    private static boolean[][] visited;
    private static List<Integer> result;

    public static int[] snail(int[][] array) {
        n = array[0].length;
        if (n == 0) return new int[]{};
        initializeDataStructs();
        Direction direction = Direction.RIGHT;
        Point cell = new Point(0, 0);
        for (int step = 0; step < n * n; step++) {
            result.add(array[cell.x][cell.y]);
            visited[cell.x][cell.y] = true;
            Point nextCell = direction.next(cell);
            if (isForbiddenGoTo(nextCell)) {
                direction = direction.change();
                nextCell = direction.next(cell);
                if (isForbiddenGoTo(nextCell)) break;
            }
            cell = nextCell;
        }
        return result.stream().mapToInt(i -> i).toArray(); // wazny pattern!!!
    }

    private static boolean isForbiddenGoTo(Point cell) {
        if (cell.x < 0 || cell.y < 0 || cell.x > n - 1 || cell.y > n - 1) return true;
        return visited[cell.x][cell.y];
    }

    private static void initializeDataStructs() {
        visited = new boolean[n][n];
        result = new ArrayList<>(n * n);
    }

    private enum Direction {
        RIGHT, LEFT, UP, DOWN;

        public Direction change() {
            switch (this) {
                case RIGHT:
                    return DOWN;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                default:
                    return RIGHT;
            }
        }

        private Point next(Point cell) {
            switch (this) {
                case RIGHT:
                    return new Point(cell.x, cell.y + 1);
                case LEFT:
                    return new Point(cell.x, cell.y - 1);
                case DOWN:
                    return new Point(cell.x + 1, cell.y);
                default:
                    return new Point(cell.x - 1, cell.y);
            }
        }
    }
}
