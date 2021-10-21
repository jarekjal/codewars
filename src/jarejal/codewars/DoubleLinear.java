package jarejal.codewars;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DoubleLinear {
    public static int dblLinear(int n) {
        Set<Integer> result = new HashSet<>();
        result.add(1);
        add(1000000, 1, result);
        var answer = result.stream().sorted().collect(Collectors.toList());
        return answer.get(n);
    }

    private static void add(int max, int n, Set<Integer> result) {
        int a = 2 * n + 1;
        int b = 3 * n + 1;
        result.add(a);
        result.add(b);
        if (a <= max) add(max, a, result);
        if (b <= max) add(max, b, result);
    }
}
