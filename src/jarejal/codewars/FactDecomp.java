package jarejal.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FactDecomp {

    private static final List<Integer> primes = generatePrimes(4000);

    public static String decomp(int n) {
        List<Integer> factors = new ArrayList<>();
        IntStream.range(2, n + 1).forEach(i -> factors.addAll(decompose(i, new ArrayList<>())));
        Map<Integer, Long> factorToItsCount = factors.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String result = factorToItsCount.keySet().stream().sorted()
                .map(i -> mapFactorAndCountAsPower(i, factorToItsCount))
                //.reduce((a, b) -> String.join(" * ", a, b)).orElseThrow();
                .collect(Collectors.joining(" * "));
        System.out.println(result);
        return result;
    }

    private static String mapFactorAndCountAsPower(Integer i, final Map<Integer, Long> factorToItsCount) {
        long count = factorToItsCount.get(i);
        return count > 1 ? "" + i + "^" + count : "" + i;
    }

    private static List<Integer> decompose(int number, List<Integer> result) {
        if (primes.contains(number)) {
            result.add(number);
        } else {
            for (int prime : primes) {
                if (number % prime == 0) {
                    result.add(prime);
                    decompose(number / prime, result);
                    break;
                }
            }
        }
        return result;
    }

    private static List<Integer> generatePrimes(int range) {
        // Eratostenes algorithm
        List<Integer> primes = IntStream.range(0, range + 1).boxed().collect(Collectors.toList());
        for (int i = 2; i <= Math.sqrt(range); i++) {
            if (primes.get(i) != null) {
                for (int j = 2 * i; j <= range; j += i) {
                    primes.set(j, null);
                }
            }
        }
        return primes.stream().filter(Objects::nonNull).filter(i -> i > 1).collect(Collectors.toList());
    }

}
