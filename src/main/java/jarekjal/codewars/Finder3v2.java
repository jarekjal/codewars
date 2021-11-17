package jarekjal.codewars;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class Finder3v2 {

    private static int[][] gameField;
    private static int gameFieldSize;
    private static Map<Set<Point>, Integer> edgeToCost;

    public static int pathFinder(String maze) {
        createGameField(maze);
        if (gameFieldSize == 0) throw new IllegalArgumentException();
        if (gameFieldSize == 1) return 0;
        buildMaps();

        return dijkstra();
    }

    private static int dijkstra() {
        int[] d = new int[gameFieldSize * gameFieldSize];
        Set<Integer> q = new HashSet<>();
        for (int i = 0; i < gameFieldSize * gameFieldSize; i++) {
            q.add(i);
        }
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        while (!q.isEmpty()) {
            int indexOfNodeWithMinimalCost = getIndexOfNodeWithMinimalCost(d, q);
            q.remove(indexOfNodeWithMinimalCost);
            getNeighboursOf(nodeForNumber(indexOfNodeWithMinimalCost))
                    .forEach(neighbour -> {
                        int nodeNumber = nodeNumberOf(neighbour);
                        if (q.contains(nodeNumber)) {
                            int cost = edgeToCost.get(Set.of(nodeForNumber(indexOfNodeWithMinimalCost), neighbour));
                            if (d[nodeNumber] > d[indexOfNodeWithMinimalCost] + cost) {
                                d[nodeNumber] = d[indexOfNodeWithMinimalCost] + cost;
                            }
                        }
                    });
        }
        return d[d.length - 1];
    }

    private static int getIndexOfNodeWithMinimalCost(int[] array, Set<Integer> q) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i : q) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void buildMaps() {
        edgeToCost = new HashMap<>();
        for (int row = 0; row < gameFieldSize; row++) {
            for (int field = 0; field < gameFieldSize; field++) {
                Point point = new Point(row, field);
                Set<Point> neighbours = getNeighboursOf(point);
                updateEdgeToCostMap(point, neighbours);
            }
        }
    }

    private static void updateEdgeToCostMap(Point point, Set<Point> neighbours) {
        neighbours.forEach(neighbour -> edgeToCost
                .put(Set.of(point, neighbour), calculateCost(point, neighbour)));
    }

    private static Integer calculateCost(Point point, Point neighbour) {
        return Math.abs(gameField[point.x][point.y] - gameField[neighbour.x][neighbour.y]);
    }

    private static Set<Point> getNeighboursOf(Point point) {
        return getNeighbourCandidates(point).stream().filter(Finder3v2::isValid).collect(Collectors.toSet());
    }

    private static boolean isValid(Point p) {
        return isValid(p.x) && isValid(p.y);
    }

    private static boolean isValid(int i) {
        return i >= 0 && i < gameFieldSize;
    }

    private static Set<Point> getNeighbourCandidates(Point point) {
        return Set.of(left(point), right(point), up(point), down(point));
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

    private static Point nodeForNumber(int nodeNumber) {
        return new Point(nodeNumber / gameFieldSize, nodeNumber % gameFieldSize);
    }

    private static int nodeNumberOf(Point node) {
        return node.x * gameFieldSize + node.y;
    }

    private static void createGameField(String maze) {
        String[] rows = maze.split("\n");
        if (rows.length < 1) throw new IllegalArgumentException();
        gameFieldSize = rows[0].length();
        if (gameFieldSize != rows.length) throw new IllegalArgumentException();
        gameField = new int[gameFieldSize][gameFieldSize];
        for (int row = 0; row < gameFieldSize; row++) {
            for (int field = 0; field < gameFieldSize; field++) {
                gameField[row][field] = Integer.parseInt(Character.toString(rows[row].charAt(field)));
            }
        }
    }
}
