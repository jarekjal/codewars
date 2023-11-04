package jarekjal.codewars.kyu5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        LinkedList<Integer> input = new LinkedList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        List<Integer> indices = new ArrayList<>(IntStream.range(0, input.size()).boxed().collect(Collectors.toList()));
        // first shrink all 'plateaus' into single peak and shrink indices list accordingly
        var it = input.listIterator();
        int cnt = 0;
        while (it.hasNext()) {
            int e1, e2;
            e1 = it.next();
            if (it.hasNext()) {
                e2 = it.next();
                if (e1 == e2) {
                    it.remove();
                    indices.remove(cnt + 1);
                    cnt--;
                }
                it.previous();
            } else {
                break;
            }
            cnt++;
        }

        // prepare result map
        Map<String, List<Integer>> results = new HashMap<>();
        results.put("pos", new ArrayList<>());
        results.put("peaks", new ArrayList<>());
        List<Integer> pos = results.get("pos");
        List<Integer> peaks = results.get("peaks");

        // then find peaks and its indices
        for (int i = 0; i < input.size() - 2; i++) {
            if (input.get(i + 1) > input.get(i) && input.get(i + 1) > input.get(i + 2)) {
                pos.add(indices.get(i + 1));
                peaks.add(input.get(i + 1));
            }
        }

        return results;
    }
}
