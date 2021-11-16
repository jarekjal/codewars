package jarekjal.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheOdd {
    public static int[] sortArray(int[] array) {
        List<Pair> pairs = new ArrayList<>(array.length);
        List<Pair> odds = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Pair pair = new Pair(i, array[i]);
            pairs.add(pair);
            if (array[i] % 2 != 0) {
                odds.add(pair);
                indexes.add(i);
            }
        }
        Collections.sort(odds);
        for (int i = 0; i < odds.size(); i++) {
            pairs.set(indexes.get(i), odds.get(i));
        }
        int[] result = new int[array.length];
        for (int i = 0; i < pairs.size(); i++) {
            result[i] = pairs.get(i).getValue();
        }
        return result;
    }

    private static class Pair implements Comparable<Pair> {

        private Integer index;
        private Integer value;

        public Pair(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }

        public Integer getIndex() {
            return this.index;
        }

        public Integer getValue() {
            return this.value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.getValue().compareTo(o.getValue());
        }
    }

}
