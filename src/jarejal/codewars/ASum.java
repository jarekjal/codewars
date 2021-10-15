package jarejal.codewars;

public class ASum {
    public static long findNb(long m) {
        long sum = 0L;
        long n = 1L;
        do {
            sum += n * n * n;
            n++;
        } while (sum < m);
        return (sum == m) ? n - 1L : -1L;
    }
}
