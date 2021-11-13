package jarejal.codewars;

import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class RectangleRotation {

    private static final double SQRT_2 = Math.sqrt(2.0);
    private static double leftX, leftY, rightX, rightY, bottomX, topX;
    private static Set<Segment> segments;

    static int rectangleRotation(final int a, final int b) {
        calculateExtremePoints(a, b);
        createSegments();
        return countPoints();
    }

    private static int countPoints() {
        int result = 0;
        int from = (int) leftX;
        int to = (int) rightX;
        for (int x = from; x <= to; x++) {
            result += countPointsInColumn(x);
        }
        return result;
    }

    private static int countPointsInColumn(int x) {
        List<Double> yRange = segments.stream()
                .map(segment -> segment.calculateYForCrossingWithGivenX(x))
                .filter(OptionalDouble::isPresent)
                .map(OptionalDouble::getAsDouble)
                .sorted().collect(Collectors.toList());
        int lastInteger = (int) Math.ceil(yRange.get(1));
        int firstInteger = (int) Math.floor(yRange.get(0));
        return lastInteger - firstInteger - 1;
    }

    private static void createSegments() {
        segments = new HashSet<>(4);
        segments.add(new Segment(-1, rightX, rightY, topX, rightX));
        segments.add(new Segment(1, rightX, rightY, bottomX, rightX));
        segments.add(new Segment(-1, leftX, leftY, leftX, bottomX));
        segments.add(new Segment(1, leftX, leftY, leftX, topX));
    }

    private static void calculateExtremePoints(int a, int b) {
        double midDownX = (a / 2.0) * (-1) / SQRT_2;
        double midDownY = midDownX;
        leftX = midDownX + (b / 2.0 * (-1) / SQRT_2);
        leftY = midDownY + (b / 2.0 / SQRT_2);
        rightX = -1 * leftX;
        rightY = -1 * leftY;
        bottomX = midDownX - (b / 2.0 * (-1) / SQRT_2);
        topX = -bottomX;
    }

    private static class Segment {
        // y = a * x + b
        double a;
        double b;
        double xMin;
        double xMax;

        public Segment(double a, double b, double xMin, double xMax) {
            this.a = a;
            this.b = b;
            this.xMin = xMin;
            this.xMax = xMax;
        }

        public Segment(double a, double x, double y, double xMin, double xMax) {
            this(a, y - a * x, xMin, xMax);
        }

        public OptionalDouble calculateYForCrossingWithGivenX(int x) {
            double y = a * x + b;
            return (x >= xMin && x <= xMax) ? OptionalDouble.of(y) : OptionalDouble.empty();
        }
    }
}
