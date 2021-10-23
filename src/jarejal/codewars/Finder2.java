package jarejal.codewars;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Finder2 {
    private static int[][] gameField;
    private static int gameFieldSize;
    private static final int EMPTY = -2;
    private static final int WALL = -1;

    static int pathFinder(String maze) {
        createGameField(maze);
        if (gameFieldSize == 0) throw new IllegalArgumentException();
        if (gameFieldSize == 1) return 0;
        Point startPoint = new Point(gameFieldSize - 1, gameFieldSize - 1);
        Point stopPoint = new Point(0, 0);
        Set<Point> start = new HashSet<>();
        start.add(startPoint);
        calculateDistance(start, 0);
        int stopValue = gameField[stopPoint.x][stopPoint.y];
        return stopValue == EMPTY ? -1 : stopValue;
    }

    private static void calculateDistance(Set<Point> points, int distance) {
        points.forEach(p -> gameField[p.x][p.y] = distance);
        Set<Point> neighbours = findNeighbours(points);
        if (!neighbours.isEmpty()) {
            calculateDistance(neighbours, distance + 1);
        }
    }

    private static Set<Point> findNeighbours(Set<Point> points) {
        Set<Point> neighbours = new HashSet<>();
        points.forEach(p -> {
            Set<Point> neighbourCandidates = getPointsAround(p);
            neighbourCandidates.forEach(candidate -> {
                if (canBeNeighbour(candidate)) neighbours.add(candidate);
            });
        });
        return neighbours;
    }

    private static Set<Point> getPointsAround(Point p) {
        return Set.of(up(p), down(p), left(p), right(p));
    }

    private static boolean canBeNeighbour(Point p) {
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

    private static boolean isEmpty(Point p) {
        return gameField[p.x][p.y] == EMPTY;
    }

    private static void createGameField(String maze) {
        String[] lines = maze.split("\n");
        gameFieldSize = lines.length > 0 ? lines[0].length() : 0;
        if (gameFieldSize == 0) return;
        gameField = new int[gameFieldSize][gameFieldSize];
        for (int l = 0; l < gameFieldSize; l++) {
            for (int f = 0; f < gameFieldSize; f++) {
                char symbol = lines[l].charAt(f);
                if (symbol == 'W') {
                    gameField[l][f] = WALL;
                }
                if (symbol == '.') {
                    gameField[l][f] = EMPTY;
                }
            }
        }
    }

}
