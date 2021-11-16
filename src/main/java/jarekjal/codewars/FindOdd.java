package jarekjal.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static int findIt(int[] a) {

        Map<Integer, Integer> numberToAppearances = new HashMap<>();
        Arrays.stream(a).forEach(e -> addToMap(numberToAppearances, e));
        return numberToAppearances.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findAny().orElseThrow(() -> new RuntimeException("Not found"));
    }

    private static void addToMap(Map<Integer, Integer> map, Integer e) {
        if (map.containsKey(e)) {
            map.put(e, map.get(e) + 1);
        } else {
            map.put(e, 1);
        }
    }
}
