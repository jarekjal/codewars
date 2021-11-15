package jarejal.codewars;

import java.awt.*;
import java.util.Arrays;

public class Finder3 {

    private static int[][] gameField;
    private static int gameFieldSize;
    private static int bestCost;
    private static Point stop;
    private static final Point start = new Point(0, 0);

    public static int pathFinder(String maze) {
        createGameField(maze);
        if (gameFieldSize == 0) throw new IllegalArgumentException();
        if (gameFieldSize == 1) return 0;
        goToNeighbour(start, 0, null);
        return bestCost;
    }

    private static void goToNeighbour(Point p, int cost, boolean[][] visited) {
        if (visited != null) {markAsVisited(p, visited);}
        if (stop.equals(p) && !isCostWorse(cost)) { // todo
            bestCost = cost;
            return;
        }
        boolean[][] copy = visited == null ? new boolean[gameFieldSize][gameFieldSize] : copyOfArray(visited);
        Point next = left(p);
        go(p, cost, next, copy);
        next = right(p);
        go(p, cost, next, copy);
        next = up(p);
        go(p, cost, next, copy);
        next = down(p);
        go(p, cost, next, copy);
    }

    private static boolean[][] copyOfArray(boolean[][] visited) {
        return Arrays.stream(visited).map(boolean[]::clone).toArray(boolean[][]::new);
    }

    private static void go(Point p, int cost, Point next, boolean[][] visited) {
        if (canGoTo(next, visited)) {
            int newCost = cost + costBetween(p, next);
            if (!isCostWorse(newCost)) {
                goToNeighbour(next, newCost, visited);
            }
        }
    }

    private static void markAsVisited(Point p, boolean[][] visited) {
        visited[p.x][p.y] = true;
    }

    private static boolean canGoTo(Point p, boolean[][] visited) {
        return isValid(p) && !isVisited(p, visited);
    }

    private static boolean isValid(Point p) {
        return isValid(p.x) && isValid(p.y);
    }

    private static boolean isValid(int i) {
        return i >= 0 && i < gameFieldSize;
    }

    private static boolean isVisited(Point p, boolean[][] visited) {
        return visited[p.x][p.y];
    }

    private static int costBetween(Point p, Point next) {
        return Math.abs(gameField[p.x][p.y] - gameField[next.x][next.y]);
    }

    private static boolean isCostWorse(int cost) {
        return cost > bestCost;
    }

    private static Point left(Point p) {
        return new Point(p.x, p.y - 1);
    }

    private static Point right(Point p) {
        return new Point(p.x, p.y + 1);
    }

    private static Point up(Point p) {
        return new Point(p.x - 1, p.y);
    }

    private static Point down(Point p) {
        return new Point(p.x + 1, p.y);
    }

    private static void createGameField(String maze) {
        bestCost = Integer.MAX_VALUE;
        String[] rows = maze.split("\n");
        if (rows.length < 1) throw new IllegalArgumentException();
        gameFieldSize = rows[0].length();
        if (gameFieldSize != rows.length) throw new IllegalArgumentException();
        gameField = new int[gameFieldSize][gameFieldSize];
        stop = new Point(gameFieldSize - 1, gameFieldSize - 1);
        for (int row = 0; row < gameFieldSize; row++) {
            for (int field = 0; field < gameFieldSize; field++) {
                gameField[row][field] = Integer.parseInt(Character.toString(rows[row].charAt(field)));
            }
        }
    }
}
