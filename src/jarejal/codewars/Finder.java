package jarejal.codewars;

import java.awt.*;

public class Finder {

    private static MazeField[][] gameField;
    private static int gameFieldSize;

    static boolean pathFinder(String maze) {
        createGameField(maze);
        if (gameFieldSize == 0) throw new IllegalArgumentException();
        if (gameFieldSize == 1) return true;
        Point start = new Point(0, 0);
        Point end = new Point(gameFieldSize - 1, gameFieldSize - 1);
        fire(start);
        return isBurned(end);
    }

    private static void fire(Point p) {
        gameField[p.x][p.y] = MazeField.BURNED;
        Point up = up(p);
        if (canBurn(up)) fire(up);
        Point down = down(p);
        if (canBurn(down)) fire(down);
        Point left = left(p);
        if (canBurn(left)) fire(left);
        Point right = right(p);
        if (canBurn(right)) fire(right);
    }

    private static boolean canBurn(Point p) {
        return isValid(p) && isEmpty(p);
    }

    private static boolean isValid(Point p) {
        return p.x >= 0 && p.x < gameFieldSize && p.y >= 0 && p.y < gameFieldSize;
    }

    private static Point up(Point p) {
        return new Point(p.x - 1, p.y);
    }

    private static Point down(Point p) {
        return new Point(p.x + 1, p.y);
    }

    private static Point left(Point p) {
        return new Point(p.x, p.y - 1);
    }

    private static Point right(Point p) {
        return new Point(p.x, p.y + 1);
    }

    private static boolean isBurned(Point p) {
        return gameField[p.x][p.y] == MazeField.BURNED;
    }

    private static boolean isEmpty(Point p) {
        return gameField[p.x][p.y] == MazeField.EMPTY;
    }

    private static void createGameField(String maze) {
        String[] lines = maze.split("\n");
        gameFieldSize = lines.length > 0 ? lines[0].length() : 0;
        if (gameFieldSize == 0) return;
        gameField = new MazeField[gameFieldSize][gameFieldSize];
        for (int l = 0; l < gameFieldSize; l++) {
            for (int f = 0; f < gameFieldSize; f++) {
                char symbol = lines[l].charAt(f);
                if (symbol == 'W') {
                    gameField[l][f] = MazeField.WALL;
                }
                if (symbol == '.') {
                    gameField[l][f] = MazeField.EMPTY;
                }
            }
        }
    }

    private static enum MazeField {
        EMPTY, WALL, BURNED
    }
}
