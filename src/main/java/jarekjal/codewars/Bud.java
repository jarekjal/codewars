package jarekjal.codewars;

import java.util.ArrayList;
import java.util.List;

public class Bud {
    public static String buddy(long start, long limit) {
        for (long number = start; number <= limit; number++) {
            List<Long> divisors = getDivisors(number);
            long sumOf = getSumOf(divisors);
            long buddyCandidate = sumOf - 1;
            List<Long> divisorsOfCandidate = getDivisors(buddyCandidate);
            long sumOfCandidate = getSumOf(divisorsOfCandidate);
            if (sumOfCandidate - 1 == number && number < buddyCandidate) {
                return "(" + number + " " + buddyCandidate + ")";
            }
        }
        return "Nothing";
    }

    private static List<Long> getDivisors(Long number) {
        List<Long> result = new ArrayList<>();
        for (long i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            long divisor = number / result.get(i);
            if (divisor != result.get(i) && divisor != number) {
                result.add(divisor);
            }
        }
        return result;
    }

    private static long getSumOf(List<Long> list) {
        return list.stream().reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(getSumOf(getDivisors(75L)));
    }

}