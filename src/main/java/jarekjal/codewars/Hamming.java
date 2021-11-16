package jarekjal.codewars;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Hamming {
    public static long hamming(int n) {
        Set<Long> result = new TreeSet<Long>();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 18; k++) {
                    double h = Math.pow(2, i) * Math.pow(3, j) * Math.pow(5, k);
                    result.add((long) h);
                    //System.out.println(h);
                }
            }
        }
        List<Long> answer = result.stream().sorted().collect(Collectors.toList());
        return answer.get(n-1);
    }

    public static void main(String[] args) {
        System.out.println(Hamming.hamming(1));
    }
}
