package jarekjal.codewars.kyu4;

public class Magnets {
    public static double doubles(int maxK, int maxN) {
        double s = 0;
        for (int k = 1; k <= maxK; k++) {
            double u = 0;
            for (int n = 1; n <= maxN; n++) {
                u += 1.0 / (k * Math.pow(n + 1, 2 * k));
            }
            s += u;
        }
        return s;
    }
}
