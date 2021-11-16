package jarekjal.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextSmaller {

    private static final long IMPOSSIBLE = -1;
    private static List<Integer> digits;

    public static long nextSmaller(long n) {
        digits = getDigitsOf(n);
        if (digits.size() < 2) return IMPOSSIBLE;
        int index = getIndex();
        if (index < 0) return IMPOSSIBLE;
        int valueAtIndex = digits.get(index);
        List<Integer> mostMeaningfulDigits = getMostMeanigfulDigits(index);
        List<Integer> lessMeaningfulDigits = getLessMeaningfulDigits(index);
        int maxButLessThanValueAtIndex = lessMeaningfulDigits.stream()
                .filter(i -> i < valueAtIndex).max(Integer::compareTo).orElseThrow();
        lessMeaningfulDigits.remove((Integer) maxButLessThanValueAtIndex);
        lessMeaningfulDigits.add(valueAtIndex);
        Collections.sort(lessMeaningfulDigits);
        Collections.reverse(lessMeaningfulDigits);
        List<Integer> resultDigits = new ArrayList<>(mostMeaningfulDigits);
        resultDigits.add(maxButLessThanValueAtIndex);
        resultDigits.addAll(lessMeaningfulDigits);
        if (!resultDigits.isEmpty() && resultDigits.get(0) == 0) return IMPOSSIBLE;
        String resultedString = resultDigits.stream()
                .map(i -> "" + i).reduce("", (a, b) -> "" + a + b);
        return Long.parseLong(resultedString);
    }

    private static List<Integer> getMostMeanigfulDigits(final int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            result.add(digits.get(i));
        }
        return result;
    }

    private static List<Integer> getLessMeaningfulDigits(final int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = index + 1; i < digits.size(); i++) {
            result.add(digits.get(i));
        }
        return result;
    }

    private static int getIndex() {
        int index = digits.size() - 2;
        while (index >= 0 && digits.get(index) <= digits.get(index + 1)) {
            index--;
        }
        return index;
    }

    private static List<Integer> getDigitsOf(long n) {
        String number = String.valueOf(n);
        List<Integer> result = new ArrayList<>(number.length());
        for (int i = 0; i < number.length(); i++) {
            result.add(i, Integer.parseInt("" + number.charAt(i)));
        }
        return result;
    }
}
