package jarekjal.codewars;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class FindOutlier {
    public static int find(int[] integers) {
        final int FIRST_THREE_ELEMENTS = 3;
        final IntPredicate ODD = i -> i % 2 != 0;
        final IntPredicate EVEN = i -> i % 2 == 0;
        final long evenCount = Arrays.stream(integers).limit(FIRST_THREE_ELEMENTS).filter(EVEN).count();
        IntPredicate predicate = (evenCount > FIRST_THREE_ELEMENTS - evenCount) ? ODD : EVEN;
        return Arrays.stream(integers).filter(predicate).findFirst().orElseThrow();
    }
}
