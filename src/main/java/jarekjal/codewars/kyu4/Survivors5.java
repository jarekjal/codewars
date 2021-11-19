package jarekjal.codewars.kyu4;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class Survivors5 {
    private static char[][] gameField;
    private static boolean[][] visited;
    private static Set<Point> lettersToRemove;
    private static Set<Point> lettersPositions;
    private static int rowCount;
    private static int columnCount;
    private static Set<Set<Point>> groups;

    public static String survivors(String[] arr) {
        createGameField(arr);
        findGroups();
        findLettersToRemove();
        lettersPositions.removeAll(lettersToRemove);
        return getResultAsString(lettersPositions);
    }

    private static String getResultAsString(Set<Point> set) {
        return set.stream().map(p -> Character.toString(gameField[p.x][p.y])).reduce("", String::concat);
    }

    private static void findLettersToRemove() {
        for (Set<Point> removingGroup : groups) {
            int distance = removingGroup.size();
            Set<Point> toRemove = new HashSet<>();
            for (Point p : removingGroup) {
                Set<Point> toRemoveByOneLetter = lettersPositions.stream()
                        .filter(pos -> isInsideChebyshevArea(pos, p, distance)).collect(Collectors.toSet());
                toRemove.addAll(toRemoveByOneLetter);
            }
            toRemove.removeAll(removingGroup);
            lettersToRemove.addAll(toRemove);
        }
    }

    private static boolean isInsideChebyshevArea(Point p, Point centre, int distance) {
        return isInsideChebyshevArea(p.x, centre.x, distance) &&
                isInsideChebyshevArea(p.y, centre.y, distance);
    }

    private static boolean isInsideChebyshevArea(int p, int centre, int distance) {
        return p >= centre - distance && p <= centre + distance;
    }

    private static void findGroups() {
        Set<Point> positions = new HashSet<>(lettersPositions);
        while (!positions.isEmpty()) {
            Iterator<Point> it = positions.iterator();
            Point startingPoint = it.next();
            Set<Point> group = new HashSet<>();
            group.add(startingPoint);
            buildGroup(group, startingPoint);
            positions.removeAll(group);
            groups.add(group);
//            System.out.println(group);
        }
//        System.out.println("---");
    }

    private static void buildGroup(Set<Point> group, Point p) {
        visited[p.x][p.y] = true;
        Set<Point> neighbours = getNeighbours(p);
        Set<Point> neighbourLetters = neighbours.stream()
                .filter(point -> isLetter(gameField[point.x][point.y])).collect(Collectors.toSet());
        group.addAll(neighbourLetters);
        neighbourLetters.forEach(neighbour -> buildGroup(group, neighbour));
    }

    private static Set<Point> getNeighbours(Point p) {
        Set<Point> neighbours = new HashSet<>();
        getPointsAround(p).forEach(point -> {
            if (isValid(point) && !isVisited(point)) {
                neighbours.add(point);
            }
        });
        return neighbours;
    }

    private static Set<Point> getPointsAround(Point p) {
        return Set.of(up(p), down(p), left(p), right(p));
    }

    private static boolean isVisited(Point point) {
        return visited[point.x][point.y];
    }

    private static boolean isValid(Point p) {
        return p.x >= 0 && p.x < rowCount && p.y >= 0 && p.y < columnCount;
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

    private static void createGameField(String[] arr) {
        groups = new HashSet<>();
        lettersPositions = new HashSet<>();
        lettersToRemove = new HashSet<>();
        rowCount = arr.length;
        columnCount = Arrays.stream(arr).map(String::length).max(Integer::compare).orElseThrow();
        gameField = new char[rowCount][columnCount];
        visited = new boolean[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            String row = arr[i];
            for (int j = 0; j < row.length(); j++) {
                gameField[i][j] = row.charAt(j) == ' ' ? '\0' : row.charAt(j);
                if (isLetter(row.charAt(j))) lettersPositions.add(new Point(i, j));
            }
        }
    }

    private static boolean isLetter(char ch) {
        return ch != '\0' && ch != ' ';
    }
}
