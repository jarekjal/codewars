package jarejal.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> itemsToRemove = Arrays.stream(b).boxed().collect(Collectors.toList());
        List<Integer> itemsAfterRemoval = Arrays.stream(a)
                .filter(e -> !itemsToRemove.contains(e)).boxed().collect(Collectors.toList());
        return itemsAfterRemoval.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
